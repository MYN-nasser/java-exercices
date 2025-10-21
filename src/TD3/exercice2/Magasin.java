package TD3.exercice2;

import java.util.ArrayList;

public class Magasin {
    private ArrayList<Marque>marques;
    private ArrayList<String> produitVendu;

    public Magasin(ArrayList<Marque>marques,ArrayList<String> produitVendu){
        this.marques=marques;
        this.produitVendu=produitVendu;
    }
    public ArrayList<Marque> getMarques() {
        return marques; // Copie défensive
    }

    public ArrayList<String> getProduitVendu() {
        return produitVendu; // Copie défensive
    }

}
