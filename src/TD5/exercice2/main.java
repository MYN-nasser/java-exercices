package TD5.exercice2;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class main {

    public static void main(String[] args){

        Set<Produit> produitsSet = new HashSet<>();
        produitsSet.add(new Produit("Laptop", 1200.99, "Électronique"));
        produitsSet.add(new Produit("T-shirt", 25.50, "Vêtement"));
        produitsSet.add(new Produit("Livre", 15.75, "Culture"));
        produitsSet.add(new Produit("Café", 8.30, "Alimentation"));
        produitsSet.add(new Produit("Smartphone", 899.99, "Électronique"));


        Set<Produit>result = produitsSet.stream().filter(p->p.prix < 10).map(p-> new Produit(p.nom,p.prix-(p.prix*0.1),p.categorie)).peek(p->System.out.println(p)).collect(Collectors.toSet());
    }
}
