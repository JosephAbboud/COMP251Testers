import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * COMP 251 Test file
 * <p>Assignment 2, Question 4
 *
 * <p>This class tests the {@code SelectAssignments} method in the HW_Sched class.
 * The method takes as input two arrays: deadlines and weights (each assignment takes exactly one hour).
 * It returns a homework plan (an int array) of length equal to the last deadline,
 * where each element represents the assignment to be completed in that time slot
 * (with -1 indicating an empty slot). The homework plan must maximise the total weight
 * of completed assignments while respecting deadlines.
 * <p>
 *
 * @author Joseph Abboud
 */
public class JUnitA2_Q4Test {

    /** Separator string for output */
    private static final String SEPARATOR = "--------------------------------------------------";

    /** Counter for tests passed */
    private static int testsPassed = 0;

    /** Total tests executed */
    private static int totalTests = 0;

    /**
     * Test 1: Simple Non-Conflicting Assignments.
     * <p>
     * Input:
     *   deadlines = [1, 2, 3]
     *   weights   = [10, 20, 30]
     * <p>
     * Expected homework plan (length 3): [0, 1, 2]
     * <br>Explanation: Each assignment can be scheduled in its only available slot.
     */
    @Test
    @DisplayName("Test 1: Simple Non-Conflicting Assignments")
    public void testSimpleNonConflicting() {
        int[] deadlines = {1, 2, 3};
        int[] weights   = {10, 20, 30};
        HW_Sched sched = new HW_Sched(weights, deadlines, 3);
        int[] result = sched.SelectAssignments();
        int[] expected = {0, 1, 2};
        System.out.println(SEPARATOR);
        System.out.println("Testing HW_Sched.SelectAssignments() with:");
        System.out.println("Deadlines: " + Arrays.toString(deadlines));
        System.out.println("Weights  : " + Arrays.toString(weights));
        System.out.println("Expected schedule: " + Arrays.toString(expected));
        System.out.println("Received schedule: " + Arrays.toString(result));
        totalTests++;
        try {
            assertArrayEquals(expected, result, "Simple non-conflicting assignments failed.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 2: Conflict with Tight Deadlines.
     * <p>
     * Input:
     *   deadlines = [2, 2, 2]
     *   weights   = [10, 50, 20]
     * <p>
     * Expected homework plan (length 2): [2, 1]
     * <br>Explanation: The highest weight (50, index 1) is scheduled at slot 1.
     * Assignment index 2 (weight 20) then takes slot 0; index 0 is dropped.
     */
    @Test
    @DisplayName("Test 2: Conflict with Tight Deadlines")
    public void testConflictTightDeadlines() {
        int[] deadlines = {2, 2, 2};
        int[] weights   = {10, 50, 20};
        HW_Sched sched = new HW_Sched(weights, deadlines, 3);
        int[] result = sched.SelectAssignments();
        int[] expected = {2, 1};
        System.out.println(SEPARATOR);
        System.out.println("Testing HW_Sched.SelectAssignments() with:");
        System.out.println("Deadlines: " + Arrays.toString(deadlines));
        System.out.println("Weights  : " + Arrays.toString(weights));
        System.out.println("Expected schedule: " + Arrays.toString(expected));
        System.out.println("Received schedule: " + Arrays.toString(result));
        totalTests++;
        try {
            assertArrayEquals(expected, result, "Conflict with tight deadlines failed.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch(AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 3: Mixed Assignments.
     * <p>
     * Input:
     *   deadlines = [4, 4, 2, 3, 1]
     *   weights   = [10, 40, 30, 20, 50]
     * <p>
     * Expected homework plan (length 4): [4, 2, 3, 1]
     * <br>Explanation: Highest weight assignment (index 4) must be at slot 0 (deadline 1).
     * Then assignments with indices 1, 2, and 3 fill the remaining slots optimally.
     */
    @Test
    @DisplayName("Test 3: Mixed Assignments")
    public void testMixedAssignments() {
        int[] deadlines = {4, 4, 2, 3, 1};
        int[] weights   = {10, 40, 30, 20, 50};
        HW_Sched sched = new HW_Sched(weights, deadlines, 5);
        int[] result = sched.SelectAssignments();
        int[] expected = {4, 2, 3, 1};
        System.out.println(SEPARATOR);
        System.out.println("Testing HW_Sched.SelectAssignments() with:");
        System.out.println("Deadlines: " + Arrays.toString(deadlines));
        System.out.println("Weights  : " + Arrays.toString(weights));
        System.out.println("Expected schedule: " + Arrays.toString(expected));
        System.out.println("Received schedule: " + Arrays.toString(result));
        totalTests++;
        try {
            assertArrayEquals(expected, result, "Mixed assignments test failed.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch(AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 4: All Assignments with the Same Tight Deadline.
     * <p>
     * Input:
     *   deadlines = [1, 1, 1]
     *   weights   = [10, 20, 30]
     * <p>
     * Expected homework plan (length 1): [2]
     * <br>Explanation: Only one assignment can be scheduled; the one with highest weight (index 2).
     */
    @Test
    @DisplayName("Test 4: All with Same Tight Deadline")
    public void testSameTightDeadline() {
        int[] deadlines = {1, 1, 1};
        int[] weights   = {10, 20, 30};
        HW_Sched sched = new HW_Sched(weights, deadlines, 3);
        int[] result = sched.SelectAssignments();
        int[] expected = {2};
        System.out.println(SEPARATOR);
        System.out.println("Testing HW_Sched.SelectAssignments() with:");
        System.out.println("Deadlines: " + Arrays.toString(deadlines));
        System.out.println("Weights  : " + Arrays.toString(weights));
        System.out.println("Expected schedule: " + Arrays.toString(expected));
        System.out.println("Received schedule: " + Arrays.toString(result));
        totalTests++;
        try {
            assertArrayEquals(expected, result, "Same tight deadline test failed.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch(AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 5: Varied Deadlines.
     * <p>
     * Input:
     *   deadlines = [2, 3, 4, 4]
     *   weights   = [30, 10, 20, 40]
     * <p>
     * Expected homework plan (length 4): [1, 0, 2, 3]
     * <br>Explanation: Following the greedy algorithm, assignments are scheduled in the latest possible free slot.
     */
    @Test
    @DisplayName("Test 5: Varied Deadlines")
    public void testVariedDeadlines() {
        int[] deadlines = {2, 3, 4, 4};
        int[] weights   = {30, 10, 20, 40};
        HW_Sched sched = new HW_Sched(weights, deadlines, 4);
        int[] result = sched.SelectAssignments();
        int[] expected = {1, 0, 2, 3};
        System.out.println(SEPARATOR);
        System.out.println("Testing HW_Sched.SelectAssignments() with:");
        System.out.println("Deadlines: " + Arrays.toString(deadlines));
        System.out.println("Weights  : " + Arrays.toString(weights));
        System.out.println("Expected schedule: " + Arrays.toString(expected));
        System.out.println("Received schedule: " + Arrays.toString(result));
        totalTests++;
        try {
            assertArrayEquals(expected, result, "Varied deadlines test failed.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch(AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 6: Custom Mixed Case.
     * <p>
     * Input:
     *   deadlines = [4, 4, 2, 3, 1, 7]
     *   weights   = [10, 40, 30, 20, 50, 60]
     * <p>
     * Expected homework plan (length 7): [4, 2, 3, 1, -1, -1, 5]
     * <br>Explanation: Assignments are scheduled optimally; unfilled slots remain as -1.
     */
    @Test
    @DisplayName("Test 6: Custom Mixed Case")
    public void testCustomMixedCase() {
        int[] deadlines = {4, 4, 2, 3, 1, 7};
        int[] weights   = {10, 40, 30, 20, 50, 60};
        HW_Sched sched = new HW_Sched(weights, deadlines, 6);
        int[] result = sched.SelectAssignments();
        int[] expected = {4, 2, 3, 1, -1, -1, 5};
        System.out.println(SEPARATOR);
        System.out.println("Testing HW_Sched.SelectAssignments() with:");
        System.out.println("Deadlines: " + Arrays.toString(deadlines));
        System.out.println("Weights  : " + Arrays.toString(weights));
        System.out.println("Expected schedule: " + Arrays.toString(expected));
        System.out.println("Received schedule: " + Arrays.toString(result));
        totalTests++;
        try {
            assertArrayEquals(expected, result, "Custom mixed case test failed.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch(AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 7: Efficiency Test on Large Input.
     * <p>
     * This test uses 100 assignments where:
     *   - All deadlines are 100.
     *   - Weights are in descending order: [100, 99, ..., 1].
     * <p>
     * Expected homework plan (length 100): The schedule should be the reverse of the indices,
     * i.e., [99, 98, ..., 0].
     */
    @Test
    @DisplayName("Test 7: Efficiency on Large Input")
    public void testLargeInputEfficiency() {
        int n = 100;
        int[] deadlines = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            deadlines[i] = 100;
            weights[i] = 100 - i;
        }
        HW_Sched sched = new HW_Sched(weights, deadlines, n);
        long start = System.currentTimeMillis();
        int[] result = sched.SelectAssignments();
        long end = System.currentTimeMillis();
        int[] expected = new int[n];
        for (int i = 0; i < n; i++) {
            expected[i] = n - 1 - i;
        }
        System.out.println(SEPARATOR);
        System.out.println("Testing HW_Sched.SelectAssignments() on large input (n=" + n + ").");
        System.out.println("Time taken (ms): " + (end - start));
        System.out.println("Expected schedule (first 10 slots): "
                + Arrays.toString(Arrays.copyOfRange(expected, 0, 10)));
        System.out.println("Received schedule (first 10 slots): "
                + Arrays.toString(Arrays.copyOfRange(result, 0, 10)));
        totalTests++;
        try {
            assertArrayEquals(expected, result, "Large input efficiency test failed.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch(AssertionError e) {
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
        System.out.println("A2_Q4 Tests Summary: Passed " + testsPassed + " out of " + totalTests + " tests.");
        System.out.println(SEPARATOR);
    }
}
