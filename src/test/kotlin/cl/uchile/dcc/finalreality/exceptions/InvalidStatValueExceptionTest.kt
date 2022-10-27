package cl.uchile.dcc.finalreality.exceptions

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.checkAll
import org.junit.jupiter.api.assertThrows

class InvalidStatValueExceptionSpec : FunSpec({
    val prefix = "The required condition is not met. "

    test("An invalid stat value exception can be thrown with a message.") {
      checkAll<String> { message ->
          assertThrows<InvalidStatValueException> {
              throw InvalidStatValueException(message)
          }.message shouldBe prefix + message
      }
    }
})
