package com.kata.kataforfun.services

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class KataForFunServiceTest {


    private var kataForFunService = KataForFunService()

    @Test
    fun convertNumber_should_return_input_number_when_input_number_is_1() {
        //given
        assertCase(1, "1")
    }

    @Test
    fun convertNumber_should_return_KataKata_when_input_number_is_3() {
        //given
        assertCase(3, "KataKata")
    }

    @Test
    fun convertNumber_should_return_ForFor_when_input_number_is_5() {
        //given
        assertCase(5, "ForFor")
    }

    @Test
    fun convertNumber_should_return_FunFun_when_input_number_is_7() {
        assertCase(7, "Fun")
    }

    @Test
    fun convertNumber_should_return_Fun_when_input_number_is_9() {
        assertCase(7, "Fun")
    }

    @Test
    fun convertNumber_should_return_Fun_when_input_number_is_7() {
        assertCase(7, "Fun")
    }

    @Test
    fun convertNumber_should_return_KataFor_when_input_number_is_51() {
        assertCase(51, "KataFor")
    }

    @Test
    fun convertNumber_should_return_ForKata_when_input_number_is_53() {
        assertCase(53, "ForKata")
    }

    @Test
    fun convertNumber_should_return_KataKataKata_when_input_number_is_33() {
        assertCase(33, "KataKataKata")
    }

    @Test
    fun convertNumber_should_return_KataFun_when_input_number_is_27() {
        assertCase(27, "KataFun")
    }

    @Test
    fun convertNumber_should_return_KataForFor_when_input_number_is_15() {
        assertCase(15, "KataForFor")
    }


    // Aggregate test cases using Parametrized test
    // Supply Csv binding as a list of key:value pairs , where key is the input number , value is the expected result
    @ParameterizedTest
    @CsvSource(
        value = [
            "1:1",
            "3:KataKata",
            "5:ForFor",
            "5:ForFor",
            "7:Fun",
            "9:Kata",
            "51:KataFor",
            "53:ForKata",
            "33:KataKataKata",
            "27:KataFun",
            "15:KataForFor"
        ],
        delimiterString = ":"
    )
    fun convertNumber_should_return_FunFun_when_input_number_is_7(input: Int, expected: String) {
        assertCase(input, expected)
    }

    // given an iput number assert that the result of its conversion is equals to expectedResult
    private fun assertCase(input: Int, expectedResult: String) {
        //given the input number input

        //when + capture
        val result: String = kataForFunService.convertNumber(input)

        //then
        assertThat(result).isEqualTo(expectedResult)
    }

}