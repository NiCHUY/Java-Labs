import java.math.BigDecimal;
import java.util.Scanner;

public class Task_1 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter your number: ");
        int number = scanner.nextInt();
        scanner.close();
        System.out.println("Число в двоичной: " + Integer.toBinaryString(number));
        System.out.printf("Число в восьмеричной: " + "%o", number);
        System.out.println();
        System.out.printf("Число в шестнадцатеричной: " + "%x", number);
        System.out.println();
        System.out.printf("Число в шестнадцатеричной с плавающей точкой: " + "%.2a", 12.001);
    }
}
