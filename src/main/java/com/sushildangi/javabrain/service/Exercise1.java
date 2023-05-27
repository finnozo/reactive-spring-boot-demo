package com.sushildangi.javabrain.service;

import com.sushildangi.javabrain.model.User;
import com.sushildangi.javabrain.util.StreamSources;

public class Exercise1 {
    // Use StreamSources.intNumbersStream() and StreamSources.userStream()
    public static void main(String[] args) {
        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        System.out.println("#########################################################");
        System.out.println("Print all numbers in the intNumbersStream stream");
        StreamSources.intNumbersStream()
                .forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        System.out.println("#########################################################");
        System.out.println("Print numbers from intNumbersStream that are less than 5");
        StreamSources.intNumbersStream()
                .filter(i -> i < 5)
                .forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        System.out.println("#########################################################");
        System.out.println("Print the second and third numbers in intNumbersStream that's greater than 5");
        StreamSources.intNumbersStream()
                .filter(i -> i > 5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);
        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        System.out.println("#########################################################");
        System.out.println("Print the first number in intNumbersStream that's greater than 5.\nIf nothing is found, print -1");
        System.out.println(StreamSources.intNumbersStream()
                .filter(i -> i > 5)
                .findFirst().orElse(-1));
        // Print first names of all users in userStream
        // TODO: Write code here
        System.out.println("#########################################################");
        System.out.println("Print first names of all users in userStream");
        // todo: M1
        StreamSources.userStream()
                .forEach(u -> System.out.println(u.getFirstName()));
        System.out.println("-----------------------------------------");
        // TODO: 28/05/23 M2
        StreamSources.userStream()
                .map(User::getFirstName)
                .forEach(System.out::println);
        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        System.out.println("#########################################################");
        System.out.println("Print first names in userStream for users that have IDs from number stream");
        // TODO: 28/05/23 M1
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(u -> u.getId() == id))
                .map(User::getFirstName)
                .forEach(System.out::println);
        System.out.println("-----------------------------------------");
        // TODO: 28/05/23 M2
        StreamSources.userStream()
                .filter(u -> StreamSources.intNumbersStream()
                        .anyMatch(i -> i == u.getId()))
                .map(User::getFirstName)
                .forEach(System.out::println);
        System.out.println("#########################################################");
    }

}
