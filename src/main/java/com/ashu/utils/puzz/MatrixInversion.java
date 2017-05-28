package com.ashu.utils.puzz;

import java.util.Random;

/**
 * Transpose MxN matrix
 * Created by mishra.ashish@icloud.com
 */
public class MatrixInversion {

    static int matrix[][] ;

    public static void init(int m, int n ) {

        matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new Random().nextInt(50)  + 1;
            }
        }
    }


    public static void main(String[] args) {

        init(5, 6);
        printMatrix(matrix);
        System.out.println("\n---------------");
        printMatrix(transposeMatrix(matrix));

        System.out.println("this is " + matrix.length + " by " + matrix[0].length + " matrix");
    }



    private static int[][] transposeMatrix(int[][] matrix) {

        int invertedMatrix[][]  = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {
               invertedMatrix[j][i] = matrix[i][j];
            }
        }
        return invertedMatrix;
    }


    public static void printMatrix(int [][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            System.out.println("\n");
            for (int j = 0; j < matrix[0].length; j++) {
                String toPrint = " " + matrix[i][j];
                System.out.print( toPrint);
            }
        }
    }


}
