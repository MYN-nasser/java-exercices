package TD3.exercice3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Administration extends Personne{
    private int id;
    private ArrayList<Filiere>filiers;

    public Administration(String nom,String prenom,int id,ArrayList<Filiere>filiers){
        super(nom,prenom);
        this.id=id;
        this.filiers=filiers;
    }



    public void saisirAbsences(Enseignant enseignant) {
        int totalAbsences = 0;

        for (Matiere matiere : enseignant.getMatieres()) {
            Map<Groupe, List<Etudiant>> absences = enseignant.envoyerAbsencesPourMatiere(matiere);

            for (Map.Entry<Groupe, List<Etudiant>> entry : absences.entrySet()) {
                List<Etudiant> etudiantsAbsents = entry.getValue();

                for (Etudiant etudiant : etudiantsAbsents) {
                    // Vérifier si l'absence n'existe pas déjà
                    boolean absenceExisteDeja = etudiant.getAbscences().stream()
                            .anyMatch(absence ->
                                    absence.getMatiere().equals(matiere) && absence.getMois() == java.time.LocalDate.now().getMonthValue() && absence.getJour() == java.time.LocalDate.now().getDayOfMonth()
                            );

                    if (!absenceExisteDeja) {
                            // Créer la nouvelle absence
                        etudiant.getAbscences().add(new Abscence(matiere,
                                java.time.LocalDate.now().getMonthValue(),
                                java.time.LocalDate.now().getDayOfMonth()));
                        totalAbsences++;
                    }
                }
            }
        }

            System.out.println("✓ " + totalAbsences + " absences saisies par l'administration");
    }





    public int getId(){return id;}
    public ArrayList<Filiere> getFiliers(){return filiers;}
}
