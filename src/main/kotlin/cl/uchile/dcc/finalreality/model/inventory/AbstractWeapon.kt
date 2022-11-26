package cl.uchile.dcc.finalreality.model.inventory

import cl.uchile.dcc.finalreality.exceptions.UnsupportedEquipmentException
import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.mage.WhiteMage
import cl.uchile.dcc.finalreality.model.character.player.melee.Engineer
import cl.uchile.dcc.finalreality.model.character.player.melee.Knight
import cl.uchile.dcc.finalreality.model.character.player.melee.Thief

abstract class AbstractWeapon(
    override val name: String,
    override val damage: Int,
    override val weight: Int
) : Weapon {
    override fun equipToBlackMage(blackMage: BlackMage) {
        throw UnsupportedEquipmentException(blackMage, this)
    }

    override fun equipToEngineer(engineer: Engineer) {
        throw UnsupportedEquipmentException(engineer, this)
    }

    override fun equipToKnight(knight: Knight) {
        throw UnsupportedEquipmentException(knight, this)
    }

    override fun equipToThief(thief: Thief) {
        throw UnsupportedEquipmentException(thief, this)
    }

    override fun equipToWhiteMage(whiteMage: WhiteMage) {
        throw UnsupportedEquipmentException(whiteMage, this)
    }
}
