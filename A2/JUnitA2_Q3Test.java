import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * COMP 251 Test file
 * <p>Assignment 2, Question 3
 *
 * <p>This class tests the {@code directions} method which receives an array of positive integers
 * representing the number of stair steps to walk at each stage of the training and returns a String
 * consisting of the concatenation of characters "U" (up) and "D" (down). Each character indicates the
 * direction to take at the corresponding stage. A legal training must start and end at street level
 * (i.e., height 0) and must not go below street level or above 1000 stairs. If no legal solution exists,
 * the method returns the String "IMPOSSIBLE".
 *
 * @author Joseph Abboud
 */
public class JUnitA2_Q3Test {

    /** Separator string for output */
    private static final String SEPARATOR = "--------------------------------------------------";

    /** Counter for tests passed */
    private static int testsPassed = 0;

    /** Total tests executed */
    private static int totalTests = 0;

    /**
     * Test Sample Call 1:
     * <p>
     * Input: [20, 20, 20, 20]
     * <br>Expected output: "UDUD"
     * <br>This solution stays as close as possible to street level.
     */
    @Test
    @DisplayName("Test Sample Call 1")
    public void testSampleCall1() {
        int[] input = {20, 20, 20, 20};
        String expected = "UDUD";
        String result = A2_Q3.directions(input);
        System.out.println(SEPARATOR);
        System.out.println("Testing directions() with input: " + Arrays.toString(input));
        System.out.println("Expected result: " + expected);
        System.out.println("Received result: " + result);
        totalTests++;
        try {
            assertEquals(expected, result, "For input [20,20,20,20] expected \"UDUD\".");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test Sample Call 2:
     * <p>
     * Input: [3, 2, 5, 3, 1, 2]
     * <br>Expected output: "UUDUDD"
     */
    @Test
    @DisplayName("Test Sample Call 2")
    public void testSampleCall2() {
        int[] input = {3, 2, 5, 3, 1, 2};
        String expected = "UUDUDD";
        String result = A2_Q3.directions(input);
        System.out.println(SEPARATOR);
        System.out.println("Testing directions() with input: " + Arrays.toString(input));
        System.out.println("Expected result: " + expected);
        System.out.println("Received result: " + result);
        totalTests++;
        try {
            assertEquals(expected, result, "For input [3,2,5,3,1,2] expected \"UUDUDD\".");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test Sample Call 3:
     * <p>
     * Input: [3, 4, 2, 1, 6, 4, 5]
     * <br>Expected output: "IMPOSSIBLE"
     */
    @Test
    @DisplayName("Test Sample Call 3")
    public void testSampleCall3() {
        int[] input = {3, 4, 2, 1, 6, 4, 5};
        String expected = "IMPOSSIBLE";
        String result = A2_Q3.directions(input);
        System.out.println(SEPARATOR);
        System.out.println("Testing directions() with input: " + Arrays.toString(input));
        System.out.println("Expected result: " + expected);
        System.out.println("Received result: " + result);
        totalTests++;
        try {
            assertEquals(expected, result, "For input [3,4,2,1,6,4,5] expected \"IMPOSSIBLE\".");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test the case of an empty array.
     * <p>
     * When no moves are provided, the training is trivially legal.
     * Expected output: "" (an empty string).
     */
    @Test
    @DisplayName("Test Empty Array")
    public void testEmptyArray() {
        int[] input = {};
        String expected = "";
        String result = A2_Q3.directions(input);
        System.out.println(SEPARATOR);
        System.out.println("Testing directions() with empty array: " + Arrays.toString(input));
        System.out.println("Expected result: \"" + expected + "\"");
        System.out.println("Received result: \"" + result + "\"");
        totalTests++;
        try {
            assertEquals(expected, result, "For an empty array, expected an empty string.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test the case of a single element array.
     * <p>
     * With one positive number, no legal training exists.
     * Expected output: "IMPOSSIBLE"
     */
    @Test
    @DisplayName("Test Single Element Array")
    public void testSingleElement() {
        int[] input = {5};
        String expected = "IMPOSSIBLE";
        String result = A2_Q3.directions(input);
        System.out.println(SEPARATOR);
        System.out.println("Testing directions() with single element array: " + Arrays.toString(input));
        System.out.println("Expected result: " + expected);
        System.out.println("Received result: " + result);
        totalTests++;
        try {
            assertEquals(expected, result, "For input [5], expected \"IMPOSSIBLE\".");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test a minimal valid case.
     * <p>
     * Input: [1, 1]
     * <br>Expected output: "UD" (up then down returns to street level).
     */
    @Test
    @DisplayName("Test Minimal Valid Case")
    public void testMinimalValidCase() {
        int[] input = {1, 1};
        String expected = "UD";
        String result = A2_Q3.directions(input);
        System.out.println(SEPARATOR);
        System.out.println("Testing directions() with input: " + Arrays.toString(input));
        System.out.println("Expected result: " + expected);
        System.out.println("Received result: " + result);
        totalTests++;
        try {
            assertEquals(expected, result, "For input [1,1], expected \"UD\".");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch(AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test a custom case.
     * <p>
     * Input: [10, 5, 5, 10]
     * <br>Analysis: "UDUD" is optimal because it only goes 10 steps up, as opposed to "UUDD" which goes 15.
     * <br>Expected output: "UDUD"
     */
    @Test
    @DisplayName("Test Custom Case: [10,5,5,10]")
    public void testCustomCase1() {
        int[] input = {10, 5, 5, 10};
        String expected = "UDUD";
        String result = A2_Q3.directions(input);
        System.out.println(SEPARATOR);
        System.out.println("Testing directions() with input: " + Arrays.toString(input));
        System.out.println("Expected result: " + expected);
        System.out.println("Received result: " + result);
        totalTests++;
        try {
            assertEquals(expected, result, "For input [10,5,5,10], expected \"UDUD\".");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch(AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test a three-element valid case.
     * <p>
     * Input: [3, 3, 6]
     * <br>Analysis: Only "UUD" returns to 0 (0 -> 3 -> 6 -> 0).
     * <br>Expected output: "UUD"
     */
    @Test
    @DisplayName("Test Three-Element Valid Case")
    public void testThreeElementValidCase() {
        int[] input = {3, 3, 6};
        String expected = "UUD";
        String result = A2_Q3.directions(input);
        System.out.println(SEPARATOR);
        System.out.println("Testing directions() with input: " + Arrays.toString(input));
        System.out.println("Expected result: " + expected);
        System.out.println("Received result: " + result);
        totalTests++;
        try {
            assertEquals(expected, result, "For input [3,3,6], expected \"UUD\".");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch(AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test another custom case.
     * <p>
     * Input: [4, 4, 4, 4]
     * <br>Analysis: "UDUD" is optimal as it never goes above 4.
     * <br>Expected output: "UDUD"
     */
    @Test
    @DisplayName("Test Custom Case: [4,4,4,4]")
    public void testCustomCase2() {
        int[] input = {4, 4, 4, 4};
        String expected = "UDUD";
        String result = A2_Q3.directions(input);
        System.out.println(SEPARATOR);
        System.out.println("Testing directions() with input: " + Arrays.toString(input));
        System.out.println("Expected result: " + expected);
        System.out.println("Received result: " + result);
        totalTests++;
        try {
            assertEquals(expected, result, "For input [4,4,4,4], expected \"UDUD\".");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch(AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Efficiency Test: Test on a large input array.
     * <p>
     * Here, we test the algorithm's performance on an input of 1000 moves, all with value 1.
     * Since 1000 is even, a legal and optimal solution is to alternate "U" and "D" (i.e., "UD" repeated 500 times).
     */
    @Test
    @DisplayName("Test Efficiency on Large Input Array")
    public void testLargeInputEfficiency() {
        int n = 1000; // Must be even for a legal solution
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = 1;
        }
        // Expected solution: "UD" repeated n/2 times.
        StringBuilder expectedBuilder = new StringBuilder();
        for (int i = 0; i < n / 2; i++) {
            expectedBuilder.append("UD");
        }
        String expected = expectedBuilder.toString();
        System.out.println(SEPARATOR);
        System.out.println("Testing directions() efficiency on large input array of size: " + n);
        long start = System.currentTimeMillis();
        String result = A2_Q3.directions(input);
        long end = System.currentTimeMillis();
        System.out.println("Time taken (ms): " + (end - start));
        System.out.println("Expected result length: " + expected.length());
        System.out.println("Received result length: " + result.length());
        totalTests++;
        try {
            assertEquals(expected, result, "For large input array of ones, expected alternating \"UD\" pattern.");
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
        System.out.println("A2_Q3 Tests Summary: Passed " + testsPassed + " out of " + totalTests + " tests.");
        System.out.println(SEPARATOR);
    }
}