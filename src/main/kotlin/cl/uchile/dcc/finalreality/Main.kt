package cl.uchile.dcc.finalreality

import cl.uchile.dcc.finalreality.model.Weapon
import cl.uchile.dcc.finalreality.model.WeaponType
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import java.util.concurrent.LinkedBlockingQueue
import kotlin.random.Random

fun main() {
    println("Student: Roberto Alvarado Bustamante 20992516-8")
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
        val weapon = Weapon("", 0, Random.nextInt(1, 50), WeaponType.KNIFE)
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
