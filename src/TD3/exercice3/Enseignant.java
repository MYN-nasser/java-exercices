package TD3.exercice3;

import TD3.exercice1.Personnne;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
