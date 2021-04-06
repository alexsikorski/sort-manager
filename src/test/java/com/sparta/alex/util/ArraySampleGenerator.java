package com.sparta.alex.util;

import java.util.HashSet;
import java.util.Random;
import java.util.stream.IntStream;

public class ArraySampleGenerator {

    public static int[] uniqueIntegerArray(int sampleSize) {
        // array to be used with binary tree must have unique integers
        HashSet<Integer> set = new HashSet<>();

        do {
            set.add(new Random().nextInt(sampleSize));
        }
        while (set.size() < sampleSize);


        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] integerArray(int sampleSize) {
        return IntStream.generate(() -> new Random().nextInt(sampleSize)).limit(sampleSize).toArray();
    }
}
