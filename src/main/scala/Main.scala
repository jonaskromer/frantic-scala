/* import Card._ */

@main def main(): Unit = {
  val card = new Card(ColoredCard(Red, Point(5)))
  println(card)
  val card2 = new Card(ColoredCard(Blue, Draw2))
  println(card2)
  val card3 = new Card(ColoredCard(Yellow, Skip))
  println(card3)
  val card4 = new Card(WildCard)
  println(card4)
}