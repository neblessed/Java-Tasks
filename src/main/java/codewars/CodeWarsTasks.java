package codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CodeWarsTasks {
    public static void main(String[] args) {
        System.out.println(spinWords("Привет всем"));
    }

    /*
    Task: "Stop gninnipS My sdroW!"
    Write a function that takes in a string of one or more words,
    and returns the same string, but with all five or more letter words reversed.
    Strings passed in will consist of only letters and spaces.
    Spaces will be included only when more than one word is present.
    */
    public static String spinWords(String sentence) {
        return Arrays.stream(sentence.trim().split(" "))
                .map(x -> {
                    if (x.toCharArray().length >= 5) {
                        return new StringBuilder(x).reverse() + " ";
                    } else return x + " ";
                }).collect(Collectors.joining());
    }

    /*
    Task: "Find the smallest integer in the array"
    Given an array of integers your solution should find the smallest integer.
    */
    public static int findSmallestInt(int[] args) {
        return Arrays.stream(args).sorted().toArray()[0];
    }

    /*
    Task: Sum of positives
    You get an array of numbers, return the sum of all the positives ones.
    */
    public static int sumOfPositiveValuesInArray(int[] arr) {
        return IntStream.of(arr).filter(x -> x > 0).sum();
    }
}
