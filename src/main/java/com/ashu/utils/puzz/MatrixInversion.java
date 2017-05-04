package com.ashu.utils.puzz;

import java.util.Random;

/**
 * Created by mishra.ashish@icloud.com
 */
public class MatrixInversion {

    static int matrix[][] ;

    public static void init(int n ) {

        matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new Random().nextInt(50)  + 1;
            }
        }
    }


    public static void main(String[] args) {
        init(5);
        printMatrix(matrix);

        //printMatrix(transposeMatrix(matrix));
        printMatrix(mirrorMatrix(matrix));
    }

    private static int[][] transposeMatrix(int[][] matrix) {

        int invertedMatrix[][]  = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++) {
               invertedMatrix[i][j] = matrix[j][i];
            }
        }
        return invertedMatrix;
    }


    private static int[][] mirrorMatrix(int[][] matrix) {

        int mirroredMatrix[][]  = new int[matrix.length][matrix.length];
        //Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < matrix.length; i++) {

            System.out.print(i);
            for (int j = 0; j < matrix.length; j++) {

                System.out.println(j);
            }
        }

/*
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++) {
                mirroredMatrix[j][i] = stack.pop();
            }

        }
*/
        return mirroredMatrix;
    }


    public static void printMatrix(int [][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            System.out.println("\n");
            for (int j = 0; j < matrix.length; j++) {
                String toPrint = " " + matrix[i][j];
                System.out.print( toPrint);
            }
        }
    }


}
