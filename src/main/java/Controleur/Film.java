package Controleur;

public class Film {

    private String Titre;
    private String Synopsis;
    private int Prix;
    private int Duree;
    private String Genre;
    private int FilmID;

    public Film(String titre, String synopsis, int prix, int duree, String genre, int filmID) {
        Titre = titre;
        Synopsis = synopsis;
        Prix = prix;
        Duree = duree;
        Genre = genre;
        FilmID = filmID;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getSynopsis() {
        return Synopsis;
    }

    public void setSynopsis(String synopsis) {
        Synopsis = synopsis;
    }

    public int getPrix() {
        return Prix;
    }

    public void setPrix(int prix) {
        Prix = prix;
    }

    public int getDuree() {
        return Duree;
    }

    public void setDuree(int duree) {
        Duree = duree;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public int getFilmID() {
        return FilmID;
    }

    public void setFilmID(int filmID) {
        FilmID = filmID;
    }
}
