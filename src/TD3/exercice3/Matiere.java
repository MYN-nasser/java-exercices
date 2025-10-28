package TD3.exercice3;

public class Matiere {
    private double coefficient;
    private String nom;
    private double note;
    private double nb_heures;


    public Matiere(String nom, double coefficient, double note, double nb_heures) {
        this.nom = nom;
        this.coefficient = coefficient;
        this.note = note;
        this.nb_heures = nb_heures;
    }

    // GETTERS
    public double getCoefficient() {
        return coefficient;
    }

    public String getNom() {
        return nom;
    }

    public double getNote() {
        return note;
    }

    public double getNb_heures() {
        return nb_heures;
    }

    // SETTERS
    public void setCoefficient(double coefficient) {
        if (coefficient >= 0) {
            this.coefficient = coefficient;
        }
    }

    public void setNom(String nom) {
        if (nom != null && !nom.trim().isEmpty()) {
            this.nom = nom;
        }
    }

    public void setNote(double note) {
        if (note >= 0 && note <= 20) {
            this.note = note;
        }
    }

    public void setNb_heures(double nb_heures) {
        if (nb_heures >= 0) {
            this.nb_heures = nb_heures;
        }
    }

}
