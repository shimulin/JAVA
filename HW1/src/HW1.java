package src;

import java.util.Scanner;
import java.math.BigDecimal;

public class HW1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String value1 = scanner.next();
        String value2 = scanner.next();
        BigDecimal n1 = new BigDecimal(value1);
        BigDecimal n2 = new BigDecimal(value2);
        BigDecimal sum = n1.add(n2);

        System.out.println(sum);
        scanner.close();
    }
}
