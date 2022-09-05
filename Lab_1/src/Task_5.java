import java.util.Scanner;

public class Task_5 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your double.value: ");
        double number = scanner.nextDouble();
        scanner.close();
        System.out.println("Result: " + (int) number);
        System.out.println("Ответ: Все после точки обрезалось");
    }
}
