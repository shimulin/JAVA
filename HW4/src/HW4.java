package src;

import java.util.Scanner;

public class HW4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String varNumString = scanner.nextLine();
        int varNum = Integer.parseInt(varNumString);
        double[][] matrix = new double[10][varNum + 1];
        int m = 0;
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("-999")) {
                break;
            }
            String[] parts = line.split(" ");
            for (int i = 0; i <= varNum; i++) {
                matrix[m][i] = Double.parseDouble(parts[i]);
            }
            m++;
        }
        scanner.close();

        int ans = solutionType(matrix, m);

        switch (ans) {
            case 0:
                System.out.println("No solution");
                break;
            case 1:
                System.out.println("The only solution");
                break;
            default:
                System.out.println("Infinite solutions");
                break;
        }
    }

    private static int solutionType(double[][] matrix, int m) {
        int matrixColumns = matrix[0].length - 1;
        int matrixRows = m;
        for (int i = 0; i < matrixRows; i++) {
            for (int j = i + 1; j < matrixColumns; j++) {
                if (matrix[i][i] == 0) {
                    for (int k = i; k < matrixColumns + 1; k++) {
                        matrix[j][k] -= matrix[i][k];
                    }
                    continue;
                }
                else {
                    double factor = matrix[j][i] / matrix[i][i];
                    // System.out.println("factor is " + factor);
                    for (int k = i; k < matrixColumns + 1; k++) {
                        matrix[j][k] -= factor * matrix[i][k];
                    }
                }
            }
        }

        // check solution numbers
        for (int i = 0; i < matrixRows; i++) {
            int count = 0;
            for (int j = 0; j < matrixColumns + 1; j++) {
                // System.out.println(matrix[i][j]);
                if (matrix[i][j] == 0) {
                    count++;
                }
                if (count == matrixColumns + 1) {
                    return 2; // infinite solutions
                } else if (count == matrixColumns && matrix[i][matrixColumns] != 0) {
                    return 0; // no solution
                }
            }
        }
        return 1;
    }
}
