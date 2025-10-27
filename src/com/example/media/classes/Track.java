package com.example.media.classes;

/**
 * Music track class extending Media.
 */
public class Track extends Media {
    private String artist;
    private String genre;
    private int rating;

    public Track(String title, String artist, String genre, int duration, int rating) {
        super(title, duration);
        this.artist = artist;
        this.genre = genre;
        this.rating = rating;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        // TODO: Return string with title, artist, genre, rating
        return title + " — " + artist + " (" + genre + "), rating " + rating;
    }
}
