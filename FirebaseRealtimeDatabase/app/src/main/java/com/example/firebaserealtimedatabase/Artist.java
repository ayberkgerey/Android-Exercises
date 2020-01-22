package com.example.firebaserealtimedatabase;

public class Artist {

    String artistID, artistName , artistGenre;

public Artist(){

}

    public Artist(String artistID, String artistName, String artistGenre) {
        this.artistID = artistID;
        this.artistName = artistName;
        this.artistGenre = artistGenre;
    }

    public String getArtistID() {
        return artistID;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getArtistGenre() {
        return artistGenre;
    }
}
