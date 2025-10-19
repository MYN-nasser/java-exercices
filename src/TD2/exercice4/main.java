package TD2.exercice4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class main {

    public static void suppression(String code, Map<Integer, Produit> st){
        // Trouver directement la clé
        for (Integer cle : st.keySet()) {
            Produit p = st.get(cle);
            if (p.getCodeProduit().equals(code)) {
                if (!p.isEnStock()) {
                    System.out.println("Le produit " + code + " n'est pas en stock !");
                } else {
                    st.remove(cle); // ✅ Suppression simple
                    System.out.println("Produit " + code + " supprimé avec succès");
                }
                return; // On sort après avoir trouvé
            }
        }
        System.out.println("Produit " + code + " non trouvé");
    }

    public static void main(String[] args) {
        // Déclaration de la Map (clé = Integer, valeur = Produit)
        Map<Integer, Produit> stock = new HashMap<Integer, Produit>();

        // Remplissage de la Map pour tests
        stock.put(1, new Produit("P001", "Électronique", 50, true));
        stock.put(2, new Produit("P002", "Vêtements", 0, false));
        stock.put(3, new Produit("P003", "Électronique", 25, true));
        stock.put(4, new Produit("P004", "Alimentation", 100, true));
        stock.put(5, new Produit("P005", "Livres", 10, true));
        stock.put(6, new Produit("P006", "Vêtements", 5, true));
        stock.put(7, new Produit("P007", "Électronique", 0, false));

        for(Produit p: stock.values()){
            if (p.getQuantite()<5){
                p.setEnStock(false);
            }
        }

        // 3. Créer une Map où la clé est une catégorie et la valeur est un Set de produits ayant la même catégorie

        Map<String, Set<Produit>> produitsParCategorie = new HashMap<>();

        // Parcourir tous les produits de la map stock
        for (Produit produit : stock.values()) {
            String categorie = produit.getCategorie();

            // Vérifier si la catégorie existe déjà dans la map
            if (produitsParCategorie.containsKey(categorie)) {
                // Si oui, ajouter le produit au Set existant
                produitsParCategorie.get(categorie).add(produit);
            } else {
                // Si non, créer un nouveau Set et ajouter le produit
                Set<Produit> nouveauxProduits = new HashSet<>();
                nouveauxProduits.add(produit);
                produitsParCategorie.put(categorie, nouveauxProduits);
            }
        }
    }
}
