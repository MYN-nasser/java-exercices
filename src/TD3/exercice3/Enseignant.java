package TD3.exercice3;

import TD3.exercice1.Personnne;

import java.util.*;

public class Enseignant extends Personne{
    public int id;
    public ArrayList<Matiere>matieres;
    public ArrayList<Groupe>groupes;

    public Enseignant(String nom,String prenom,int id,ArrayList<Matiere>matieres,ArrayList<Groupe>groupes){
        super(nom,prenom);
        this.id=id;
        this.matieres=matieres;
        this.groupes=groupes;
    }

    public void Add_Note(Groupe g,Matiere m){

        for (int i=0;i<groupes.size();i++){
            if (groupes.get(i).equals(g)){
                for (int j=0;j<groupes.get(i).getEtudiants().size();j++){
                    for (int k=0;k<groupes.get(i).getEtudiants().get(j).getMatieres().size();k++){
                        if (groupes.get(i).getEtudiants().get(j).getMatieres().get(k).equals(m)){
                            double n;
                            System.out.println("entrer note");
                            Scanner scanner = new Scanner(System.in);
                            n = scanner.nextDouble();
                            groupes.get(i).getEtudiants().get(j).getMatieres().get(k).setNote(n);
                        }
                    }
                }
            }
        }
    }

    public Map<Groupe, List<Etudiant>> envoyerAbsencesPourMatiere(Matiere matiere) {
        Map<Groupe, List<Etudiant>> absencesParGroupe = new HashMap<>();

        for (Groupe groupe : groupes) {
            List<Etudiant> etudiantsAbsents = new ArrayList<>();

            for (Etudiant etudiant : groupe.getEtudiants()) {
                for (Abscence absence : etudiant.getAbscences()) {
                    if (absence.getMatiere().equals(matiere)) {
                        etudiantsAbsents.add(etudiant);
                        break;
                    }
                }
            }

            if (!etudiantsAbsents.isEmpty()) {
                absencesParGroupe.put(groupe, etudiantsAbsents);
            }
        }

        return absencesParGroupe;
    }

    public void modificationNot(Etudiant etu, Matiere mat, double note) {
        // Vérification directe si l'étudiant a la matière
        if (etu.getMatieres().contains(mat)) {
            for (Matiere m : etu.getMatieres()) {
                if (m.equals(mat)) {
                    m.setNote(note);
                    System.out.println("La note a été modifiée avec succès");
                    return; // On sort après la modification
                }
            }
        } else {
            System.out.println("Matière non trouvée pour cet étudiant");
        }
    }



    // GETTERS
    public int getId() {
        return id;
    }

    public ArrayList<Matiere> getMatieres() {
        return new ArrayList<>(matieres); // Copie défensive
    }

    public ArrayList<Groupe> getGroupes() {
        return new ArrayList<>(groupes); // Copie défensive
    }

    // SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setMatieres(ArrayList<Matiere> matieres) {
        this.matieres = new ArrayList<>(matieres); // Copie défensive
    }

    public void setGroupes(ArrayList<Groupe> groupes) {
        this.groupes = new ArrayList<>(groupes); // Copie défensive
    }

}
