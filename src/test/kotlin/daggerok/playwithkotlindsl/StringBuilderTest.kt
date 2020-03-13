package daggerok.playwithkotlindsl

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringBuilderTest {

  /**
   * How to write Kotlin DSLs
   * see: ~/.m2/repositories/org/jetbrains/kotlin/kotlin-stdlib-common/1.3.61/kotlin-stdlib-common-1.3.61-sources.jar!/kotlin/text/StringBuilder.kt:16
   */
  @Test
  fun `should test builder receiver`() {
    val actual = buildString {
      append("<")
      append("MindOrks")
      append(">")
    }
    assertThat(actual).isEqualTo("<MindOrks>")
  }
}
