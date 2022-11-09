package cl.uchile.dcc.finalreality.model.character.player.mage

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.inventory.magic.setUpStaff
import cl.uchile.dcc.finalreality.model.inventory.magic.staff1
import cl.uchile.dcc.finalreality.model.inventory.magic.staff3
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

val queueBMage = LinkedBlockingQueue<GameCharacter>()
lateinit var b_mage1: BlackMage
lateinit var b_mage2: BlackMage
lateinit var b_mage3: BlackMage

fun setUpBlackMage() {
    b_mage1 = BlackMage("BlackMage1", 10, 10, queueBMage, 10)
    b_mage2 = BlackMage("BlackMage1", 10, 10, queueBMage, 10)
    b_mage3 = BlackMage("BlackMage3", 15, 15, queueBMage, 15)
}

class BlackMageTest : FunSpec({

    beforeEach {
        setUpBlackMage()
        setUpAxe()
        setUpBow()
        setUpKnife()
        setUpStaff()
        setUpSword()
    }

    test("BlackMage should be equal to itself") {
        b_mage1 shouldBeSameInstanceAs b_mage1
        b_mage1 shouldBe b_mage1
    }

    test("A BlackMage is not equal to one of a different class") {
        b_mage1 shouldNotBe "$b_mage1"
    }

    test("Two BlackMages with the same name should be equal") {
        b_mage1 shouldNotBeSameInstanceAs b_mage2
        b_mage1 shouldBe b_mage2
    }

    test("Two BlackMages with different names should not be equal") {
        b_mage1 shouldNotBe b_mage3
    }

    test("Two BlackMages with the same name should have the same hashcode") {
        b_mage1 should haveSameHashCodeAs(b_mage2)
    }

    test("Two BlackMages with different names should have different hashcode") {
        b_mage1 shouldNot haveSameHashCodeAs(b_mage3)
    }

    test("The string representation of a b_mage should be correct") {
        "$b_mage1" shouldBe "BlackMage { name= BlackMage1, maxMp= 10, maxHp= 10, defense= 10, currentMp= 10, currentHp= 10 }"
    }

    test("A BlackMage should equip an Axe and a Staff") {
        b_mage1.equip(knife1)
        b_mage1.equippedWeapon shouldBe knife1
        b_mage1.waitTurn()
        b_mage1.equip(staff1)
        b_mage1.equippedWeapon shouldBe staff1
        b_mage1.waitTurn()
    }

    test("A BlackMage shouldn't equip others weapons") {
        shouldThrow<AssertionError> {
            b_mage1.equip(axe1)
        }
        shouldThrow<AssertionError> {
            b_mage1.equip(bow1)
        }
        shouldThrow<AssertionError> {
            b_mage1.equip(sword1)
        }
    }

    test("pop the names of the character of the queue in the correct order") {
        b_mage1.equip(staff1)
        b_mage1.waitTurn()
        b_mage2.equip(staff3)
        b_mage2.waitTurn()
        Thread.sleep(6000)
        queueBMage.poll() shouldBe b_mage1
        queueBMage.poll() shouldBe b_mage2
    }
})