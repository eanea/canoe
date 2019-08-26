package canoe.methods.chats

import canoe.marshalling.CirceEncoders
import canoe.methods.{JsonRequest, Method}
import canoe.models.{ChatId, InputFile}
import io.circe.{Decoder, Encoder}

/**
  * Use this method to unpin a message in a supergroup chat.
  * The bot must be an administrator in the chat for this to work and must have the ‘can_pin_messages’ admin right in
  * the supergroup or ‘can_edit_messages’ admin right in the channel.
  * Returns True on success.
  *
  * @param chatId Integer or String Unique identifier for the target chat or username of the target channel (in the format @channelusername)
  */
case class UnpinChatMessage(chatId: ChatId) extends JsonRequest[Boolean]

object UnpinChatMessage {

  implicit val method: Method[UnpinChatMessage, Boolean] =
    new Method[UnpinChatMessage, Boolean] {

      def name: String = "unpinChatMessage"

      def encoder: Encoder[UnpinChatMessage] = CirceEncoders.unpinChatMessageEncoder

      def decoder: Decoder[Boolean] = Decoder.decodeBoolean

      def uploads(request: UnpinChatMessage): List[(String, InputFile)]= Nil
    }
}