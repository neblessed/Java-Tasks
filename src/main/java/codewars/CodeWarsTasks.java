package codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CodeWarsTasks {
    public static void main(String[] args) {
        System.out.println(spinWords("Привет всем"));
    }

    public static String spinWords(String sentence) {
        return Arrays.stream(sentence.trim().split(" "))
                .map(x -> {
                    if (x.toCharArray().length >= 5) {
                        return new StringBuilder(x).reverse() + " ";
                    } else return x + " ";
                }).collect(Collectors.joining()).trim();
    }
}
