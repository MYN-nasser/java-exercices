package TD5.exercice4;

import java.util.*;
import java.util.stream.Collectors;

public class Magasin {
    private ArrayList<Marque>marques;
    private ArrayList<String> produitVendu;

    public Magasin(ArrayList<Marque>marques, ArrayList<String> produitVendu){
        this.marques=marques;
        this.produitVendu=produitVendu;
    }
    public ArrayList<Marque> getMarques() {
        return marques; // Copie défensive
    }

    public ArrayList<String> getProduitVendu() {
        return produitVendu; // Copie défensive
    }


    public Map<String, Produit> meileurProduitVendu_Marque() {
        // Compter les ventes pour chaque nom de produit
        Map<String, Long> ventesParProduit = produitVendu.stream()
                .collect(Collectors.groupingBy(nom -> nom, Collectors.counting()));

        Map<String, Produit> result = new HashMap<>();

        marques.forEach(marque -> {
            marque.getProduits().stream()
                    .filter(produit -> ventesParProduit.containsKey(produit.getNom()))
                    .max(Comparator.comparing(produit -> ventesParProduit.get(produit.getNom())))
                    .ifPresent(meilleurProduit -> result.put(marque.getNom(), meilleurProduit));
        });

        return result;
    }
    public String meilleurProduitVendu_Magasin() {
        return produitVendu.stream()
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
    public Produit meilleurProduitRentable_Magasin() {
        // Compter les ventes par produit
        Map<String, Long> ventesParProduit = produitVendu.stream()
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()));

        // Trouver le produit le plus rentable
        return marques.stream()
                .flatMap(marque -> marque.getProduits().stream())
                .filter(produit -> ventesParProduit.containsKey(produit.getNom()))
                .max(Comparator.comparing(produit ->
                        produit.getPrix() * ventesParProduit.get(produit.getNom())))
                .orElse(null);
    }
    public void SupressionProduitMoinsVendu() {
        // Compter les ventes par produit
        Map<String, Long> ventesParProduit = produitVendu.stream()
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()));

        // Pour chaque marque, trouver et supprimer le produit le moins vendu
        marques.forEach(marque -> {
            Optional<Produit> produitMoinsVendu = marque.getProduits().stream()
                    .filter(produit -> ventesParProduit.containsKey(produit.getNom()))
                    .min(Comparator.comparing(produit -> ventesParProduit.get(produit.getNom())));

            produitMoinsVendu.ifPresent(produit -> {
                marque.getProduits().remove(produit);
                System.out.println("Produit supprimé: " + produit.getNom() +
                        " de la marque " + marque.getNom() +
                        " (" + ventesParProduit.get(produit.getNom()) + " ventes)");
            });
        });
    }




}
