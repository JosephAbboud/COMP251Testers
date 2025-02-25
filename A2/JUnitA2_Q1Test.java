import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

 /**
 * COMP 251 Test file
 * <p>Assignment 2, Question 1
 *
 * <p>This class tests the {@code game} method which takes a 2-D array of Strings
 * representing a board and returns an int array of two elements: the first element
 * is the minimum number of balls remaining after performing valid moves, and the
 * second element is the minimum number of moves required to reach that state.
 * <p>
 * The board follows a fixed 5x9 pattern where:
 * <ul>
 *   <li>"#" indicates a wall (no hole),</li>
 *   <li>"." indicates an empty hole, and</li>
 *   <li>"o" indicates a hole containing a ball.</li>
 * </ul>
 *
 * @author Joseph Abboud
 */
public class JUnitA2_Q1Test {

    /** Separator string for output */
    private static final String SEPARATOR = "--------------------------------------------------";

    /** Counter for tests passed */
    private static int testsPassed = 0;

    /** Total tests executed */
    private static int totalTests = 0;

    /**
     * Test the example case provided in the assignment instructions.
     * <p>
     * The board is defined as:
     * <pre>
     *   { "#", "#", "#", ".", ".", ".", "#", "#", "#" },
     *   { ".", ".", "o", "o", ".", ".", ".", ".", "." },
     *   { ".", ".", ".", ".", ".", "o", "o", ".", "." },
     *   { ".", ".", ".", ".", ".", ".", ".", ".", "." },
     *   { "#", "#", "#", ".", ".", ".", "#", "#", "#" }
     * </pre>
     * The expected outcome is 1 ball remaining after 3 moves.
     */
    @Test
    @DisplayName("Test Example Case")
    public void testExampleCase() {
        String[][] exampleBoard = {
                {"#", "#", "#", ".", ".", ".", "#", "#", "#"},
                {".", ".", "o", "o", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", "o", "o", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", "."},
                {"#", "#", "#", ".", ".", ".", "#", "#", "#"}
        };

        int[] result = A2_Q1.game(exampleBoard);
        System.out.println(SEPARATOR);
        System.out.println("Testing game() with board: Example Case");
        System.out.println("Expected result: [1, 3]");
        System.out.println("Received result: " + Arrays.toString(result));
        totalTests++;
        try {
            assertEquals(1, result[0], "Expected one ball remaining.");
            assertEquals(3, result[1], "Expected three moves performed.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test the scenario where the board is already in a solved state (only one ball).
     * <p>
     * Expected outcome: 1 ball remaining with 0 moves.
     */
    @Test
    @DisplayName("Test Already Solved Board")
    public void testAlreadySolved() {
        String[][] board = {
                {"#", "#", "#", ".", ".", ".", "#", "#", "#"},
                {".", ".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", "o", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", "."},
                {"#", "#", "#", ".", ".", ".", "#", "#", "#"}
        };

        int[] result = A2_Q1.game(board);
        System.out.println(SEPARATOR);
        System.out.println("Testing game() with board: Already Solved Board");
        System.out.println("Expected result: [1, 0]");
        System.out.println("Received result: " + Arrays.toString(result));
        totalTests++;
        try {
            assertEquals(1, result[0], "Board is already solved with one ball.");
            assertEquals(0, result[1], "No moves should be needed.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test the case where no moves are possible.
     * <p>
     * Two balls are placed far apart so that no valid jump can be performed.
     * Expected outcome: Ball count remains unchanged with 0 moves.
     */
    @Test
    @DisplayName("Test No Moves Possible")
    public void testNoMovesPossible() {
        String[][] board = {
                {"#", "#", "#", ".", ".", ".", "#", "#", "#"},
                {".", ".", ".", "o", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", "o", ".", ".", "."},
                {"#", "#", "#", ".", ".", ".", "#", "#", "#"}
        };

        int[] result = A2_Q1.game(board);
        System.out.println(SEPARATOR);
        System.out.println("Testing game() with board: No Moves Possible");
        System.out.println("Expected result: [2, 0]");
        System.out.println("Received result: " + Arrays.toString(result));
        totalTests++;
        try {
            assertEquals(2, result[0], "No moves possible, ball count remains the same.");
            assertEquals(0, result[1], "No moves performed.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test the scenario with two independent clusters, each capable of one move.
     * <p>
     * Cluster 1: Located on row 1 with pattern at columns 3 and 4 ("o", "o") and an empty hole at column 5.
     * Cluster 2: Located on row 3 with the same pattern.
     * <p>
     * Each cluster performs one move to reduce from two balls to one ball.
     * The expected outcome is 2 balls remaining with a total of 2 moves.
     */
    @Test
    @DisplayName("Test Two Independent Clusters")
    public void testTwoClusters() {
        String[][] board = {
                {"#", "#", "#", ".", ".", ".", "#", "#", "#"},
                {".", ".", ".", "o", "o", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", "o", "o", ".", ".", ".", "."},
                {"#", "#", "#", ".", ".", ".", "#", "#", "#"}
        };

        int[] result = A2_Q1.game(board);
        System.out.println(SEPARATOR);
        System.out.println("Testing game() with board: Two Independent Clusters");
        System.out.println("Expected result: [2, 2]");
        System.out.println("Received result: " + Arrays.toString(result));
        totalTests++;
        try {
            assertEquals(2, result[0], "Expected two balls remaining after optimal moves.");
            assertEquals(2, result[1], "Expected two moves performed in total.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test the full board scenario where every playable position is occupied by a ball.
     * <p>
     * The board is defined as:
     * <pre>
     *   Row 0: { "#", "#", "#", "o", "o", "o", "#", "#", "#" }  (3 balls)
     *   Row 1: { "o", "o", "o", "o", "o", "o", "o", "o", "o" }  (9 balls)
     *   Row 2: { "o", "o", "o", "o", "o", "o", "o", "o", "o" }  (9 balls)
     *   Row 3: { "o", "o", "o", "o", "o", "o", "o", "o", "o" }  (9 balls)
     *   Row 4: { "#", "#", "#", "o", "o", "o", "#", "#", "#" }  (3 balls)
     * </pre>
     * Since there is no empty hole, no moves can be performed.
     * The expected outcome is 33 balls remaining with 0 moves.
     */
    @Test
    @DisplayName("Test Full Board - No Moves Possible")
    public void testFullBoard() {
        String[][] board = {
                {"#", "#", "#", "o", "o", "o", "#", "#", "#"},
                {"o", "o", "o", "o", "o", "o", "o", "o", "o"},
                {"o", "o", "o", "o", "o", "o", "o", "o", "o"},
                {"o", "o", "o", "o", "o", "o", "o", "o", "o"},
                {"#", "#", "#", "o", "o", "o", "#", "#", "#"}
        };

        int[] result = A2_Q1.game(board);
        System.out.println(SEPARATOR);
        System.out.println("Testing game() with board: Full Board - No Moves Possible");
        System.out.println("Expected result: [33, 0]");
        System.out.println("Received result: " + Arrays.toString(result));
        totalTests++;
        try {
            assertEquals(33, result[0], "Full board should remain unchanged with 33 balls.");
            assertEquals(0, result[1], "No moves performed on a full board.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test a board with a single horizontal jump opportunity.
     * <p>
     * In row 2, a ball at column 3 can jump over an adjacent ball at column 4 into the empty hole at column 5.
     * Expected outcome: 1 ball remaining with 1 move.
     */
    @Test
    @DisplayName("Test Single Horizontal Jump")
    public void testSingleHorizontalJump() {
        String[][] board = {
                {"#", "#", "#", ".", ".", ".", "#", "#", "#"},
                {".", ".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", "o", "o", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", "."},
                {"#", "#", "#", ".", ".", ".", "#", "#", "#"}
        };

        int[] result = A2_Q1.game(board);
        System.out.println(SEPARATOR);
        System.out.println("Testing game() with board: Single Horizontal Jump");
        System.out.println("Expected result: [1, 1]");
        System.out.println("Received result: " + Arrays.toString(result));
        totalTests++;
        try {
            assertEquals(1, result[0], "Expected one ball remaining after horizontal jump.");
            assertEquals(1, result[1], "Expected one move performed.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test a board with a single vertical jump opportunity.
     * <p>
     * In column 4, a ball at row 1 can jump over the ball at row 2 into the empty hole at row 3.
     * Expected outcome: 1 ball remaining with 1 move.
     */
    @Test
    @DisplayName("Test Single Vertical Jump")
    public void testSingleVerticalJump() {
        String[][] board = {
                {"#", "#", "#", ".", ".", ".", "#", "#", "#"},
                {".", ".", ".", ".", "o", ".", ".", ".", "."},
                {".", ".", ".", ".", "o", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", "."},
                {"#", "#", "#", ".", ".", ".", "#", "#", "#"}
        };

        int[] result = A2_Q1.game(board);
        System.out.println(SEPARATOR);
        System.out.println("Testing game() with board: Single Vertical Jump");
        System.out.println("Expected result: [1, 1]");
        System.out.println("Received result: " + Arrays.toString(result));
        totalTests++;
        try {
            assertEquals(1, result[0], "Expected one ball remaining after vertical jump.");
            assertEquals(1, result[1], "Expected one move performed.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test a board that requires a chain of two horizontal moves.
     * <p>
     * In row 1, balls are arranged at columns 3, 4, and 6 with an empty cell at column 5.
     * The first move: ball at column 3 jumps to the right over column 4 to column 5.
     * The second move: ball at column 6 jumps to the left over the newly positioned ball at column 5 to column 4.
     * Expected outcome: 1 ball remaining with 2 moves.
     */
    @Test
    @DisplayName("Test Two Horizontal Moves Chain")
    public void testTwoHorizontalMovesChain() {
        String[][] board = {
                {"#", "#", "#", ".", ".", ".", "#", "#", "#"},
                {".", ".", ".", "o", "o", ".", "o", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", "."},
                {"#", "#", "#", ".", ".", ".", "#", "#", "#"}
        };

        int[] result = A2_Q1.game(board);
        System.out.println(SEPARATOR);
        System.out.println("Testing game() with board: Two Horizontal Moves Chain");
        System.out.println("Expected result: [1, 2]");
        System.out.println("Received result: " + Arrays.toString(result));
        totalTests++;
        try {
            assertEquals(1, result[0], "Expected one ball remaining after two horizontal moves.");
            assertEquals(2, result[1], "Expected two moves performed.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test a board with three balls placed non-adjacently.
     * <p>
     * Balls are placed in row 1 at column 3, row 2 at column 5, and row 3 at column 7.
     * No moves are possible since no two balls are adjacent.
     * Expected outcome: 3 balls remaining with 0 moves.
     */
    @Test
    @DisplayName("Test Three Balls Not Adjacent")
    public void testThreeBallsNotAdjacent() {
        String[][] board = {
                {"#", "#", "#", ".", ".", ".", "#", "#", "#"},
                {".", ".", ".", "o", ".", ".", ".", ".", "."},
                {".", ".", ".", ".", ".", "o", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", "o", "."},
                {"#", "#", "#", ".", ".", ".", "#", "#", "#"}
        };

        int[] result = A2_Q1.game(board);
        System.out.println(SEPARATOR);
        System.out.println("Testing game() with board: Three Balls Not Adjacent");
        System.out.println("Expected result: [3, 0]");
        System.out.println("Received result: " + Arrays.toString(result));
        totalTests++;
        try {
            assertEquals(3, result[0], "Expected three balls remaining as no moves are possible.");
            assertEquals(0, result[1], "Expected zero moves performed.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test a board with four isolated balls.
     * <p>
     * Balls are placed at row 1 in columns 3 and 5, and row 3 in columns 3 and 5.
     * They are isolated, so no moves can be performed.
     * Expected outcome: 4 balls remaining with 0 moves.
     */
    @Test
    @DisplayName("Test Four Isolated Balls")
    public void testFourIsolatedBalls() {
        String[][] board = {
                {"#", "#", "#", ".", ".", ".", "#", "#", "#"},
                {".", ".", ".", "o", ".", "o", ".", ".", "."},
                {".", ".", ".", ".", ".", ".", ".", ".", "."},
                {".", ".", ".", "o", ".", "o", ".", ".", "."},
                {"#", "#", "#", ".", ".", ".", "#", "#", "#"}
        };

        int[] result = A2_Q1.game(board);
        System.out.println(SEPARATOR);
        System.out.println("Testing game() with board: Four Isolated Balls");
        System.out.println("Expected result: [4, 0]");
        System.out.println("Received result: " + Arrays.toString(result));
        totalTests++;
        try {
            assertEquals(4, result[0], "Expected four balls remaining as no moves are possible.");
            assertEquals(0, result[1], "Expected zero moves performed.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Cleanup method executed once after all tests.
     */
    @AfterAll
    public static void tearDownAfterClass() {
        System.out.println(SEPARATOR);
        System.out.println("Chaining Tests Summary: Passed " + testsPassed + " out of " + totalTests + " tests.");
        System.out.println(SEPARATOR);
    }
}