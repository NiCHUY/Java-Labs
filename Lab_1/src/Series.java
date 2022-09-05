import java.math.BigDecimal;
import java.util.Scanner;
//Variant №1
public class Series {
public static void main(String[] args) {
//Input your values
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter your x");
    BigDecimal x = scanner.nextBigDecimal();
    System.out.println("Enter your precision");
    BigDecimal precision = scanner.nextBigDecimal();
    scanner.close();
//Initializing of new values
    BigDecimal result = new BigDecimal(0);
    BigDecimal term;
    int k = 1;
    term = x.pow((3 * (int)Math.pow(k , 2)));
//Series loop
    while(term.compareTo(precision) > 0)
    {
        result= result.add(term);
        k++;
        term = x.pow((3 * (int)Math.pow(k , 2)));
    }
    System.out.println(result);
    }
}
