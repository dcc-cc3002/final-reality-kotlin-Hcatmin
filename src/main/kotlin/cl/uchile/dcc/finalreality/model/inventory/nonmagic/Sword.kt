package cl.uchile.dcc.finalreality.model.inventory.nonmagic

import cl.uchile.dcc.finalreality.model.inventory.GameWeapon

class Sword(
    override val name: String,
    override val damage: Int,
    override val weight: Int
) : GameWeapon {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Sword

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
        return "Sword(name='$name', damage=$damage, weight=$weight)"
    }
}