import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;
//Variant №1
public class Series {
public static void main(String[] args) {
    BigDecimal[] arguments;
//Input your values
    arguments = GetArguments();
//Initializing of new values
    BigDecimal result = new BigDecimal(0);
    BigDecimal term;
    int k = 1;
    term = arguments[0].pow((3 * (int)Math.pow(k , 2)));
//Series loop
    while(term.compareTo(arguments[1]) > 0)
    {
        result = result.add(term);
        k++;
        term = arguments[0].pow((3 * (int)Math.pow(k , 2)));
    }
    System.out.println(result);
    }

    static BigDecimal[] GetArguments() {
        BigDecimal[] arguments;
        try {
            arguments = new BigDecimal[2];
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your x and precision:");
            String str = scanner.nextLine();
            String[] args = str.split(" ");
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("Too many or not enough arguments");
            }
            arguments[0] = new BigDecimal(args[0]);
            arguments[1] = new BigDecimal(args[1]);
            scanner.close();
            if (arguments[0].abs().compareTo(new BigDecimal("1")) >= 0) {
                throw new IllegalArgumentException("Please input x in (-1, 1)");
            }
        } catch (NumberFormatException ex) {
            throw new InputMismatchException("Please input correct");
        }
        return arguments;
    }
}
