package com.equipoisegames.adventofcode2021.puzzles.day2

import com.equipoisegames.adventofcode2021.puzzles.BASE_PATH
import com.equipoisegames.adventofcode2021.puzzles.Puzzle
import java.io.File

class DivePartOne : Puzzle {

    private var depth = 0
    private var horizontalPosition = 0

    private val values: List<Pair<String, Int>> =
        File("$BASE_PATH/day2/input.txt")
            .readLines()
            .map {
                with(it.split(" ")) { first() to last().toInt() }
            }

    override fun solve(): Int {
        values.forEach(::processMovement)
        return horizontalPosition * depth
    }

    private fun processMovement(movement: Pair<String, Int>) {
        when (movement.first) {
            "forward" -> horizontalPosition += movement.second
            "up" -> depth -= movement.second
            "down" -> depth += movement.second
        }
    }
}