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

lateinit var axe1: Axe
lateinit var axe2: Axe
lateinit var axe3: Axe

fun setUpAxe() {
    axe1 = Axe("Axe1", 10, 10)
    axe2 = Axe("Axe1", 10, 10)
    axe3 = Axe("Axe3", 15, 15)
}
class AxeTest : FunSpec({

    beforeEach {
        setUpAxe()
        setUpStaff()
    }

    test("Axe should be equal to itself") {
        axe1 shouldBeSameInstanceAs axe1
        axe1 shouldBe axe1
    }

    test("A Axe is not equal to one of a different class") {
        axe1 shouldNotBe "$axe1"
    }

    test("Two Axes with the same name should be equal") {
        axe1 shouldNotBeSameInstanceAs axe2
        axe1 shouldBe axe2
    }

    test("Two Axes with different names should not be equal") {
        axe1 shouldNotBe axe3
    }

    test("Two Axes with the same name should have the same hashcode") {
        axe1 should haveSameHashCodeAs(axe2)
    }

    test("Two Axes with different names should have different hashcode") {
        axe1 shouldNot haveSameHashCodeAs(axe3)
    }

    test("The string representation of a axe should be correct") {
        "$axe1" shouldBe "Axe { name= Axe1, damage= 10, weight= 10 }"
    }
})
