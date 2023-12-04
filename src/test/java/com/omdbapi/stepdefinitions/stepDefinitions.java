package com.omdbapi.stepdefinitions;


import com.omdbapi.base.baseConfig;
import com.omdbapi.base.baseMethods;
import com.thoughtworks.gauge.Step;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.List;

public class stepDefinitions {

    private Response response;
    private String movieImdbID;
    private String ratingValue;

    HashMap<String, Object> map = new HashMap<>();


    @Step("Save movieImdbID parameter to search Rotten Tomatoes rating value")
    public void saveMovieImdbID() {
        movieImdbID = response.jsonPath().getString("Search[1].imdbID");
        map.put("i",movieImdbID);
        response = baseConfig.get(map);
        System.out.println("Movie ImdbID: "+movieImdbID);
    }


    @Step("Get rating value of Rotten Tomatoes")
    public void getRatingValueFromResponse() {
        ratingValue = response.jsonPath().getString("Ratings[1].Value");
        System.out.println("Movie Rating Values: "+ratingValue);
    }

    @Step("Verify <string> value for <string> parameter from response")
    public void verifyMovieInTheResponse(String expected, String responsePath) {
        response = baseConfig.get(map);
        Assertions.assertEquals(expected, response.jsonPath().getString(responsePath));
    }

    @Step("Verify status code is <int>")
    public void verifyResponseStatus(int statusCode) {
        baseMethods.verifyStatusCode(response, statusCode);
    }

    @Step("Send get request to the all Batman movies list")
    public void sendGETRequestBatmanMovies() {

        map.put("apikey", "5bd7631f");
        map.put("s", "Batman");
        response = baseConfig.get(map);
        // Print the response to the console
        System.out.println("Response:");
        response.prettyPrint();
    }

    @Step("Send get request for The Batman ImdbID")
    public void sendGETRequestTheBatmanMovie() {
        map.clear();
        map.put("apikey", "5bd7631f");
        map.put("i", movieImdbID);
        response = baseConfig.get(map);
        System.out.println("Response:");
        response.prettyPrint();

    }

    @Step("Send GET request for <movie>")
    public void sendGETRequestForMovie(String movieKey) {
        map.clear();
        map.put("apikey", "5bd7631f");
        map.put("t", movieKey);
        response = baseConfig.get(map);
        System.out.println("Response:");
        response.prettyPrint();
    }


    @Step("Get Imdb Rating of <movie>")
    public String getImdbRatingForMovie(String movieKey) {
        map.clear();
        map.put("apikey", "5bd7631f");
        map.put("t", movieKey);
        Response response = baseConfig.get(map);

        String movieIMDBRating = response.jsonPath().getString("imdbRating");
        System.out.printf("%s imdb rating value: %s", movieKey, movieIMDBRating);
        return movieIMDBRating;
    }
    @Step("Get Actors of <movie>")
    public String getActorsForMovie(String movieKey) {
        map.clear();
        map.put("apikey", "5bd7631f");
        map.put("t", movieKey);
        Response response = baseConfig.get(map);

        String movieActors = response.jsonPath().getString("Actors");
        System.out.printf("%s actors: %s", movieKey, movieActors);
        return movieActors;
    }
    @Step("Get Year of <movie>")
    public String getYearForMovie(String movieKey) {
        map.clear();
        map.put("apikey", "5bd7631f");
        map.put("t", movieKey);
        Response response = baseConfig.get(map);

        String movieYear = response.jsonPath().getString("Year");
        System.out.printf("%s year: %s", movieKey, movieYear);
        return movieYear;
    }

    @Step("Compare IMDb Ratings between <movie1> and <movie2> movies")
    public void compareImdbRatings(String movieKey1, String movieKey2) {
        String imdbRating1 = getImdbRatingForMovie(movieKey1);
        String imdbRating2 = getImdbRatingForMovie(movieKey2);

        baseMethods.compareDoubles(Double.parseDouble(imdbRating1), Double.parseDouble(imdbRating2));
    }
    @Step("Find common actors between <movie1> and <movie2> movies")
    public void findCommonActors(String movie1,String movie2) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> commonActors = baseMethods.findCommonValues(getActorsForMovie(movie1), getActorsForMovie(movie2));

        // Ortak eleman bulunmazsa veya stringBuilder'ın uzunluğu 0 ise Assertions.assertTrue
        // metodu false dönecek ve hata bildirilmeyecek.
        Assertions.assertFalse(commonActors.isEmpty() && stringBuilder.length() == 0,
                "There is no common actors in two movies: " + commonActors);

        // Iterate through the commonActors list and print each value
        for (String actor : commonActors) {
            System.out.println("Common Actor: " + actor);
        }
    }
    @Step("Compare year of movie between <movie1> and <movie2> movies")
    public void compareYears(String movieKey1, String movieKey2) {
        String movieYear1 = getYearForMovie(movieKey1);
        String movieYear2 = getYearForMovie(movieKey2);

        baseMethods.compareIntegers(Integer.parseInt(movieYear1), Integer.parseInt(movieYear2));
    }

}



