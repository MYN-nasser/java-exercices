package TD3.exercice3;

import java.util.ArrayList;

public class Abscence {
    private Matiere matiere;
    private int mois;
    private int jour;

    public Abscence(Matiere matiere, int mois, int jour) {
        this.matiere = matiere;
        this.mois=mois;
        this.jour=jour;
    }

    // GETTERS
    public Matiere getMatiere() {
        return matiere;
    }

    public int getMois() {
        return mois;
    }

    public int getJour() {
        return jour;
    }

    // SETTERS
    public void setMatiere(Matiere matiere) {
        if (matiere != null) {
            this.matiere = matiere;
        }
    }

    public void setMois(int mois) {
        if (mois >= 1 && mois <= 12) {
            this.mois = mois;
        }
    }

    public void setJour(int jour) {
        if (jour >= 1 && jour <= 31) {
            this.jour = jour;
        }
    }

}
