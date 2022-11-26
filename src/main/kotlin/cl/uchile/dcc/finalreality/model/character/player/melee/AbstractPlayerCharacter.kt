package cl.uchile.dcc.finalreality.model.character.player.melee

import cl.uchile.dcc.finalreality.exceptions.UnsupportedEquipmentException
import cl.uchile.dcc.finalreality.model.character.AbstractCharacter
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter
import cl.uchile.dcc.finalreality.model.inventory.Weapon
import cl.uchile.dcc.finalreality.model.inventory.magic.Staff
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.Axe
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.Bow
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.Knife
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.Sword
import java.util.concurrent.BlockingQueue
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * A class that holds all the information of a player-controlled character in the game.
 *
 * @param name        the character's name
 * @param maxHp       the character's maximum health points
 * @param defense     the character's defense
 * @param turnsQueue  the queue with the characters waiting for their turn
 * @constructor Creates a new playable character.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
abstract class AbstractPlayerCharacter(
    name: String,
    maxHp: Int,
    defense: Int,
    turnsQueue: BlockingQueue<GameCharacter>
) : AbstractCharacter(name, maxHp, defense, turnsQueue), PlayerCharacter {

    protected lateinit var _equippedWeapon: Weapon
    override val equippedWeapon: Weapon
        get() = _equippedWeapon

    override fun waitTurn() {
        scheduledExecutor = Executors.newSingleThreadScheduledExecutor()
        scheduledExecutor.schedule(
            /* command = */ ::addToQueue,
            /* delay = */ (this.equippedWeapon.weight / 10).toLong(),
            /* unit = */ TimeUnit.SECONDS
        )
    }

    open fun equipAxe(axe: Axe) {
        throw UnsupportedEquipmentException(this, axe)
    }
    open fun equipBow(bow: Bow) {
        throw UnsupportedEquipmentException(this, bow)
    }
    open fun equipKnife(knife: Knife) {
        throw UnsupportedEquipmentException(this, knife)
    }
    open fun equipStaff(staff: Staff) {
        throw UnsupportedEquipmentException(this, staff)
    }
    open fun equipSword(sword: Sword) {
        throw UnsupportedEquipmentException(this, sword)
    }
}
