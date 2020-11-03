package com.urumuqi.javapractice.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author wuqi
 * @desc todo
 * @class MySteams
 * @date 2020/8/4 13:20
 **/
public class MyStreams {

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "C++", "PHP", "Scala", "Haskell", "Lisp");

        System.out.println("Which Language Is Started With J :");
        filter(languages, n -> ((String) n).startsWith("J"));

        System.out.println("Print all languages :");
        filter(languages, n -> true);

        System.out.println("Which language is end with a :");
        filter(languages, n -> ((String) n).endsWith("a"));

        System.out.println("Print no language :");
        filter(languages, n -> false);

        System.out.println("Print languages whose length is greater than 4 : ");
        filter(languages, n -> ((String) n).length() > 4);

        System.out.println("Print start with J and four letter long language : ");
        filter2(languages);
    }

    public static void filter1(List<String> names, Predicate condition) {
        for (String name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }

    public static void filter(List<String> names, Predicate condition) {
        // stream
        names.stream().filter(n -> condition.test(n)).forEach(n -> System.out.println(n + ""));
    }

    // and(), or()
    public static void filter2(List<String> names) {
        Predicate<String> startWithJ = (n -> n.startsWith("J"));
        Predicate<String> fourLetterLength = (n -> n.length() == 4);
        names.stream().filter(startWithJ.and(fourLetterLength))
                .forEach(n -> System.out.println("which start with J and four letter long language is : " + n));
        names.stream().filter(startWithJ.or(fourLetterLength))
                .forEach(n -> System.out.println("which start with J or four letter long language is : " + n));
    }
}
