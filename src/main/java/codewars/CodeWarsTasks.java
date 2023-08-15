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

    /*
    Task: Sums of Parts
    The function parts_sums (or its variants in other languages) will take as parameter
    a list ls and return a list of the sums of its parts as defined above.
    Example:
    ls = [0, 1, 3, 6, 10]
    ls = [1, 3, 6, 10]
    ls = [3, 6, 10]
    ls = [6, 10]
    ls = [10]
    ls = []
    */
    public static int[] sumOfParts(int[] arr) {
        int[] sum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            sum[i] = IntStream.of(arr).sum();
            arr[i] = 0;
        }
        sum[sum.length - 1] = 0;
        return sum;
    }

    /*
    Task: "Simple Pig Latin"
    Move the first letter of each word to the end of it,
    then add "ay" to the end of the word.
    Leave punctuation marks untouched.
    */
    public static String phraseReverser(String phrase) {
        return Arrays.stream(phrase.split(" ")).map(x -> {
            char[] word = x.toCharArray();
            char move = word[0];
            String result = new String(word).substring(1, word.length).concat(String.valueOf(move));
            char[] resArr = result.toCharArray();
            Matcher matcher = Pattern.compile("^\\W").matcher(String.valueOf(resArr[resArr.length-1]));
            return (matcher.matches()) ? result : result + "ay ";
        }).collect(Collectors.joining()).trim();
    }

    /*
    Task: "Multiplication table"
    Your task, is to create N×N multiplication table, of size provided in parameter.

    For example, when given size is 3:
    1 2 3
    2 4 6
    3 6 9
    */
    public static int[][] multiplicationTable(int n) {
        int[][] table = new int[n][n];
        for (int i = 0; i < n; i++) {
            if (i < 1) {
                for (int j = 0; j < n; j++) {
                    table[i][j] = j + 1;
                }
            } else {
                for (int j = 0; j < n; j++) {
                    table[i][j] = table[0][j]*(i+1);
                }
            }
        }
        return table;
    }
}
