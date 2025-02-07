package assignment1.question3;

import org.junit.jupiter.api.*;       // JUnit 5 annotations
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * COMP 251 Test file
 * <p>Assignment 1, Question 3
 *
 * <p>JUnit tests for the Discussion Board feature implemented in
 * {@link A1_Q3#Discussion_Board(String[])}.
 *
 * <p>This function must return a sorted list of keywords that were used by every user.
 * The returned list is sorted from most to least frequent, and in case of a tie, alphabetically.
 *
 * Test cases include:
 * <ul>
 *   <li>Example One (provided in the assignment).
 *   <li>Example Two (provided in the assignment).
 *   <li>A single-user case.
 *   <li>A multiple-message case with different users.
 *   <li>An efficiency test with a large number of posts.
 *   <li>Additional tests:
 *       <ul>
 *         <li>Test 6: All posts from the same user with repeated common words.
 *         <li>Test 7: Two-user tie on frequency (alphabetical order).
 *         <li>Test 8: Common word appears with different frequencies across users.
 *         <li>Test 9: Multiple posts from one user and one from another, so only words used by both appear.
 *         <li>Test 10: No common words among several users.
 *       </ul>
 * </ul>
 *
 * Each test prints its outcome (green for pass, red for fail) along with expected and received results.
 * A summary is printed at the end.
 *
 * @author Joseph Abboud
 */
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class JUnitA1_Q3Test {

    /** Separator string for output (same length as used in previous tests) */
    private static final String SEPARATOR = "--------------------------------------------------";

    /** Global counter for tests passed */
    private static int testsPassed = 0;

    /** Global counter for tests executed */
    private static int totalTests = 0;

    // ---------- Tests for Discussion_Board() ----------

    /**
     * Test 1: Discussion_Board Example One.
     *
     * Posts:
     * <pre>
     * David no no no no nobody never
     * Alexia why ever not
     * Parham no not never nobody
     * Brian no never know nobody
     * Jeremy why no nobody
     * Jeremy nobody never know why nobody
     * David never no nobody
     * Alexia never never nobody no
     * </pre>
     * Expected output: [no, nobody, never]
     */
    @Test
    @DisplayName("Test 1: Discussion_Board Example One")
    public void testDiscussionBoardExampleOne() {
        try {
            String[] posts = {
                    "David no no no no nobody never",
                    "Alexia why ever not",
                    "Parham no not never nobody",
                    "Brian no never know nobody",
                    "Jeremy why no nobody",
                    "Jeremy nobody never know why nobody",
                    "David never no nobody",
                    "Alexia never never nobody no"
            };
            ArrayList<String> expected = new ArrayList<>(Arrays.asList("no", "nobody", "never"));
            totalTests++;
            System.out.println(SEPARATOR);
            System.out.println("Test 1: Discussion_Board Example One");
            System.out.println("Expected result: " + expected);
            ArrayList<String> result = A1_Q3.Discussion_Board(posts);
            System.out.println("Received result: " + result);
            try {
                assertEquals(expected, result, "Test 1 failed: Expected " + expected + " but got " + result);
                System.out.println("\u001B[32mTest Passed\u001B[0m");
                testsPassed++;
            } catch (AssertionError e) {
                System.out.println("\u001B[31mTest Failed\u001B[0m");
                throw e;
            }
        } catch(Exception e) {
            e.printStackTrace();
            fail("Exception occurred in testDiscussionBoardExampleOne: " + e.getMessage());
        }
    }

    /**
     * Test 2: Discussion_Board Example Two.
     *
     * Posts:
     * <pre>
     * David comp
     * Ziqi music
     * </pre>
     * Expected output: [] (an empty ArrayList)
     */
    @Test
    @DisplayName("Test 2: Discussion_Board Example Two")
    public void testDiscussionBoardExampleTwo() {
        try {
            String[] posts = {
                    "David comp",
                    "Ziqi music"
            };
            ArrayList<String> expected = new ArrayList<>();
            totalTests++;
            System.out.println(SEPARATOR);
            System.out.println("Test 2: Discussion_Board Example Two");
            System.out.println("Expected result: " + expected);
            ArrayList<String> result = A1_Q3.Discussion_Board(posts);
            System.out.println("Received result: " + result);
            try {
                assertEquals(expected, result, "Test 2 failed: Expected " + expected + " but got " + result);
                System.out.println("\u001B[32mTest Passed\u001B[0m");
                testsPassed++;
            } catch (AssertionError e) {
                System.out.println("\u001B[31mTest Failed\u001B[0m");
                throw e;
            }
        } catch(Exception e) {
            e.printStackTrace();
            fail("Exception occurred in testDiscussionBoardExampleTwo: " + e.getMessage());
        }
    }

    /**
     * Test 3: Discussion_Board Single User.
     *
     * Posts:
     * <pre>
     * Alice apple banana apple banana cherry
     * </pre>
     * Expected output: [apple, banana, cherry]
     */
    @Test
    @DisplayName("Test 3: Discussion_Board Single User")
    public void testDiscussionBoardSingleUser() {
        try {
            String[] posts = {"Alice apple banana apple banana cherry"};
            ArrayList<String> expected = new ArrayList<>(Arrays.asList("apple", "banana", "cherry"));
            totalTests++;
            System.out.println(SEPARATOR);
            System.out.println("Test 3: Discussion_Board Single User");
            System.out.println("Expected result: " + expected);
            ArrayList<String> result = A1_Q3.Discussion_Board(posts);
            System.out.println("Received result: " + result);
            try {
                assertEquals(expected, result, "Test 3 failed: Expected " + expected + " but got " + result);
                System.out.println("\u001B[32mTest Passed\u001B[0m");
                testsPassed++;
            } catch (AssertionError e) {
                System.out.println("\u001B[31mTest Failed\u001B[0m");
                throw e;
            }
        } catch(Exception e) {
            e.printStackTrace();
            fail("Exception occurred in testDiscussionBoardSingleUser: " + e.getMessage());
        }
    }

    /**
     * Test 4: Discussion_Board Multiple Messages.
     *
     * Posts:
     * <pre>
     * Alice cat dog
     * Alice dog mouse
     * Bob cat mouse
     * Bob dog cat
     * </pre>
     * Expected output: [cat, dog, mouse]
     */
    @Test
    @DisplayName("Test 4: Discussion_Board Multiple Messages")
    public void testDiscussionBoardMultipleMessages() {
        try {
            String[] posts = {
                    "Alice cat dog",
                    "Alice dog mouse",
                    "Bob cat mouse",
                    "Bob dog cat"
            };
            ArrayList<String> expected = new ArrayList<>(Arrays.asList("cat", "dog", "mouse"));
            totalTests++;
            System.out.println(SEPARATOR);
            System.out.println("Test 4: Discussion_Board Multiple Messages");
            System.out.println("Expected result: " + expected);
            ArrayList<String> result = A1_Q3.Discussion_Board(posts);
            System.out.println("Received result: " + result);
            try {
                assertEquals(expected, result, "Test 4 failed: Expected " + expected + " but got " + result);
                System.out.println("\u001B[32mTest Passed\u001B[0m");
                testsPassed++;
            } catch (AssertionError e) {
                System.out.println("\u001B[31mTest Failed\u001B[0m");
                throw e;
            }
        } catch(Exception e) {
            e.printStackTrace();
            fail("Exception occurred in testDiscussionBoardMultipleMessages: " + e.getMessage());
        }
    }

    /**
     * Test 5: Efficiency Test.
     *
     * This test generates 1000 posts (each from a unique user) containing the common word "common" and a unique word.
     * Expected output: [common] and the runtime must be below 1.0 seconds.
     */
    @Test
    @DisplayName("Test 5: Efficiency Test")
    public void testDiscussionBoardEfficiency() {
        try {
            int numPosts = 1000;
            String[] posts = new String[numPosts];
            for (int i = 0; i < numPosts; i++) {
                posts[i] = "User" + i + " common word" + i;
            }
            ArrayList<String> expected = new ArrayList<>(Arrays.asList("common"));
            totalTests++;
            System.out.println(SEPARATOR);
            System.out.println("Test 5: Efficiency Test for Discussion_Board with " + numPosts + " posts.");
            System.out.println("Expected result: " + expected);
            long startTime = System.nanoTime();
            ArrayList<String> result = A1_Q3.Discussion_Board(posts);
            long endTime = System.nanoTime();
            double seconds = (endTime - startTime) / 1_000_000_000.0;
            double threshold = 1.0; // seconds
            System.out.println("Received result: " + result);
            System.out.println("Execution time: " + seconds + " seconds (threshold: " + threshold + " seconds)");
            try {
                assertEquals(expected, result, "Test 5 failed: Expected " + expected + " but got " + result);
                assertTrue(seconds < threshold, "Efficiency test failed: Execution time " + seconds + " seconds exceeds threshold " + threshold);
                System.out.println("\u001B[32mTest Passed\u001B[0m");
                testsPassed++;
            } catch (AssertionError e) {
                System.out.println("\u001B[31mTest Failed\u001B[0m");
                throw e;
            }
        } catch(Exception e) {
            e.printStackTrace();
            fail("Exception occurred in testDiscussionBoardEfficiency: " + e.getMessage());
        }
    }

    // ---------- Additional Tests ----------

    /**
     * Test 6: All posts from the same user with repeated common words.
     *
     * Posts:
     * <pre>
     * Alice apple apple banana
     * Alice banana apple apple
     * </pre>
     * Expected output: [apple, banana]
     * (apple and banana both appear; apple and banana have equal total frequency,
     * so the tie is broken alphabetically.)
     */
    @Test
    @DisplayName("Test 6: All posts from one user")
    public void testDiscussionBoardAllSameUser() {
        try {
            String[] posts = {
                    "Alice apple apple banana",
                    "Alice banana apple apple"
            };
            // For the single user, every word is common.
            // Total frequencies: apple: 4, banana: 2.
            // Sorted by frequency descending: [apple, banana].
            ArrayList<String> expected = new ArrayList<>(Arrays.asList("apple", "banana"));
            totalTests++;
            System.out.println(SEPARATOR);
            System.out.println("Test 6: Discussion_Board with all posts from one user");
            System.out.println("Expected result: " + expected);
            ArrayList<String> result = A1_Q3.Discussion_Board(posts);
            System.out.println("Received result: " + result);
            try {
                assertEquals(expected, result, "Test 6 failed: Expected " + expected + " but got " + result);
                System.out.println("\u001B[32mTest Passed\u001B[0m");
                testsPassed++;
            } catch (AssertionError e) {
                System.out.println("\u001B[31mTest Failed\u001B[0m");
                throw e;
            }
        } catch(Exception e) {
            e.printStackTrace();
            fail("Exception in testDiscussionBoardAllSameUser: " + e.getMessage());
        }
    }

    /**
     * Test 7: Two-user tie on frequency where alphabetical order decides.
     *
     * Posts:
     * <pre>
     * Bob apple orange
     * Alice orange apple
     * </pre>
     * Both "apple" and "orange" appear once in each post (total frequency 2 each).
     * Expected output: [apple, orange] (alphabetical order for the tie).
     */
    @Test
    @DisplayName("Test 7: Two-user tie on frequency")
    public void testDiscussionBoardTwoUserTie() {
        try {
            String[] posts = {
                    "Bob apple orange",
                    "Alice orange apple"
            };
            ArrayList<String> expected = new ArrayList<>(Arrays.asList("apple", "orange"));
            totalTests++;
            System.out.println(SEPARATOR);
            System.out.println("Test 7: Discussion_Board with two users having a tie on frequency.");
            System.out.println("Expected result: " + expected);
            ArrayList<String> result = A1_Q3.Discussion_Board(posts);
            System.out.println("Received result: " + result);
            try {
                assertEquals(expected, result, "Test 7 failed: Expected " + expected + " but got " + result);
                System.out.println("\u001B[32mTest Passed\u001B[0m");
                testsPassed++;
            } catch (AssertionError e) {
                System.out.println("\u001B[31mTest Failed\u001B[0m");
                throw e;
            }
        } catch(Exception e) {
            e.printStackTrace();
            fail("Exception in testDiscussionBoardTwoUserTie: " + e.getMessage());
        }
    }

    /**
     * Test 8: Common word appears with different frequencies across users.
     *
     * Posts:
     * <pre>
     * Alice hello world hello
     * Bob hello there
     * Charlie hello everyone hello
     * </pre>
     * Expected output: [hello]
     */
    @Test
    @DisplayName("Test 8: Common word with different frequencies")
    public void testDiscussionBoardDifferentFrequencies() {
        try {
            String[] posts = {
                    "Alice hello world hello",
                    "Bob hello there",
                    "Charlie hello everyone hello"
            };
            ArrayList<String> expected = new ArrayList<>(Arrays.asList("hello"));
            totalTests++;
            System.out.println(SEPARATOR);
            System.out.println("Test 8: Discussion_Board with common word across users with different frequencies.");
            System.out.println("Expected result: " + expected);
            ArrayList<String> result = A1_Q3.Discussion_Board(posts);
            System.out.println("Received result: " + result);
            try {
                assertEquals(expected, result, "Test 8 failed: Expected " + expected + " but got " + result);
                System.out.println("\u001B[32mTest Passed\u001B[0m");
                testsPassed++;
            } catch (AssertionError e) {
                System.out.println("\u001B[31mTest Failed\u001B[0m");
                throw e;
            }
        } catch(Exception e) {
            e.printStackTrace();
            fail("Exception in testDiscussionBoardDifferentFrequencies: " + e.getMessage());
        }
    }

    /**
     * Test 9: Multiple posts from one user and one from another.
     *
     * Posts:
     * <pre>
     * Alice apple banana apple
     * Bob apple orange apple
     * </pre>
     * Expected output: [apple] (only "apple" appears in both users’ posts).
     */
    @Test
    @DisplayName("Test 9: Multiple posts from one user")
    public void testDiscussionBoardMultiplePostsOneUser() {
        try {
            String[] posts = {
                    "Alice apple banana apple",
                    "Bob apple orange apple"
            };
            ArrayList<String> expected = new ArrayList<>(Arrays.asList("apple"));
            totalTests++;
            System.out.println(SEPARATOR);
            System.out.println("Test 9: Discussion_Board with multiple posts from one user and one from another.");
            System.out.println("Expected result: " + expected);
            ArrayList<String> result = A1_Q3.Discussion_Board(posts);
            System.out.println("Received result: " + result);
            try {
                assertEquals(expected, result, "Test 9 failed: Expected " + expected + " but got " + result);
                System.out.println("\u001B[32mTest Passed\u001B[0m");
                testsPassed++;
            } catch (AssertionError e) {
                System.out.println("\u001B[31mTest Failed\u001B[0m");
                throw e;
            }
        } catch(Exception e) {
            e.printStackTrace();
            fail("Exception in testDiscussionBoardMultiplePostsOneUser: " + e.getMessage());
        }
    }

    /**
     * Test 10: When no common words exist among several users.
     *
     * Posts:
     * <pre>
     * Alice apple
     * Bob banana
     * Charlie cherry
     * </pre>
     * Expected output: [] (empty list).
     */
    @Test
    @DisplayName("Test 10: No common words")
    public void testDiscussionBoardNoCommonWords() {
        try {
            String[] posts = {
                    "Alice apple",
                    "Bob banana",
                    "Charlie cherry"
            };
            ArrayList<String> expected = new ArrayList<>();
            totalTests++;
            System.out.println(SEPARATOR);
            System.out.println("Test 10: Discussion_Board when no common words exist among users.");
            System.out.println("Expected result: " + expected);
            ArrayList<String> result = A1_Q3.Discussion_Board(posts);
            System.out.println("Received result: " + result);
            try {
                assertEquals(expected, result, "Test 10 failed: Expected " + expected + " but got " + result);
                System.out.println("\u001B[32mTest Passed\u001B[0m");
                testsPassed++;
            } catch (AssertionError e) {
                System.out.println("\u001B[31mTest Failed\u001B[0m");
                throw e;
            }
        } catch(Exception e) {
            e.printStackTrace();
            fail("Exception in testDiscussionBoardNoCommonWords: " + e.getMessage());
        }
    }

    // ---------- Cleanup ----------

    /**
     * Cleanup method executed once after all tests.
     */
    @AfterAll
    public static void tearDownAfterClass() {
        System.out.println(SEPARATOR);
        System.out.println("Discussion Board Tests Summary: Passed " + testsPassed + " out of " + totalTests + " tests.");
        System.out.println(SEPARATOR);
    }
}