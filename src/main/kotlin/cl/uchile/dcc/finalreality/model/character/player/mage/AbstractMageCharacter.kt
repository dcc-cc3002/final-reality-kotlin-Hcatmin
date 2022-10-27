package cl.uchile.dcc.finalreality.model.character.player.mage

import cl.uchile.dcc.finalreality.exceptions.Require
import cl.uchile.dcc.finalreality.model.character.AbstractCharacter
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter
import cl.uchile.dcc.finalreality.model.character.player.melee.AbstractPlayerCharacter
import cl.uchile.dcc.finalreality.model.inventory.GameWeapon
import cl.uchile.dcc.finalreality.model.inventory.magic.MagicWeapon
import java.util.concurrent.BlockingQueue
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * A class that holds all the information of a player-controlled mage-character in the game.
 *
 * @param name        the mage's name
 * @param maxHp       the mage's maximum health points
 * @param defense     the mage's defense
 * @param turnsQueue  the queue with the mages waiting for their turn
 * @param maxMp       the mage's maximum mana points
 * @constructor Creates a new playable mage.
 *
 * @property currentMp The current MP of the character.
 * @property currentHp The current HP of the character.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
abstract class AbstractMageCharacter(
    name: String,
    maxHp: Int,
    defense: Int,
    turnsQueue: BlockingQueue<GameCharacter>,
    maxMp: Int,
) : AbstractPlayerCharacter(name, maxHp, defense, turnsQueue) {

    val maxMp = Require.Stat(maxMp, "Max MP") atLeast 0
    var currentMp: Int = maxMp
        set(value) {
            field = Require.Stat(value, "Current MP") inRange 0..maxMp
        }
}
