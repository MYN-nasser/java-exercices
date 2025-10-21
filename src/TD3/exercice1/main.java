package TD3.exercice1;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void afficheraveccondition(List<Personnne> personnes, filtrer condition) {
        for (Personnne p : personnes) {
            if (condition.verifier(p)) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        interfaceCalcule somme = (a, b) ->(a + b);
        interfaceCalcule max = (a, b) -> Math.max(a, b);

        System.out.println("Somme : " + somme.calcule(5, 3));
        System.out.println("Max : " + max.calcule(10, 3));

        // Pour la liste, on garde l'affichage dans le lambda
        List<interfaceCalcule> operations = new ArrayList<>();
        operations.add((a, b) -> (a + b));
        operations.add((a, b) -> (a - b));
        operations.add((a, b) -> (a * b));
        operations.add((a, b) -> Math.max(a, b));
        operations.add((a, b) -> Math.min(a, b));

        // Utilisation de la liste
        System.out.println("\nUtilisation de la liste :");
        for (var x : operations){
            x.calcule(7,9);
        }

        System.out.println("\nMultiplié par 3 :");
        int a = 7, b = 9; // Déclarer a et b
        for (var x : operations) {
            var valeur = x.calcule(a, b);
            System.out.println(valeur * 3);
        }

        List<Personnne>personnes=new ArrayList<>();
        personnes.add(new Personnne("Dupont", "Pierre"));
        personnes.add(new Personnne("Martin", "Alice"));
        personnes.add(new Personnne("Bernard", "Jean"));
        personnes.add(new Personnne("Albert", "Marie"));
        personnes.add(new Personnne("Moreau", "Luc"));
        personnes.add(new Personnne("Andre", "Sophie"));

        personnes.sort((p1,p2) ->p1.getNom().compareTo(p2.getNom())) ;

        // A - Afficher le contenu de la liste
        System.out.println("\n=== CONTENU COMPLET DE LA LISTE ===");
        afficheraveccondition(personnes, p -> true);

        // B - Afficher les gens dont le nom commence par A
        System.out.println("\n=== GENS DONT LE NOM COMMENCE PAR A ===");
        afficheraveccondition(personnes, p -> p.getNom().startsWith("A"));


    }
}