package TD1.exercice1;

import java.util.ArrayList;

public class Groupe {
    private String nom;
    private ArrayList<Etudiant>etudiants;
    private String filiere;

    public Groupe(String nom,ArrayList<Etudiant>etudiants,String filiere){
        this.etudiants=etudiants;
        this.nom=nom;
        this.filiere=filiere;
    }

    public void MoyenneGroupe(){
        double somme=0;
        for (Etudiant e : etudiants){
            somme+=e.Moyenne();
        }
        System.out.println("la moyenne du groupe est : "+ somme/etudiants.size());
    }

    public int NbValidation(String mat){
       int  nb=0;
       for (Etudiant e: etudiants){
           for (int i=0;i<e.getMatieres().size();i++){
               if (mat.equals(e.getMatieres().get(i))){
                   if (e.getNote().get(i)>=10){
                       nb++;
                   }
               }
           }
       }
        return nb;
    }
}
