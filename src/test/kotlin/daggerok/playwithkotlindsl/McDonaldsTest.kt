package daggerok.playwithkotlindsl

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class McDonaldsTest {

  @Test
  fun `test empty mcDonalds order`() {
    val order = mcDonalds {
    }

    val string = order.toString()
    val splits = string.split("=0")

    assertThat(splits).hasSizeGreaterThanOrEqualTo(7)
  }

  @Test
  fun `test non empty mcDonalds order`() {
    val order = mcDonalds {
      bigMac(1)
      FRIES(2)
      cocaCola(1)
    }

    val string = order.toString()
    assertThat(string.split("=0")).hasSizeGreaterThanOrEqualTo(7-3)
    assertThat(string.split("=1")).hasSizeGreaterThanOrEqualTo(2)
    assertThat(string.split("=0")).hasSizeGreaterThanOrEqualTo(1)
  }
}
