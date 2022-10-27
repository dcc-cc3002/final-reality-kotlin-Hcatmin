package cl.uchile.dcc.finalreality.model.inventory.nonmagic

import cl.uchile.dcc.finalreality.model.inventory.magic.setUpStaff
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs

lateinit var bow1 : Bow
lateinit var bow2 : Bow
lateinit var bow3 : Bow

fun setUpBow() {
    bow1 = Bow("Bow1", 10, 10)
    bow2 = Bow("Bow1", 10, 10)
    bow3 = Bow("Bow3", 15, 15)
}
class BowTest : FunSpec({

    beforeEach {
        setUpBow()
        setUpStaff()
    }

    test("Bow should be equal to itself") {
        bow1 shouldBeSameInstanceAs bow1
        bow1 shouldBe bow1
    }

    test("A Bow is not equal to one of a different class") {
        bow1 shouldNotBe "$bow1"
    }

    test("Two Bows with the same name should be equal") {
        bow1 shouldNotBeSameInstanceAs bow2
        bow1 shouldBe bow2
    }

    test("Two Bows with different names should not be equal") {
        bow1 shouldNotBe bow3
    }

    test("Two Bows with the same name should have the same hashcode") {
        bow1 should haveSameHashCodeAs(bow2)
    }

    test("Two Bows with different names should have different hashcode") {
        bow1 shouldNot haveSameHashCodeAs(bow3)
    }

    test("The string representation of a bow should be correct") {
        "$bow1" shouldBe "Bow { name= Bow1, damage= 10, weight= 10 }"
    }




                        })
