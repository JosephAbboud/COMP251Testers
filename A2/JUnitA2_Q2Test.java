import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * COMP 251 Test file
 * <p>Assignment 2, Question 2
 *
 * <p>This class tests the {@code num_swaps} method which takes a 1-D array of integers
 * representing a queue of students and returns a BigInteger representing the total number
 * of successive swapping pairs of adjacent students required to sort the array in increasing order.
 * <p>
 * The sorting is based on the student IDs in the array
 *
 * @author Joseph Abboud
 */
public class JUnitA2_Q2Test {

    /** Separator string for output */
    private static final String SEPARATOR = "--------------------------------------------------";

    /** Counter for tests passed */
    private static int testsPassed = 0;

    /** Total tests executed */
    private static int totalTests = 0;

    /**
     * Test the sample call provided in the assignment instructions.
     * <p>
     * Sample call: num_swaps([3,1,2])
     * Expected outcome: 2 swaps.
     */
    @Test
    @DisplayName("Test Sample Call")
    public void testSampleCall() {
        int[] input = {3, 1, 2};
        BigInteger expected = BigInteger.valueOf(2);
        BigInteger result = A2_Q2.num_swaps(input);
        System.out.println(SEPARATOR);
        System.out.println("Testing num_swaps() with input: " + Arrays.toString(input));
        System.out.println("Expected result: " + expected);
        System.out.println("Received result: " + result);
        totalTests++;
        try {
            assertEquals(expected, result, "Expected 2 swaps for input [3,1,2].");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test the scenario where the array is already sorted.
     * <p>
     * Expected outcome: 0 swaps.
     */
    @Test
    @DisplayName("Test Already Sorted Array")
    public void testAlreadySorted() {
        int[] input = {1, 2, 3, 4, 5};
        BigInteger expected = BigInteger.ZERO;
        BigInteger result = A2_Q2.num_swaps(input);
        System.out.println(SEPARATOR);
        System.out.println("Testing num_swaps() with input (Already Sorted): " + Arrays.toString(input));
        System.out.println("Expected result: " + expected);
        System.out.println("Received result: " + result);
        totalTests++;
        try {
            assertEquals(expected, result, "Expected 0 swaps for an already sorted array.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch(AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test the scenario where the array is reverse sorted.
     * <p>
     * For an array of 5 elements in reverse order, the expected number of swaps is 10.
     */
    @Test
    @DisplayName("Test Reverse Sorted Array")
    public void testReverseSorted() {
        int[] input = {5, 4, 3, 2, 1};
        BigInteger expected = BigInteger.valueOf(10); // 5*4/2 = 10
        BigInteger result = A2_Q2.num_swaps(input);
        System.out.println(SEPARATOR);
        System.out.println("Testing num_swaps() with input (Reverse Sorted): " + Arrays.toString(input));
        System.out.println("Expected result: " + expected);
        System.out.println("Received result: " + result);
        totalTests++;
        try {
            assertEquals(expected, result, "Expected 10 swaps for reverse sorted array [5,4,3,2,1].");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch(AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test a random array.
     * <p>
     * For the array [2, 3, 1, 5, 4], the expected number of swaps is 3.
     */
    @Test
    @DisplayName("Test Random Array")
    public void testRandomArray() {
        int[] input = {2, 3, 1, 5, 4};
        BigInteger expected = BigInteger.valueOf(3);
        BigInteger result = A2_Q2.num_swaps(input);
        System.out.println(SEPARATOR);
        System.out.println("Testing num_swaps() with input (Random Array): " + Arrays.toString(input));
        System.out.println("Expected result: " + expected);
        System.out.println("Received result: " + result);
        totalTests++;
        try {
            assertEquals(expected, result, "Expected 3 swaps for input [2,3,1,5,4].");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch(AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test a single element array.
     * <p>
     * Expected outcome: 0 swaps.
     */
    @Test
    @DisplayName("Test Single Element Array")
    public void testSingleElement() {
        int[] input = {42};
        BigInteger expected = BigInteger.ZERO;
        BigInteger result = A2_Q2.num_swaps(input);
        System.out.println(SEPARATOR);
        System.out.println("Testing num_swaps() with single element array: " + Arrays.toString(input));
        System.out.println("Expected result: " + expected);
        System.out.println("Received result: " + result);
        totalTests++;
        try {
            assertEquals(expected, result, "Expected 0 swaps for a single element array.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch(AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test an empty array.
     * <p>
     * Expected outcome: 0 swaps.
     */
    @Test
    @DisplayName("Test Empty Array")
    public void testEmptyArray() {
        int[] input = {};
        BigInteger expected = BigInteger.ZERO;
        BigInteger result = A2_Q2.num_swaps(input);
        System.out.println(SEPARATOR);
        System.out.println("Testing num_swaps() with empty array: " + Arrays.toString(input));
        System.out.println("Expected result: " + expected);
        System.out.println("Received result: " + result);
        totalTests++;
        try {
            assertEquals(expected, result, "Expected 0 swaps for an empty array.");
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch(AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Efficiency test: Test on a large reverse sorted array.
     * <p>
     * This test creates a large reverse sorted array to check the efficiency of the algorithm.
     * The expected outcome is computed using the formula n*(n-1)/2.
     */
    @Test
    @DisplayName("Test Efficiency on Large Reverse Sorted Array")
    public void testLargeReverseSortedArrayEfficiency() {
        int n = 10000;
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = n - i; // reverse sorted order
        }
        long expectedValue = ((long)n * (n - 1)) / 2; // expected number of swaps
        BigInteger expected = BigInteger.valueOf(expectedValue);
        System.out.println(SEPARATOR);
        System.out.println("Testing num_swaps() efficiency on large reverse sorted array of size: " + n);
        long start = System.currentTimeMillis();
        BigInteger result = A2_Q2.num_swaps(input);
        long end = System.currentTimeMillis();
        System.out.println("Time taken (ms): " + (end - start));
        System.out.println("Expected result: " + expected);
        System.out.println("Received result: " + result);
        totalTests++;
        try {
            assertEquals(expected, result, "Expected " + expected + " swaps for a reverse sorted array of size " + n);
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
        System.out.println("A2_Q2 Tests Summary: Passed " + testsPassed + " out of " + totalTests + " tests.");
        System.out.println(SEPARATOR);
    }
}