package TD3.exercice3;

import java.util.ArrayList;

public class Etudiant extends Personne {
    private int niveau;
    private int id;
    private int groupe;
    private String filiere;
    private ArrayList<Matiere> matieres;
    private ArrayList<Abscence> abscences;

    public Etudiant(String nom, String prenom, int id, int niveau, int groupe, String filiere){
        super(nom,prenom);
        this.id=id;
        this.niveau=niveau;
        this.groupe=groupe;
        this.filiere = filiere;
        this.matieres = new ArrayList<>();
        this.abscences = new ArrayList<>();
    }

    public void Affichage(){
        System.out.println("nom: "+nom);
        System.out.println("prenom: "+prenom);
        System.out.println("niveau: "+niveau);
        System.out.println("id: "+id);
        System.out.println("groupe: "+groupe);
        System.out.println("filiere: "+filiere);
        System.out.println("Ces Matieres => ");
        for(Matiere m :matieres){
            System.out.println("matiere : "+m.getNom()+"coeff: "+m.getCoefficient()+"note: "+m.getNote()+"nb-heures: "+m.getNb_heures());
        }
        for (Abscence abs:abscences){
            System.out.println("matiere: "+abs.getMatiere()+"mois :"+abs.getMois()+"jour"+abs.getJour());
        }
    }

    public String justifier_abscence(String justif){
        System.out.println(justif);
        return justif;
    }


    // GETTERS
    public int getNiveau() {
        return niveau;
    }

    public int getId() {
        return id;
    }

    public int getGroupe() {
        return groupe;
    }

    public String getFiliere() {
        return filiere;
    }

    public ArrayList<Matiere> getMatieres() {
        return new ArrayList<>(matieres); // Copie défensive
    }

    public ArrayList<Abscence> getAbscences() {
        return new ArrayList<>(abscences); // Copie défensive
    }

    // SETTERS
    public void setNiveau(int niveau) {
        if (niveau >= 1 && niveau <= 5) {
            this.niveau = niveau;
        }
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public void setGroupe(int groupe) {
        if (groupe >= 1) {
            this.groupe = groupe;
        }
    }

    public void setFiliere(String filiere) {
        if (filiere != null && !filiere.trim().isEmpty()) {
            this.filiere = filiere;
        }
    }

    public void setMatieres(ArrayList<Matiere> matieres) {
        if (matieres != null) {
            this.matieres = new ArrayList<>(matieres);
        }
    }

    public void setAbscences(ArrayList<Abscence> abscences) {
        if (abscences != null) {
            this.abscences = new ArrayList<>(abscences);
        }
    }
}
