package day2;

import java.io.*;
import java.util.*;

public class Task1 {
    static int lowCount;
    static String lowName;

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        //Парсинг в коллекцию
        String row;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/names.txt"))) {
            while ((row = reader.readLine()) != null) {
                names.add(row);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Вывод меню в консоль
        System.out.println("Меню программы: ");
        System.out.println(
                "1 - вывести результаты подсчета\n" +
                        "2 - вывести популярное имя\n" +
                        "3 - вывести редкое имя\n" +
                        "0 - выйти из программы");

        System.out.print("Введите команду: ");
        int input = new Scanner(System.in).nextInt();
        switch (input) {
            case 1 -> printAllNames(names);
            case 2 -> countMostPopularName(names);
            case 3 -> printMostUnpopularName(names);
            case 0 -> System.exit(0);
            default -> {
                System.out.println("Unsupported command");
                System.exit(1);
            }
        }
    }


    static void countMostPopularName(List<String> names) {
        int count = 0;
        String n = "";
        int colSize;
        for (int i = 0; i < names.size(); i++) {

            String name = names.get(i);

            List<String> match = names.stream()
                    .filter(x -> x.hashCode() - name.hashCode() == 0)
                    .toList();
            colSize = match.size();

            if (count < colSize) {
                count = colSize;
                n = match.get(0);
            }
        }
        System.out.println("Имя: " + n + " = " + count);
    }

    static void printAllNames(List<String> names) {
        Map<String, Integer> asd = new LinkedHashMap<>();
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            List<String> match = new ArrayList<>(names.stream()
                    .filter(x -> x.hashCode() - name.hashCode() == 0)
                    .toList());
            asd.putIfAbsent(match.get(0), match.size());
        }
        asd.entrySet().forEach(System.out::println);
        List<Integer> lows = asd.values().stream().toList();
        System.out.println(asd);

        lowCount = lows.stream().sorted().toList().get(0);
        lowName = asd.entrySet().stream()
                .filter(x -> x.getValue().equals(lowCount))
                .map(Map.Entry::getKey)
                .toList().get(0);
    }


    static void printMostUnpopularName(List<String> names) {
        Map<String, Integer> keyNames = new LinkedHashMap<>();
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            List<String> match = new ArrayList<>(names.stream()
                    .filter(x -> x.hashCode() - name.hashCode() == 0)
                    .toList());
            keyNames.putIfAbsent(match.get(0), match.size());
        }
        keyNames.entrySet().forEach(System.out::println);
        List<Integer> lows = keyNames.values().stream().toList();

        lowCount = lows.stream().sorted().toList().get(0);
        lowName = keyNames.entrySet().stream()
                .filter(x -> x.getValue().equals(lowCount))
                .map(Map.Entry::getKey)
                .toList().get(0);

        System.out.println("Самое не популярное имя: " + lowName + " (" + lowCount + ")");
    }
}
