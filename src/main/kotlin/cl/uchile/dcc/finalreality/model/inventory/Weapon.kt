package cl.uchile.dcc.finalreality.model.inventory

import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.mage.WhiteMage
import cl.uchile.dcc.finalreality.model.character.player.melee.Engineer
import cl.uchile.dcc.finalreality.model.character.player.melee.Knight
import cl.uchile.dcc.finalreality.model.character.player.melee.Thief

/**
 * This represents a weapon from the game.
 * A weapon can be normal.
 *
 * @property name String
 *     The name of the weapon.
 * @property damage Int
 *     The base damage done by the weapon.
 * @property weight Int
 *     The weight of the weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */

interface Weapon {
    val name: String
    val damage: Int
    val weight: Int

    fun equipToBlackMage(blackMage: BlackMage)
    fun equipToEngineer(engineer: Engineer)
    fun equipToKnight(knight: Knight)
    fun equipToThief(thief: Thief)
    fun equipToWhiteMage(whiteMage: WhiteMage)
}
