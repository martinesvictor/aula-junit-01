package com.ada.aulajunit.modelo;

import org.springframework.stereotype.Component;

@Component
public class Calculadora {

    public int somar(int x, int y) {
        return x + y;
    }

    public int subtrair(int x, int y) {
        return x - y;
    }

    public float dividir(int x, int y) {
        return x / y;
    }

    public float multiplicar(int x, int y) {
        return x * y;
    }
}
