package cl.uchile.dcc.finalreality.model.character.player.mage

import cl.uchile.dcc.finalreality.exceptions.UnsupportedEquipmentException
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
import java.util.concurrent.LinkedBlockingQueue

val queueWMage = LinkedBlockingQueue<GameCharacter>()
lateinit var w_mage1: WhiteMage
lateinit var w_mage2: WhiteMage
lateinit var w_mage3: WhiteMage

fun setUpWhiteMage() {
    w_mage1 = WhiteMage("WhiteMage1", 10, 10, queueWMage, 10)
    w_mage2 = WhiteMage("WhiteMage1", 10, 10, queueWMage, 10)
    w_mage3 = WhiteMage("WhiteMage3", 15, 15, queueWMage, 15)
}

class WhiteMageTest : FunSpec({

    beforeEach {
        setUpWhiteMage()
        setUpAxe()
        setUpBow()
        setUpKnife()
        setUpStaff()
        setUpSword()
    }

    test("WhiteMage should be equal to itself") {
        w_mage1 shouldBeSameInstanceAs w_mage1
        w_mage1 shouldBe w_mage1
    }

    test("A WhiteMage is not equal to one of a different class") {
        w_mage1 shouldNotBe "$w_mage1"
    }

    test("Two WhiteMages with the same name should be equal") {
        w_mage1 shouldNotBeSameInstanceAs w_mage2
        w_mage1 shouldBe w_mage2
    }

    test("Two WhiteMages with different names should not be equal") {
        w_mage1 shouldNotBe w_mage3
    }

    test("Two WhiteMages with the same name should have the same hashcode") {
        w_mage1 should haveSameHashCodeAs(w_mage2)
    }

    test("Two WhiteMages with different names should have different hashcode") {
        w_mage1 shouldNot haveSameHashCodeAs(w_mage3)
    }

    test("The string representation of a w_mage should be correct") {
        "$w_mage1" shouldBe "WhiteMage { name= WhiteMage1, maxMp= 10, maxHp= 10, defense= 10, currentMp= 10, currentHp= 10 }"
    }

    test("A WhiteMage should equip a Staff") {
        w_mage1.equip(staff1)
        w_mage1.equippedWeapon shouldBe staff1
        w_mage1.waitTurn()
    }

    test("A WhiteMage shouldn't equip others weapons") {
        shouldThrow<UnsupportedEquipmentException> {
            w_mage1.equip(axe1)
        }
        shouldThrow<UnsupportedEquipmentException> {
            w_mage1.equip(bow1)
        }
        shouldThrow<UnsupportedEquipmentException> {
            w_mage1.equip(knife1)
        }
        shouldThrow<UnsupportedEquipmentException> {
            w_mage1.equip(sword1)
        }
    }
    test("pop the names of the character of the queue in the correct order") {
        w_mage1.equip(staff1)
        w_mage1.waitTurn()
        w_mage2.equip(staff3)
        w_mage2.waitTurn()
        Thread.sleep(6000)
        queueWMage.poll() == w_mage1
        queueWMage.poll() == w_mage2
    }
})
