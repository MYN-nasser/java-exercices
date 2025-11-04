package TD5.exercice3;

import java.util.List;

public class Produit {
    public String nom;
    public String id;
    public double prix;
    public String categorie;
    public int anneFabric;
    public List<Integer>evaluations;

    public Produit(String nom,double prix,String categorie,int anneFabric,List<Integer>evaluations){
        this.nom=nom;
        this.prix=prix;
        this.categorie=categorie;
        this.anneFabric=anneFabric;
        this.evaluations=evaluations;
    }
}
