sealed trait Color
case object Red extends Color
case object Green extends Color
case object Blue extends Color
case object Yellow extends Color

sealed trait Value
case class Point(value:Int) extends Value
case object Draw2 extends Value
case object Skip extends Value // has consequences on the next player
case object Reverse extends Value // has consequences on the direction of play

/**
 * The type of a card.
 * A card can be a colored card, a wild card or a wild draw 4 card.
 * A wild card can be played on any color. Its color is Black
 * A colored card has a color and a value. The value can be a number or a special card.
 */

sealed trait CardType
case class ColoredCard(color: Color, value:Value) extends CardType
case object WildCard extends CardType
case object WildDraw4Card extends CardType




class Card(val cardType:CardType) {
  override def toString: String = {
    val colorStr = cardType match {
      case ColoredCard(color, _) => color match {
        case Red => Console.RED
        case Green => Console.GREEN
        case Blue => Console.BLUE
        case Yellow => Console.YELLOW
      }
      case WildCard => Console.BLACK
      case WildDraw4Card => Console.BLACK
    }
    val cardTypeStr = cardType match {
      case ColoredCard(_, Point(value)) => value.toString + " "
      case ColoredCard(_, Draw2) => "+2"
      case ColoredCard(_, Skip) => "->"
      case ColoredCard(_, Reverse) => "<-"
      case WildCard => "# "
      case WildDraw4Card => "#4"
    }
    s"\n${colorStr}+----+\n" +
      s"${colorStr}| $cardTypeStr |\n" +
      s"${colorStr}+----+${Console.RESET}\n"
  }
}

class Field(val stack:Card, val draw:Card) {
  override def toString: String = stack.toString
}