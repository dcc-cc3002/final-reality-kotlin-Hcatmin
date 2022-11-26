package cl.uchile.dcc.finalreality.model.character.player.melee

import cl.uchile.dcc.finalreality.exceptions.UnsupportedEquipmentException
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.inventory.magic.setUpStaff
import cl.uchile.dcc.finalreality.model.inventory.magic.staff1
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.axe1
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.axe3
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

val queueEngineer = LinkedBlockingQueue<GameCharacter>()
lateinit var engineer1: Engineer
lateinit var engineer2: Engineer
lateinit var engineer3: Engineer

fun setUpEngineer() {
    engineer1 = Engineer("Engineer1", 10, 10, queueEngineer)
    engineer2 = Engineer("Engineer1", 10, 10, queueEngineer)
    engineer3 = Engineer("Engineer3", 15, 15, queueEngineer)
}

class EngineerTest : FunSpec({

    beforeEach {
        setUpEngineer()
        setUpAxe()
        setUpBow()
        setUpKnife()
        setUpStaff()
        setUpSword()
    }

    test("Engineer should be equal to itself") {
        engineer1 shouldBeSameInstanceAs engineer1
        engineer1 shouldBe engineer1
    }

    test("A Engineer is not equal to one of a different class") {
        engineer1 shouldNotBe "$engineer1"
    }

    test("Two Engineers with the same name should be equal") {
        engineer1 shouldNotBeSameInstanceAs engineer2
        engineer1 shouldBe engineer2
    }

    test("Two Engineers with different names should not be equal") {
        engineer1 shouldNotBe engineer3
    }

    test("Two Engineers with the same name should have the same hashcode") {
        engineer1 should haveSameHashCodeAs(engineer2)
    }

    test("Two Engineers with different names should have different hashcode") {
        engineer1 shouldNot haveSameHashCodeAs(engineer3)
    }

    test("The string representation of a engineer should be correct") {
        "$engineer1" shouldBe "Engineer { name= Engineer1, maxHp= 10, defense= 10, currentHp= 10 }"
    }

    test("An Engineer should equip an Axe and a Bow weapon") {
        engineer1.equip(axe1)
        engineer1.equippedWeapon shouldBe axe1
        engineer1.waitTurn()
        engineer1.equip(bow1)
        engineer1.equippedWeapon shouldBe bow1
        engineer1.waitTurn()
    }

    test("An Engineer shouldn't equip the others weapons") {
        shouldThrow<UnsupportedEquipmentException> {
            engineer1.equip(knife1)
        }
        shouldThrow<UnsupportedEquipmentException> {
            engineer1.equip(staff1)
        }
        shouldThrow<UnsupportedEquipmentException> {
            engineer1.equip(sword1)
        }
    }

    test("pop the names of the character of the queue in the correct order") {
        engineer1.equip(axe1)
        engineer1.waitTurn()
        engineer2.equip(axe3)
        engineer2.waitTurn()
        Thread.sleep(6000)
        queueEngineer.poll() == engineer1
        queueEngineer.poll() == engineer2
    }
})
