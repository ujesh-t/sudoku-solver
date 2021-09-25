package src;
public class Sudoku {
    int problem[][] = new int[9][9];
    int solution[][] = new int[9][9];
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Sudoku(int[][] problem) {
        this.problem = problem;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                solution[i][j] = problem[i][j];
            }
        }
    }

    public void printSudoku() {
        for (int i = 0; i < 9; i++) {
            if(i%3==0 && i!=0)
            System.out.println(ANSI_YELLOW + "--------------------------------"+ANSI_RESET);
            for (int j = 0; j < 9; j++) {
                if(j%3==0 && j!=0) System.out.print(ANSI_YELLOW + " |"+ANSI_RESET);
                if(problem[i][j] > 0) System.out.print(ANSI_RED+"  " + solution[i][j]+ANSI_RESET);
                else System.out.print("  " + solution[i][j]);
            }
            System.out.println("");
        }
    }

    public void solve() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!solveCell(i, j)) {
                    solution[i][j] = 0;
                    do {
                        if (j == 0) {
                            i--;
                            j = 8;
                        } else {
                            j--;
                        }
                    } while (problem[i][j] > 0);
                    j--;
                }
            }
        }
    }

    private boolean solveCell(int i, int j) {
        if (problem[i][j] > 0)
            return true;
        int c = solution[i][j];
        c++;
        while (c <= 9) {
            if (checkRow(c, i) && checkCol(c, j) && checkBox(c, i, j)) {
                solution[i][j] = c;
                return true;
            }
            c++;
        }
        return false;
    }

    public boolean checkBox(int c, int i, int j) {
        for (int x = (3 * (i / 3)); x < (3 * (i / 3) + 3); x++) {
            for (int y = 3 * (j / 3); y < (3 * (j / 3) + 3); y++) {
                if (solution[x][y] == c)
                    return false;
            }
        }
        return true;
    }

    public boolean checkCol(int c, int j) {
        for (int i = 0; i < 9; i++) {
            if (solution[i][j] == c) {
                return false;
            }
        }
        return true;
    }

    public boolean checkRow(int c, int i) {
        for (int j = 0; j < 9; j++) {
            if (solution[i][j] == c)
                return false;
        }
        return true;
    }
}
