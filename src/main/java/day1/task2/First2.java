package day1.task2;
/*
Задача 1 . Пользователь ввел сумму в банкомат 13745.
Банкомат ему должен напечатать минимальное количество купюр каждого номинала:
5000 - 2, 1000 - 3, 500 - 1, 100 - 2, 50 - 0, 10 - 4, 5 - 1, 2 - 0, 1 - 0.
*/
public class First2 {
    public static void main(String[] args) {
        int sum = 13748;

        int c5000 = 0;
        int c1000 = 0;
        int c500 = 0;
        int c100 = 0;
        int c50 = 0;
        int c10 = 0;
        int c5 = 0;
        int c2 = 0;

        while (sum != 0) {
            if (sum % 5000 == 0) {
                c5000++;
                sum -= 5000;
            } else if (sum % 1000 == 0) {
                c1000++;
                sum -= 1000;
            } else if (sum % 500 == 0) {
                c500++;
                sum -= 500;
            } else if (sum % 100 == 0) {
                c100++;
                sum -= 100;
            } else if (sum % 50 == 0) {
                c50++;
                sum -= 50;
            } else if (sum % 10 == 0) {
                c10++;
                sum -= 10;
            } else if (sum % 5 == 0) {
                c5++;
                sum -= 5;
            } else if (sum % 2 == 0) {
                c2++;
                sum -= 2;
            }
        }

        System.out.println("Купюра 5000: " + c5000);
        System.out.println("Купюра 1000: " + c1000);
        System.out.println("Купюра 500: " + c500);
        System.out.println("Купюра 100: " + c100);
        System.out.println("Купюра 50: " + c50);
        System.out.println("Купюра 10: " + c10);
        System.out.println("Купюра 5: " + c5);
        System.out.println("Купюра 2: " + c2);
        System.out.println("Купюра 1: " + sum);
    }

}
