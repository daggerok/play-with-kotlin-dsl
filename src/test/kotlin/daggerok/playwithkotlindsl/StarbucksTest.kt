package daggerok.playwithkotlindsl

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class StarbucksTest {

  @Test
  fun `test starbucks empty order`() {
    val starbucks = starbucks { }
    val order = starbucks.toString()
    val splits = order.split("=0")
    assertThat(splits.size).isGreaterThanOrEqualTo(6)
  }

  @Test
  fun `test starbucks non empty order`() {
    val starbucks = starbucks {
      hotCoffees {
        misto = 1
        roast = 2
      }
    }
    val order = starbucks.toString()
    assertThat(order).contains("misto=1")
    assertThat(order).contains("roast=2")
  }

  @Test
  fun `test starbucks all items order`() {
    val order = starbucks {
      hotCoffees {
        misto = 1
        roast = 2
      }
      hotTeas {
        teavana = 1
        earlGreyTea = 3
        chaiLatte = 2
      }
      coldDrinks {
        iceGoldenGingerDrink = 5
      }
    }
    assertTrue(order.hotTeas.earlGreyTea == 3)
    assertThat(order.coldDrinks.iceGoldenGingerDrink).isEqualTo(5)
    // ...
  }
}
