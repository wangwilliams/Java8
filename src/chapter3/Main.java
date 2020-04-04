package chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyunpeng
 * @date 2020/3/22
 */
public class Main {
    private final static int M = 1024 * 1024;
    private static String a = "demo";
    public static void main(String[] args) {
        int[][] num = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] num2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        Long time1 = System.nanoTime();
        List<Integer> anss = spiralOrder(num2);
        Long time2 = System.nanoTime();
        for (Integer ans : anss) {
            System.out.print(ans + " ");
        }
        System.out.println(time2 - time1);
        a = "tal";
        System.out.println(a);
        changeA();
        System.out.println(a);
    }

    private static void changeA() {
        a = "lalal";
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] flagMatrix = new boolean[m][n];
        List<Integer> ans = new ArrayList<>();
        RightPlace rightPlace = new RightPlace(0, 0);
        int direction = 0;
        while (!flagMatrix[rightPlace.getX()][rightPlace.getY()]) {
            ans.add(matrix[rightPlace.getX()][rightPlace.getY()]);
            flagMatrix[rightPlace.getX()][rightPlace.getY()] = true;
            if (direction==0) {
                rightPlace.setY(rightPlace.getY() + 1);
                if (rightPlace.getY() >= n || flagMatrix[rightPlace.getX()][rightPlace.getY()]) {
                    direction = 1;
                    rightPlace.setY(rightPlace.getY() - 1);
                    rightPlace.setX(rightPlace.getX() + 1);
                    if (flagMatrix[rightPlace.getX()][rightPlace.getY()]) {
                        return ans;
                    }
                }
            } else if (direction==1) {
                rightPlace.setX(rightPlace.getX() + 1);
                if (rightPlace.getX() >= m || flagMatrix[rightPlace.getX()][rightPlace.getY()]) {
                    direction = 2;
                    rightPlace.setX(rightPlace.getX() - 1);
                    rightPlace.setY(rightPlace.getY() - 1);
                    if (flagMatrix[rightPlace.getX()][rightPlace.getY()]) {
                        return ans;
                    }
                }
            } else if (direction==2) {
                rightPlace.setY(rightPlace.getY() - 1);
                if (rightPlace.getY() < 0 || flagMatrix[rightPlace.getX()][rightPlace.getY()]) {
                    direction = 3;
                    rightPlace.setY(rightPlace.getY() + 1);
                    rightPlace.setX(rightPlace.getX() - 1);
                    if (flagMatrix[rightPlace.getX()][rightPlace.getY()]) {
                        return ans;
                    }
                }
            } else if (direction==3) {
                rightPlace.setX(rightPlace.getX() - 1);
                if (rightPlace.getX() < 0 || flagMatrix[rightPlace.getX()][rightPlace.getY()]) {
                    direction = 0;
                    rightPlace.setX(rightPlace.getX() + 1);
                    rightPlace.setY(rightPlace.getY() + 1);
                    if (flagMatrix[rightPlace.getX()][rightPlace.getY()]) {
                        return ans;
                    }
                }
            }
        }
        return ans;
    }

    static class RightPlace {
        private int x;
        private int y;

        public RightPlace(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
