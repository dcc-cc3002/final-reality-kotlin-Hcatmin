package cl.uchile.dcc.finalreality.model.character.player.melee

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.mage.b_mage1
import cl.uchile.dcc.finalreality.model.character.player.mage.setUpBlackMage
import cl.uchile.dcc.finalreality.model.character.player.mage.setUpWhiteMage
import cl.uchile.dcc.finalreality.model.character.player.mage.w_mage1
import cl.uchile.dcc.finalreality.model.inventory.magic.Staff
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import kotlin.random.Random

fun currentHpTesting(player: AbstractPlayerCharacter) {
    player.currentHp = 0
    player.currentHp shouldNotBe player.maxHp
    player.currentHp = player.maxHp
    player.currentHp shouldBe player.maxHp
}

fun notInRange(player: AbstractPlayerCharacter) {
    player.currentHp = -1
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
            shouldThrow<InvalidStatValueException> {
                notInRange(player)
            }
        }
    }
})
