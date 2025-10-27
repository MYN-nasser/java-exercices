package TD3.exercice2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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


    public Map<String,Produit> meileurProduitVendu_Marque(){
        Map<String, Produit> result = new HashMap<>();

        Map<String,Integer> count = new HashMap<>();
        int c;
        for (int i=0; i<produitVendu.size(); i++){
            c=1;
            for (int j=i+1; j<produitVendu.size(); j++){
                if (produitVendu.get(i).equals(produitVendu.get(j))){
                    c++;
                }
            }
            count.put(produitVendu.get(i),c);
        }

        for (Marque m : marques){
            int MaxVentes=0;
            Produit meilleurProduit = null;
            for (Produit p : m.getProduits()){
                if (count.containsKey(p.getNom())){
                    int vente = count.get(p.getNom());
                    if (vente > MaxVentes){
                        MaxVentes=vente;
                        meilleurProduit = p;
                    }
                }
            }
            if (meilleurProduit!=null){
                result.put(m.getNom(), meilleurProduit);
            }
        }

        return result;
    }

    public String meilleurProduitVendu_Magasin() {
        int max = 0;
        String meilleurProduit = null;

        // Compter ET trouver le max en même temps
        for (int i = 0; i < produitVendu.size(); i++) {
            String produitCourant = produitVendu.get(i);
            int c = 1;

            // Compter les occurrences
            for (int j = i + 1; j < produitVendu.size(); j++) {
                if (produitCourant.equals(produitVendu.get(j))) {
                    c++;
                }
            }
            // Vérifier si c'est le nouveau maximum
            if (c > max) {
                max = c;
                meilleurProduit = produitCourant;
            }
        }

        return meilleurProduit;
    }

    public Produit meilleurProduitRentable_Magasin() {
        Produit result = null;

        Map<String, Integer> count = new HashMap<>();
        int c;

        // Compter les occurrences de chaque produit vendu (par nom)
        for (int i = 0; i < produitVendu.size(); i++) {
            c = 1;
            for (int j = i + 1; j < produitVendu.size(); j++) {
                if (produitVendu.get(i).equals(produitVendu.get(j))) {
                    c++;
                }
            }
            count.put(produitVendu.get(i), c);
        }

        double maxCA = 0;

        // Parcourir TOUTES les marques et TOUS les produits pour trouver le plus rentable
        for (Marque m : marques) {
            for (Produit p : m.getProduits()) {
                if (count.containsKey(p.getNom())) {
                    int ventes = count.get(p.getNom());
                    double chiffreAffaires = p.getPrix() * ventes;

                    if (chiffreAffaires > maxCA) {
                        maxCA = chiffreAffaires;
                        result = p;
                    }
                }
            }
        }

        return result;
    }

    public void SupressionProduitMoinsVendu() {
        Map<String, Integer> count = new HashMap<>();
        int c;

        // Compter les occurrences de chaque produit vendu
        for (int i = 0; i < produitVendu.size(); i++) {
            c = 1;
            for (int j = i + 1; j < produitVendu.size(); j++) {
                if (produitVendu.get(i).equals(produitVendu.get(j))) {
                    c++;
                }
            }
            count.put(produitVendu.get(i), c);
        }

        // Pour chaque marque, trouver et supprimer le produit le moins vendu
        for (Marque m : marques) {
            int minVentes = Integer.MAX_VALUE;  // Initialiser avec une grande valeur
            Produit produitMoinsVendu = null;

            for (Produit p : m.getProduits()) {
                if (count.containsKey(p.getNom())) {
                    int ventes = count.get(p.getNom());
                    if (ventes < minVentes) {  // ← CHANGEMENT ICI : < au lieu de >
                        minVentes = ventes;
                        produitMoinsVendu = p;
                    }
                }
            }

            // Supprimer le produit le moins vendu de la marque
            if (produitMoinsVendu != null) {
                marques.remove(produitMoinsVendu);
                System.out.println("Produit supprimé: " + produitMoinsVendu.getNom() +
                        " de la marque " + m.getNom() + " (" + minVentes + " ventes)");
            }
        }
    }






}
