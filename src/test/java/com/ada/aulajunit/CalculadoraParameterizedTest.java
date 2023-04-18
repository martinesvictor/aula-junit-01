package com.ada.aulajunit;

import com.ada.aulajunit.modelo.Calculadora;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraParameterizedTest {

    @ParameterizedTest(name="Caso {index}: Passando {0} e {1} deveria retornar {2}")
    @CsvFileSource(resources="/dados.csv")

//    @JsonFileSource(resources="/dados.json")
    public void testeSoma(int primeiro, int segundo, int expected){

        Calculadora calc = new Calculadora();
        int result = calc.somar(primeiro, segundo);

        assertEquals(expected, result);
    }

    public static Collection<?> obterDados(){
        return Arrays.asList(new Object[][] {
                {10, 3, 13},
                {8, 7, 15},
                {-2, -5, -7},
                // primeiro menor que segundo
                {3, 4, 7}

                }

        );
    }



}
