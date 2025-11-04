package TD4.exercice2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class Etudiant {

    public int id;
    public String nom;
    public String prenom;
    public int age;
    public String groupe;
    public double moyenne;

    public Etudiant(int id,String nom,String prenom,int age,String groupe,double moyenne){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.age=age;
        this.groupe=groupe;
        this.moyenne=moyenne;
    }

    public static void main(String[] args){

        //question 1
        List<Etudiant> lst = new ArrayList<>();
        Etudiant e1 = new Etudiant(1, "Dupont", "Jean", 20, "Groupe A", 15.5);
        Etudiant e2 = new Etudiant(2, "Martin", "Marie", 21, "Groupe B", 16.2);
        Etudiant e3 = new Etudiant(3, "Bernard", "Pierre", 19, "Groupe A", 14.8);
        Etudiant e4 = new Etudiant(4, "Dubois", "Sophie", 22, "Groupe C", 17.1);
        Etudiant e5 = new Etudiant(5, "Moreau", "Luc", 20, "Groupe B", 13.9);

        lst.add(e1);
        lst.add(e2);
        lst.add(e3);
        lst.add(e4);
        lst.add(e5);

        //question 2
        List<String>lstNom = lst.stream().map(x->x.nom).toList();

        //question 3
        Map<Integer,Etudiant> mapEtud = lst.stream().collect(toMap(e->e.id,e->e));

        //question 4
        double moyenne= lst.stream().mapToDouble(e->e.moyenne).average().orElse(0.0);;

        //question 5
        Map<String, List<String>> etudiantsParGroupe = lst.stream().collect(groupingBy(e -> e.groupe,mapping(e -> e.nom, toList())));

    }
}


