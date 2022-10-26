package cl.uchile.dcc.finalreality

import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.mage.WhiteMage
import cl.uchile.dcc.finalreality.model.character.player.melee.Engineer
import cl.uchile.dcc.finalreality.model.character.player.melee.Knight
import cl.uchile.dcc.finalreality.model.character.player.melee.Thief
import cl.uchile.dcc.finalreality.model.inventory.magic.MagicWeapon
import cl.uchile.dcc.finalreality.model.inventory.magic.Staff
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.Axe
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.Bow
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.Knife
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.Sword
import java.util.concurrent.LinkedBlockingQueue
import kotlin.random.Random

fun main() {
    println("Student: Roberto Alvarado Bustamante 20992516-8")
    println()
    println("--- Weapon test ---")
    val axe = Axe("Diamond Axe", 20, 35)
    val bow = Bow("Haunted Bow", 15, 18)
    val bow2 = Bow("Diamond Axe", 20, 35)
    val knife = Knife("Valkyrie Knife", 20, 9)
    val sword = Sword("Excalibur", 50, 50)
    val sword2 = Sword("Excalibur", 50, 50)
    print("axe = ")
    println(axe.toString())
    print("bow = ")
    println(bow.toString())
    print("bow2 = ")
    println(bow2.toString())
    println("axe == bow2 is " + axe.equals(bow2))
    println("bow2 == axe is " + bow2.equals(axe))
    print("knife = ")
    println(knife.toString())
    print("sword = ")
    println(sword.toString())
    print("sword2 = ")
    println(sword2.toString())
    println("sword == sword2 is " + sword.equals(sword2))
    println("sword2 == sword is " + sword2.equals(sword))
    println()
    println("--- MagicWeapon test ---")
    val staff1 = Staff("Staff1", 0, Random.nextInt(1, 50), 10)
    val staff2 = staff1
    val staff3 = Staff("Staff3", 0, Random.nextInt(1, 50), 20)
    print("staff1 = ")
    println(staff1.toString())
    print("staff2 = ")
    println(staff2.toString())
    print("staff3 = ")
    println(staff3.toString())
    print("staff1 == staff2 is ")
    println(staff1.equals(staff2))
    print("staff2 == staff1 is ")
    println(staff2.equals(staff1))
    print("staff1 == staff3 is ")
    println(staff1.equals(staff3))
    print("staff3 == staff1 is ")
    println(staff3.equals(staff1))

    try { // En la tarea 1, este try/catch podia NO fallar
        val queueEngineer = LinkedBlockingQueue<GameCharacter>()
        val magicweapon = Staff("", 0, Random.nextInt(1, 50),0)
        val character = Engineer("Genio", 10, 10, queueEngineer)
        character.equip(magicweapon)
        character.waitTurn()
        println("Try/Catch: Engineer was able to equip a magicweapon")
    } catch (e: AssertionError) {
        println("Error: A non-magic character tried to equip a magicweapon")
        println(e.message)
    }
    try { // Este try/catch no debiese fallar
        val queueBlackMage = LinkedBlockingQueue<GameCharacter>()
        val weapon = Axe("", 0, Random.nextInt(1, 50))
        val character = BlackMage("Mago X", 10, 5, queueBlackMage, 10)
        character.equip(weapon)
        character.waitTurn()
        println("Try/Catch: BlackMage was able to equip a melee weapon")
    } catch (e: AssertionError) {
        println("Error: BlackMage wasn't able to equip a melee weapon.")
        println(e.message)
    }

    try { // Este try/catch debiese fallar
        val queueWhiteMage = LinkedBlockingQueue<GameCharacter>()
        val weapon = Axe("", 0, Random.nextInt(1, 50))
        val character = WhiteMage("Mago Porfiado", 10, 5, queueWhiteMage, 10)
        character.equip(weapon)
        character.waitTurn()
        println("Try/Catch: WhiteMage was able to equip a melee weapon")
    } catch (e: AssertionError) {
        println("Error: WhiteMage wasn't able to equip a melee weapon.")
        println(e.message)
    }

    println("--- BlackMage Stats ---")
    val queueBlackMage = LinkedBlockingQueue<GameCharacter>()
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = Staff("", 0, Random.nextInt(1, 50), 0)
        val character = BlackMage("$i", 10, 5, queueBlackMage, 10)
        character.equip(weapon)
        character.waitTurn()
    }
    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000)
    while (!queueBlackMage.isEmpty()) {
        // Pops and prints the names of the characters of the queueBlackMage to illustrate the turns
        // order
        println(queueBlackMage.poll())
    }
    println("--- Engineer Stats ---")
    val queueEngineer = LinkedBlockingQueue<GameCharacter>()
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = Axe("", 0, Random.nextInt(1, 50))
        val character = Engineer("$i", 10, 10, queueEngineer)
        character.equip(weapon)
        character.waitTurn()
    }
    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000)
    while (!queueEngineer.isEmpty()) {
        // Pops and prints the names of the characters of the queueEngineer to illustrate the turns
        // order
        println(queueEngineer.poll())
    }
    println("--- Knight Stats ---")
    val queueKnight = LinkedBlockingQueue<GameCharacter>()
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = Sword("", 0, Random.nextInt(1, 50))
        val character = Knight("$i", 10, 10, queueKnight)
        character.equip(weapon)
        character.waitTurn()
    }
    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000)
    while (!queueKnight.isEmpty()) {
        // Pops and prints the names of the characters of the queueKnight to illustrate the turns
        // order
        println(queueKnight.poll())
    }
    println("--- Thief test ---")
    val queueThief = LinkedBlockingQueue<GameCharacter>()
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = Knife("", 0, Random.nextInt(1, 50))
        val character = Thief("$i", 10, 10, queueThief)
        character.equip(weapon)
        character.waitTurn()
    }
    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000)
    while (!queueThief.isEmpty()) {
        // Pops and prints the names of the characters of the queueThief to illustrate the turns
        // order
        println(queueThief.poll())
    }

    println("--- WhiteMage test ---")
    val queueWMage = LinkedBlockingQueue<GameCharacter>()
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = Staff("", 0, Random.nextInt(1, 50), 0)
        val character = WhiteMage("$i", 10, 10, queueWMage, 0)
        character.equip(weapon)
        character.waitTurn()
    }
    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000)
    while (!queueWMage.isEmpty()) {
        // Pops and prints the names of the characters of the queueWMage to illustrate the turns
        // order
        println(queueWMage.poll())
    }

    println("--- Enemy test ---")
    val queueEnemy = LinkedBlockingQueue<GameCharacter>()
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val character = Enemy("$i", 10, 10, 5, queueEnemy)
        character.waitTurn()
    }
    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000)
    while (!queueEnemy.isEmpty()) {
        // Pops and prints the names of the characters of the queueEnemy to illustrate the turns
        // order
        println(queueEnemy.poll())
    }

    println("--- All test ---")
    val queueAll = LinkedBlockingQueue<GameCharacter>()
    val blackmage1 = BlackMage("El mago Oscuro", 30, 15, queueAll, 20)
    val blackmage2 = blackmage1
    val blackmage3 = BlackMage("El mago Oscuro", 45, 20, queueAll, 25)
    print("blackmage1 = ")
    println(blackmage1.toString())
    print("blackmage2 = ")
    println(blackmage2.toString())
    print("blackmage3 = ")
    println(blackmage3.toString())
    println("blackmage1 == blackmage2 is " + blackmage1.equals(blackmage2))
    println("blackmage1 == blackmage3 is " + blackmage1.equals(blackmage3))
    val whitemage1 = WhiteMage("El Hechicero", 30, 15, queueAll, 20)
    val whitemage2 = whitemage1
    val whitemage3 = WhiteMage("El Hechicero", 45, 20, queueAll, 25)
    print("whitemage1 = ")
    println(whitemage1.toString())
    print("whitemage2 = ")
    println(whitemage2.toString())
    print("whitemage3 = ")
    println(whitemage3.toString())
    println("whitemage1 == whitemage2 is " + whitemage1.equals(whitemage2))
    println("whitemage1 == whitemage3 is " + whitemage1.equals(whitemage3))
    val engineer1 = Engineer("Engineer1", 30, 15, queueAll)
    val engineer2 = engineer1
    val engineer3 = Engineer("Engineer3", 45, 20, queueAll)
    print("engineer1 = ")
    println(engineer1.toString())
    print("engineer2 = ")
    println(engineer2.toString())
    print("engineer3 = ")
    println(engineer3.toString())
    println("engineer1 == engineer2 is " + engineer1.equals(engineer2))
    println("engineer1 == engineer3 is " + engineer1.equals(engineer3))
    val knight1 = Knight("Knight1", 30, 15, queueAll)
    val knight2 = knight1
    val knight3 = Knight("Knight3", 45, 20, queueAll)
    print("knight1 = ")
    println(knight1.toString())
    print("knight2 = ")
    println(knight2.toString())
    print("knight3 = ")
    println(knight3.toString())
    println("knight1 == knight2 is " + knight1.equals(knight2))
    println("knight1 == knight3 is " + knight1.equals(knight3))
    val thief1 = Thief("Thief1", 30, 15, queueAll)
    val thief2 = thief1
    val thief3 = Thief("Thief3", 45, 20, queueAll)
    print("thief1 = ")
    println(thief1.toString())
    print("thief2 = ")
    println(thief2.toString())
    print("thief3 = ")
    println(thief3.toString())
    println("thief1 == thief2 is " + thief1.equals(thief2))
    println("thief1 == thief3 is " + thief1.equals(thief3))
    val enemy1 = Enemy("Enemy1", 30, 15, 5, queueAll)
    val enemy2 = enemy1
    val enemy3 = Enemy("Enemy3", 45, 20, 5, queueAll)
    print("enemy1 = ")
    println(enemy1.toString())
    print("enemy2 = ")
    println(enemy2.toString())
    print("enemy3 = ")
    println(enemy3.toString())
    println("enemy1 == enemy2 is " + enemy1.equals(enemy2))
    println("enemy1 == enemy3 is " + enemy1.equals(enemy3))
    println()
    println("All next equals must be false:")
    println("------------------------------")
    println("blackmage1 == engineer1 is " + blackmage1.equals(engineer1))
    println("blackmage1 == knight1 is " + blackmage1.equals(knight1))
    println("blackmage1 == thief1 is " + blackmage1.equals(thief1))
    println("blackmage1 == whitemage1 is " + blackmage1.equals(whitemage1))
    println("blackmage1 == enemy1 is " + blackmage1.equals(enemy1))
    println("engineer1 == blackmage1 is " + engineer1.equals(blackmage1))
    println("engineer1 == knight1 is " + engineer1.equals(knight1))
    println("engineer1 == thief1 is " + engineer1.equals(thief1))
    println("engineer1 == whitemage1 is " + engineer1.equals(whitemage1))
    println("engineer1 == enemy1 is " + engineer1.equals(enemy1))
    println("knight1 == blackmage1 is " + knight1.equals(blackmage1))
    println("knight1 == engineer1 is " + knight1.equals(engineer1))
    println("knight1 == thief1 is " + knight1.equals(thief1))
    println("knight1 == whitemage1 is " + knight1.equals(whitemage1))
    println("knight1 == enemy1 is " + knight1.equals(enemy1))
    println("thief1 == blackmage1 is " + thief1.equals(blackmage1))
    println("thief1 == engineer1 is " + thief1.equals(engineer1))
    println("thief1 == knight1 is " + thief1.equals(knight1))
    println("thief1 == whitemage1 is " + thief1.equals(whitemage1))
    println("thief1 == enemy1 is " + thief1.equals(enemy1))
    println("whitemage1 == blackmage1 is " + whitemage1.equals(blackmage1))
    println("whitemage1 == engineer1 is " + whitemage1.equals(engineer1))
    println("whitemage1 == knight1 is " + whitemage1.equals(knight1))
    println("whitemage1 == thief1 is " + whitemage1.equals(thief1))
    println("whitemage1 == enemy1 is " + whitemage1.equals(enemy1))
    println("enemy1 == blackmage1 is " + enemy1.equals(blackmage1))
    println("enemy1 == engineer1 is " + enemy1.equals(engineer1))
    println("enemy1 == knight1 is " + enemy1.equals(knight1))
    println("enemy1 == thief1 is " + enemy1.equals(thief1))
    println("enemy1 == whitemage1 is " + enemy1.equals(whitemage1))
}
