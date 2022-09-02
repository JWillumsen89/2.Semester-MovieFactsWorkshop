package dk.kea.moviefactsworkshopdat22v2.controller;

import dk.kea.moviefactsworkshopdat22v2.repository.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;


@RestController
public class MovieController {
  MovieRepository movieRepository = new MovieRepository();


  @GetMapping("/")
  public String index() {

    return "Welcome to Movie Facts <br>" +
        "<b>/getFirst</b> returns first movie in database<br>" +
        "<b>/getRandom</b> returns an random movie database<br>" +
        "<b>/getTenSortByPopularity</b> returns ten movies, with top ten rating from database<br>" +
        "<b>/getFirst</b> returns the number of movies who have won an award<br>";
  }

  @GetMapping("/getFirst")
  public String getFirst() {

    String responseText = "<h1>First movie in database</h1>";
    responseText += movieRepository.getFirst();

    return responseText;
  }

  @GetMapping("/getRandom")
  public String getRandom() {

    String responseText = "<h1>Random movie from database</h1>";
    responseText += movieRepository.getRandom();

    return responseText;
  }

  @GetMapping("/getTenSortByPopularity")
  public String getTenSortByPopularity() {

    String responseText = "<h1>Top ten list by popularity</h1>";
    responseText += movieRepository.getTenSortByPopularity();

    return responseText;
  }

  @GetMapping("/getHowManyWonAnAward")
  public String getHowManyWonAnAward() {

    String responseText = "<h1>Number of movies who have won an award</h1>";
    responseText += movieRepository.getHowManyWonAnAward();

    return responseText;
  }

  @GetMapping("/filter")
  //How to make the URL: http://localhost:8080/filter?x=a&n=2

  public String getByParameter(@RequestParam char x, int n) {
    x = Character.toUpperCase(x);
    String responseText = "<h1>Movies that contains the letter: " + x + " - " + n + " times</h1>";
    responseText += movieRepository.getByParameter(x, n);

    return responseText;
  }

  @GetMapping("/longest")
  //How to make the URL: http://localhost:8080/filter?g1=genre&g2=genre
  public String getLongest(@RequestParam String g1, String g2) {
    g1 = g1.toUpperCase(Locale.ROOT);
    g2 = g2.toUpperCase(Locale.ROOT);
    String responseText = "<h1>Out these two genres: " + g1 + " and " + g2 + ", this one have in average the movies with the longest title:</h1>";
    responseText += movieRepository.getLongest(g1, g2);

    return responseText;
  }


}
