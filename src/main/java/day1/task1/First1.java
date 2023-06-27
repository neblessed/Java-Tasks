package day1.task1;

import java.util.*;
/*
Задача 2. Пусть на вход подаются числа от 1 до 1000
в случайном порядке, одно число пропущено. Нужно сказать какое.
*/
public class First1 {
    public static void main(String[] args) {
        HashSet<Integer> uniqNums = new HashSet<>();
        //Наполнение коллекции уникальными значениями
        for (int i = 0; i < 1000; i++) {
            while (uniqNums.size() < 1000) {
                uniqNums.add(new Random().nextInt(1000));
            }
        }
        //Присваивание в лист
        List<Integer> nums = new ArrayList<>(uniqNums);

        //Удаление случайного элемента
        nums.remove(new Random().nextInt(1000));

        //Поиск пропущенного элемента
        for (int i = nums.size() - 1; i > 1; i--) {
            if (nums.get(i) - nums.get(i - 1) == 2) {
                System.out.println("Missed element: " + (nums.get(i) - 1));
            }
        }
    }
}
