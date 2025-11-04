package TD5.exercice3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        // Création des objets Produit pour les tests
        List<Produit> produits = Arrays.asList(
                new Produit("Laptop123", 1200.99, "Electronique", 2023, Arrays.asList(4, 5, 3, 4)),
                new Produit("Smartphone456", 899.99, "Electronique", 2024, Arrays.asList(5, 5, 4, 3, 5)),
                new Produit("Chaise789", 150.00, "meuble", 2022, Arrays.asList(3, 2, 4)),
                new Produit("Table012", 320.50, "meuble", 2023, Arrays.asList(4, 4, 5, 3)),
                new Produit("Roman345", 15.75, "librairie", 2024, Arrays.asList(5, 4, 5, 5, 4)),
                new Produit("Cahier678", 8.30, "librairie", 2023, Arrays.asList(3, 3, 2)),
                new Produit("Casque901", 89.99, "Electronique", 2024, Arrays.asList(4, 4, 3, 5)),
                new Produit("Armoire234", 450.00, "meuble", 2022, Arrays.asList(2, 3, 1, 2)),
                new Produit("Dictionnaire567", 25.50, "librairie", 2023, Arrays.asList(4, 4, 3)),
                new Produit("Tablette890", 650.00, "Electronique", 2024, Arrays.asList(5, 4, 5, 4, 5))
        );

        //stream 1 :
        Set<Produit> prd = produits.stream().filter(p->p.anneFabric>=2021).map(p-> {
            String newid = p.categorie.substring(0,3).toUpperCase()+"-"+p.id;
            p.id=newid;
            return p;
        }).peek(p-> System.out.println(p)).collect(Collectors.toSet());

        //stream 2 :
        Set<Produit> prd2 = produits.stream().filter(p -> p.prix < 2000 && p.categorie.equals("Electronique"))
                .map(p -> new Produit(
                        p.nom,
                        p.prix - (p.prix * 0.15),  // Application de la remise
                        p.categorie,
                        p.anneFabric,
                        p.evaluations
                ))
                .filter(p -> p.categorie.equals("librairie")).collect(Collectors.toSet());

        List<Produit> prd3 = produits.stream().filter(p->p.categorie.equals("meuble"))
                .map(p->new Produit(p.nom,p.prix-(p.prix*0.1),p.categorie,p.anneFabric,p.evaluations))

                .filter(p -> p.evaluations.size() > 20 &&
                        p.evaluations.stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0.0) <= 2.0)

                .map(p -> new Produit(
                p.nom + "ME",  // Concaténation de "ME"
                    p.prix,
                    p.categorie,
                    p.anneFabric,
                    p.evaluations))

                .filter(p -> {
                    long countZeros = p.evaluations.stream().filter(eval -> eval == 0).count();
                    return countZeros >= 7;
                })
                .collect(Collectors.toList());
    }
}
