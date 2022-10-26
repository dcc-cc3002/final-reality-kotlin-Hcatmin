package cl.uchile.dcc.finalreality.model.inventory

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

interface GameWeapon {
    val name: String
    val damage: Int
    val weight: Int
}
