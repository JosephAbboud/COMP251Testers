package assignment1.question1;

import org.junit.jupiter.api.*;  // JUnit 5 annotations
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

/**
 * COMP 251 Test file
 * <p>Assignment 1, Question 1
 *
 * <p>JUnit tests for the Open_Addressing class.
 *
 * <p>This class tests the following functionalities:
 * <ul>
 *   <li>{@link Open_Addressing#probe(int, int)}: Computes the probe function g(k,i) using the formula
 *       g(k,i) = (h(k) + i) mod 2^r.</li>
 *   <li>{@link Open_Addressing#insertKey(int)}: Inserts a key into the open addressing hash table and returns the collision count.</li>
 *   <li>{@link Open_Addressing#insertKeyArray(int[])}: Inserts an array of keys and returns the total collisions.</li>
 *   <li>{@link Open_Addressing#removeKey(int)}: Removes a key from the table and returns the number of slots visited (collision count).</li>
 * </ul>
 *
 * Each test prints its outcome in color (green for pass, red for fail) along with the expected and received results.
 * A summary is printed at the end.
 *
 * (Following the sample format provided.)
 *
 * @author Joseph Abboud
 */
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class JUnitOpenAddressingTest {

    /** Separator string for output */
    private static final String SEPARATOR = "--------------------------------------------------";

    /** Global counter for tests passed */
    private static int testsPassed = 0;

    /** Global counter for tests executed */
    private static int totalTests = 0;

    /**
     * Setup method executed once before all tests.
     */
    @BeforeAll
    public static void setUpBeforeClass() {
        System.out.println(SEPARATOR);
        System.out.println("Starting Open_Addressing Tests");
        System.out.println(SEPARATOR);
    }

    // ---------- Tests for probe(int, int) ----------

    /**
     * Test 1: probe(5, 0)
     */
    @Test
    @DisplayName("Test 1: probe(5, 0)")
    public void testProbe_i0() {
        int w = 4, seed = 0, A = 11;
        Open_Addressing oa = new Open_Addressing(w, seed, A);
        int key = 5, i = 0;
        int baseHash = 1; // expected h(5)
        int expected = (baseHash + i) % oa.m;  // (1 + 0) mod 4 = 1
        int result = oa.probe(key, i);
        totalTests++;
        System.out.println(SEPARATOR);
        System.out.println("Test 1: Testing probe() for key: " + key + " with i: " + i);
        System.out.println("Expected result: " + expected);
        System.out.println("Received result: " + result);
        try {
            assertEquals(expected, result, "probe(" + key + ", " + i + ") expected " + expected + " but got " + result);
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 2: probe(5, 1)
     */
    @Test
    @DisplayName("Test 2: probe(5, 1)")
    public void testProbe_i1() {
        int w = 4, seed = 0, A = 11;
        Open_Addressing oa = new Open_Addressing(w, seed, A);
        int key = 5, i = 1;
        int baseHash = 1;
        int expected = (baseHash + i) % oa.m;  // (1 + 1) mod 4 = 2
        int result = oa.probe(key, i);
        totalTests++;
        System.out.println(SEPARATOR);
        System.out.println("Test 2: Testing probe() for key: " + key + " with i: " + i);
        System.out.println("Expected result: " + expected);
        System.out.println("Received result: " + result);
        try {
            assertEquals(expected, result, "probe(" + key + ", " + i + ") expected " + expected + " but got " + result);
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 3: probe(5, 2)
     */
    @Test
    @DisplayName("Test 3: probe(5, 2)")
    public void testProbe_i2() {
        int w = 4, seed = 0, A = 11;
        Open_Addressing oa = new Open_Addressing(w, seed, A);
        int key = 5, i = 2;
        int baseHash = 1;
        int expected = (baseHash + i) % oa.m;  // (1 + 2) mod 4 = 3
        int result = oa.probe(key, i);
        totalTests++;
        System.out.println(SEPARATOR);
        System.out.println("Test 3: Testing probe() for key: " + key + " with i: " + i);
        System.out.println("Expected result: " + expected);
        System.out.println("Received result: " + result);
        try {
            assertEquals(expected, result, "probe(" + key + ", " + i + ") expected " + expected + " but got " + result);
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 4: probe(5, 3)
     */
    @Test
    @DisplayName("Test 4: probe(5, 3)")
    public void testProbe_i3() {
        int w = 4, seed = 0, A = 11;
        Open_Addressing oa = new Open_Addressing(w, seed, A);
        int key = 5, i = 3;
        int baseHash = 1;
        int expected = (baseHash + i) % oa.m;  // (1 + 3) mod 4 = 0
        int result = oa.probe(key, i);
        totalTests++;
        System.out.println(SEPARATOR);
        System.out.println("Test 4: Testing probe() for key: " + key + " with i: " + i);
        System.out.println("Expected result: " + expected);
        System.out.println("Received result: " + result);
        try {
            assertEquals(expected, result, "probe(" + key + ", " + i + ") expected " + expected + " but got " + result);
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    // ---------- Tests for insertKey(int) ----------

    /**
     * Test 5: Insert key 5 into an empty table; expect 0 collisions.
     */
    @Test
    @DisplayName("Test 5: insertKey() - empty table")
    public void testInsertKeyEmpty() {
        int w = 4, seed = 0, A = 11;
        Open_Addressing oa = new Open_Addressing(w, seed, A);
        int key = 5;
        int expectedCollisions = 0;
        int collisions = oa.insertKey(key);
        totalTests++;
        System.out.println(SEPARATOR);
        System.out.println("Test 5: Testing insertKey() in Open_Addressing for key: " + key + " (empty table)");
        System.out.println("Expected collisions: " + expectedCollisions);
        System.out.println("Received collisions: " + collisions);
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
     * Test 6: Insert key 21 which should collide with key 5; expect 1 collision.
     */
    @Test
    @DisplayName("Test 6: insertKey() - collision")
    public void testInsertKeyCollision() {
        int w = 4, seed = 0, A = 11;
        Open_Addressing oa = new Open_Addressing(w, seed, A);
        oa.insertKey(5); // Insert key 5 first.
        int key = 21;    // Should collide with key 5 (h(21)=1).
        int expectedCollisions = 1;
        int collisions = oa.insertKey(key);
        totalTests++;
        System.out.println(SEPARATOR);
        System.out.println("Test 6: Testing insertKey() in Open_Addressing for key: " + key + " (collision expected)");
        System.out.println("Expected collisions: " + expectedCollisions);
        System.out.println("Received collisions: " + collisions);
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
     * Test 7: Insert key 0 into an empty slot; expect 0 collisions.
     */
    @Test
    @DisplayName("Test 7: insertKey() - no collision")
    public void testInsertKeyNoCollision() {
        int w = 4, seed = 0, A = 11;
        Open_Addressing oa = new Open_Addressing(w, seed, A);
        int key = 0;
        int expectedCollisions = 0;
        int collisions = oa.insertKey(key);
        totalTests++;
        System.out.println(SEPARATOR);
        System.out.println("Test 7: Testing insertKey() in Open_Addressing for key: " + key + " (no collision expected)");
        System.out.println("Expected collisions: " + expectedCollisions);
        System.out.println("Received collisions: " + collisions);
        try {
            assertEquals(expectedCollisions, collisions, "insertKey(" + key + ") expected collisions " + expectedCollisions + " but got " + collisions);
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    // ---------- Test for insertKeyArray(int[]) ----------

    /**
     * Test 8: Insert an array of keys and verify the total collision count.
     * For the array {5, 21, 0, 10} the expected total collisions is 1.
     */
    @Test
    @DisplayName("Test 8: insertKeyArray()")
    public void testInsertKeyArray() {
        int w = 4, seed = 0, A = 11;
        Open_Addressing oa = new Open_Addressing(w, seed, A);
        int[] keys = {5, 21, 0, 10};
        int expectedTotalCollisions = 1;
        int totalCollisions = oa.insertKeyArray(keys);
        totalTests++;
        System.out.println(SEPARATOR);
        System.out.println("Test 8: Testing insertKeyArray() in Open_Addressing for keys: " + Arrays.toString(keys));
        System.out.println("Expected total collisions: " + expectedTotalCollisions);
        System.out.println("Received total collisions: " + totalCollisions);
        try {
            assertEquals(expectedTotalCollisions, totalCollisions, "insertKeyArray(" + Arrays.toString(keys) + ") expected total collisions " + expectedTotalCollisions + " but got " + totalCollisions);
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    // ---------- Tests for removeKey(int) ----------

    /**
     * Test 9: After inserting keys 5 and 21, verify that removeKey(5) returns 0 collisions.
     */
    @Test
    @DisplayName("Test 9: removeKey() - key present (5)")
    public void testRemoveKeyPresent5() {
        int w = 4, seed = 0, A = 11;
        Open_Addressing oa = new Open_Addressing(w, seed, A);
        oa.insertKey(5);   // h(5)=1
        oa.insertKey(21);  // should require 1 collision
        int key = 5;
        int expectedCollisions = 0;
        int collisions = oa.removeKey(key);
        totalTests++;
        System.out.println(SEPARATOR);
        System.out.println("Test 9: Testing removeKey() in Open_Addressing for key: " + key);
        System.out.println("Expected collisions: " + expectedCollisions);
        System.out.println("Received collisions: " + collisions);
        try {
            assertEquals(expectedCollisions, collisions, "removeKey(" + key + ") expected collisions " + expectedCollisions + " but got " + collisions);
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 10: After inserting keys 5 and 21 and removing key 5, verify that removeKey(21) returns 1 collision.
     */
    @Test
    @DisplayName("Test 10: removeKey() - key present (21)")
    public void testRemoveKeyPresent21() {
        int w = 4, seed = 0, A = 11;
        Open_Addressing oa = new Open_Addressing(w, seed, A);
        oa.insertKey(5);   // h(5)=1
        oa.insertKey(21);  // goes to next available slot
        oa.removeKey(5);   // remove key 5 so that key 21 is shifted
        int key = 21;
        int expectedCollisions = 1;
        int collisions = oa.removeKey(key);
        totalTests++;
        System.out.println(SEPARATOR);
        System.out.println("Test 10: Testing removeKey() in Open_Addressing for key: " + key);
        System.out.println("Expected collisions: " + expectedCollisions);
        System.out.println("Received collisions: " + collisions);
        try {
            assertEquals(expectedCollisions, collisions, "removeKey(" + key + ") expected collisions " + expectedCollisions + " but got " + collisions);
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    /**
     * Test 11: For a non-existing key 100, verify that removeKey(100) returns 1 collision.
     */
    @Test
    @DisplayName("Test 11: removeKey() - non-existing key")
    public void testRemoveKeyNonExisting() {
        int w = 4, seed = 0, A = 11;
        Open_Addressing oa = new Open_Addressing(w, seed, A);
        int key = 100;
        int expectedCollisions = 1;
        int collisions = oa.removeKey(key);
        totalTests++;
        System.out.println(SEPARATOR);
        System.out.println("Test 11: Testing removeKey() in Open_Addressing for non-existing key: " + key);
        System.out.println("Expected collisions (slots visited): " + expectedCollisions);
        System.out.println("Received collisions: " + collisions);
        try {
            assertEquals(expectedCollisions, collisions, "removeKey(" + key + ") expected collisions " + expectedCollisions + " but got " + collisions);
            System.out.println("\u001B[32mTest Passed\u001B[0m");
            testsPassed++;
        } catch (AssertionError e) {
            System.out.println("\u001B[31mTest Failed\u001B[0m");
            throw e;
        }
    }

    // ---------- Cleanup -------------------

    /**
     * Cleanup method executed once after all tests.
     */
    @AfterAll
    public static void tearDownAfterClass() {
        System.out.println(SEPARATOR);
        System.out.println("Open_Addressing Tests Summary: Passed " + testsPassed + " out of " + totalTests + " tests.");
        System.out.println(SEPARATOR);
    }
}