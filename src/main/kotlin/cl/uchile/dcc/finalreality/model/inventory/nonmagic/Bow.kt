package cl.uchile.dcc.finalreality.model.inventory.nonmagic

import cl.uchile.dcc.finalreality.model.character.player.melee.Engineer
import cl.uchile.dcc.finalreality.model.character.player.melee.Thief
import cl.uchile.dcc.finalreality.model.inventory.AbstractWeapon

/**
 * This represents a bow weapon from the game.
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
class Bow(
    override val name: String,
    override val damage: Int,
    override val weight: Int
) : AbstractWeapon(name, damage, weight) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Bow

        if (name != other.name) return false
        if (damage != other.damage) return false
        if (weight != other.weight) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + damage
        result = 31 * result + weight
        return result
    }

    override fun toString(): String {
        return "Bow { name= $name, damage= $damage, weight= $weight }"
    }

    override fun equipToEngineer(engineer: Engineer) {
        engineer.equipBow(this)
    }

    override fun equipToThief(thief: Thief) {
        thief.equipBow(this)
    }
}
