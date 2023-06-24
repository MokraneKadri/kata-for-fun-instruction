package com.kata.kataforfun.controllers

import com.kata.kataforfun.services.KataForFunService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class KataForFunControllerTest {

    private val kataForFunController = KataForFunController(KataForFunService());


    // Aggregate test cases using Parametrized test
    // Supply Csv binding as a list of key:value pairs , where key is the input number , value is the expected result
    //extends base use cases with extra ones
    @ParameterizedTest
    @CsvSource(
        value = [
            "1:1",
            "8:8",
            "3:KataKata",
            "5:ForFor",
            "5:ForFor",
            "7:Fun",
            "9:Kata",
            "51:KataFor",
            "53:ForKata",
            "33:KataKataKata",
            "27:KataFun",
            "15:KataForFor",
            "5555:ForForForForFor",
            "757557:KataFunForFunForForFun",
            "13:Kata"
        ],
        delimiterString = ":"
    )
    fun convertNumber_should_call_kata_for_un_service_and_return_convertedValue(input: Int, expectedResult: String){
    //given the input number input

     //when + capture
     val conversion : KataForFunController.ResultDto = kataForFunController.convertNumber(input);

     //then
     assertThat(conversion.result).isEqualTo(expectedResult)
    }
}