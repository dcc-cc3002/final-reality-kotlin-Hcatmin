package cl.uchile.dcc.finalreality.model.inventory

import java.util.Objects

/**
 * A class that holds all the information of a magic weapon.
 *
 * @property name String
 *     The name of the magic weapon.
 * @property damage Int
 *     The base damage done by the magic weapon.
 * @property magicdamage Int
 *     The base magic damage done by the magic weapon.
 * @property weight Int
 *     The weight of the magic weapon.
 * @property type WeaponType
 *     The type of the magic weapon.
 *
 * @constructor Creates a magic weapon with a name, a base damage and magic damage, speed, and it's type.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Roberto Alvarado~
 */
class MagicWeapon(
    override val name: String,
    override val damage: Int,
    override val weight: Int,
    override val type: MagicWeaponType,
    private val magicdamage: Int,
) : GameWeapon {
    // testing
    override fun equals(other: Any?) = when {
        this === other -> true
        other !is MagicWeapon -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        damage != other.damage -> false
        magicdamage != other.magicdamage -> false
        weight != other.weight -> false
        type != other.type -> false
        else -> true
    }

    override fun hashCode() = Objects.hash(MagicWeapon::class, name, damage, weight, type, magicdamage)

    override fun toString() = "MagicWeapon { name: $name, damage: $damage, weight: $weight, " +
        "type: $type, magicdamage: $magicdamage )"
}
