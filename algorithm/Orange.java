package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Orange {

    class Tuple{
        public int x;
        public int y;
        public int timePassed;
        public Tuple(int x, int y, int timePassed) {
            this.x = x;
            this.y = y;
            this.timePassed = timePassed;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Tuple) {
                Tuple target = (Tuple)obj;
                if (target.x == this.x && target.y == this.y) {
                    return true;
                } else {
                    return false;
                }
            }

            return false;
        }
    }

    public int orangesRotting(int[][] grid) {
        LinkedList<Tuple> rotten = new LinkedList<>();
        LinkedList<Tuple> fresh = new LinkedList<>();
        int count = 0;
        int maxTimePassed= 0;
        // default is false;
        boolean visitedGrid[][] = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j =0; j < grid[i].length;j++) {
                if (grid[i][j] == 2 ) {
                    // means find rotten
                    rotten.add(new Tuple(i,j,0));
                    count++;

                } else if (grid[i][j] == 1) {
                    //fresh.add(new Tuple(i,j,0));
                } else if (grid[i][j] == 0) {
                    count++;
                }
            }
        }

        while(!rotten.isEmpty()) {
            Tuple eachRottenOrange = rotten.removeFirst();
            visitedGrid[eachRottenOrange.x][eachRottenOrange.y] = true;


            if (
                    isValidGride(eachRottenOrange.x-1, eachRottenOrange.y, grid) &&
                            grid[eachRottenOrange.x-1][eachRottenOrange.y] == 1
            ) {
                if (visitedGrid[eachRottenOrange.x-1][eachRottenOrange.y] == false) {
                    rotten.add(
                            new Tuple(
                                    eachRottenOrange.x - 1,
                                    eachRottenOrange.y,
                                    eachRottenOrange.timePassed + 1));
                    grid[eachRottenOrange.x-1][eachRottenOrange.y] = 2;
                    count++;
                    if (maxTimePassed < eachRottenOrange.timePassed + 1) {
                        maxTimePassed = eachRottenOrange.timePassed + 1;
                    }
                    //fresh.remove(new Tuple(eachRottenOrange.x - 1, eachRottenOrange.y, 0));
                }
            }

            if (
                    isValidGride(eachRottenOrange.x+1, eachRottenOrange.y, grid) &&
                            grid[eachRottenOrange.x+1][eachRottenOrange.y] == 1
            ) {
                if (visitedGrid[eachRottenOrange.x+1][eachRottenOrange.y] == false) {
                    rotten.add(
                            new Tuple(
                                    eachRottenOrange.x + 1,
                                    eachRottenOrange.y,
                                    eachRottenOrange.timePassed + 1));
                    grid[eachRottenOrange.x+1][eachRottenOrange.y] = 2;
                    count++;
                    if (maxTimePassed < eachRottenOrange.timePassed + 1) {
                        maxTimePassed = eachRottenOrange.timePassed + 1;
                    }
                    //fresh.remove(new Tuple(eachRottenOrange.x - 1, eachRottenOrange.y, 0));
                }
            }

            if (
                    isValidGride(eachRottenOrange.x, eachRottenOrange.y - 1, grid) &&
                            grid[eachRottenOrange.x][eachRottenOrange.y -1] == 1
            ) {
                if (visitedGrid[eachRottenOrange.x][eachRottenOrange.y-1] == false) {
                    rotten.add(
                            new Tuple(
                                    eachRottenOrange.x,
                                    eachRottenOrange.y - 1,
                                    eachRottenOrange.timePassed + 1));
                    grid[eachRottenOrange.x][eachRottenOrange.y -1] = 2;
                    count++;
                    if (maxTimePassed < eachRottenOrange.timePassed + 1) {
                        maxTimePassed = eachRottenOrange.timePassed + 1;
                    }
                    //fresh.remove(new Tuple(eachRottenOrange.x - 1, eachRottenOrange.y, 0));
                }
            }

            if (
                    isValidGride(eachRottenOrange.x, eachRottenOrange.y + 1, grid) &&
                            grid[eachRottenOrange.x][eachRottenOrange.y + 1] == 1
            ) {
                if (visitedGrid[eachRottenOrange.x][eachRottenOrange.y + 1] == false) {
                    rotten.add(
                            new Tuple(
                                    eachRottenOrange.x,
                                    eachRottenOrange.y + 1,
                                    eachRottenOrange.timePassed + 1));
                    grid[eachRottenOrange.x][eachRottenOrange.y + 1] = 2;
                    count++;
                    if (maxTimePassed < eachRottenOrange.timePassed + 1) {
                        maxTimePassed = eachRottenOrange.timePassed + 1;
                    }
                    //fresh.remove(new Tuple(eachRottenOrange.x - 1, eachRottenOrange.y, 0));
                }
            }


        }

        if (count == grid.length * grid[0].length) {
            return maxTimePassed;
        }

        return -1;
    }

    public boolean isValidGride(int i, int j, int[][] grid) {
        return (i > -1 && i < grid.length) && (j > -1 && j < grid[0].length);

    }

    public static void main(String[] args) {
        Orange orange = new Orange();
        int[][] grid = {
                {2,1,1},
                {0,1,1},
                {0,1,1}
        };
        //System.out.println(orange.orangesRotting(grid));
        int[][] grid2 = {
                {0}
        };
        //System.out.println(orange.orangesRotting(grid2));
        //[[1],[2]]
        int[][] grid3 = {
                {1},
                {2}
        };
        System.out.println(orange.orangesRotting(grid3));
    }
}
