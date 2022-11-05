package cl.uchile.dcc.finalreality.model.character.mage.mage

import cl.uchile.dcc.finalreality.model.character.player.mage.AbstractMageCharacter
import cl.uchile.dcc.finalreality.model.character.player.mage.b_mage1
import cl.uchile.dcc.finalreality.model.character.player.mage.setUpBlackMage
import cl.uchile.dcc.finalreality.model.character.player.mage.setUpWhiteMage
import cl.uchile.dcc.finalreality.model.character.player.mage.w_mage1
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

fun currentMpTesting(mage: AbstractMageCharacter) {
    mage.currentMp = 0
    mage.currentMp shouldNotBe mage.maxMp
    mage.currentMp = mage.maxMp
    mage.currentMp shouldBe mage.maxMp
}

class AbstractMageCharacterTest : FunSpec({
    beforeEach {
        setUpBlackMage()
        setUpWhiteMage()
    }

    test("Set the current Mp") {
        val list = listOf(b_mage1, w_mage1)
        for (mage in list) {
            currentMpTesting(mage)
        }
    }
})
