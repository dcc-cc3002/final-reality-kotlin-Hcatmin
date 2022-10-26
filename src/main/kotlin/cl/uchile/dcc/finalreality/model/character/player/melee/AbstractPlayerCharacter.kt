package cl.uchile.dcc.finalreality.model.character.player.melee

import cl.uchile.dcc.finalreality.model.character.AbstractCharacter
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter
import cl.uchile.dcc.finalreality.model.inventory.GameWeapon
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

    protected lateinit var _equippedWeapon: GameWeapon
    override val equippedWeapon: GameWeapon
        get() = _equippedWeapon

    override fun waitTurn() {
        scheduledExecutor = Executors.newSingleThreadScheduledExecutor()
        scheduledExecutor.schedule(
            /* command = */ ::addToQueue,
            /* delay = */ (this.equippedWeapon.weight / 10).toLong(),
            /* unit = */ TimeUnit.SECONDS
        )
    }
}
