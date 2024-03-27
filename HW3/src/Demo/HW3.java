package src.Demo;

import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        Point mainPoint = new Point(0, 0);
        Point otherPoint = new Point(arr[2], arr[3]);

        // print original main point (x,y)
        mainPoint.Set(arr[0], arr[1]);

        // print the point after moving
        mainPoint.Move(arr[4], arr[5]);

        // print all the points after rotating 90 degrees clockwise respectively
        for (int i = 0; i < 4; i++) {
            mainPoint.Rotate();
        }

        // print out the Manhatten distance
        System.out.println(mainPoint.calculateManhattanDistance(otherPoint));

        // print out the Chebyshev distance
        System.out.println(mainPoint.ChebyshevDistance(otherPoint));
    }
}
