    package src;

    import java.util.Scanner;

    public class HW5 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            String[][] str = new String[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    str[i][j] = scanner.next();
                }
            }
            String target = scanner.next();
            scanner.close();

            System.out.println(exist(str, target));
        }
        
        private static boolean exist(String[][] str, String target) {
            int rows = str.length;
            int cols = str[0].length;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (dfs(str, i, j, target, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private static boolean dfs(String[][] str, int row, int col, String target, int index) {
            if (index == target.length()) {
                return true;
            }

            if (row < 0 || row >= str.length || col < 0 || col >= str[0].length || str[row][col].charAt(0) != target.charAt(index)) {
                return false;
            }

            String temp = str[row][col];
            str[row][col] = " ";

            boolean found = dfs(str, row + 1, col, target, index + 1) ||
                            dfs(str, row - 1, col, target, index + 1) ||
                            dfs(str, row, col + 1, target, index + 1) ||
                            dfs(str, row, col - 1, target, index + 1);

            str[row][col] = temp;
            return found;
        }
    }
    
