package Controleur;

public class Offre
{
    private int ID=0;
    private String Type="a";
    private int Remise = 0;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getRemise() {
        return Remise;
    }

    public void setRemise(int remise) {
        Remise = remise;
    }
}
