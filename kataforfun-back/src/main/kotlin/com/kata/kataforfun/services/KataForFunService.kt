package com.kata.kataforfun.services

import org.springframework.stereotype.Component

@Component
class KataForFunService {

    private val three = 3
    private val five = 5
    private  val seven = 7
    private val threeReplacement = "Kata"
    private val fiveReplacement = "For"
    private val sevenReplacement = "Fun"

    /**
     * First evaluate divisors, then the content is analyzed in the order of appearance.
     * If no match for (3,5,7) return the input number as a string.
     */
    fun convertNumber(inputNumber: Int): String {
        val result = convertDividers(inputNumber) + convertOccurrences(inputNumber)
        return result.ifEmpty { inputNumber.toString() }
    }

    /**
     * if the division is not possible return empty, otherwise return associated text according to the
     * target number (3, 5)
     */
    private fun convertDividers(inputNumber: Int): String {
        var result = ""
        if (couldBeDividedBy(inputNumber, three)) result += threeReplacement
        if (couldBeDividedBy(inputNumber, five)) result += fiveReplacement
        return result
    }

    /**
     * In order of appearance of the target numbers (3,5,7) in the input number,
     * append the conversion value associated to the target number for each target occurrence
     */
    private fun convertOccurrences(inputNumber: Int): String {
        var result = ""
        val inputAsCharArray = inputNumber.toString().toCharArray();
        for (character in inputAsCharArray) {
            result += convertOccurrence(character)
        }
        return result
    }

    /**
     * if the character is on of the targets(3,5,7) return its associated conversion value
     * empty when no target matched
     */
    private fun convertOccurrence(chartAt: Char): String {
        return when (chartAt.toString()) {
            asString(three) -> threeReplacement
            asString(five) -> fiveReplacement
            asString(seven) -> sevenReplacement
            else -> ""
        }
    }

    /**
     * check if the rest of division o input by divider is zero
     */
    private fun couldBeDividedBy(input: Int, divider: Int?): Boolean {
        if (divider == null) return false
        return input % divider == 0
    }

    /**
     * tiny helper method for Int to String conversion
     */
    private fun asString(value: Int?): String {
        if(value==null) return "";
        return value.toString();
    }
}