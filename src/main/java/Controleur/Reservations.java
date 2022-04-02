package Controleur;

public class Reservations
{
    private int ResaID;
    private int IDClient;
    private int IDFilm;
    private int Heure;
    private int Nb_Ticket;

    public Reservations(int resaID, int IDClient, int IDFilm, int heure, int nb_ticket) {
        ResaID = resaID;
        this.IDClient = IDClient;
        this.IDFilm = IDFilm;
        Heure = heure;
        Nb_Ticket=nb_ticket;
    }
}
