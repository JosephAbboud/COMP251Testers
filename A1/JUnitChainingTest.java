package assignment1.question1;

import org.junit.jupiter.api.*;  // JUnit 5 annotations
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

/**
 * COMP 251 Test file
 * <p>Assignment 1, Question 1
 *
 * <p>JUnit tests for the Chaining class.
 *
 * <p>This class tests the following functionalities:
 * <ul>
 *   <li>{@link Chaining#chain(int)}: Computes the hash value using the multiplication method.</li>
 *   <li>{@link Chaining#insertKey(int)}: Inserts a key and returns the collision count (number of keys already in the chain).</li>
 *   <li>{@link Chaining#insertKeyArray(int[])}: Inserts an array of keys and returns the total collisions.</li>
 * </ul>
 *
 * Each test prints its outcome in color (green for pass, red for fail) along with the expected and received results.
 * A summary is printed at the end.
 *
 * @author Joseph Abboud
 */
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class JUnitChainingTest {

    /** Separator string for output */
    private static final String SEPARATOR = "--------------------------------------------------";

    /** Counter for tests passed */
    private static int testsPassed = 0;

    /** Total tests executed */
    private static int totalTests = 0;

    /**
     * Setup method executed once before all tests.
     */
    @BeforeAll
    public static void setUpBeforeClass() {
        System.out.println(SEPARATOR);
        System.out.println("Starting Chaining Tests");
        System.out.println(SEPARATOR);
    }

    // ------------------- Tests for chain(int) -------------------

    /**
     * Test chain() for key 5.
     */
    @Test
    @DisplayName("Test 1: chain(5)")
    public void testChainKey5() {
        int w = 4, seed = 0, A = 11;
        Chaining chaining = new Chaining(w, seed, A);
        int expected = 1;  // ((11*5) mod 16 = 55 mod 16 = 7) >> 2 = 1
        int result = chaining.chain(5);
        System.out.println(SEPARATOR);
        System.out.println("Testing chain() for key: 5");
        System.out.println("Expected result: " + expected);
        System.out.println("Received result: " + result);
        totalTests++;
        try {
            assertEquals(expected, result, "chain(5) expected " + expected + " but got " + result);
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test chain() for key 10.
     */
    @Test
    @DisplayName("Test 2: chain(10)")
    public void testChainKey10() {
        int w = 4, seed = 0, A = 11;
        Chaining chaining = new Chaining(w, seed, A);
        int expected = 3;  // ((11*10) mod 16 = 110 mod 16 = 14) >> 2 = 3
        int result = chaining.chain(10);
        System.out.println(SEPARATOR);
        System.out.println("Testing chain() for key: 10");
        System.out.println("Expected result: " + expected);
        System.out.println("Received result: " + result);
        totalTests++;
        try {
            assertEquals(expected, result, "chain(10) expected " + expected + " but got " + result);
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test chain() for key 0.
     */
    @Test
    @DisplayName("Test 3: chain(0)")
    public void testChainKey0() {
        int w = 4, seed = 0, A = 11;
        Chaining chaining = new Chaining(w, seed, A);
        int expected = 0;  // ((11*0) mod 16 = 0) >> 2 = 0
        int result = chaining.chain(0);
        System.out.println(SEPARATOR);
        System.out.println("Testing chain() for key: 0");
        System.out.println("Expected result: " + expected);
        System.out.println("Received result: " + result);
        totalTests++;
        try {
            assertEquals(expected, result, "chain(0) expected " + expected + " but got " + result);
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    // ------------------- Tests for insertKey(int) -------------------

    /**
     * Test insertKey() when inserting a key into an empty chain.
     */
    @Test
    @DisplayName("Test 4: insertKey() with empty bin")
    public void testInsertKeyEmpty() {
        int w = 4, seed = 0, A = 11;
        Chaining chaining = new Chaining(w, seed, A);
        int key = 5;
        int expectedCollisions = 0;
        int collisions = chaining.insertKey(key);
        System.out.println(SEPARATOR);
        System.out.println("Testing insertKey() for key: " + key + " in an empty bin");
        System.out.println("Expected collisions: " + expectedCollisions);
        System.out.println("Received collisions: " + collisions);
        totalTests++;
        try {
            assertEquals(expectedCollisions, collisions, "insertKey(" + key + ") expected collisions " + expectedCollisions + " but got " + collisions);
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test insertKey() when inserting a key that collides with an existing key.
     */
    @Test
    @DisplayName("Test 5: insertKey() with collision")
    public void testInsertKeyCollision() {
        int w = 4, seed = 0, A = 11;
        Chaining chaining = new Chaining(w, seed, A);
        // Insert key 5 into a bin.
        chaining.insertKey(5);
        int key = 21;  // This should hash to the same bin as 5.
        int expectedCollisions = 1;
        int collisions = chaining.insertKey(key);
        System.out.println(SEPARATOR);
        System.out.println("Testing insertKey() for key: " + key + " with a collision");
        System.out.println("Expected collisions: " + expectedCollisions);
        System.out.println("Received collisions: " + collisions);
        totalTests++;
        try {
            assertEquals(expectedCollisions, collisions, "insertKey(" + key + ") expected collisions " + expectedCollisions + " but got " + collisions);
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test insertKey() when inserting a key into an empty slot.
     */
    @Test
    @DisplayName("Test 6: insertKey() with no collision")
    public void testInsertKeyNoCollision() {
        int w = 4, seed = 0, A = 11;
        Chaining chaining = new Chaining(w, seed, A);
        int key = 0;
        int expectedCollisions = 0;
        int collisions = chaining.insertKey(key);
        System.out.println(SEPARATOR);
        System.out.println("Testing insertKey() for key: " + key + " in an empty slot");
        System.out.println("Expected collisions: " + expectedCollisions);
        System.out.println("Received collisions: " + collisions);
        totalTests++;
        try {
            assertEquals(expectedCollisions, collisions, "insertKey(" + key + ") expected collisions " + expectedCollisions + " but got " + collisions);
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    // ------------------- Test for insertKeyArray(int[]) -------------------

    /**
     * Test insertKeyArray() with a given array of keys.
     */
    @Test
    @DisplayName("Test 7: insertKeyArray()")
    public void testInsertKeyArray() {
        int w = 4, seed = 0, A = 11;
        Chaining chaining = new Chaining(w, seed, A);
        int[] keys = {5, 21, 0, 10};
        int expectedTotalCollisions = 1;
        int totalCollisions = chaining.insertKeyArray(keys);
        System.out.println(SEPARATOR);
        System.out.println("Testing insertKeyArray() for keys: " + Arrays.toString(keys));
        System.out.println("Expected total collisions: " + expectedTotalCollisions);
        System.out.println("Received total collisions: " + totalCollisions);
        totalTests++;
        try {
            assertEquals(expectedTotalCollisions, totalCollisions, "insertKeyArray(" + Arrays.toString(keys) + ") expected total collisions " + expectedTotalCollisions + " but got " + totalCollisions);
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