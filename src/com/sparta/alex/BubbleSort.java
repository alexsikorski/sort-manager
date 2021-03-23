package com.sparta.alex;

public class BubbleSort {

    public int[] sort(int[] array) {
        for (int j = 0; j < array.length - 1; j++) {
            for (int i = 0; i < array.length - 1 - j; i++) {
                int currentInt = array[i];
                int intAhead = array[i + 1];

                if (currentInt > intAhead) {
                    array[i] = intAhead;
                    array[i + 1] = currentInt;
                } else {
                    array[i] = currentInt;
                }
            }
        }
        return array;
    }
}
