package Ski;

/**
 * Created by kecen on 17/5/18.
 */
public class SkiSolverTest {
    @org.junit.Test
    public void solvePuzzle() throws Exception {

        int[][] arr = {{4, 8, 7, 3}, {2, 5, 9, 3}, {6, 3, 2, 5}, {4, 4, 1, 6}};
        String path = "map.txt";
        SkiSolver solver = new SkiSolver();
        solver.solvePuzzle(path);
    }

}