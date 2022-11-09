package cl.uchile.dcc.finalreality.model.inventory.magic

import cl.uchile.dcc.finalreality.model.inventory.GameWeapon

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
 *
 * @constructor Creates a magic weapon with a name, a base damage and magic damage, speed.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Roberto Alvarado~
 */
interface MagicWeapon : GameWeapon {
    val magicdamage: Int
}
