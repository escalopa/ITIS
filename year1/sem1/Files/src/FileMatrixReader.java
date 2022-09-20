import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.Arrays;

public class FileMatrixReader {

    public static void MatrixReader(int Rows, int Columns, String Path) throws IOException {

        int[][] matrix = new int[Rows][Columns];

        BufferedReader data = new BufferedReader(new FileReader(Path));

        String text;
        String[] str;
        int rows_counter = 0;
        while ((text = data.readLine()) != null) {
            str = text.split(" ");
            System.out.println(Arrays.toString(str));
            for (int j = 0; j < Columns; j++) {
                matrix[rows_counter][j] = Integer.parseInt(str[j]);
            }
            rows_counter++;
        }


        for (int k = 0; k < Rows; k++) {
            for (int j = 0; j < Columns; j++) {

                System.out.print((matrix[k][j])+" ");
            }
            System.out.println();
        }
    }
}