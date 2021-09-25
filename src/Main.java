package src;
public class Main {
    public static void main(String a[]) {

        int problem[][] = {{0,0,0,0,3,0,0,0,2},
                 {0,0,0,9,0,0,8,3,0},
                 {1,0,0,7,0,0,5,0,0},
                 {0,8,0,0,0,4,0,0,0},
                 {0,0,0,0,5,0,0,0,0},
                 {4,7,0,0,0,0,3,0,6},
                 {0,0,0,0,6,0,4,1,5},
                 {0,0,9,5,0,1,0,6,0},
                 {0,0,0,0,0,0,0,0,0}};

        Sudoku sudoku = new Sudoku(problem);
        sudoku.solve();
        sudoku.printSudoku();
    }
}
