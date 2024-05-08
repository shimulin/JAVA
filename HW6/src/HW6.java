package src;

import java.util.Scanner;
import java.util.ArrayList;

public class HW6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        int x = 0;
        int o = 0;
        ArrayList<Integer> index = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            switch (input.split("")[i]) {
                case "X":
                    x++;
                    index.add(i);
                    break;
                case "O":
                    o++;
                    break;
                default:
                    break;
            }
        }

        // if x won the game, output invalid. else output valid (draw or o won)
        if (x < o || (x == o && !judge(index))) {
            System.out.println("invalid");
        }
        else {
            System.out.println("valid"); 
        }
    }

    private static boolean line(ArrayList<Integer> index) {
        // check horizontal
        if (index.contains(0) && index.contains(1) && index.contains(2)) {
            return true;
        }
        if (index.contains(3) && index.contains(4) && index.contains(5)) {
            return true;
        }
        if (index.contains(6) && index.contains(7) && index.contains(8)) {
            return true;
        }
        
        // check vertical
        if (index.contains(0) && index.contains(3) && index.contains(6)) {
            return true;
        }
        if (index.contains(1) && index.contains(4) && index.contains(7)) {
            return true;
        }
        if (index.contains(2) && index.contains(5) && index.contains(8)) {
            return true;
        }
        
        // check diagonal
        if (index.contains(0) && index.contains(4) && index.contains(8)) {
            return true;
        }
        if (index.contains(2) && index.contains(4) && index.contains(6)) {
            return true;
        }
        return false;
    }
    

    private static boolean judge(ArrayList<Integer> index) { // false is invalid or x wins
        if (index.size() < 3 || line(index) == false) {
            return true;
        }
        return false;
    }
}
