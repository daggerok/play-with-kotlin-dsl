package daggerok.playwithkotlindsl

fun testStarbucks() {
  val order = starbucks {
    hotCoffees {
      roast = 2
    }
    hotTeas {
      chaiLatte = 1
      teavana = 2
    }
    coldDrinks {
      iceGoldenGingerDrink = 1
    }
  }
  println(order)
}

fun starbucks(block: Starbucks.() -> Unit): Starbucks =
    Starbucks().apply(block)

data class Starbucks(var hotCoffees: HotCoffees = HotCoffees(),
                     var hotTeas: HotTeasDsl = HotTeasDsl(),
                     var coldDrinks: ColdDrinksDsl = ColdDrinksDsl()) {

  fun hotCoffees(block: HotCoffees.() -> Unit) {
    hotCoffees = HotCoffees().apply(block)
  }

  fun hotTeas(block: HotTeasDsl.() -> Unit) {
    hotTeas = HotTeasDsl().apply(block)
  }

  fun coldDrinks(block: ColdDrinksDsl.() -> Unit) {
    coldDrinks = ColdDrinksDsl().apply(block)
  }
}

data class HotCoffees(var roast: Int = 0,
                      var misto: Int = 0)

data class HotTeasDsl(var chaiLatte: Int = 0,
                      var teavana: Int = 0,
                      var earlGreyTea: Int = 0)

data class ColdDrinksDsl(var iceGoldenGingerDrink: Int = 0)
