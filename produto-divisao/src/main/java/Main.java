import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal result = new BigDecimal("1.0");

        int lines =Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {
            String[] arguments = scanner.nextLine().trim().split(" ");

            BigDecimal current = new BigDecimal(arguments[0]);
            String operator = arguments[1];

            if (operator.equals("*")) {
                result = result.multiply(current);
            } else if (operator.equals("/")) {
                result = result.divide(current, MathContext.DECIMAL128);
            }
        }

        System.out.println(result.setScale(0, RoundingMode.DOWN));
        scanner.close();
    }
}