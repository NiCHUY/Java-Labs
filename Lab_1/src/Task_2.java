import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your angle: ");
        int angle = scanner.nextInt();
        scanner.close();
        System.out.println("Приведенный с помощью % угол: " + angle % 360 + "'");
        System.out.println("Приведенный с помощью floorMod угол: " + Math.floorMod(angle, 360) + "'");
    }
}
