import java.util.Scanner;

/**
 *
 * Created by mishra.ashish@icloud.com
 */
class ImageRecognition {


    private static Character[][] matrix ;

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            String tests = scanner.nextLine();


            int t = Integer.parseInt(tests);
            if (t <= 0) {
                System.err.println("Invalid input - no. of tests");
                System.exit(200);
            }

            int i = 0;

            String inputs;
            while (i < t) {
                String matrixSize = scanner.nextLine();

                int size = Integer.parseInt(matrixSize);
                if (size <= 0) {
                    System.err.println("Invalid input - image matrix size but be a non-zero +ve integer");
                    System.exit(200);
                }

                matrix = new Character[size][size];
                matrix = initMatrix(size);
                int n = 0;
                while (n < size) {
                    inputs = scanner.nextLine();
                    populateMatrixRow(n, size, inputs);
                    n++;
                }

                //printMatrix(matrix);
                printImageType(matrix);

                i++;
            }

        } catch( NumberFormatException nfex) {
            nfex.printStackTrace();
            System.out.println("Invalid input ");
        }




    }

    private static void printImageType(Character[][] matrix) {

        if ( isTriangle(matrix) || isTriangle(invertMatrix(matrix)) ) {
            System.out.println("triangle");
            return;
        }
    }

    private static boolean isTriangle(Character[][] matrix) {
        int three1sInRow = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[j][i] == '1')
                    three1sInRow++;
                if (three1sInRow == 3) {
                    return true;
                }
            }
            three1sInRow = 0;
        }
        return false;
    }


    private static boolean isSquare(Character[][] matrix) {

            StringBuilder builder = new StringBuilder();
            builder.append("");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    builder.append(matrix[j][i]);
                }
            }
            return false;
    }


    private static Character[][] invertMatrix(Character[][] matrix) {

        Character invertedMatrix[][]  = new Character[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {
                invertedMatrix[j][i] = matrix[i][j];
            }
        }
        return invertedMatrix;
    }


    private static Character[][] initMatrix(int size) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = '0';
            }
        }

        return matrix;
    }


    private static void populateMatrixRow(int i, int size, String inputs) {

        char[] row = inputs.toCharArray();
        for (int j = 0; j < size; j++) {
            //System.out.println(matrix[i][j] + " : " +  row[j]);
            matrix[i][j] = row[j];
        }
    }

    public static void printMatrix(Character [][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            System.out.println("\n");
            for (int j = 0; j < matrix[0].length; j++) {
                String toPrint = " " + matrix[i][j];
                System.out.print( toPrint);
            }
        }
    }



}
