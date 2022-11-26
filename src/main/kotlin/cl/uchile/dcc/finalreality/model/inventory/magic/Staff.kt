package cl.uchile.dcc.finalreality.model.inventory.magic

import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.mage.WhiteMage
import cl.uchile.dcc.finalreality.model.inventory.AbstractWeapon

/**
 * This represents a staff weapon from the game.
 *
 * @property name String
 *     The name of the magic weapon.
 * @property damage Int
 *     The base damage done by the magic weapon.
 * @property magicdamage Int
 *     The base magic damage done by the magic weapon.
 * @property weight Int
 *     The weight of the magic weapon.
 *
 * @constructor Creates a magic weapon with a name, a base damage and magic damage, speed.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Roberto Alvarado~
 */
class Staff(
    override val name: String,
    override val damage: Int,
    override val weight: Int,
    override val magicdamage: Int
) : AbstractWeapon(name, damage, weight), MagicWeapon {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Staff

        if (name != other.name) return false
        if (damage != other.damage) return false
        if (weight != other.weight) return false
        if (magicdamage != other.magicdamage) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + damage
        result = 31 * result + weight
        result = 31 * result + magicdamage
        return result
    }

    override fun toString(): String {
        return "Staff { name= $name, damage= $damage, weight= $weight, magicdamage= $magicdamage }"
    }

    override fun equipToBlackMage(blackMage: BlackMage) {
        blackMage.equipStaff(this)
    }

    override fun equipToWhiteMage(whiteMage: WhiteMage) {
        whiteMage.equipStaff(this)
    }
}
