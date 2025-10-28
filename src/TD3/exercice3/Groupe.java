package TD3.exercice3;

import java.util.ArrayList;

public class Groupe {
    private String nom;
    private ArrayList<Etudiant>etudiants;

    public Groupe(String nom,ArrayList<Etudiant>etudiants){
        this.nom=nom;
        this.etudiants=etudiants;
    }

    public String getNom() {
        return nom;
    }

    public ArrayList<Etudiant> getEtudiants() {
        return new ArrayList<>(etudiants); // Copie défensive
    }
}
