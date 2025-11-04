package TD5.exercice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args){
        //Exercice1 :
        List<String>mois = Arrays.asList("janvier", "fevrier","mars","avrile","mai","juin","juillet","aout","septembre","octobre","novembre","decembre");
        List<String> result =  mois.stream().filter(m->!m.contains("a")).map(m->m.toUpperCase()).peek(m->System.out.println(m)).collect(Collectors.toList());


    }
}
