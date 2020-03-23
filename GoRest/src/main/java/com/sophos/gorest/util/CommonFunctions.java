package com.sophos.promart.util;

import java.util.Random;

public class CommonFunctions {

    /**
     * Este metodo se encarga de entregar un número aleatorio entre un intervalo determinado
     *
     * @param biggerNumber  Variable tipo int que representa el número mayor del intervalo
     * @param smallerNumber Variable tipo int que representa el número menor del intervalo
     * @return Variable tipo String que representa el número aleatorio elegido entre el intervalo ingresado
     */
    public Integer getRandomNumberInterval(int biggerNumber, int smallerNumber) {
        return (new Random()).nextInt(biggerNumber - smallerNumber + 1) + smallerNumber;
    }
}