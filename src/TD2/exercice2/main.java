package TD2.exercice2;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static List<Artiste> lesArtistes(List<Guitariste>lstGuit, List<Acteur>lstAct){
        List<Artiste> resultat = new ArrayList<>();

        for (Acteur act:lstAct){
            if (act.getNbFilm()>20){
                resultat.add(act);
            }
        }
        for (Guitariste guit:lstGuit){
            if (guit.AnneeDebut<1998){
                resultat.add(guit);
            }
        }
        return resultat;
    }

    public static void modification(List<Acteur> lstAct, List<Guitariste> lstGuit){
        List<Artiste> artistesSelectionnes = lesArtistes(lstGuit,lstAct);

        for (Artiste art : artistesSelectionnes){
            if (art instanceof Acteur){
              Acteur acteur=(Acteur) art;
              acteur.setNbFilm(acteur.getNbFilm()-2);
            }
            else if(art instanceof Guitariste){
                Guitariste guitariste = (Guitariste) art;
                guitariste.setNbMorceaux(guitariste.getNbMorceaux()+3);
            }
        }
    }

    public static void main(String[] args){
        // Création des listes
        List<Acteur> lstAct = new ArrayList<>();
        List<Guitariste> lstGuit = new ArrayList<>();

        // Ajout de quelques données de test
        lstAct.add(new Acteur(1, "Tom Hanks", 1980, "Drame", 25));
        lstAct.add(new Acteur(2, "Julia Roberts", 1987, "Comédie", 15));

        lstGuit.add(new Guitariste(3, "Eric Clapton", 1963, "Electrique", 150));
        lstGuit.add(new Guitariste(4, "John Mayer", 2001, "Acoustique", 80));

        System.out.println("=== DÉBUT DU TEST ===");

        // Test de lesArtistes
        List<Artiste> resultat = lesArtistes(lstGuit, lstAct);
        System.out.println("Artistes sélectionnés: " + resultat.size());

        // Test de modification
        modification(lstAct, lstGuit);
        System.out.println("Modifications terminées!");

        System.out.println("=== FIN DU TEST ===");
    }


}


