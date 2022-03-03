import java.util.List;

public class TestGame extends Board {

    public static void main(String[] args) throws CloneNotSupportedException {

        Board chess = new Board(8);
        chess.placeQueens();
        chess.printAllAnswers();

    }
}
