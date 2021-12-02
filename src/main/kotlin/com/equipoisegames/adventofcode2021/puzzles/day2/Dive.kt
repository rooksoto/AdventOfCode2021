package com.equipoisegames.adventofcode2021.puzzles.day2

import com.equipoisegames.adventofcode2021.puzzles.BASE_PATH
import com.equipoisegames.adventofcode2021.puzzles.Puzzle
import java.io.File

class Dive : Puzzle {

    private var depth = 0
    private var horizontalPosition = 0
    private var aim = 0

    private val values: List<Pair<String, Int>> =
        File("$BASE_PATH/day2/_input.txt")
            .readLines()
            .map {
                with(it.split(" ")) { first() to last().toInt() }
            }

    override fun solvePartOne(): Int {
        values.forEach(::processMovementPartOne)
        return horizontalPosition * depth
    }

    override fun solvePartTwo(): Int {
        values.forEach(::processMovementPartTwo)
        return horizontalPosition * depth
    }

    private fun processMovementPartOne(movement: Pair<String, Int>) {
        when (movement.first) {
            "forward" -> horizontalPosition += movement.second
            "up" -> depth -= movement.second
            "down" -> depth += movement.second
        }
    }

    private fun processMovementPartTwo(movement: Pair<String, Int>) {
        when (movement.first) {
            "forward" -> {
                horizontalPosition += movement.second
                depth += aim * movement.second
            }
            "up" -> aim -= movement.second
            "down" -> aim += movement.second
        }
    }
}