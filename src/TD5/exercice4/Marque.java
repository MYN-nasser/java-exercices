package TD5.exercice4;

import java.util.ArrayList;

public class Marque {
    private String nom;
    private ArrayList<Produit>produits;
    private String paysOrigine;

    public Marque(String nom, ArrayList<Produit>produits, String paysOrigine){
        this.nom=nom;
        this.produits=produits;
        this.paysOrigine=paysOrigine;
    }
    // Getters
    public String getNom() {
        return nom;
    }
    public ArrayList<Produit> getProduits() {
        return produits;
    }
    public String getPaysOrigine() {
        return paysOrigine;
    }

    public void Add_Product(Produit produit) {
        produits.add(produit);
    }

}
