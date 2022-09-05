import java.util.Scanner;

public class Task_7 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter your numbers: ");
        short num1 = scanner.nextShort();
        short num2 = scanner.nextShort();
        scanner.close();
        sum(num1, num2);
        sub(num1, num2);
        mul(num1, num2);
        div(num1, num2);
    }
    public static void sum(short num1, short num2)
    {
        int result = num1 + num2;
        System.out.println("Sum of num1 and num2 equals " + result);
    }

    public static void sub(short num1, short num2)
    {
        int result = num1 - num2;
        System.out.println("sub of num1 and num2 equals " + result);
    }

    public static void mul(short num1, short num2)
    {
        int result = num1 * num2;
        System.out.println("Mul of num1 and num2 equals " + result);
    }

    public static void div(short num1, short num2)
    {
        int result = num1 / num2;
        int remainder = num1 - (result * num2);
        System.out.println("Div of num1 and num2 equals " + result + " With remainder equals " + remainder);
    }
}
