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

lateinit var sword1 : Sword
lateinit var sword2 : Sword
lateinit var sword3 : Sword

fun setUpSword() {
    sword1 = Sword("Sword1", 10, 10)
    sword2 = Sword("Sword1", 10, 10)
    sword3 = Sword("Sword3", 15, 15)
}
class SwordTest : FunSpec({

                              beforeEach {
                                  setUpSword()
                                  setUpStaff()
                              }

                              test("Sword should be equal to itself") {
                                  sword1 shouldBeSameInstanceAs sword1
                                  sword1 shouldBe sword1
                              }

                              test("A Sword is not equal to one of a different class") {
                                  sword1 shouldNotBe "$sword1"
                              }

                              test("Two Swords with the same name should be equal") {
                                  sword1 shouldNotBeSameInstanceAs sword2
                                  sword1 shouldBe sword2
                              }

                              test("Two Swords with different names should not be equal") {
                                  sword1 shouldNotBe sword3
                              }

                              test("Two Swords with the same name should have the same hashcode") {
                                  sword1 should haveSameHashCodeAs(sword2)
                              }

                              test("Two Swords with different names should have different hashcode") {
                                  sword1 shouldNot haveSameHashCodeAs(sword3)
                              }

                              test("The string representation of a sword should be correct") {
                                  "$sword1" shouldBe "Sword { name= Sword1, damage= 10, weight= 10 }"
                              }




                          })