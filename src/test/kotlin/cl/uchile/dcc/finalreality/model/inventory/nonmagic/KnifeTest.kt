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

lateinit var knife1 : Knife
lateinit var knife2 : Knife
lateinit var knife3 : Knife

fun setUpKnife() {
    knife1 = Knife("Knife1", 10, 10)
    knife2 = Knife("Knife1", 10, 10)
    knife3 = Knife("Knife3", 15, 15)
}
class KnifeTest : FunSpec({

                              beforeEach {
                                  setUpKnife()
                                  setUpStaff()
                              }

                              test("Knife should be equal to itself") {
                                  knife1 shouldBeSameInstanceAs knife1
                                  knife1 shouldBe knife1
                              }

                              test("A Knife is not equal to one of a different class") {
                                  knife1 shouldNotBe "$knife1"
                              }

                              test("Two Knifes with the same name should be equal") {
                                  knife1 shouldNotBeSameInstanceAs knife2
                                  knife1 shouldBe knife2
                              }

                              test("Two Knifes with different names should not be equal") {
                                  knife1 shouldNotBe knife3
                              }

                              test("Two Knifes with the same name should have the same hashcode") {
                                  knife1 should haveSameHashCodeAs(knife2)
                              }

                              test("Two Knifes with different names should have different hashcode") {
                                  knife1 shouldNot haveSameHashCodeAs(knife3)
                              }

                              test("The string representation of a knife should be correct") {
                                  "$knife1" shouldBe "Knife { name= Knife1, damage= 10, weight= 10 }"
                              }




                          })