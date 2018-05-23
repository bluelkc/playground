package Ski;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by kecen on 15/5/18.
 */
public class SkiSolver {

    public static void main(String[] args) {


    }

    public void solvePuzzle(int[][] input) {
        if (input.length == 0 || input[0].length == 0) {
            return;
        }
        int rows = input.length;
        int cols = input[0].length;
        int[][][] tmp = new int[rows][cols][2];
        for (int[][] a : tmp)
            for (int[] b : a) {
                b[0] = 1; // default length of route
                b[1] = 0; // default drop
            }
        solvePuzzleCell(input, tmp);
    }

    public void solvePuzzle(String path) {

        int[][] input = readFileToMatrix(path);

        if (input.length == 0 || input[0].length == 0) {
            return;
        }
        int rows = input.length;
        int cols = input[0].length;
        int[][][] tmp = new int[rows][cols][2];
        for (int[][] a : tmp)
            for (int[] b : a) {
                b[0] = 1; // default length of route
                b[1] = 0; // default drop
            }

        long sTime = System.nanoTime();
        solvePuzzleCell(input, tmp);
        long eTime = System.nanoTime();
        System.out.println("Time taken: " + (eTime - sTime)/1000000);
    }

    public static void solvePuzzleCell(int[][] input, int[][][] tmp) {

        int MAX = 1500;
        int rows = input.length;
        int cols = input[0].length;
        int[] max_route = {0, 0}; // {length, drop}
        for (int i = 0; i <= MAX; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols; k++) {
                    if (input[j][k] == i) {
                        tmp[j][k] = max(input, tmp, j, k);
                        if (tmp[j][k][0] > max_route[0]
                                || (tmp[j][k][0] == max_route[0]
                                    && tmp[j][k][1] > max_route[1])) {
                            max_route[0] = tmp[j][k][0];
                            max_route[1] = tmp[j][k][1];
                        }
                    }
                }
            }
        }
        System.out.println("Max length: " + max_route[0] + " with a drop: " + max_route[1]);
    }

    private static int[] max(int[][] input, int[][][] tmp, int row, int col) {

        int MAX = 1500;
        int north = MAX;
        int south = MAX;
        int east = MAX;
        int west = MAX;
        int[] maxRoute = tmp[row][col];

        if (row != 0) north = input[row-1][col];
        if (row != (input.length - 1)) south = input[row+1][col];
        if (col != 0) west = input[row][col-1];
        if (col != (input[0].length - 1)) east = input[row][col+1];

        int cur = input[row][col];
        if (cur > north && compareRoute(tmp[row-1][col][0] + 1,
                                       tmp[row-1][col][1] + cur - north,
                                               maxRoute[0],
                                               maxRoute[1])) {
            maxRoute[0] = tmp[row-1][col][0] + 1;
            maxRoute[1] = tmp[row-1][col][1] + cur - north;
        }
        if (cur > south && compareRoute(tmp[row+1][col][0] + 1,
                                       tmp[row+1][col][1] + cur - south,
                                               maxRoute[0],
                                               maxRoute[1])) {
            maxRoute[0] = tmp[row+1][col][0] + 1;
            maxRoute[1] = tmp[row+1][col][1] + cur - south;
        }
        if (cur > west && compareRoute(tmp[row][col-1][0] + 1,
                                      tmp[row][col-1][1] + cur - west,
                                              maxRoute[0],
                                              maxRoute[1])) {
            maxRoute[0] = tmp[row][col-1][0] + 1;
            maxRoute[1] = tmp[row][col-1][1] + cur - west;
        }
        if (cur > east && compareRoute(tmp[row][col+1][0] + 1,
                                      tmp[row][col+1][1] + cur - east,
                                              maxRoute[0],
                                              maxRoute[1])) {
            maxRoute[0] = tmp[row][col+1][0] + 1;
            maxRoute[1] = tmp[row][col+1][1] + cur - east;
        }

        return maxRoute;
    }

    private static boolean compareRoute(int r1Len, int r1Drop, int r2Len, int r2Drop) {
        if (r1Len > r2Len || (r1Len == r2Len && r1Drop > r2Drop))
            return true;
        return false;
    }

    private int[][] readFileToMatrix(String path) {
        ClassLoader loader = getClass().getClassLoader();
        File file = new File(loader.getResource(path).getFile());
        int[][] res;
        try (Scanner scanner = new Scanner(file)) {

            if (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int[] tmp = stringToIntArr(line);
                int rows = tmp[0];
                int cols = tmp[1];
                res = new int[rows][cols];

                int index = 0;
                while (scanner.hasNextLine()) {
                    int[] data = stringToIntArr(scanner.nextLine());
                    res[index] = data;
                    index ++;
                }
                return res;
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private int[] stringToIntArr(String input) {
        String[] words = input.split("\\s+");
        int[] arr = new int[words.length];
        int index = 0;
        for (String s : words) {
            arr[index] = Integer.parseInt(s);
            index++;
        }
        return arr;
    }
}
