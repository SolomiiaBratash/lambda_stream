package com.bratash.task_3;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomList {
    static List<Integer> randList(int n){
        Random rand = new Random();
        return Stream.generate(()-> rand.nextInt(10)).limit(n).collect(Collectors.toList());
    }

    public static void main(String[] args){
        List<Integer> randList = randList(10);

        System.out.println(randList);

        System.out.println("Average: " + randList
                .stream()
                .mapToDouble(Integer::intValue)
                .average()
                .getAsDouble());

        System.out.println("Min: " + randList
                .stream()
                .min(Integer::compareTo)
                .get());

        System.out.println("Max: " + randList
                .stream()
                .max(Integer::compareTo)
                .get());

        System.out.println("Sum(reduce): " + randList
                .stream()
                .reduce((a, b) -> a + b)
                .get());

        System.out.println("Sum(sum): " + randList
                .stream()
                .mapToDouble(Integer::intValue)
                .sum());

        System.out.println("Count(>average): " + randList
                .stream()
                .filter((a)->a>(randList
                        .stream()
                        .mapToDouble(Integer::intValue)
                        .average()
                        .getAsDouble()))
                .count());
    }
}


