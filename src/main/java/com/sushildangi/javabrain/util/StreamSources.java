package com.sushildangi.javabrain.util;

import com.sushildangi.javabrain.model.User;

import java.util.stream.Stream;

/**
 * This class is a source of collection streams used in the exercises.
 * DO NOT MODIFY THIS CODE
 *
 * @author sushildangi
 */
public class StreamSources {

    public static Stream<String> stringNumbersStream() {
        return Stream.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
    }

    public static Stream<Integer> intNumbersStream() {
        return Stream.iterate(0, i -> i + 2)
                .limit(10);
    }

    public static Stream<User> userStream() {
        return Stream.of(
                User.builder().id(1).firstName("Lionel").lastName("Messi").build(),
                User.builder().id(2).firstName("Cristiano").lastName("Ronaldo").build(),
                User.builder().id(2).firstName("Diego").lastName("Maradona").build(),
                User.builder().id(4).firstName("Zinedine").lastName("Zidane").build(),
                User.builder().id(5).firstName("Jürgen").lastName("Klinsmann").build(),
                User.builder().id(6).firstName("Gareth").lastName("Bale").build()
        );
    }
}