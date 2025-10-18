package TD2.exercice2;

public class Guitariste extends Artiste{
    private String typeGuitare;
    private int nbMorceaux;

    public Guitariste(int id_Artist,String nom,int AnneeDebut,String typeGuitare,int nbMorceaux){
        super();
        this.nbMorceaux=nbMorceaux;
        this.typeGuitare=typeGuitare;
    }
    public int getNbMorceaux(){return nbMorceaux;}
    public String getTypeGuitare(){return typeGuitare;}
    public void setNbMorceaux(int nb){this.nbMorceaux=nb;}

}
