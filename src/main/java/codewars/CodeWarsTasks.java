package codewars;

import java.util.*;
import java.util.List;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class CodeWarsTasks {
    public static void main(String[] args) {
        System.out.println(opposite(-5));
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
            Matcher matcher = Pattern.compile("^\\W").matcher(String.valueOf(resArr[resArr.length - 1]));
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
                    table[i][j] = table[0][j] * (i + 1);
                }
            }
        }
        return table;
    }

    /*
    Task: "Which are in?"
    Given two arrays of strings a1 and a2 return a sorted array r in lexicographical
    order of the strings of a1 which are substrings of strings of a2.
    Example 1:
    a1 = ["arp", "live", "strong"]
    a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
    returns ["arp", "live", "strong"]
    */
    public static String[] inArray(String[] array1, String[] array2) {
        Set<String> result = new HashSet<>();
        for (String s : array2) {
            result.addAll(Arrays.stream(array1).filter(s::contains).sorted().toList());
        }
        List<String> sorted = new ArrayList<>(result);
        Collections.sort(sorted);
        return sorted.toArray(new String[sorted.size()]);
    }

    /*
    Complete the solution so that it returns true if the first argument(string)
    passed in ends with the 2nd argument (also a string).
    */
    public static boolean wordEndsWord(String str, String ending) {
        return str.endsWith(ending);
    }

    /*
    Complete the function that accepts a string parameter,
    and reverses each word in the string.
    All spaces in the string should be retained.

    Example: "This is an example!" ==> "sihT si na !elpmaxe"
    */
    public static String reverseWords(final String original) {
        return (original.isBlank())
                ? original
                : Arrays.stream(original.split(" "))
                .map(x -> new StringBuilder(x).reverse())
                .map(StringBuilder::toString)
                .collect(Collectors.joining(" "));
    }

    /*
    Task: "Sum Arrays"

    Write a function that takes an array
    of numbers and returns the sum of the numbers.
    The numbers can be negative or non-integer.
    If the array does not contain any numbers then you should return 0.
    */
    public static double sumDoubleArray(double[] numbers) {
        return DoubleStream.of(numbers).sum();
    }

    public static String noSpace(final String x) {
        return String.join("", x.split(" "));
    }

    /*
    Task: Counting sheep...
    Consider an array/list of sheep where some sheep may be missing from their place.
    We need a function that counts the number of sheep present in the array (true means present).
    */
    public static int countSheeps(Boolean[] arrayOfSheeps) {
        return Arrays.stream(arrayOfSheeps)
                .filter(Objects::nonNull)
                .filter(x -> x.equals(true))
                .toList().size();
    }

    /*
    Task: Complementary DNA
    Example: (input --> output)
    "ATTGC" --> "TAACG"
    "GTAT" --> "CATA"
    */
    public static String makeComplement(String dna) {
        StringBuilder s = new StringBuilder(" ");
        for (char c : dna.toCharArray()) {
            switch (c) {
                case 'A' -> s.append("T");
                case 'T' -> s.append("A");
                case 'C' -> s.append("G");
                case 'G' -> s.append("C");
            }
        }
        return s.toString().trim();
    }

    public static int opposite(int number) {
        return number > 0 ? Math.negateExact(number) : Math.abs(number);
    }

    /*
    Task: "Abbreviate a Two Word Name"
    Write a function to convert a name into initials.
    This kata strictly takes two words with one space in between them.
    The output should be two capital letters with a dot separating them.
    It should look like this: "Sam Harris => S.H"
    */
    public static String abbrevName(String name) {
        return Arrays.stream(name.split(" "))
                .map(x -> String.valueOf(x.toCharArray()[0]))
                .collect(Collectors.joining("."))
                .substring(0, 3).toUpperCase();
    }
}
