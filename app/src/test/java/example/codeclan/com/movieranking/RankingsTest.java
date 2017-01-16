package example.codeclan.com.movieranking;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by user on 16/01/2017.
 */

public class RankingsTest {

    Rankings rankings;
    Movie movie1;
    Movie movie2;
    Movie movie3;
    Movie movie4;
    Movie movie5;
    Movie movie6;
    Movie movie7;
    Movie movie8;
    Movie movie9;
    Movie movie10;

    @Before
    public void setUp() {
        rankings = new Rankings();
        movie1 = new Movie("Godfather", "drama", 1);
        movie2 = new Movie("The Shawshank Redemption", "drama", 2);
        movie8 = new Movie("The Dark Knight", "thriller", 3);
        movie4 = new Movie("12 angry men", "thriller", 4);
        movie10 = new Movie("Schindler's List", "drama", 5);
        movie6 = new Movie("Pulp Fiction", "thriller", 6);
        movie7 = new Movie("Lord Of The Rings", "fantasy", 7);
        movie3 = new Movie("Fight Club", "thriller", 8);
        movie9 = new Movie("Forrest Gump", "comedy", 9);
        movie5 = new Movie("The Matrix", "thriller", 10);
    }

    @Test
    public void canGetRankingsLength() {
        assertEquals(0, rankings.getLength());
    }

    @Test
    public void canAddMovie() {
        rankings.addMovie(movie1);
        assertEquals(1, rankings.getLength());
    }

    @Test
    public void canAddMoreMovies() {
        rankings.addMovie(movie1);
        rankings.addMovie(movie2);
        rankings.addMovie(movie3);
        rankings.addMovie(movie4);
        rankings.addMovie(movie5);
        rankings.addMovie(movie6);
        rankings.addMovie(movie7);
        rankings.addMovie(movie8);
        rankings.addMovie(movie9);
        rankings.addMovie(movie10);
        assertEquals(10, rankings.getLength());
    }

    @Test
    public void canGetMovieByIndex() {
        rankings.addMovie(movie1);
        assertEquals("Godfather", rankings.getMovieByIndex(1).getTitle());
    }

    @Test
    public void canSortRankings() {
        rankings.addMovie(movie1);
        rankings.addMovie(movie2);
        rankings.addMovie(movie3);
        rankings.addMovie(movie4);
        rankings.addMovie(movie5);
        rankings.addMovie(movie6);
        rankings.addMovie(movie7);
        rankings.addMovie(movie8);
        rankings.addMovie(movie9);
        rankings.addMovie(movie10);
        assertEquals(1, rankings.getMovieByIndex(1).getRanking());
        assertEquals(3, rankings.getMovieByIndex(3).getRanking());
        assertEquals(8, rankings.getMovieByIndex(8).getRanking());
    }

    @Test
    public void canReplaceLastMovie(){
        rankings.addMovie(movie1);
        rankings.addMovie(movie2);
        rankings.addMovie(movie3);
        rankings.addMovie(movie4);
        rankings.addMovie(movie5);
        rankings.addMovie(movie6);
        rankings.addMovie(movie7);
        rankings.addMovie(movie8);
        rankings.addMovie(movie9);
        rankings.addMovie(movie10);
        rankings.sortByRanking();
        Movie substituteMovie = new Movie("Godzilla", "action", 10);
        rankings.addMovie(substituteMovie);
        assertEquals("Godzilla", rankings.getMovieByIndex(10).getTitle());
    }

    @Test
    public void canFindMovieByTitle(){
        rankings.addMovie(movie1);
        rankings.addMovie(movie2);
        rankings.addMovie(movie3);
        rankings.addMovie(movie4);
        rankings.addMovie(movie5);
        rankings.addMovie(movie6);
        rankings.addMovie(movie7);
        rankings.addMovie(movie8);
        rankings.addMovie(movie9);
        rankings.addMovie(movie10);
        rankings.sortByRanking();
        assertEquals(10, rankings.getMovieByTitle("The Matrix").getRanking());
    }

    @Test
    public void canTitleUpMovie(){
        rankings.addMovie(movie1);
        rankings.addMovie(movie2);
        rankings.addMovie(movie3);
        rankings.addMovie(movie4);
        rankings.addMovie(movie5);
        rankings.addMovie(movie6);
        rankings.addMovie(movie7);
        rankings.addMovie(movie8);
        rankings.addMovie(movie9);
        rankings.addMovie(movie10);
        rankings.sortByRanking();
        assertEquals("Pulp Fiction", rankings.getMovieByIndex(6).getTitle());
        assertEquals("Lord Of The Rings", rankings.getMovieByIndex(7).getTitle());
        rankings.titleUpMovie(7);
        assertEquals("Pulp Fiction", rankings.getMovieByIndex(7).getTitle());
        assertEquals("Lord Of The Rings", rankings.getMovieByIndex(6).getTitle());
    }

    @Test
    public void canTitleDownMovie(){
        rankings.addMovie(movie1);
        rankings.addMovie(movie2);
        rankings.addMovie(movie3);
        rankings.addMovie(movie4);
        rankings.addMovie(movie5);
        rankings.addMovie(movie6);
        rankings.addMovie(movie7);
        rankings.addMovie(movie8);
        rankings.addMovie(movie9);
        rankings.addMovie(movie10);
        rankings.sortByRanking();
        assertEquals("Pulp Fiction", rankings.getMovieByIndex(6).getTitle());
        assertEquals("Lord Of The Rings", rankings.getMovieByIndex(7).getTitle());
        rankings.titleDownMovie(6);
        assertEquals("Pulp Fiction", rankings.getMovieByIndex(7).getTitle());
        assertEquals("Lord Of The Rings", rankings.getMovieByIndex(6).getTitle());
    }

    @Test
    public void canGetRankings() {
        rankings.addMovie(movie1);
        assertEquals("[Title: 'Godfather', Genre: 'drama', Ranking: 1, null, null, null, null, null, null, null, null, null]", rankings.getRankings());
    }
}
