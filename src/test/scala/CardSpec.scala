import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class CardSpec extends AnyWordSpec {
  "Card" should {
    "be red 5" in {
      Card(ColoredCard(Red, Point(5))).toString should be(
        s"\n${Console.RED}+----+\n${Console.RED}| 5  |\n${Console.RED}+----+${Console.RESET}\n"
      )
    }
  }

  "green +2" in {
    val greenDraw2Card = new Card(ColoredCard(Green, Draw2))
    greenDraw2Card.toString shouldBe
      s"\n${Console.GREEN}+----+\n" +
        s"${Console.GREEN}| +2 |\n" +
        s"${Console.GREEN}+----+${Console.RESET}\n"
  }

  "blue skip" in {
    val blueSkipCard = new Card(ColoredCard(Blue, Skip))
    blueSkipCard.toString shouldBe
      s"\n${Console.BLUE}+----+\n" +
        s"${Console.BLUE}| -> |\n" +
        s"${Console.BLUE}+----+${Console.RESET}\n"
  }

  "yellow reverse" in {
    val yellowReverseCard = new Card(ColoredCard(Yellow, Reverse))
    yellowReverseCard.toString shouldBe
      s"\n${Console.YELLOW}+----+\n" +
        s"${Console.YELLOW}| <- |\n" +
        s"${Console.YELLOW}+----+${Console.RESET}\n"
  }

  "wild" in {
    val wildCard = new Card(WildCard)
    wildCard.toString shouldBe
      s"\n${Console.BLACK}+----+\n" +
        s"${Console.BLACK}| #  |\n" +
        s"${Console.BLACK}+----+${Console.RESET}\n"
  }

  "wild draw 4" in {
    val wildDraw4Card = new Card(WildDraw4Card)
    wildDraw4Card.toString shouldBe
      s"\n${Console.BLACK}+----+\n" +
        s"${Console.BLACK}| #4 |\n" +
        s"${Console.BLACK}+----+${Console.RESET}\n"
  }

}

class FieldTests extends AnyWordSpec {
  "Field" should {
    "be empty" in {
      val field = Field(Card(ColoredCard(Red, Point(5))), Card(ColoredCard(Red, Point(5))))
      field.toString shouldBe
        s"\n${Console.RED}+----+\n" +
          s"${Console.RED}| 5  |\n" +
          s"${Console.RED}+----+${Console.RESET}\n"
    }
  }
}
