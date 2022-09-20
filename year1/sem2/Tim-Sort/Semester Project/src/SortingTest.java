import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;


class SortingTest {

    static int[][] matrix;

    static {
        try {
            matrix = DataGenerate.readSets("testCases.TXT");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Stream<int[]> arrayStream() {
        return Arrays.stream(matrix.clone());
    }

    @ParameterizedTest
    @MethodSource("arrayStream")
    @DisplayName("Arrays Set Checker")
    public void isArraySorted(int[] array) {

        Sorting.timSort(array, array.length);
        Assertions.assertTrue(Sorting.isSorted(array));
    }

}