package dk.kea.moviefactsworkshopdat22v2.repository;

import dk.kea.moviefactsworkshopdat22v2.model.Movie;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Repository
public class MovieRepository {

  private String filePath = "src/main/resources/imdb-data.csv";

  private ArrayList<Movie> movieList = new ArrayList<>();
  Movie movie = new Movie();

  public MovieRepository() {
    loadCSVFile();
  }

  public List<Movie> getMovieList() {
    return movieList;
  }

  public void setMovieList(ArrayList<Movie> movieList) {
    this.movieList = movieList;
  }

  public void loadCSVFile() {

    try {
      Scanner input = new Scanner(new File(filePath));
      //Remove headers.
      input.nextLine();

      while (input.hasNextLine()) {
        String line = input.nextLine();
        Movie movie = readMovie(line);
        movieList.add(movie);
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found: " + e);
    }

  }

  public Movie readMovie(String line) {

    //Read first movie
    Scanner lineScanner = new Scanner(line).useDelimiter(";");

    //Set one field at the time
    //Year;Length;Title;Subject;Popularity;Awards
    int year = lineScanner.nextInt();
    int length = lineScanner.nextInt();
    String title = lineScanner.next();
    String subject = lineScanner.next();
    int popularity = lineScanner.nextInt();
    boolean hasAward = lineScanner.next().equalsIgnoreCase("yes");


    return new Movie(year, length, title, subject, popularity, hasAward);
  }


  public Movie getFirst() {

    movie = movieList.get(0);

    return movie;
  }

  public Movie getRandom() {

    int listSize = movieList.size();
    Random random = new Random();
    int randomInt = random.nextInt(listSize);

    return movieList.get(randomInt);
  }

  public String getTenSortByPopularity() {


    movieList.sort(Comparator.comparing(Movie::getPopularity).reversed());

    String temp = "";

    for (int i = 0; i < 10; i++) {
      temp += movieList.get(i) + "<br>";
    }

    System.out.println(temp);
    return temp;
  }

  public String getHowManyWonAnAward() {

    int count = 20;
    for (Movie movie : movieList) {
      if (movie.isAward()) {
        count++;
      }
    }
    return String.valueOf(count);
  }

  public String getByParameter(char x, int n) {

    String tempString = "";
    ArrayList<Movie> temp = new ArrayList<>();


    for (Movie movie : movieList) {
      int count = 0;
      for (int i = 0; i < movie.getTitle().length(); i++) {
        if (movie.getTitle().toUpperCase(Locale.ROOT).charAt(i) == x) {
          count++;
        }
      }
      if (count == n) {
        temp.add(movie);
      }
    }

    for (Movie movie : temp) {
      tempString += movie + "<br>";
    }
    return tempString;
  }

  public String getLongest(String g1, String g2) {

    double averageG1 = 0;
    double averageG2 = 0;
    ArrayList<Movie> g1List = new ArrayList<>();
    ArrayList<Movie> g2List = new ArrayList<>();

    for (Movie movie : movieList) {
      if (movie.getSubject().equalsIgnoreCase(g1)) {
        g1List.add(movie);
      }
      if (movie.getSubject().equalsIgnoreCase(g2)) {
        g2List.add(movie);
      }
    }
    for (Movie movie : g1List) {
      averageG1 += movie.getTitle().length();
    }
    averageG1 = averageG1 / (g1List.size() + 1);

    for (Movie movie : g2List) {
      averageG2 += movie.getTitle().length();
    }
    averageG2 = averageG2 / (g2List.size() + 1);

    if (averageG1 > averageG2)
      return g1;
    else
      return g2;
  }

}
