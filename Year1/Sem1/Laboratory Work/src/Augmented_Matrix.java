import java.util.Scanner;

        //Хелали Ахмед

public class Augmented_Matrix {

    /*Print array(used to debug the matrix)*/
    public static void Print_array(float[][] matrix) {
        for (float[] floats : matrix) {
            for (int j = 0; j < matrix.length + 1; j++) {
                if(floats[j]!=0)
                {
                    System.out.print(floats[j] + "  ");
                }else System.out.print("0.0  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /*Call functions in a specific order to get the value of the augmented matrix */
    public static void Get_augmented_matrix(float[][] matrix) {
        Check_zero(matrix);
        Get_zero_down(matrix);
        Check_zero(matrix);
        Get_zero_down(matrix);
        Divide_rows(matrix);
        Get_zero_up(matrix);
    }

    /*Remove zero elements form the main diagonal at the begging*/
    public static void Check_zero(float[][]matrix){
        for (int i = 0; i <matrix.length ; i++) {
            if(matrix[i][i]==0) {
                for (int j = 0; j< matrix.length ; j++) {
                    if (matrix[j][i]!=0) {
                        for (int k = 0; k <= matrix.length ; k++) {
                            matrix[i][k]+=matrix[j][k];
                        }
                         break;
                    }
                }
            }
        }
    }

    /*Form a zero triangle under the main diagonal*/
    public static void Get_zero_down(float[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                Matrix_operation(matrix, i, j);
            }
        }
    }

    /*Form a zero triangle over the main diagonal*/
    public static void Get_zero_up(float[][] matrix) {
        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = matrix.length - 1; j > i; j--) {
                Matrix_operation(matrix, i, j);
            }
        }
    }

    /*From the 1 main diagonal elements*/
    public static void Divide_rows(float[][] matrix) {
        float temp_var;
        for (int i = 0; i < matrix.length; i++) {
            temp_var = matrix[i][i];
            for (int j = 0; j <= matrix.length; j++) {
                matrix[i][j] /= temp_var;
            }
        }
    }

    /*Get zero elements in a specific row*/
    public static void Matrix_operation(float[][] matrix, int i, int j) {
        float[] temp_row_first = new float[matrix.length + 1];
        float[] temp_row_second = new float[matrix.length + 1];
        if (matrix[i][j] != 0) {
            float value_to_first = matrix[i][j];
            float value_to_second = matrix[j][j];
            for (int k = 0; k <= matrix.length; k++) {
                temp_row_first[k] = matrix[j][k] * value_to_first;
                temp_row_second[k] = matrix[i][k] * value_to_second;
                matrix[i][k] = temp_row_second[k] - temp_row_first[k];
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Введите размеры квадратной матрицы"); /*Enter the size of the square  matrix*/
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        float[][] augmented_mat = new float[size][size + 1];
        System.out.println("Введите элементы матрицы, где каждый элемент в строке разделен пробелом и новая строка в новой строке"); /* Enter elements of the matrix where every element is separated by a space and each row is separated by a row  */
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <size ; j++) {
                augmented_mat[i][j]=input.nextFloat();
            }
            augmented_mat[i][augmented_mat[0].length-1]=(int)(Math.random()*100);
        }
        System.out.println();
        System.out.println("Значения введенной матрицы");
        Print_array(augmented_mat);
        System.out.println("Значение дополненной матрицы");
        Get_augmented_matrix(augmented_mat);
        Print_array(augmented_mat);
    }
}
