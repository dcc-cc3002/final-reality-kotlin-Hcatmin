package cl.uchile.dcc.finalreality.model.character.player.melee

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.inventory.magic.setUpStaff
import cl.uchile.dcc.finalreality.model.inventory.magic.staff1
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.axe1
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.bow1
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.knife1
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.knife3
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
import java.util.concurrent.LinkedBlockingQueue

val queueThief = LinkedBlockingQueue<GameCharacter>()
lateinit var thief1: Thief
lateinit var thief2: Thief
lateinit var thief3: Thief

fun setUpThief() {
    thief1 = Thief("Thief1", 10, 10, queueThief)
    thief2 = Thief("Thief1", 10, 10, queueThief)
    thief3 = Thief("Thief3", 15, 15, queueThief)
}

class ThiefTest : FunSpec({

    beforeEach {
        setUpThief()
        setUpAxe()
        setUpBow()
        setUpKnife()
        setUpStaff()
        setUpSword()
    }

    test("Thief should be equal to itself") {
        thief1 shouldBeSameInstanceAs thief1
        thief1 shouldBe thief1
    }

    test("A Thief is not equal to one of a different class") {
        thief1 shouldNotBe "$thief1"
    }

    test("Two Thiefs with the same name should be equal") {
        thief1 shouldNotBeSameInstanceAs thief2
        thief1 shouldBe thief2
    }

    test("Two Thiefs with different names should not be equal") {
        thief1 shouldNotBe thief3
    }

    test("Two Thiefs with the same name should have the same hashcode") {
        thief1 should haveSameHashCodeAs(thief2)
    }

    test("Two Thiefs with different names should have different hashcode") {
        thief1 shouldNot haveSameHashCodeAs(thief3)
    }

    test("The string representation of a thief should be correct") {
        "$thief1" shouldBe "Thief { name= Thief1, maxHp= 10, defense= 10, currentHp= 10 }"
    }

    test("A Thief should equip a Bow, a Knife and a Sword") {
        thief1.equip(bow1)
        thief1.equippedWeapon shouldBe bow1
        thief1.waitTurn()
        thief1.equip(knife1)
        thief1.equippedWeapon shouldBe knife1
        thief1.waitTurn()
        thief1.equip(sword1)
        thief1.equippedWeapon shouldBe sword1
        thief1.waitTurn()
    }

    test("A Thief shouldn't equip the others weapon") {
        shouldThrow<AssertionError> {
            thief1.equip(axe1)
        }
        shouldThrow<AssertionError> {
            thief1.equip(staff1)
        }
    }

    test("pop the names of the character of the queue in the correct order") {
        thief1.equip(knife1)
        thief1.waitTurn()
        thief2.equip(knife3)
        thief2.waitTurn()
        Thread.sleep(6000)
        queueThief.poll() == thief1
        queueThief.poll() == thief2
    }
})
