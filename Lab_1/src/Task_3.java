import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your 3 nums: ");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        scanner.close();
        if(num1 >= num2){
            if(num1 >= num3){
                System.out.println("Ответ: " + num1);
            }else {
                System.out.println("Ответ: " + num3);
            }
        }else{
            if(num2 >= num3){
                System.out.println("Ответ: " + num2);
            }else {
                System.out.println("Ответ: " + num3);
            }
        }

        System.out.println("Ответ с помощью Math.max(): " + Math.max(Math.max(num1, num2), num3));
    }
}
