package TD1.exercice1;

import java.util.ArrayList;

public class Etudiant {
    private String nom;
    private String prenom;
    private ArrayList<String>matieres;
    private ArrayList<Double>note;
    private int absence;
    public Etudiant(){}
    public Etudiant(String nom, String prenom, ArrayList<String>matieres, ArrayList<Double>note ){
        this.nom=nom;
        this.prenom = prenom;
        this.matieres=matieres;
        this.note=note;
        this.absence=0;
    }

    public ArrayList<String> getMatieres() {
        return matieres;
    }
    public ArrayList<Double> getNote(){
        return note;
    }

    public void SetInfo(String mat, double mark){

        for (int i=0; i<matieres.size();i++){
            if(mat.equals(matieres.get(i)) ){
                return;
            }
        }

        matieres.add(mat);
        note.add(mark) ;
        System.out.println("la matiere a été ajouter avec succée ");
    }

    public void Affichage(){
        System.out.println("étudiant : "+nom +" "+prenom);
        System.out.println("nb absence : "+absence);
        System.out.println("  matière  || note");
        for (int i=0; i< matieres.size();i++){
            System.out.println(matieres.get(i) + note.get(i));
        }
    }

    public double Moyenne(){
        double somme=0;

      for (double n : note){
          somme +=n;
      }
      return somme / note.size();
    }

    public void Suppression(){
        for (int i = note.size() - 1; i >= 0; i--){
            if (note.get(i) <10){
                note.remove(i);
                matieres.remove(i);
            }
        }
    }



}
