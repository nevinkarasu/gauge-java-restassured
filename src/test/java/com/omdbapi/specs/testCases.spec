Specification Heading
=====================
Created by ASUS on 28.11.2023

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.


The Batman Movie
--------------------------
The Batman and Rotten Tomatoes Movie(concept dosyasında tüm stepler yer almaktadır incelenebilir)
* Send get request for list all Batman movies and check status code is "200"
* Get The Batman movie "Search[2].imdbID" and verify if it is "tt2975590" and save it
* Send get request for The Batman movie with ImdbID and check status code is "200"
* Get the Rotten Tomatoes "Ratings[1].Value" and verify if it is "85%" and check status code is "200"

Movie and Series Match
---------------------
Sherlock and The Hobbit Movie (concept dosyasında tüm stepler yer almaktadır incelenebilir)
* Send Get Reguest for two movies "Sherlock" and "The Hobbit: The Battle of the Five Armies"
* Get IMDB Rating Value of two movies "Sherlock" and "The Hobbit: The Battle of the Five Armies"
* Compare IMDb Ratings between "Sherlock" and "The Hobbit: The Battle of the Five Armies" movies
* Find common actors between "Sherlock" and "The Hobbit: The Battle of the Five Armies" movies


Movie and Movie Match
---------------------
 The Shawsank and Con Air Movie (concept dosyasında tüm stepler yer almaktadır incelenebilir)
 * Send Get Reguest for two movies "The Shawshank Redemption" and "Con Air"
 * Get Year Value of two movies "The Shawshank Redemption" and "Con Air"
 * Compare year of movie between "The Shawshank Redemption" and "Con Air" movies
 * Find common actors between "The Shawshank Redemption" and "Con Air" movies


