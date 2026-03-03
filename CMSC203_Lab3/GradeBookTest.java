import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 * Starter JUnit 5 test class for GradeBook.
 *
 * TODO:
 *  - Complete the setUp method.
 *  - Complete each test method with appropriate assertions.
 *  - Add any additional tests you think are necessary.
 */
public class GradeBookTest {

    // Test fixtures: shared objects used in multiple tests
    private GradeBook g1;
    private GradeBook g2;

    /**
     * setUp runs BEFORE each @Test method.
     * Use it to create fresh GradeBook objects for every test.
     */
    @BeforeEach
    public void setUp() {
        // initialize g1 and g2 with capacity 5
        g1 = new GradeBook(5);
        g1.addScore(50.0);
        g1.addScore(75.0);

        g2 = new GradeBook(5);
        g2.addScore(90.0);
        g2.addScore(85.0);
        g2.addScore(70.0);
    }

    /**
     * tearDown runs AFTER each @Test method.
     * Use it to clean up any objects if needed.
     */
    @AfterEach
    public void tearDown() {
        g1 = null;
        g2 = null;
    }

    /**
     * Test addScore and toString.
     *
     * Goal:
     *  - Verify that the scores are stored correctly.
     *  - Verify that toString returns the expected string
     *    (each score followed by a space, in the order added).
     */
    @Test
    public void testAddScoreAndToString() {
        assertEquals("50.0 75.0 ", g1.toString());
        assertEquals("90.0 85.0 70.0 ", g2.toString());
    }

    /**
     * Test getScoreSize.
     *
     * Goal:
     *  - Verify that getScoreSize returns the number of scores
     *    actually added to each GradeBook.
     */
    @Test
    public void testGetScoreSize() {
        assertEquals(2, g1.getScoreSize());
        assertEquals(3, g2.getScoreSize());
    }

    /**
     * Test sum.
     *
     * Goal:
     *  - Verify that sum() returns the correct total of all scores.
     */
    @Test
    public void testSum() {
        assertEquals(125.0, g1.sum(), 0.0001);
        assertEquals(245.0, g2.sum(), 0.0001);
    }

    /**
     * Test minimum.
     *
     * Goal:
     *  - Verify that minimum() returns the smallest score.
     *  - Optionally test behavior when there are no scores.
     */
    @Test
    public void testMinimum() {
        assertEquals(50.0, g1.minimum(), 0.0001);
        assertEquals(70.0, g2.minimum(), 0.0001);

        GradeBook empty = new GradeBook(5);
        assertEquals(0.0, empty.minimum(), 0.0001);
    }

    /**
     * Test finalScore.
     *
     * Goal:
     *  - Verify that finalScore() drops the lowest score
     *    when there are at least two scores.
     *  - Verify behavior when there is exactly one score
     *    and when there are no scores.
     */
    @Test
    public void testFinalScore() {
        assertEquals(75.0, g1.finalScore(), 0.0001);
        assertEquals(175.0, g2.finalScore(), 0.0001);

        GradeBook empty = new GradeBook(5);
        assertEquals(0.0, empty.finalScore(), 0.0001);

        GradeBook single = new GradeBook(5);
        single.addScore(100.0);
        assertEquals(100.0, single.finalScore(), 0.0001);
    }
}
// Something interesting:
//I watched a whole video on how to use jUnit and apparently
//certain code blocks just don't work in jUnit....
