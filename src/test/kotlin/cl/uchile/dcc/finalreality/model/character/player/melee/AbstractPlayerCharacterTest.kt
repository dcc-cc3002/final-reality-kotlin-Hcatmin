package cl.uchile.dcc.finalreality.model.character.player.melee

import cl.uchile.dcc.finalreality.model.character.player.mage.b_mage1
import cl.uchile.dcc.finalreality.model.character.player.mage.setUpBlackMage
import cl.uchile.dcc.finalreality.model.character.player.mage.setUpWhiteMage
import cl.uchile.dcc.finalreality.model.character.player.mage.w_mage1
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

fun currentHpTesting(player : AbstractPlayerCharacter) {
    player.currentHp = 0
    player.currentHp shouldNotBe player.maxHp
    player.currentHp = player.maxHp
    player.currentHp shouldBe player.maxHp
}

class AbstractPlayerCharacterTest : FunSpec({

    beforeEach {
        setUpBlackMage()
        setUpEngineer()
        setUpKnight()
        setUpThief()
        setUpWhiteMage()
    }

    test("Set the current Hp") {
        for (player in listOf(b_mage1, engineer1, knight1, thief1, w_mage1)) {
            currentHpTesting(player)
        }
    }

})
