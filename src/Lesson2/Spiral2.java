package Lesson2;

import java.util.Arrays;

public class Spiral2 {
    static int       changeCount = 0;
    static int       changeLimit = 0;

    static int[][] arr;

    public static void main(String[] args) {

        fillMatrix(3,5 );

        printMatrix(arr);

    }

    public static void modifyElement(int _i, int _j, int _value){
        if (changeCount < changeLimit)
            arr[_i][_j] = _value;
    }

    public static void fillMatrix(int _rows, int _columns){
        changeLimit = _rows * _columns;

        arr = new int[_rows][_columns];

        int element = 1;
        int i_max   = _rows;
        int j_max   = _columns;

        for (int i = 0; i < i_max; i++) {
            for (int r1 = _columns - j_max; r1 < j_max; r1++) {
                modifyElement(i, r1, element++);
                changeCount++;
            }

            for (int c1 = i + 1; c1 < i_max; c1++) {
                modifyElement(c1, j_max - 1, element++);
                changeCount++;
            }

            for (int r2 = j_max - 2; r2 > _columns - j_max - 1; r2--) {
                modifyElement(i_max - 1, r2, element++);
                changeCount++;
            }

            for (int c2 = i_max-2; c2 > _rows - i_max; c2--) {
                modifyElement(c2, _columns - j_max, element++);
                changeCount++;
            }
            i_max--;
            j_max--;
        }
    }

    public static void printMatrix(int[][] _matrix){
        for (int i = 0; i < _matrix.length; i++) {
            System.out.println(Arrays.toString(_matrix[i]));
        }
    }
}
