import java.util.LinkedList;
import java.util.List;

public class Board {

    int size;
    private int[][] field;
    private static List<Board> solutions = new LinkedList<>();


    Board() {

    }

     Board(Board board) {
        this.size = board.size;
        this.field = new int[size][size];

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                this.field[i][j] = board.field[i][j];
            }
        }
    }

    Board(int size) {
        this.size = size;
        field = new int[size][size];

    }

    private boolean isSafe(Board board, int row, int col) {
        int i, j;
        for (i = 0; i < col; i++)
            if (board.field[row][i] == 1)
                return false;

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board.field[i][j] == 1)
                return false;

        for (i = row, j = col; j >= 0 && i < size; i++, j--)
            if (board.field[i][j] == 1)
                return false;

        return true;
    }

    public void placeQueens() {

        placeQueens(0, this);

    }

    private void placeQueens(int col, Board board) {
        if (col < size) {
            for (int i = 0; i < size; i++) {
                if (isSafe(board, i, col)) {
                    board.field[i][col] = 1;
                    placeQueens(col + 1, new Board(board));
                    board.field[i][col] = 0;
                }
            }
        } else {
            solutions.add(board);
        }
    }

    public void printAllAnswers() {

        for (Board board : solutions) {
            System.out.println(board.toString());
        }
        System.out.println("Number of answers :" + "\u001B[36m" + solutions.size() + "\u001B[0m");

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (field[i][j] == 1) res.append("\u001B[36m" + "Q" + "\u001B[0m");
                else res.append("0");
            }
            res.append("\n");
        }
        res.append("-".repeat(Math.max(0, size)));
        res.append("\n");
        return res.toString();
    }

}
