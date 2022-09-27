package cl.uchile.dcc.finalreality

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import cl.uchile.dcc.finalreality.model.inventory.MagicWeapon
import cl.uchile.dcc.finalreality.model.inventory.MagicWeaponType
import cl.uchile.dcc.finalreality.model.inventory.Weapon
import cl.uchile.dcc.finalreality.model.inventory.WeaponType
import java.util.concurrent.LinkedBlockingQueue
import kotlin.random.Random

fun main() {
    println("Student: Roberto Alvarado Bustamante 20992516-8")
    println("Weapon test:")
    val axe = Weapon("Diamond Axe", 20, 35, WeaponType.AXE)
    val bow = Weapon("Haunted Bow", 15, 18, WeaponType.BOW)
    val bow2 = Weapon("Diamond Axe", 20, 35, WeaponType.BOW)
    val knife = Weapon("Valkyrie Knife", 20, 9, WeaponType.KNIFE)
    val sword = Weapon("Excalibur", 50, 50, WeaponType.SWORD)
    val sword2 = Weapon("Excalibur", 50, 50, WeaponType.SWORD)
    print("axe = ")
    println(axe.toString())
    print("bow = ")
    println(bow.toString())
    print("bow2 = ")
    println(bow2.toString())
    println("axe == bow2 is " + axe.equals(bow2))
    print("knife = ")
    println(knife.toString())
    print("sword = ")
    println(sword.toString())
    print("sword2 = ")
    println(sword2.toString())
    println("sword == sword2 is " + sword.equals(sword2))
    println("MagicWeapon test")
    val staff2 = MagicWeapon("", 0, Random.nextInt(1, 50), MagicWeaponType.STAFF, 0)
    println(staff2.toString())
    println("BlackMage")
    val queueBlackMage = LinkedBlockingQueue<GameCharacter>()
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = MagicWeapon("", 0, Random.nextInt(1, 50), MagicWeaponType.STAFF, 0)
        val character = BlackMage("$i", 10, 5, 10, queueBlackMage)
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
    println("Engineer Stats")
    val queueEngineer = LinkedBlockingQueue<GameCharacter>()
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = Weapon("", 0, Random.nextInt(1, 50), WeaponType.AXE)
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
    println("Knight Stats:")
    val queueKnight = LinkedBlockingQueue<GameCharacter>()
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = Weapon("", 0, Random.nextInt(1, 50), WeaponType.SWORD)
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
    println("Thief test")
    val queueThief = LinkedBlockingQueue<GameCharacter>()
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = Weapon("", 0, Random.nextInt(1, 50), WeaponType.KNIFE)
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

    println("WhiteMage test")
    val queueWMage = LinkedBlockingQueue<GameCharacter>()
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = MagicWeapon("", 0, Random.nextInt(1, 50), MagicWeaponType.STAFF, 0)
        val character = WhiteMage("$i", 10, 5, 10, queueWMage)
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
}
