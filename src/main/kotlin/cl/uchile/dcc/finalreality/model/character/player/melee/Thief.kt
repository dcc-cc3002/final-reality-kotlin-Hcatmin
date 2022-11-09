/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.player.melee

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.inventory.GameWeapon
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.Bow
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.Knife
import cl.uchile.dcc.finalreality.model.inventory.nonmagic.Sword
import java.lang.AssertionError
/* ktlint-disable no-wildcard-imports */
import java.util.* // https://pinterest.github.io/ktlint/faq/#how-do-i-globally-disable-a-rule
/* ktlint-enable no-wildcard-imports */
import java.util.concurrent.BlockingQueue

/**
 * A `Thief` is a type of [PlayerCharacter] that can equip `Sword`s, `Knife`s and `Bow`s.
 *
 * @param name        the character's name
 * @param maxHp       the character's maximum health points
 * @param defense     the character's defense
 * @param turnsQueue  the queue with the characters waiting for their turn
 * @constructor Creates a new Thief.
 *
 * @property currentHp The current HP of the character.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
class Thief(
    name: String,
    maxHp: Int,
    defense: Int,
    turnsQueue: BlockingQueue<GameCharacter>,
) :
    AbstractPlayerCharacter(name, maxHp, defense, turnsQueue) {

    override fun equals(other: Any?) = when {
        this === other -> true
        other !is Thief -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        maxHp != other.maxHp -> false
        defense != other.defense -> false
        else -> true
    }

    override fun hashCode() = Objects.hash(Thief::class, name, maxHp, defense)

    override fun toString() =
        "Thief { name= $name, maxHp= $maxHp, defense= $defense, currentHp= $currentHp }"

    override fun equip(weapon: GameWeapon) {
        _equippedWeapon = weapon.isEquipped(this);
    }
}
