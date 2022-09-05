import java.math.BigInteger;

public class Task_6 {
    public static void main(String[] args)
    {
        BigInteger result = BigInteger.ONE;
        BigInteger number = new BigInteger("1000");
        while(number.compareTo(BigInteger.ZERO) > 0)
        {
            result = result.multiply(number);
            number = number.subtract(BigInteger.ONE);
        }
        System.out.println("!1000 = " + result);
    }
}
