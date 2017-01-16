package example.codeclan.com.movieranking;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 16/01/2017.
 */

public class MovieTest {

    Movie movie;
    Movie testMovie;

    @Before
    public void setUp() {
        movie = new Movie("Godfather", "drama", 1);
        testMovie = new Movie("blablabla", "blabla", 2);
    }

    @Test
    public void canGetTitle() {
        assertEquals("Godfather", movie.getTitle());
    }

    @Test
    public void canGetGenre() {
        assertEquals("drama", movie.getGenre());
    }

    @Test
    public void canGetRanking() {
        assertEquals(1, movie.getRanking());
    }

    @Test
    public void canSetTitle() {
        testMovie.setTitle("XXX");
        assertEquals("XXX",testMovie.getTitle());
    }

    @Test
    public void canSetGenre() {
        testMovie.setGenre("comedy");
        assertEquals("comedy", testMovie.getGenre());
    }

    @Test
    public void canSetRanking() {
        testMovie.setRanking(3);
        assertEquals(3, testMovie.getRanking());
    }

    @Test
    public void canOverrideToString() {
        assertEquals("Title: 'Godfather', Genre: 'drama', Ranking: 1", movie.toString());
    }

}
