package TD3.exercice2;

import java.util.ArrayList;

public class Produit {
    private ArrayList<String>composantes ;
    private String nom;
    private double prix;

    public Produit(ArrayList<String>composantes,String nom,double prix){
        this.composantes=composantes;
        this.nom=nom;
        this.prix=prix;
    }
    // Getters
    public ArrayList<String> getComposantes() {
        return composantes;
    }
    public String getNom() {
        return nom;
    }
    public double getPrix() {
        return prix;
    }

}
