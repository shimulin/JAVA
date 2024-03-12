package src;

import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class HW2 {
    public static int lcm_func(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int lcm = max;
        while (true) {
            if (lcm % min == 0) {
                return lcm;
            }
            lcm += max;
        }
    }

    public static BigDecimal add_func(String str1, String str2) {
        int idx1 = str1.indexOf("."); // find the index of the period
        int idx2 = str2.indexOf(".");
        int len1 = str1.length() - idx1 - 1;
        int len2 = str2.length() - idx2 - 1;
        int lcm = lcm_func(len1, len2);
        int t1 = lcm / len1;
        int t2 = lcm / len2;

        String temp1 = str1; // change 1.2345 into 1.23452345, if lcm is 8, that is, t1 is 2
        for (int i = 0; i < 2 * t1 - 1; i++) {
            str1 = str1.concat(temp1.substring(idx1 + 1));

        }
        String temp2 = str2;
        for (int i = 0; i < 2 * t2 - 1; i++) {
            str2 = str2.concat(temp2.substring(idx2 + 1));
        }

        BigDecimal n1 = new BigDecimal(str1);
        BigDecimal n2 = new BigDecimal(str2);

        BigDecimal ans = n1.add(n2);

        // System.out.println(ans);

        // 3.56 + 9.2 -> 12.7878 12.78 / 6.8 + 0.142857 -> 7.031746031745 7.031746
        if ((Integer.parseInt(String.valueOf(str1.charAt(str1.indexOf('.') + lcm)))
            + Integer.parseInt(String.valueOf(str2.charAt(str2.indexOf('.') + lcm)))) > 9) { // if carry happened  
            ans = ans.setScale(lcm, RoundingMode.HALF_DOWN);
        } else {
            ans = ans.setScale(lcm, RoundingMode.FLOOR);
        }

        for (int i = 0; i < lcm; i++) {
            String ansString = ans.toString();
            int count = 0;
            int check = Integer.parseInt(String.valueOf(ansString.charAt(ansString.indexOf('.') + 1)));

            System.out.println("//" + Integer.parseInt(String.valueOf(ansString.charAt(ansString.indexOf('.') + i + 1))));
            
            if (Integer.parseInt(String.valueOf(ansString.charAt(ansString.indexOf('.') + i + 1))) == check) {
                count++;
                // System.out.println("//" + count);
            }
            if (count == check) {
                String tempString = ansString;
                ansString = ansString.concat(tempString.substring(ansString.indexOf('.') + 1, ansString.indexOf('.') + 2));
                ans = new BigDecimal(ansString);
                // System.out.println("654654654654");
                return ans;
            }
        }

        // System.out.println(ans);

        // fix 1.234 + 4.321 and 88.3 + 11.6

        return (ans);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            String v1 = scanner.next();
            String v2 = scanner.next();
            BigDecimal sum = add_func(v1, v2);

            // System.out.println("sum is " + sum);

            String sumStringInt = sum.toString();
            sumStringInt = sumStringInt.split("\\.")[0]; // the first element after split
            BigDecimal sumBigDecimal = new BigDecimal(sumStringInt);

            // System.out.println("int value of sum is " + sumBigDecimal);
            // System.out.println("double value of sum is " + sum.doubleValue());
            // BigDecimal diff = new BigDecimal(sum.doubleValue() - sum.intValue());
            // System.err.println("diff is " + diff);
            // System.out.println("bigdecimal diff is " + (sum.subtract(sumBigDecimal)));

            if (sum.subtract(sumBigDecimal).doubleValue() == 0.9) { // if the recurring part is 0.9. ex: 4.9 will lead
                                                                    // to the answer 5
                System.out.print(sum.intValue() + 1);
            } else {
                System.out.print(sum);
            }
        }
        scanner.close();
    }
}
