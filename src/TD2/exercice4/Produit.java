package TD2.exercice4;


import java.util.Objects;

public class Produit {
    private String codeProduit;
    private String categorie;
    private int quantite;
    private boolean enStock;

    // Constructeur avec tous les attributs
    public Produit(String codeProduit, String categorie, int quantite, boolean enStock) {
        this.codeProduit = codeProduit;
        this.categorie = categorie;
        this.quantite = quantite;
        this.enStock = enStock;
    }

    // Getters
    public String getCodeProduit() {
        return codeProduit;
    }

    public String getCategorie() {
        return categorie;
    }

    public int getQuantite() {
        return quantite;
    }

    public boolean isEnStock() {
        return enStock;
    }

    // Setters
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setEnStock(boolean enStock) {
        this.enStock = enStock;
    }
}