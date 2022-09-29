package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.exceptions.Require
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import java.util.concurrent.BlockingQueue

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
    var maxMp = Require.Stat(maxMp, "Max MP") atLeast 0
    var currentMp: Int = maxMp
        set(value) {
            field = Require.Stat(value, "Current MP") inRange 0..maxMp
        }
}
