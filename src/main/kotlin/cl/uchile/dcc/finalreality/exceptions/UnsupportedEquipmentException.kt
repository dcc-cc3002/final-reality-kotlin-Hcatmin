package cl.uchile.dcc.finalreality.exceptions

import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter
import cl.uchile.dcc.finalreality.model.inventory.Weapon

class UnsupportedEquipmentException(character: PlayerCharacter, weapon: Weapon) :
    Exception(
        "Attempted to equip a weapon that is not compatible with the character. " +
            "Character: ${character::class.simpleName}, Weapon: ${weapon::class.simpleName}"
    )
