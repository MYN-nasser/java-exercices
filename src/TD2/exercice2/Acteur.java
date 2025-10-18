package TD2.exercice2;

public class Acteur extends Artiste {
    private String genre;
    private int nbFilm;

    public Acteur(int id_Artist,String nom,int AnneeDebut, String genre,int nbFilm){
        super();
        this.genre=genre;
        this.nbFilm=nbFilm;
        this.id_Artist=id_Artist;
        this.nom=nom;

    }
    public int getNbFilm(){return nbFilm;}
    public String getGenre(){return genre;}
    public void setNbFilm(int nb){this.nbFilm=nb;}
}
