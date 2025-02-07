package assignment1.question2a;

import org.junit.jupiter.api.*;       // JUnit 5 annotations
import static org.junit.jupiter.api.Assertions.*;

/**
 * COMP 251 Test file<p>
 * Assignment 1, Question 2a
 *
 * <p>JUnit tests for the DisjointSetsA class.
 *
 * <p>This class tests the following functionalities:
 * <ul>
 *   <li>{@link DisjointSetsA#find(int)}: Returns the representative of the set containing an element,
 *       implementing path compression.
 *   <li>{@link DisjointSetsA#union(int, int)}: Merges two disjoint sets using union by rank, and returns the new representative.
 *   <li>{@link DisjointSetsA#toString()}: Produces a formatted string showing the current partition.
 * </ul>
 *
 * Each test prints its outcome (with ANSI color codes: green for pass, red for fail) along with expected and received results.
 * A summary is printed at the end.
 *
 * @author Joseph Abboud
 */
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class JUnitDisjointSetsATest {

    /** Separator string for output (same length as used in previous tests) */
    private static final String SEPARATOR = "--------------------------------------------------";

    /** Counter for tests passed */
    private static int testsPassed = 0;

    /** Total tests executed */
    private static int totalTests = 0;

    /** Shared instance for the union sequence tests */
    private static DisjointSetsA ds;

    // Expected outputs (with trailing newline) as in unionfind.txt:
    private static final String expectedInitial =
            "6 set(s):\n" +
                    "0 : 0\n" +
                    "1 : 1\n" +
                    "2 : 2\n" +
                    "3 : 3\n" +
                    "4 : 4\n" +
                    "5 : 5\n";

    private static final String expectedAfterUnion23 =
            "5 set(s):\n" +
                    "0 : 0\n" +
                    "1 : 1\n" +
                    "3 : 2,3\n" +
                    "4 : 4\n" +
                    "5 : 5\n";

    private static final String expectedAfterUnion23Again = expectedAfterUnion23;

    private static final String expectedAfterUnion21 =
            "4 set(s):\n" +
                    "0 : 0\n" +
                    "3 : 1,2,3\n" +
                    "4 : 4\n" +
                    "5 : 5\n";

    private static final String expectedAfterUnion45 =
            "3 set(s):\n" +
                    "0 : 0\n" +
                    "3 : 1,2,3\n" +
                    "5 : 4,5\n";

    private static final String expectedAfterUnion31 = expectedAfterUnion45;

    private static final String expectedAfterUnion24 =
            "2 set(s):\n" +
                    "0 : 0\n" +
                    "5 : 1,2,3,4,5\n";

    /**
     * Setup method executed once before all tests.
     */
    @BeforeAll
    public static void setUpBeforeClass() {
        System.out.println(SEPARATOR);
        System.out.println("Starting DisjointSetsA Tests");
        System.out.println(SEPARATOR);
        // Initialize ds with 6 elements.
        ds = new DisjointSetsA(6);
    }

    // ---------- Tests for union sequence ----------

    /**
     * Test 1: Check the initial state of DisjointSetsA with 6 elements.
     */
    @Test
    @DisplayName("Test 1: Initial state")
    public void testInitialState() {
        totalTests++;
        String state = ds.toString();
        System.out.println(SEPARATOR);
        System.out.println("Test 1: Checking initial state of DisjointSetsA with 6 elements.");
        System.out.println("Expected output:\n" + expectedInitial);
        System.out.println("Received output:\n" + state);
        try {
            assertEquals(expectedInitial, state, "Initial state does not match expected output.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 2: After union(2,3).
     */
    @Test
    @DisplayName("Test 2: union(2,3)")
    public void testUnion23() {
        totalTests++;
        ds.union(2, 3);
        String state = ds.toString();
        System.out.println(SEPARATOR);
        System.out.println("Test 2: After union(2,3).");
        System.out.println("Expected output:\n" + expectedAfterUnion23);
        System.out.println("Received output:\n" + state);
        try {
            assertEquals(expectedAfterUnion23, state, "State after union(2,3) does not match expected.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 3: After calling union(2,3) again (should be idempotent).
     */
    @Test
    @DisplayName("Test 3: union(2,3) again")
    public void testUnion23Again() {
        totalTests++;
        ds.union(2, 3);
        String state = ds.toString();
        System.out.println(SEPARATOR);
        System.out.println("Test 3: After union(2,3) called a second time.");
        System.out.println("Expected output:\n" + expectedAfterUnion23Again);
        System.out.println("Received output:\n" + state);
        try {
            assertEquals(expectedAfterUnion23Again, state, "State after second union(2,3) does not match expected.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 4: After union(2,1).
     */
    @Test
    @DisplayName("Test 4: union(2,1)")
    public void testUnion21() {
        totalTests++;
        ds.union(2, 1);
        String state = ds.toString();
        System.out.println(SEPARATOR);
        System.out.println("Test 4: After union(2,1).");
        System.out.println("Expected output:\n" + expectedAfterUnion21);
        System.out.println("Received output:\n" + state);
        try {
            assertEquals(expectedAfterUnion21, state, "State after union(2,1) does not match expected.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 5: After union(4,5).
     */
    @Test
    @DisplayName("Test 5: union(4,5)")
    public void testUnion45() {
        totalTests++;
        ds.union(4, 5);
        String state = ds.toString();
        System.out.println(SEPARATOR);
        System.out.println("Test 5: After union(4,5).");
        System.out.println("Expected output:\n" + expectedAfterUnion45);
        System.out.println("Received output:\n" + state);
        try {
            assertEquals(expectedAfterUnion45, state, "State after union(4,5) does not match expected.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 6: After union(3,1) (should not change the structure).
     */
    @Test
    @DisplayName("Test 6: union(3,1)")
    public void testUnion31() {
        totalTests++;
        ds.union(3, 1);
        String state = ds.toString();
        System.out.println(SEPARATOR);
        System.out.println("Test 6: After union(3,1).");
        System.out.println("Expected output:\n" + expectedAfterUnion31);
        System.out.println("Received output:\n" + state);
        try {
            assertEquals(expectedAfterUnion31, state, "State after union(3,1) does not match expected.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 7: After union(2,4).
     */
    @Test
    @DisplayName("Test 7: union(2,4)")
    public void testUnion24() {
        totalTests++;
        ds.union(2, 4);
        String state = ds.toString();
        System.out.println(SEPARATOR);
        System.out.println("Test 7: After union(2,4).");
        System.out.println("Expected output:\n" + expectedAfterUnion24);
        System.out.println("Received output:\n" + state);
        try {
            assertEquals(expectedAfterUnion24, state, "State after union(2,4) does not match expected.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    // ---------- Test for find(int) ----------

    /**
     * Test the find() function after the union sequence.
     *
     * Expected representatives:
     * <ul>
     *   <li>find(0) should return 0.
     *   <li>find(1), find(2), find(3), find(4), find(5) should return 5.
     * </ul>
     */
    @Test
    @DisplayName("Test 8: find() after union sequence")
    public void testFindFunction() {
        try {
            int[] expectedReps = {0, 5, 5, 5, 5, 5};
            System.out.println(SEPARATOR);
            System.out.println("Test 8: Checking find() results after the union sequence.");
            for (int i = 0; i < 6; i++) {
                totalTests++;
                int rep = ds.find(i);
                System.out.println(SEPARATOR);
                System.out.println("Testing find(" + i + ")");
                System.out.println("Expected representative: " + expectedReps[i]);
                System.out.println("Received representative: " + rep);
                try {
                    assertEquals(expectedReps[i], rep, "find(" + i + ") expected " + expectedReps[i] + " but got " + rep);
                    System.out.println("\u001B[32mTest Passed\u001B[0m");
                    testsPassed++;
                } catch (AssertionError e) {
                    System.out.println("\u001B[31mTest Failed\u001B[0m");
                    throw e;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
            fail("Exception occurred in testFindFunction: " + e.getMessage());
        }
    }

    // ---------- Efficiency Test ----------

    /**
     * Test the efficiency of the union–find operations.
     *
     * This test creates a large DisjointSetsA instance and performs many union and find operations.
     * It asserts that the total runtime is under 1.3 seconds.
     */
    @Test
    @DisplayName("Test 9: Efficiency test")
    public void testEfficiency() {
        try {
            int n = 10000;
            DisjointSetsA largeDs = new DisjointSetsA(n);
            long startTime = System.nanoTime();
            // Chain unions
            for (int i = 1; i < n; i++) {
                largeDs.union(i - 1, i);
            }
            // Perform finds on all elements.
            for (int i = 0; i < n; i++) {
                largeDs.find(i);
            }
            long endTime = System.nanoTime();
            double seconds = (endTime - startTime) / 1_000_000_000.0;
            double threshold = 1.3; // seconds
            System.out.println(SEPARATOR);
            System.out.println("Test 9: Efficiency test with " + n + " elements.");
            System.out.println("Expected: Total runtime < " + threshold + " seconds.");
            System.out.println("Measured runtime: " + seconds + " seconds.");
            totalTests++;
            try {
                assertTrue(seconds < threshold, "Efficiency test failed: Runtime " + seconds + " seconds exceeds threshold " + threshold);
                System.out.println("\u001B[32mTest Passed\u001B[0m");
                testsPassed++;
            } catch (AssertionError e) {
                System.out.println("\u001B[31mTest Failed\u001B[0m");
                throw e;
            }
        } catch(Exception e) {
            e.printStackTrace();
            fail("Exception occurred in testEfficiency: " + e.getMessage());
        }
    }

    /**
     * Cleanup method executed once after all tests.
     */
    @AfterAll
    public static void tearDownAfterClass() {
        System.out.println(SEPARATOR);
        System.out.println("DisjointSetsA Tests Summary: Passed " + testsPassed + " out of " + totalTests + " tests.");
        System.out.println(SEPARATOR);
    }
}