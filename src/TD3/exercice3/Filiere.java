package TD3.exercice3;

import java.util.ArrayList;

public class Filiere {
    public ArrayList<Groupe>groupes;
    public String nom;

    public Filiere(ArrayList<Groupe>groupes,String nom){
        this.groupes=groupes;
        this.nom=nom;
    }

    public ArrayList<Groupe> getGroupes(){return groupes;}
    public String getNom(){return nom;}
}
