package cl.uchile.dcc.finalreality.model.character

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNot
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.haveSameHashCodeAs
import io.kotest.matchers.types.shouldBeSameInstanceAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import java.util.concurrent.LinkedBlockingQueue

val queueEnemy = LinkedBlockingQueue<GameCharacter> ()
lateinit var enemy1: Enemy
lateinit var enemy2: Enemy
lateinit var enemy3: Enemy

fun setUpEnemy() {
    enemy1 = Enemy("Enemy1", 5, 10, 10, queueEnemy)
    enemy1.waitTurn()
    enemy2 = Enemy("Enemy1", 5, 10, 10, queueEnemy)
    enemy2.waitTurn()
    enemy3 = Enemy("Enemy3", 3, 17, 17, queueEnemy)
    enemy3.waitTurn()
    Thread.sleep(6000)
}

class EnemyTest : FunSpec({

    beforeEach {
        setUpEnemy()
    }

    test("Enemy should be equal to itself") {
        enemy1 shouldBeSameInstanceAs enemy1
        enemy1 shouldBe enemy1
    }

    test("A Enemy is not equal to one of a different class") {
        enemy1 shouldNotBe "$enemy1"
    }

    test("Two Enemys with the same name should be equal") {
        enemy1 shouldNotBeSameInstanceAs enemy2
        enemy1 shouldBe enemy2
    }

    test("Two Enemys with different names should not be equal") {
        enemy1 shouldNotBe enemy3
    }

    test("Two Enemys with the same name should have the same hashcode") {
        enemy1 should haveSameHashCodeAs(enemy2)
    }

    test("Two Enemys with different names should have different hashcode") {
        enemy1 shouldNot haveSameHashCodeAs(enemy3)
    }

    test("The string representation of a enemy should be correct") {
        "$enemy1" shouldBe "Enemy { name= Enemy1, weight= 5, maxHp= 10, defense= 10, currentHp= 10 }"
    }

    test("An Enemy should be able to waitTurn") {
        enemy1.waitTurn()
    }
    test("pop the names of the character of the queue in the correct order") {
        val queueEnemy2 = LinkedBlockingQueue<GameCharacter> ()
        val enemy4 = Enemy("Enemy", 10, 17, 17, queueEnemy2)
        enemy4.waitTurn()
        val enemy5 = Enemy("Enemy", 5, 17, 17, queueEnemy2)
        enemy5.waitTurn()
        Thread.sleep(6000)

        queueEnemy2.poll() shouldBe enemy5
        queueEnemy2.poll() shouldBe enemy4
    }
})