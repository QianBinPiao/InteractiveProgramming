package algorithm;

public class UniquePath {
    public int uniquePaths(int m, int n) {
        int gradient[] = new int[m];

        for (int k = 0; k < gradient.length; k++) {
            gradient[k] = 1;
        }

        for (int i = n - 2; i > -1; i--) {
            for (int j = m - 2; j > -1; j--) {
                getUniquePathOptimize(gradient, j);

            }
        }


        return gradient[0];
    }

    public void getUniquePathOptimize(int[] gradient, int startRow) {

        gradient[startRow] = gradient[startRow] + gradient[startRow + 1];

    }


    public int uniquePaths4(int m, int n) {
        int gradient[] = new int[n];

        for (int k = 0; k < gradient.length; k++) {
            gradient[k] = 1;
        }

        for (int i = m  -2; i > -1; i--) {
            for (int j = n -1; j > -1; j--) {
                getUniquePathOptimize(gradient, j);

            }
        }






        return gradient[0];
    }

    public void getUniquePathOptimize4(int[] gradient, int startColumn) {

        int rightCount = 0;
        if ( startColumn + 1 < gradient.length) {
            rightCount = gradient[startColumn + 1];
        }
        gradient[startColumn] = gradient[startColumn] + rightCount;

    }


    public int uniquePaths3(int m, int n) {
        int gradient[][] = new int[m][n];



        boolean isRight = true;

        for (int i = m  -1; i > -1; i--) {
            for (int j = n -1; j > -1; j--) {
                getUniquePath(gradient, i, j, m -1 , n -1);

            }
        }






        return gradient[0][0];
    }

    public void getUniquePath(int[][] gradient, int startRow, int startColumn, int destinationRow, int destinationColumn) {


        if ( startRow == destinationRow && startColumn == destinationColumn) {
            gradient[startRow][startColumn] = 1;
            return ;

        }

        int downCount = 0;
        if ( startColumn + 1 < gradient[0].length) {
            downCount = gradient[startRow][startColumn + 1];
        }
        int rightCount = 0;
        if ( startRow + 1 < gradient.length) {
            rightCount = gradient[startRow + 1][startColumn];
        }
        gradient[startRow][startColumn] = downCount + rightCount;

    }

    public int uniquePaths2(int m, int n) {
        int gradient[][] = new int[m][n];
        calculateUniquePath(gradient,0,0, m -1, n -1);
        return gradient[0][0];
    }

    public int calculateUniquePath(int[][] gradient, int startRow, int startColumn, int destinationRow, int destinationColumn) {
        if (startRow >= gradient.length || startColumn >= gradient[0].length) {
            return 0;
        }

        if ( startRow == destinationRow && startColumn == destinationColumn) {
            gradient[startRow][startColumn] = 1;
            return 1;

        }

        int chooseRightUnique = calculateUniquePath(gradient, startRow + 1, startColumn, destinationRow, destinationColumn);
        int chooseDownUnique = calculateUniquePath(gradient, startRow, startColumn + 1, destinationRow, destinationColumn);

        gradient[startRow][startColumn] = chooseRightUnique + chooseDownUnique;

        return gradient[startRow][startColumn];
    }

    public void calculateUniquePath3(int[][] gradient, int startRow, int startColumn, int destinationRow, int destinationColumn) {
        if (startRow >= gradient.length || startColumn >= gradient[0].length) {
            return;
        }

        if ( startRow == destinationRow && startColumn == destinationColumn) {
            gradient[startRow][startColumn] = 1;
            return;
        }

        calculateUniquePath3(gradient, startRow + 1, startColumn, destinationRow, destinationColumn);
        calculateUniquePath3(gradient, startRow, startColumn + 1, destinationRow, destinationColumn);

        gradient[startRow][startColumn] = gradient[startRow + 1][startColumn] + gradient[startRow][startColumn + 1];

    }



    public static void main(String[] args) {
        UniquePath uniquePath = new UniquePath();
        System.out.println(uniquePath.uniquePaths(4, 3));
        System.out.println(uniquePath.uniquePaths(3, 3));
        System.out.println(uniquePath.uniquePaths(3, 2));
        System.out.println(uniquePath.uniquePaths(7, 3));
        System.out.println(uniquePath.uniquePaths(23, 12));
    }
}
