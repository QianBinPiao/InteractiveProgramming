package algorithm;

public class UniquePathWithObstacle {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // start is blocked.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        // destination is blocked.
        if (obstacleGrid[obstacleGrid.length -1][obstacleGrid[0].length -1] == 1) {
            return 0;
        }

        int gradient[][] = new int[m][n];


        for (int i = m  -1; i > -1; i--) {
            for (int j = n -1; j > -1; j--) {
                getUniquePathOptimize(obstacleGrid, gradient, i, j);

            }
        }

        return gradient[0][0];
    }

    public void getUniquePathOptimize(int[][] obstacleGrid, int[][] gradient,
                                      int startRow, int startColumn) {


        /*
        if (obstacleGrid[obstacleGrid.length -1][obstacleGrid[0].length -1] == 1) {
            gradient[obstacleGrid.length -1][obstacleGrid[0].length -1] = 0;
        }

        if (obstacleGrid.length == 1) {
            if (obstacleGrid[0][0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        */


        if (obstacleGrid[startRow][startColumn] == 1) {
            gradient[startRow][startColumn] = 0;
        } else {

            if (startRow == gradient.length -1 && startColumn == gradient[0].length -1) {
                gradient[startRow][startColumn] = 1;
                return;
            }

            if ( startColumn + 1 < gradient[0].length && startRow + 1 < gradient.length) {

                gradient[startRow][startColumn] = gradient[startRow + 1][startColumn] + gradient[startRow][startColumn + 1];


            } else if (startColumn + 1 == gradient[0].length && startRow + 1 < gradient.length && gradient[startRow + 1][startColumn] !=0){

                gradient[startRow][startColumn] = 1;
            } else if(startRow + 1 == gradient.length && startColumn + 1 < gradient[0].length&& gradient[startRow][startColumn + 1] !=0) {
                gradient[startRow][startColumn] = 1;
            }else {
                gradient[startRow][startColumn] = 0;
            }
        }


    }

    public static void main(String[] args) {
        //  2
        int[][] obstacleGrid = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        UniquePathWithObstacle u =  new UniquePathWithObstacle();
        System.out.println(u.uniquePathsWithObstacles(obstacleGrid));
        //  1
        int[][] obstacleGrid2 = {
                {0,0},
                {1,0}
        };
        System.out.println(u.uniquePathsWithObstacles(obstacleGrid2));

        // 1
        int[][] obstacleGrid3 = {
                {0},
                {0}
        };
        System.out.println(u.uniquePathsWithObstacles(obstacleGrid3));

        // 1
        int[][] obstacleGrid4 = {
                {0,1},
                {0,0}
        };
        System.out.println(u.uniquePathsWithObstacles(obstacleGrid4));

        int[][] obstacleGrid5 = {
                {0,1,0,0,0},
                {1,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}
        };

        System.out.println(u.uniquePathsWithObstacles(obstacleGrid5));

        // 0
        int[][] obstacleGrid6 = {
                {0,0,0,0,0},
                {0,0,0,0,1},
                {0,0,0,1,0},
                {0,0,1,0,0}
        };
        System.out.println(u.uniquePathsWithObstacles(obstacleGrid6));
    }
}
