package TD4.exercice3;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Etudiant {

        private int id;
        private String nom;
        private String prenom;
        private int age;
        private String groupe;
        private ArrayList<Double> notes; // Matière → Note

        public Etudiant(int id, String nom, String prenom, int age, String groupe, ArrayList<Double> notes) {
            this.id = id;
            this.nom = nom;
            this.prenom = prenom;
            this.age = age;
            this.groupe = groupe;
            this.notes = notes;
        }

    public ArrayList<Etudiant> functionreturn(ArrayList<Etudiant>etud,int age, String pr) {
        return etud.stream()
                .filter(etudiant -> etudiant.age == age && etudiant.prenom.equals(pr));

    }

}