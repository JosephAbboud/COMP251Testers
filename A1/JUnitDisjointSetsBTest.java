package assignment1.question2b;

import org.junit.jupiter.api.*;       // JUnit 5 annotations
import static org.junit.jupiter.api.Assertions.*;

/**
 * COMP 251 Test file<p>
 * Assignment 1, Question 2b
 *
 * <p>JUnit tests for the DisjointSetsB class.
 *
 * <p>This class tests the following functionalities:
 * <ul>
 *   <li>{@link DisjointSetsB#find(int)}: Returns the representative of the set containing an element.
 *   <li>{@link DisjointSetsB#union(int, int)}: Merges two disjoint sets using union by rank.
 *   <li>{@link DisjointSetsB#move(int, int)}: Moves an element from its set to the set containing another element.
 *   <li>{@link DisjointSetsB#sum_elements(int)}: Returns the sum of all elements in the set containing a given element.
 *   <li>{@link DisjointSetsB#toString()}: Produces a formatted string showing the current partition.
 * </ul>
 *
 * Each test prints its outcome (green for pass, red for fail) along with expected and received results.
 * A summary is printed at the end.
 *
 * @author Joseph Abboud
 */
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class JUnitDisjointSetsBTest {

    /** Separator string for output (same length as used in other tests) */
    private static final String SEPARATOR = "--------------------------------------------------";

    /** Global counter for tests passed */
    private static int testsPassed = 0;

    /** Global counter for tests executed */
    private static int totalTests = 0;

    // ---------- Tests for initial state and singleton sums ----------

    /**
     * Test 1: Verify the initial partition of 6 singleton sets.
     */
    @Test
    @DisplayName("Test 1: Initial Partition")
    public void testInitialPartitionB() {
        int n = 6;
        DisjointSetsB ds = new DisjointSetsB(n);
        String expected =
                "6 set(s):\n" +
                        "0 : 0\n" +
                        "1 : 1\n" +
                        "2 : 2\n" +
                        "3 : 3\n" +
                        "4 : 4\n" +
                        "5 : 5\n";
        totalTests++;
        String actual = ds.toString();
        System.out.println(SEPARATOR);
        System.out.println("Test 1: Checking initial partition of " + n + " elements.");
        System.out.println("Expected output:\n" + expected);
        System.out.println("Received output:\n" + actual);
        try {
            assertEquals(expected, actual, "Initial partition does not match expected output.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 2: Check that sum_elements(0) equals 0.
     */
    @Test
    @DisplayName("Test 2: sum_elements(0)")
    public void testSumElement0() {
        DisjointSetsB ds = new DisjointSetsB(6);
        totalTests++;
        int expected = 0;
        int actual = ds.sum_elements(0);
        System.out.println(SEPARATOR);
        System.out.println("Test 2: Checking sum_elements(0)");
        System.out.println("Expected: " + expected + ", Received: " + actual);
        try {
            assertEquals(expected, actual, "sum_elements(0) should be 0.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 3: Check that sum_elements(1) equals 1.
     */
    @Test
    @DisplayName("Test 3: sum_elements(1)")
    public void testSumElement1() {
        DisjointSetsB ds = new DisjointSetsB(6);
        totalTests++;
        int expected = 1;
        int actual = ds.sum_elements(1);
        System.out.println(SEPARATOR);
        System.out.println("Test 3: Checking sum_elements(1)");
        System.out.println("Expected: " + expected + ", Received: " + actual);
        try {
            assertEquals(expected, actual, "sum_elements(1) should be 1.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 4: Check that sum_elements(2) equals 2.
     */
    @Test
    @DisplayName("Test 4: sum_elements(2)")
    public void testSumElement2() {
        DisjointSetsB ds = new DisjointSetsB(6);
        totalTests++;
        int expected = 2;
        int actual = ds.sum_elements(2);
        System.out.println(SEPARATOR);
        System.out.println("Test 4: Checking sum_elements(2)");
        System.out.println("Expected: " + expected + ", Received: " + actual);
        try {
            assertEquals(expected, actual, "sum_elements(2) should be 2.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 5: Check that sum_elements(3) equals 3.
     */
    @Test
    @DisplayName("Test 5: sum_elements(3)")
    public void testSumElement3() {
        DisjointSetsB ds = new DisjointSetsB(6);
        totalTests++;
        int expected = 3;
        int actual = ds.sum_elements(3);
        System.out.println(SEPARATOR);
        System.out.println("Test 5: Checking sum_elements(3)");
        System.out.println("Expected: " + expected + ", Received: " + actual);
        try {
            assertEquals(expected, actual, "sum_elements(3) should be 3.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 6: Check that sum_elements(4) equals 4.
     */
    @Test
    @DisplayName("Test 6: sum_elements(4)")
    public void testSumElement4() {
        DisjointSetsB ds = new DisjointSetsB(6);
        totalTests++;
        int expected = 4;
        int actual = ds.sum_elements(4);
        System.out.println(SEPARATOR);
        System.out.println("Test 6: Checking sum_elements(4)");
        System.out.println("Expected: " + expected + ", Received: " + actual);
        try {
            assertEquals(expected, actual, "sum_elements(4) should be 4.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 7: Check that sum_elements(5) equals 5.
     */
    @Test
    @DisplayName("Test 7: sum_elements(5)")
    public void testSumElement5() {
        DisjointSetsB ds = new DisjointSetsB(6);
        totalTests++;
        int expected = 5;
        int actual = ds.sum_elements(5);
        System.out.println(SEPARATOR);
        System.out.println("Test 7: Checking sum_elements(5)");
        System.out.println("Expected: " + expected + ", Received: " + actual);
        try {
            assertEquals(expected, actual, "sum_elements(5) should be 5.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    // ------------------- Tests for union operations -------------------

    /**
     * Test 8: After union(1,2), check that sum_elements(1) equals 3.
     */
    @Test
    @DisplayName("Test 8: union(1,2) - sum_elements")
    public void testUnionOperationSumB() {
        DisjointSetsB ds = new DisjointSetsB(6);
        ds.union(1, 2);
        totalTests++;
        int expectedSum = 3;
        int actualSum = ds.sum_elements(1);
        System.out.println(SEPARATOR);
        System.out.println("Test 8: After union(1,2), expected sum_elements(1) = " + expectedSum);
        System.out.println("Received: " + actualSum);
        try {
            assertEquals(expectedSum, actualSum, "After union(1,2), sum_elements(1) should be 3.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 9: After union(1,2), verify that find(1) equals find(2).
     */
    @Test
    @DisplayName("Test 9: union(1,2) - find() equality")
    public void testUnionOperationFindB() {
        DisjointSetsB ds = new DisjointSetsB(6);
        ds.union(1, 2);
        totalTests++;
        int rep1 = ds.find(1);
        int rep2 = ds.find(2);
        System.out.println(SEPARATOR);
        System.out.println("Test 9: After union(1,2), expected find(1) equals find(2).");
        System.out.println("find(1): " + rep1 + ", find(2): " + rep2);
        try {
            assertEquals(rep1, rep2, "After union(1,2), find(1) and find(2) must be equal.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    // ------------------- Tests for move and sum sequence -------------------

    /**
     * Test 10: After union(1,2), check that sum_elements(1) equals 3.
     */
    @Test
    @DisplayName("Test 10: move/sum sequence Step 1")
    public void testMoveAndSumSequenceB_Step1() {
        DisjointSetsB ds = new DisjointSetsB(6);
        ds.union(1, 2);
        totalTests++;
        int expected = 3;
        int actual = ds.sum_elements(1);
        System.out.println(SEPARATOR);
        System.out.println("Test 10: After union(1,2), expected sum_elements(1) = " + expected);
        System.out.println("Received: " + actual);
        try {
            assertEquals(expected, actual, "After union(1,2), sum_elements(1) should be 3.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 11: After move(3,4), check that sum_elements(4) equals 7.
     */
    @Test
    @DisplayName("Test 11: move/sum sequence Step 2")
    public void testMoveAndSumSequenceB_Step2() {
        DisjointSetsB ds = new DisjointSetsB(6);
        ds.move(3, 4);
        totalTests++;
        int expected = 7;
        int actual = ds.sum_elements(4);
        System.out.println(SEPARATOR);
        System.out.println("Test 11: After move(3,4), expected sum_elements(4) = " + expected);
        System.out.println("Received: " + actual);
        try {
            assertEquals(expected, actual, "After move(3,4), sum_elements(4) should be 7.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 12: After union(3,5) (following Step 2), check that sum_elements(4) equals 12.
     */
    @Test
    @DisplayName("Test 12: move/sum sequence Step 3")
    public void testMoveAndSumSequenceB_Step3() {
        DisjointSetsB ds = new DisjointSetsB(6);
        ds.move(3, 4);
        ds.union(3, 5);
        totalTests++;
        int expected = 12;
        int actual = ds.sum_elements(4);
        System.out.println(SEPARATOR);
        System.out.println("Test 12: After union(3,5), expected sum_elements(4) = " + expected);
        System.out.println("Received: " + actual);
        try {
            assertEquals(expected, actual, "After union(3,5), sum_elements(4) should be 12.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 13: After move(4,1) (following previous steps), check that sum_elements(4) equals 7.
     */
    @Test
    @DisplayName("Test 13: move/sum sequence Step 4")
    public void testMoveAndSumSequenceB_Step4() {
        DisjointSetsB ds = new DisjointSetsB(6);
        ds.union(1, 2);
        ds.move(3, 4);
        ds.union(3, 5);
        ds.move(4, 1);
        totalTests++;
        int expected = 7;
        int actual = ds.sum_elements(4);
        System.out.println(SEPARATOR);
        System.out.println("Test 13: After move(4,1), expected sum_elements(4) = " + expected);
        System.out.println("Received: " + actual);
        try {
            assertEquals(expected, actual, "After move(4,1), sum_elements(4) should be 7.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 14: After move(4,1) (following previous steps), check that sum_elements(3) equals 8.
     */
    @Test
    @DisplayName("Test 14: move/sum sequence Step 5")
    public void testMoveAndSumSequenceB_Step5() {
        DisjointSetsB ds = new DisjointSetsB(6);
        ds.union(1, 2);
        ds.move(3, 4);
        ds.union(3, 5);
        ds.move(4, 1);
        totalTests++;
        int expected = 8;
        int actual = ds.sum_elements(3);
        System.out.println(SEPARATOR);
        System.out.println("Test 14: After move(4,1), expected sum_elements(3) = " + expected);
        System.out.println("Received: " + actual);
        try {
            assertEquals(expected, actual, "After move(4,1), sum_elements(3) should be 8.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    // ------------------- Test move no-op -------------------

    /**
     * Test 15: Verify that move(i,j) is a no-op when i and j are already in the same set.
     */
    @Test
    @DisplayName("Test 15: move() no-op when already in same set")
    public void testMoveNoOpB() {
        DisjointSetsB ds = new DisjointSetsB(6);
        ds.union(1, 2);
        totalTests++;
        String before = ds.toString();
        ds.move(1, 2);
        String after = ds.toString();
        System.out.println(SEPARATOR);
        System.out.println("Test 15: Testing move() no-op when elements are already in the same set.");
        System.out.println("Expected partition (unchanged):\n" + before);
        System.out.println("Received partition:\n" + after);
        try {
            assertEquals(before, after, "move(1,2) should be a no-op when both are in the same set.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    // ------------------- Test repeated moves -------------------

    /**
     * Test 16: Repeated move Step A: After union(1,2) and move(2,5), check that sum_elements(5) equals 7.
     */
    @Test
    @DisplayName("Test 16: Repeated move - Step A")
    public void testRepeatedMovesB_StepA() {
        DisjointSetsB ds = new DisjointSetsB(6);
        ds.union(1, 2);
        ds.union(3, 4);
        ds.move(2, 5);
        totalTests++;
        int expected = 7; // {5,2} → 5+2
        int actual = ds.sum_elements(5);
        System.out.println(SEPARATOR);
        System.out.println("Test 16: After move(2,5), expected sum_elements(5) = " + expected);
        System.out.println("Received: " + actual);
        try {
            assertEquals(expected, actual, "After move(2,5), sum_elements(5) should be 7.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 17: Repeated move Step B: After the previous move, perform move(2,3) and check that sum_elements(3) equals 9.
     */
    @Test
    @DisplayName("Test 17: Repeated move - Step B")
    public void testRepeatedMovesB_StepB() {
        DisjointSetsB ds = new DisjointSetsB(6);
        ds.union(1, 2);
        ds.union(3, 4);
        ds.move(2, 5);
        ds.move(2, 3);
        totalTests++;
        int expected = 9; // {3,4,2} → 3+4+2
        int actual = ds.sum_elements(3);
        System.out.println(SEPARATOR);
        System.out.println("Test 17: After move(2,3), expected sum_elements(3) = " + expected);
        System.out.println("Received: " + actual);
        try {
            assertEquals(expected, actual, "After move(2,3), sum_elements(3) should be 9.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 18: Repeated move Step C: After the moves, check that sum_elements(1) equals 1.
     */
    @Test
    @DisplayName("Test 18: Repeated move - Step C")
    public void testRepeatedMovesB_StepC() {
        DisjointSetsB ds = new DisjointSetsB(6);
        ds.union(1, 2);
        ds.union(3, 4);
        ds.move(2, 5);
        ds.move(2, 3);
        totalTests++;
        int expected = 1; // The set containing element 1 remains unchanged.
        int actual = ds.sum_elements(1);
        System.out.println(SEPARATOR);
        System.out.println("Test 18: Checking sum_elements(1) equals " + expected);
        System.out.println("Received: " + actual);
        try {
            assertEquals(expected, actual, "sum_elements(1) should be 1.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    // ------------------- Test find() after move -------------------

    /**
     * Test 19: After union(1,2) and move(2,3), verify that find(2) equals find(3) and differs from find(1).
     */
    @Test
    @DisplayName("Test 19: find() after move")
    public void testFindAfterMoveB() {
        DisjointSetsB ds = new DisjointSetsB(5);
        ds.union(1, 2);
        ds.move(2, 3);
        totalTests++;
        int rep1 = ds.find(1);
        int rep2 = ds.find(2);
        int rep3 = ds.find(3);
        System.out.println(SEPARATOR);
        System.out.println("Test 19: After union(1,2) and move(2,3):");
        System.out.println("Expected: find(2) equals find(3) and differs from find(1).");
        System.out.println("find(1): " + rep1 + ", find(2): " + rep2 + ", find(3): " + rep3);
        try {
            assertTrue(rep2 == rep3 && rep2 != rep1, "find() after move did not meet expected conditions.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    // ------------------- Test complex union and move sequence -------------------

    /**
     * Test 20: Execute a complex union and move sequence.
     *
     * Scenario:
     * <ol>
     *   <li>Start with 10 elements: {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}.
     *   <li>union(1,2) → {1,2} (sum = 3)
     *   <li>union(3,4) → {3,4} (sum = 7)
     *   <li>union(5,6) → {5,6} (sum = 11)
     *   <li>union(7,8) → {7,8} (sum = 15)
     *   <li>move(2,4) → moves 2 from {1,2} to {3,4} resulting in {1} (sum = 1) and {3,4,2} (sum = 9)
     *   <li>move(5,8) → moves 5 from {5,6} to {7,8} resulting in {6} (sum = 6) and {7,8,5} (sum = 20)
     *   <li>union(4,8) → merges {3,4,2} and {7,8,5} → merged set with sum = 9+20 = 29.
     * </ol>
     * Expected: sum_elements(2) and sum_elements(8) both equal 29.
     */
    @Test
    @DisplayName("Test 20: Complex union and move sequence")
    public void testMultipleUnionAndMoveComplexB() {
        DisjointSetsB ds = new DisjointSetsB(10);
        ds.union(1, 2);   // {1,2} => sum = 3
        ds.union(3, 4);   // {3,4} => sum = 7
        ds.union(5, 6);   // {5,6} => sum = 11
        ds.union(7, 8);   // {7,8} => sum = 15
        // Move 2 from {1,2} to {3,4}
        ds.move(2, 4);
        // Move 5 from {5,6} to {7,8}
        ds.move(5, 8);
        // Merge the sets containing 4 and 8 → merges {3,4,2} with {7,8,5}
        ds.union(4, 8);
        totalTests++;
        int expected = 29;
        int actualSum2 = ds.sum_elements(2);
        int actualSum8 = ds.sum_elements(8);
        System.out.println(SEPARATOR);
        System.out.println("Test 20: Complex union and move sequence.");
        System.out.println("Expected: sum_elements(2) = " + expected + " and sum_elements(8) = " + expected);
        System.out.println("Received: sum_elements(2) = " + actualSum2 + ", sum_elements(8) = " + actualSum8);
        try {
            assertEquals(expected, actualSum2, "Expected sum_elements(2) to be 29, but got " + actualSum2);
            assertEquals(expected, actualSum8, "Expected sum_elements(8) to be 29, but got " + actualSum8);
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    // ------------------- Cleanup -------------------

    /**
     * Cleanup method executed once after all tests.
     */
    @AfterAll
    public static void tearDownAfterClass() {
        System.out.println(SEPARATOR);
        System.out.println("DisjointSetsB Tests Summary: Passed " + testsPassed + " out of " + totalTests + " tests.");
        System.out.println(SEPARATOR);
    }
}