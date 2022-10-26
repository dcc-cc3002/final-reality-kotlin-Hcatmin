/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.player.mage

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.inventory.GameWeapon
import cl.uchile.dcc.finalreality.model.inventory.magic.Staff
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.Axe
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.Knife
/* ktlint-disable no-wildcard-imports */
import java.util.* // https://pinterest.github.io/ktlint/faq/#how-do-i-globally-disable-a-rule
/* ktlint-enable no-wildcard-imports */
import java.util.concurrent.BlockingQueue

/**
 * A Black Mage is a type of player character that can cast black magic.
 *
 * @param name        the character's name
 * @param maxHp       the character's maximum health points
 * @param maxMp       the character's maximum magic points
 * @param defense     the character's defense
 * @param turnsQueue  the queue with the characters waiting for their turn
 * @constructor Creates a new Black Mage.
 *
 * @property currentMp The current MP of the character.
 * @property currentHp The current HP of the character.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
class BlackMage(
    name: String,
    maxHp: Int,
    defense: Int,
    turnsQueue: BlockingQueue<GameCharacter>,
    maxMp: Int,
) : AbstractMageCharacter(name, maxHp, defense, turnsQueue, maxMp) {

    override val equippedWeapon: GameWeapon
        get() = _equippedWeapon
//    source: https://stackoverflow.com/questions/33602705/best-way-to-implement-visitor-pattern-in-kotlin
    override fun equip(weapon: GameWeapon) {
    _equippedWeapon = when (weapon) {
        is Axe -> weapon
        is Staff -> weapon
        else -> throw AssertionError(weapon.javaClass)
    }
    }

    override fun equals(other: Any?) = when {
        this === other -> true
        other !is BlackMage -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        maxHp != other.maxHp -> false
        maxMp != other.maxMp -> false
        defense != other.defense -> false
        else -> true
    }

    override fun hashCode() =
        Objects.hash(BlackMage::class, name, maxHp, maxMp, defense)

    override fun toString() = "BlackMage { " +
        "name: '$name' " +
        "maxMp: $maxMp, " +
        "maxHp: $maxHp, " +
        "defense: $defense, " +
        "currentMp: $currentMp, " +
        "}"
}
