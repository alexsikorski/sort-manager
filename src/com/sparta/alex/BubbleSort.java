package com.sparta.alex;

public class BubbleSort implements Sorter {

    @Override
    public int[] sortArray(int[] array) {
        if (array.length == 0) {
            new Printer().printArrayEmpty();
        } else {
            for (int j = 0; j < array.length - 1; j++) {
                boolean hasSwapped = false;
                for (int i = 0; i < array.length - 1 - j; i++) {
                    int currentInteger = array[i];
                    int integerAhead = array[i + 1];
                    if (currentInteger > integerAhead) {
                        array[i] = integerAhead;
                        array[i + 1] = currentInteger;
                        hasSwapped = true;
                    } else {
                        array[i] = currentInteger;
                    }
                }
                if (!hasSwapped) {
                    return array;
                }
            }
        }
        return array;
    }
}
