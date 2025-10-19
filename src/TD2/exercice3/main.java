package TD2.exercice3;
import java.util.*;
public class main
{

public static void suppression(int id,Set<Chambre>ch){
  for (Chambre c: ch){
      if (id == c.numChambre){
          System.out.println("chambre trouvé ");
          if (!c.disponible){
              System.out.println("la chambre est réservé on ne peut pas de la supprimé ");
          }else {
              ch.remove(c);
              System.out.println("chambre : "+id+"sipprimé avec succè");
          }
          return;
      }
  }
}
        public static void main(String[] args) {
            // Déclaration du Set
            Set<Chambre> setChambres = new HashSet<Chambre>();

            // Remplissage avec des objets Chambre
            setChambres.add(new Chambre(101, "Simple", 1, true));
            setChambres.add(new Chambre(102, "Double", 2, true));
            setChambres.add(new Chambre(103, "Suite", 4, false));
            setChambres.add(new Chambre(104, "Simple", 1, true));
            setChambres.add(new Chambre(105, "Familiale", 5, true));
            setChambres.add(new Chambre(101, "Simple", 1, true)); // ⚠️ Duplicat ignoré

            for (Chambre h:setChambres){
                if (h.capacite<3){
                    h.disponible=false;
                }
            }

            //premier methode
            Map<String, Set<Chambre>> map = new HashMap<>();
            for (Chambre ch : setChambres){
                String type = ch.type;

                if (!map.containsKey(type)){
                    map.put(type,new HashSet<>());
                }
                map.get(type).add(ch);
            }

            // deuxième méthode
            for (Chambre ch : setChambres) {
                String type = ch.type;
                map.computeIfAbsent(type, k -> new HashSet<>()).add(ch);
            }
        }

}
