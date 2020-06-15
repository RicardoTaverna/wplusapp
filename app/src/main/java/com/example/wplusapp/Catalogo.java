package com.example.wplusapp;

public class Catalogo {
    private String Actors;
    private String Awards;
    private String Country;
    private String Director;
    private String Genre;
    //private String Images;
    private String Language;
    private String Metascore;
    private String Plot;
    private String Poster;
    private String Rated;
    private String Released;
    private String Response;
    private String Runtime;
    private String Title;
    private String Type;
    private String Write;
    private String Year;
    private String imdbID;
    private String imdbRating;
    private String imdbVotes;

    public Catalogo(){}

    /*
    public Catalogo(String actors, String awards, String country, String director, String genre, String images, String language, String metascore, String plot, String poster, String rated, String released, String response, String runtime, String title, String type, String write, String year, String imdbID, String imdbRating, String imdbVotes) {
        this.Actors = actors;
        this.Awards = awards;
        this.Country = country;
        this.Director = director;
        this.Genre = genre;
        this.Images = images;
        this.Language = language;
        this.Metascore = metascore;
        this.Plot = plot;
        this.Poster = poster;
        this.Rated = rated;
        this.Released = released;
        this.Response = response;
        this.Runtime = runtime;
        this.Title = title;
        this.Type = type;
        this.Write = write;
        this.Year = year;
        this.imdbID = imdbID;
        this.imdbRating = imdbRating;
        this.imdbVotes = imdbVotes;
    }
    */


    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        this.Actors = actors;
    }

    public String getAwards() {
        return Awards;
    }

    public void setAwards(String awards) {
        this.Awards = awards;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        this.Director = director;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        this.Genre = genre;
    }
/*
    public String getImages() {
        return Images;
    }

    public void setImages(String images) {
        this.Images = images;
    }
*/
    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        this.Language = language;
    }

    public String getMetascore() {
        return Metascore;
    }

    public void setMetascore(String metascore) {
        this.Metascore = metascore;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        this.Plot = plot;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        this.Poster = poster;
    }

    public String getRated() {
        return Rated;
    }

    public void setRated(String rated) {
        this.Rated = rated;
    }

    public String getReleased() {
        return Released;
    }

    public void setReleased(String released) {
        this.Released = released;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        this.Response = response;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        this.Runtime = runtime;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public String getWrite() {
        return Write;
    }

    public void setWrite(String write) {
        this.Write = write;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        this.Year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }
    public String toString(){
        return Title;
    }
}
