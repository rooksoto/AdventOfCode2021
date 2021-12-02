package com.equipoisegames.adventofcode2021.puzzles.day1

import com.equipoisegames.adventofcode2021.puzzles.BASE_PATH
import com.equipoisegames.adventofcode2021.puzzles.Puzzle
import java.io.File

class SonarSweepPartTwo : Puzzle {

    private val values: List<Int> =
        File("${BASE_PATH}/day1/input.txt")
            .readLines()
            .map { it.toInt() }

    override fun solve(): Int =
        with(values.windowed(3, 1, false) { it.sum() }) {
            foldIndexed(0) { index, acc, window ->
                if (index == 0) 0
                else if (window > this[index - 1]) acc + 1
                else acc
            }
        }
}