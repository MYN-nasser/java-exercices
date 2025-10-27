package TD3.exercice2;

import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Création des produits
        ArrayList<String>composant = new ArrayList<String>();

        // Déclarations CORRECTES selon votre constructeur
        Produit iphone = new Produit(new ArrayList<>(), "iPhone", 1500.0);
        Produit ipad = new Produit(new ArrayList<>(), "iPad", 799.99);
        Produit macbook = new Produit(new ArrayList<>(), "MacBook", 1999.99);

        Produit galaxy = new Produit(new ArrayList<>(), "Galaxy", 899.99);
        Produit tablet = new Produit(new ArrayList<>(), "Tablet", 299.99);
        Produit ecran = new Produit(new ArrayList<>(), "Écran", 349.99);

        Produit souris = new Produit(new ArrayList<>(), "Souris", 49.99);
        Produit clavier = new Produit(new ArrayList<>(), "Clavier", 79.99);

        // Création des marques
        // Déclarations CORRECTES selon votre constructeur
        Marque apple = new Marque("Apple", new ArrayList<>(), "USA");
        Marque samsung = new Marque("Samsung", new ArrayList<>(), "Corée du Sud");
        Marque logitech = new Marque("Logitech", new ArrayList<>(), "Suisse");

        // Ajout des produits aux marques
        apple.Add_Product(iphone);
        apple.Add_Product(ipad);
        apple.Add_Product(macbook);

        samsung.Add_Product(galaxy);
        samsung.Add_Product(tablet);
        samsung.Add_Product(ecran);

        logitech.Add_Product(souris);
        logitech.Add_Product(clavier);

        // Liste des marques
        ArrayList<Marque> marques = new ArrayList<>();
        marques.add(apple);
        marques.add(samsung);
        marques.add(logitech);

        // Simulation des produits vendus
        ArrayList<String> produitsVendus = new ArrayList<>();
        produitsVendus.add("iPhone");
        produitsVendus.add("iPhone");
        produitsVendus.add("iPhone");
        produitsVendus.add("Galaxy");
        produitsVendus.add("Galaxy");
        produitsVendus.add("Souris");
        produitsVendus.add("Souris");
        produitsVendus.add("Souris");
        produitsVendus.add("Souris");
        produitsVendus.add("Souris");
        produitsVendus.add("iPad");
        produitsVendus.add("Tablet");
        produitsVendus.add("Écran");

        // Création du magasin
        Magasin magasin = new Magasin(marques, produitsVendus);

        System.out.println("=== TEST DES FONCTIONNALITÉS DU MAGASIN ===\n");

        // 1. Test: Meilleur produit vendu par marque
        System.out.println("1. 🏆 MEILLEUR PRODUIT VENDU PAR MARQUE:");
        Map<String, Produit> meilleursParMarque = magasin.meileurProduitVendu_Marque();
        for (Map.Entry<String, Produit> entry : meilleursParMarque.entrySet()) {
            System.out.println("   " + entry.getKey() + " → " + entry.getValue().getNom());
        }

        // 2. Test: Meilleur produit vendu dans le magasin
        System.out.println("\n2. 🥇 MEILLEUR PRODUIT VENDU DU MAGASIN:");
        String meilleurVente = magasin.meilleurProduitVendu_Magasin();
        System.out.println("   " + meilleurVente);

        // 3. Test: Produit le plus rentable
        System.out.println("\n3. 💰 PRODUIT LE PLUS RENTABLE:");
        Produit plusRentable = magasin.meilleurProduitRentable_Magasin();
        if (plusRentable != null) {
            System.out.println("   " + plusRentable.getNom() + " - " + plusRentable.getPrix() + "€");
        }

        // 4. Test: Suppression des produits les moins vendus
        System.out.println("\n4. 🗑️ SUPPRESSION DES PRODUITS MOINS VENDUS:");
        System.out.println("Avant suppression:");
        for (Marque m : magasin.getMarques()) {
            System.out.print("   " + m.getNom() + ": ");
            for (Produit p : m.getProduits()) {
                System.out.print(p.getNom() + " ");
            }
            System.out.println();
        }

        magasin.SupressionProduitMoinsVendu();

        System.out.println("\nAprès suppression:");
        for (Marque m : magasin.getMarques()) {
            System.out.print("   " + m.getNom() + ": ");
            for (Produit p : m.getProduits()) {
                System.out.print(p.getNom() + " ");
            }
            System.out.println();
        }

        // Test complémentaire: Vérification des ventes
        System.out.println("\n5. 📊 PRODUITS VENDUS (historique):");
        for (String produit : produitsVendus) {
            System.out.print(produit + " ");
        }
        System.out.println();
    }
}