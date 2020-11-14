package upo.mobileapplications1.rockpaperscissorsapp

import kotlin.random.Random

class Computer {
    fun extract(): Int {
        return Random.nextInt(0, 3)
    }
}