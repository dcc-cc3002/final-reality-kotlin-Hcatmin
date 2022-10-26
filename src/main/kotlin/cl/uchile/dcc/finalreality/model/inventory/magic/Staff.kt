package cl.uchile.dcc.finalreality.model.inventory.magic

class Staff(
            override val name: String,
            override val damage: Int,
            override val weight: Int,
            override val magicdamage: Int
) : MagicWeapon {

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
        return "Staff(name='$name', damage=$damage, weight=$weight, magicdamage=$magicdamage)"
    }
}