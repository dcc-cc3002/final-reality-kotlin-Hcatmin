package cl.uchile.dcc.finalreality.model

import java.util.Objects

/**
 * A class that holds all the information of a weapon.
 *
 * @property name String
 *     The name of the weapon.
 * @property damage Int
 *     The base damage done by the weapon.
 * @property weight Int
 *     The weight of the weapon.
 * @property type WeaponType
 *     The type of the weapon.
 *
 * @constructor Creates a weapon with a name, a base damage, speed, and it's type.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
open class Weapon(
    val name: String,
    val damage: Int,
    val weight: Int,
    val type: WeaponType
) {
    // testing
    override fun equals(other: Any?) = when {
        this === other -> true
        other !is Weapon -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        damage != other.damage -> false
        weight != other.weight -> false
        type != other.type -> false
        else -> true
    }

    override fun hashCode() = Objects.hash(Weapon::class, name, damage, weight, type)

    override fun toString() = "Weapon { name: $name, damage: $damage, weight: $weight, type: $type)"
}

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
    name: String,
    damage: Int,
    weight: Int,
    type: WeaponType = WeaponType.STAFF,
    private val magicdamage: Int,
) : Weapon(name, damage, weight, type) {
    // testing
    override fun equals(other: Any?) = when {
        this === other -> true
        other !is Weapon -> false
        hashCode() != other.hashCode() -> false
        name != other.name -> false
        damage != other.damage -> false
        weight != other.weight -> false
        type != other.type -> false
        else -> true
    }

    override fun hashCode() = Objects.hash(MagicWeapon::class, name, damage, weight, type, magicdamage)

    override fun toString() = "MagicWeapon { name: $name, damage: $damage, weight: $weight, " +
        "type: $type, magicdamage: $magicdamage )"
}
/**
 * Enumeration of all the weapon types.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
enum class WeaponType {
    SWORD, AXE, KNIFE, STAFF, BOW
}
