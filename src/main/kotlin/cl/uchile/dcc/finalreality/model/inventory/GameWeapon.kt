package cl.uchile.dcc.finalreality.model.inventory

interface GameWeapon {
    val name: String
    val damage: Int
    val weight: Int
    val type: Any
}