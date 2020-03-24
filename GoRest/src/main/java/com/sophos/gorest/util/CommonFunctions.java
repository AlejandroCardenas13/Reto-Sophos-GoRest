package com.sophos.gorest.util;

import java.util.Random;

public class CommonFunctions {

    /**
     * Este metodo se encarga de entregar un número aleatorio entre un intervalo determinado
     *
     * @param biggerNumber  Variable tipo int que representa el número mayor del intervalo
     * @param smallerNumber Variable tipo int que representa el número menor del intervalo
     * @return Variable tipo String que representa el número aleatorio elegido entre el intervalo ingresado
     */
    public String getRandomNumberInterval(int biggerNumber, int smallerNumber) {
        return Integer.toString((new Random()).nextInt(biggerNumber - smallerNumber + 1) + smallerNumber);
    }
}