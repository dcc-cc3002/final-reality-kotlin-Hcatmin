package cl.uchile.dcc.finalreality.model.character.player.melee

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.inventory.magic.setUpStaff
import cl.uchile.dcc.finalreality.model.inventory.magic.staff1
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.axe1
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.bow1
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.knife1
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.setUpAxe
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.setUpBow
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.setUpKnife
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.setUpSword
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.sword1
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.lang.AssertionError
import java.util.concurrent.LinkedBlockingQueue

lateinit var knight1 : Knight
lateinit var knight2 : Knight
lateinit var knight3 : Knight

fun setUpKnight() {
    val queueAll = LinkedBlockingQueue<GameCharacter>()
    knight1 = Knight("Knight1", 10, 10, queueAll)
    knight2 = Knight("Knight1", 10, 10, queueAll)
    knight3 = Knight("Knight3", 15, 15, queueAll)
}

class KnightTest : FunSpec({

                               beforeEach {
                                   setUpKnight()
                                   setUpAxe()
                                   setUpBow()
                                   setUpKnife()
                                   setUpStaff()
                                   setUpSword()
                               }

                               test("Knight should be equal to itself") {
                                   knight1 shouldBeSameInstanceAs knight1
                                   knight1 shouldBe knight1
                               }

                               test("A Knight is not equal to one of a different class") {
                                   knight1 shouldNotBe "$knight1"
                               }

                               test("Two Knights with the same name should be equal") {
                                   knight1 shouldNotBeSameInstanceAs knight2
                                   knight1 shouldBe knight2
                               }

                               test("Two Knights with different names should not be equal") {
                                   knight1 shouldNotBe knight3
                               }

                               test("Two Knights with the same name should have the same hashcode") {
                                   knight1 should haveSameHashCodeAs(knight2)
                               }

                               test("Two Knights with different names should have different hashcode") {
                                   knight1 shouldNot haveSameHashCodeAs(knight3)
                               }

                               test("The string representation of a knight should be correct") {
                                   "$knight1" shouldBe "Knight { name= Knight1, maxHp= 10, defense= 10, currentHp= 10 }"
                               }

                               test("A Knight should equip an Axe, a Knife and a Sword") {
                                   knight1.equip(axe1)
                                   knight1.waitTurn()
                                   knight1.equip(knife1)
                                   knight1.waitTurn()
                                   knight1.equip(sword1)
                                   knight1.waitTurn()
                                   knight1.equip(bow1)
                                   knight1.waitTurn()
                                   knight1.equip(staff1)
                                   knight1.waitTurn()
                               }


                           })