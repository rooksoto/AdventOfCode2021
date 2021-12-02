package com.equipoisegames.adventofcode2021.puzzles.day1

import com.equipoisegames.adventofcode2021.puzzles.BASE_PATH
import com.equipoisegames.adventofcode2021.puzzles.Puzzle
import java.io.File

class SonarSweepPartOne : Puzzle {

    private val values: List<Int> =
        File("${BASE_PATH}/day1/input.txt")
            .readLines()
            .map { it.toInt() }

    override fun solve(): Int =
        values.foldIndexed(0) { index, acc, value ->
            if (index == 0) 0
            else if (value > values[index - 1]) acc + 1
            else acc
        }
}