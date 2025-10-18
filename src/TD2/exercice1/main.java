package TD2.exercice1;

import java.util.*;

public class main {
    public static void main(String[] args) {
        // Déclaration et remplissage de la liste
        List<Chambre> lstChambres = new ArrayList<Chambre>();

        // Remplir la liste avec des chambres variées
        lstChambres.add(new Chambre(101, "Simple", 1, true));
        lstChambres.add(new Chambre(102, "Double", 2, true));
        lstChambres.add(new Chambre(103, "Suite", 4, false));  // Réservée
        lstChambres.add(new Chambre(104, "Simple", 1, true));
        lstChambres.add(new Chambre(105, "Double", 2, true));
        lstChambres.add(new Chambre(201, "Familiale", 5, true));

        // Créer l'hôtel
        Hotel hotel = new Hotel((ArrayList<Chambre>) lstChambres, "Mon Hotel");

        System.out.println("=== TEST DES FONCTIONNALITÉS ===");

        // 1. Afficher les chambres initiales
        System.out.println("\n1. CHAMBRES INITIALES:");
        afficherChambres(hotel);

        // 2. Tester la suppression
        System.out.println("\n2. TEST SUPPRESSION:");
        System.out.println("Suppression chambre 102 (disponible):");
        Hotel.suppression(102, hotel);

        System.out.println("\nSuppression chambre 103 (réservée):");
        Hotel.suppression(103, hotel);

        System.out.println("\nSuppression chambre 999 (inexistante):");
        Hotel.suppression(999, hotel);

        // 3. Afficher après suppression
        System.out.println("\n3. CHAMBRES APRÈS SUPPRESSION:");
        afficherChambres(hotel);

        // 4. Tester l'indisponibilité
        System.out.println("\n4. TEST INDISPONIBILITÉ (capacité < 3):");
        Hotel.indisponibilite(hotel);
        System.out.println("Après application de l'indisponibilité:");
        afficherChambres(hotel);

        // 5. Tester le regroupement
        System.out.println("\n5. TEST REGROUPEMENT:");
        Hotel.regroupement(hotel);
        // Note: Votre méthode ne retourne pas la Map, donc on ne peut pas afficher le résultat
        System.out.println("Regroupement effectué (méthode void)");
    }

    // Méthode utilitaire pour afficher les chambres
    public static void afficherChambres(Hotel hotel) {
        for (Chambre chambre : hotel.getChambres()) {
            String statut = chambre.getDisponible() ? "Disponible" : "Réservée";
            System.out.println("Chambre " + chambre.getNumChambre() +
                    " | " + chambre.getType() +
                    " | Capacité: " + chambre.getCapacite() +
                    " | " + statut);
        }
        System.out.println("Total: " + hotel.getChambres().size() + " chambres");
    }
}