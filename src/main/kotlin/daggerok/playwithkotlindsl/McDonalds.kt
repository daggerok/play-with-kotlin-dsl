package daggerok.playwithkotlindsl

fun testMcDonalds() {
  val order = mcDonalds {
    bigMac(1)
    FRIES(2)
    cocaCola(1)
  }
  println(order)
}

fun mcDonalds(block: McDonaldsDsl.() -> Unit): McDonaldsDsl =
    McDonaldsDsl().apply(block)

data class McDonaldsDsl(private var bigMac: Int = 0,
                        private var cheeseburger: Int = 0,
                        private var FRIES: Int = 0,
                        private var SIDES: Int = 0,
                        private var coffee: Int = 0,
                        private var mocha: Int = 0,
                        private var cocaCola: Int = 0) {

  fun bigMac(amount: Int) { bigMac = amount }
  fun cheeseburger(amount: Int) { cheeseburger = amount }
  fun FRIES(amount: Int) { FRIES = amount }
  fun SIDES(amount: Int) { SIDES = amount }
  fun coffee(amount: Int) { coffee = amount }
  fun mocha(amount: Int) { mocha = amount }
  fun cocaCola(amount: Int) { cocaCola = amount }
}
