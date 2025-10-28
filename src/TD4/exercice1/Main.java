package TD4.exercice1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);
        lst.add(5);
        lst.add(6);

        // question 1
        int somme = lst.stream().mapToInt(n->n).sum();
        System.out.println("Somme: " + somme);

        // question 2
        double moyenne = lst.stream().mapToInt(n -> n).average().getAsDouble();
        System.out.println("Moyenne: " + moyenne);

        ArrayList<String> StrLst = new ArrayList<>();
        StrLst.add("SAID");
        StrLst.add("MOHAMED");
        StrLst.add("OUSSAMA");
        StrLst.add("AYMANE");
        StrLst.add("MOUAD");
        StrLst.add("ZAKARIA");
        StrLst.add("SAAD");

        // question 3
        List<String> majuscules = StrLst.stream().map(mot->mot.toLowerCase()).collect(Collectors.toList());
        System.out.println("la liste in lowercases ==> "+StrLst );

        //question 4
        int som= lst.stream().mapToInt(n->n).sum();

        // question5
        List<Integer> resultat = lst.stream().distinct().collect(Collectors.toList());

        //question 6
        long  compte = StrLst.stream().filter(s -> s != null && !s.isEmpty()).filter(s -> s.charAt(0) == 'J').count();

        //question 7
        List<String> Croissant = StrLst.stream().sorted().collect(Collectors.toList());
        System.out.println("Résultat ==>" + Croissant);

        List<String> Decroissante = StrLst.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("Résultat ==>" + Decroissante);

        //question 8
        int max = lst.stream().mapToInt(x->x).max().orElse(0);
        int min = lst.stream().mapToInt(x->x).min().orElse(0);
        //question 9
        int NextMax = lst.stream().skip(1).mapToInt(x->x).max().orElse(0);
        int NextMin = lst.stream().skip(1).mapToInt(x->x).min().orElse(0);
    }

}