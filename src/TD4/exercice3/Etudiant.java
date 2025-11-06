package TD4.exercice3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

    public List<Etudiant> functionreturn(ArrayList<Etudiant>etud, int age, String pr) {
            return  etud.stream().filter(p->p.prenom.equals(pr) && p.age==age).collect(Collectors.toList());
    }

    public List<String> retourneNames(ArrayList<Etudiant> etud) {
        return etud.stream().filter(p-> p.notes.stream().allMatch(n->n>10)).map(p->p.nom).collect(Collectors.toList());
    }

}