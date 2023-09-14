package com.example.JuintTesting.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class JavaArrays {

    private static int[] integerList = {12,19,20,88,100,9};
    private static String s = "string data to count each character";
    public static void main(String[] args) {
        //Write a Program to find the Maximum element in an array?
        OptionalInt max = Arrays.stream(integerList).max();
        System.out.println(max);

//        s.chars().mapToObj(a -> String.valueOf((char) a).toLowerCase()).collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
//        System.out.println(collect);
    }
}
