package example.codeclan.com.movieranking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by user on 16/01/2017.
 */

public class Rankings {

    private Movie[] rankings;

    public Rankings() {
        this.rankings = new Movie[10];
    }

    public String getRankings(){
        return Arrays.toString(rankings);
    }

    public int getLength() {
        int count = 0;
        for(Movie movie : rankings){
            if(movie != null){
                count++;
            }
        }
        return count;
    }

    public void addMovie(Movie movie) {
        int movieRanking = movie.getRanking();
        rankings[movieRanking-1] = movie;
    }

    public Movie getMovieByIndex(int index) {
        return rankings[index-1];
    }

    public void sortByRanking() {
        Arrays.sort(rankings, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return Integer.compare(o1.getRanking(), o2.getRanking());
            }
        });
    }

    public Movie getMovieByTitle(String lookedUpTitle) {
//        String foundTitle = "";
//        String foundGenre = "";
//        int foundRanking = 0;
        Movie lookedUpMovie = new Movie("","",0);
        for(Movie movie : rankings){
            if(movie.getTitle() == lookedUpTitle){
//                foundTitle = movie.getTitle();
//                foundGenre = movie.getGenre();
//                foundRanking = movie.getRanking();
                lookedUpMovie = movie;
            }
        }
        return lookedUpMovie;
//        Movie lookedUpMovie = new Movie(foundTitle, foundGenre, foundRanking);
//        return lookedUpMovie;
    }

    public void titleUpMovie(int index) {
        for(Movie movie : rankings){
            if(movie.getRanking() == index){
                movie.setRanking(13);
            }
            if(movie.getRanking() == index-1){
                movie.setRanking(12);
            }
        }
        for(Movie movie : rankings){
            if(movie.getRanking() == 13){
                movie.setRanking(index-1);
            }
            if(movie.getRanking() == 12){
                movie.setRanking(index);
            }
        }
        sortByRanking();
    }

    public void titleDownMovie(int index) {
        for(Movie movie : rankings){
            if(movie.getRanking() == index){
                movie.setRanking(12);
            }
            if(movie.getRanking() == index+1){
                movie.setRanking(13);
            }
        }
        for(Movie movie : rankings){
            if(movie.getRanking() == 12){
                movie.setRanking(index+1);
            }
            if(movie.getRanking() == 13){
                movie.setRanking(index);
            }
        }
        sortByRanking();
    }
}
