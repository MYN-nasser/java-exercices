package TD1.exercice1;

import java.util.ArrayList;
import java.util.zip.ZipFile;

public class Delegue extends Etudiant {
    protected int numero_telephone;
    protected ArrayList<String>enseignant;
    protected ArrayList<Integer>date_examen;

    public Delegue(String nom,String prenom,ArrayList<String>matieres,ArrayList<Double>note,int numero_telephone, ArrayList<String>enseignant,ArrayList<Integer>date_examen){
        super(nom,prenom,matieres,note);
        this.numero_telephone=numero_telephone;
        this.enseignant=enseignant;
        this.date_examen=date_examen;

    }

    public void ModifierDate(int date , String mat){
        for (int i=0;i<date_examen.size();i++){
            if (date == date_examen.get(i)){
                System.out.println("la date existe déja !!");
                return;
            }
        }

        boolean trouve = false;
        for (int i=0;i<getMatieres().size();i++){
            if (mat.equals(getMatieres().get(i))){
                date_examen.set(i,date);
                trouve = true;
                break;
            }
        }
        if (!trouve){
            System.out.println("la matière n'eciste pas");
        }
    }
}
