package chapter03

import java.util.Date

import scala.concurrent.duration._
import akka.actor.{Actor, ActorRef, Props, ReceiveTimeout}

abstract class AuctionMessage
case class Offer(bid: Int, client: ActorRef) extends AuctionMessage
case class Inquire(client: ActorRef) extends AuctionMessage

abstract class AuctionReply
case class Status(asked: Int, expire: Date) extends AuctionReply
case object BestOffer extends AuctionReply
case class BeatenOffer(maxBid: Int) extends AuctionReply
case class AuctionConcluded(seller: ActorRef, client: ActorRef) extends AuctionReply
case object AuctionFailed extends AuctionReply
case object AuctionOver extends AuctionReply

class Auction(seller: ActorRef, minBid: Int, closing: Date) extends Actor {
  val timeToShutdown = 36000000 // msec
  val bidIncrement = 10

  var maxBid = 0
  var maxBidder: ActorRef = null
  var running = true

  override def preStart(): Unit = {
    maxBid = minBid - bidIncrement
    maxBidder = null
    running = true
  }

  context.setReceiveTimeout((closing.getTime - new Date().getTime) millisecond)
  override def receive: Receive = {
    case Offer(bid, client) =>
      if (bid >= maxBid + bidIncrement) {
        if (maxBid >= minBid)
          maxBidder ! BeatenOffer(bid)
        maxBid = bid
        maxBidder = client
        client ! BestOffer
      } else {
        client ! BeatenOffer(maxBid)
      }
    case Inquire(client) =>
      client ! Status(maxBid, closing)
    case ReceiveTimeout =>
      if (maxBid >= minBid) {
        val reply = AuctionConcluded(seller, maxBidder)
        maxBidder ! reply
        seller ! reply
      } else {
        seller ! AuctionFailed
      }
  }
}
