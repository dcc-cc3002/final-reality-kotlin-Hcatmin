package cl.uchile.dcc.finalreality.model.inventory.magic

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs


lateinit var staff1: Staff
lateinit var staff2: Staff
lateinit var staff3: Staff

fun setUpStaff() {
    staff1 = Staff("Staff1", 10, 10, 10)
    staff2 = Staff("Staff1", 10, 10, 10)
    staff3 = Staff("Staff3", 17, 17, 17)
}

open class StaffTest : FunSpec({
    beforeEach {
       setUpStaff()
    }
    test("Staff should be equal to itself") {
       staff1 shouldBeSameInstanceAs staff1
       staff1 shouldBe staff1
    }

    test("A Staff is not equal to one of a different class") {
       staff1 shouldNotBe "$staff1"
    }

    test("Two Staffs with the same name should be equal") {
       staff1 shouldNotBeSameInstanceAs staff2
       staff1 shouldBe staff2
    }

    test("Two Staffs with different names should not be equal") {
       staff1 shouldNotBe staff3
    }

    test("Two Staffs with the same name should have the same hashcode") {
       staff1 should haveSameHashCodeAs(staff2)
    }

    test("Two Staffs with different names should have different hashcode") {
       staff1 shouldNot haveSameHashCodeAs(staff3)
    }

    test("The string representation of a staff should be correct") {
        "$staff1" shouldBe "Staff { name= Staff1, damage= 10, weight= 10, magicdamage= 10 }"
    }

})
