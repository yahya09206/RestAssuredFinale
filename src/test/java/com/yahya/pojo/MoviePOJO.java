package com.yahya.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MoviePOJO {

    // @JsonProperty will match the java fields to the json fields while still using proper naming convention
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Year")
    private String year;
    private String imdbID;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Poster")
    private String poster;

    public MoviePOJO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", Year='" + year + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", Type='" + type + '\'' +
                ", Poster='" + poster + '\'' +
                '}';
    }
}
