package day1;

public class First3 {

    //Convert any number to binary

    public static void main(String[] args) {
        int sum = 14;
        String result = "";

        while (sum >= 1) {
            if (sum % 2 == 0) {
                sum = sum / 2;
                result+="0";
                System.out.println(result);
            } else {
                sum = sum / 2;
                result+="1";
                System.out.println(result);
            }
        }

        result = new StringBuilder(result).reverse().toString();
        System.out.println(result);
    }
}
