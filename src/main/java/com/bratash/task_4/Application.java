package com.bratash.task_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    List<String> reader(){
        Scanner scan = new Scanner(System.in);

        List<String> lines = new ArrayList<>();
        String line;
        while (!(line = scan.nextLine()).isEmpty()){
            lines.add(line);
        }
        return lines;
    }

    Map<String, Long> countSymbols(List<String> lines) {
        return lines.stream()
                .flatMap(a -> Stream.of(a.split(" ")))
                .flatMap(a -> Stream.of(a.split("")))
                .filter(ch -> !Character.isUpperCase(ch.charAt(0)))
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
    }

    Map<String, Long> countWord(List<String> lines) {
        return lines.stream()
                .flatMap(a -> Stream.of(a.split(" ")))
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));

    }

    long uniqueWords(List<String> lines){
        return lines.stream()
                .flatMap(a -> Stream.of(a.split(" ")))
                .distinct()
                .count();
    }

    List<String> sortUnique (List<String> lines){
        return lines.stream()
                .flatMap(a -> Stream.of(a.split(" ")))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Application test = new Application();
        List<String> lines = test.reader();
        System.out.println(lines);

        System.out.println("Unique words\n"+test.uniqueWords(lines));
        System.out.println("Sort unique\n"+test.sortUnique(lines));
        System.out.println("Count words\n"+test.countWord(lines));
        System.out.println("Count symbols\n"+test.countSymbols(lines));
    }
}
