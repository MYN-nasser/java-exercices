package TD2.exercice1;

import java.util.*;

public class Hotel {
    private ArrayList<Chambre>chambres;
    private String nom;

    public Hotel(ArrayList<Chambre>chambres,String nom){
        this.chambres=chambres;
        this.nom=nom;
    }
    public ArrayList<Chambre> getChambres() {
        return this.chambres;
    }
    public static void suppression(int num, Hotel hotel){
        for (int i=hotel.chambres.size()-1; i>=0;i--){
            if (hotel.chambres.get(i).getNumChambre()==num){
                if (!hotel.chambres.get(i).getDisponible()){
                    System.out.println("la chambre est reservé,impossible de supprimé cette chambre !!");
                    return;
                }
                hotel.chambres.remove(i);
                System.out.println("la chambre avec numéro: "+num+" a été supprimé avec succée");
            }
        }
    }

    public static void indisponibilite(Hotel hotel){
        for (int i=0;i<hotel.chambres.size();i++){
            if (hotel.chambres.get(i).getCapacite() <3){
                hotel.chambres.get(i).setDisponible(false);
            }
        }
    }

    public static void regroupement(Hotel hotel){
        Map<String, List<Chambre>> map = new HashMap<>();
        for (Chambre ch : hotel.chambres){
            String type = ch.getType();

            if (!map.containsKey(type)){
                map.put(type,new ArrayList<>());
            }
            map.get(type).add(ch);
        }

    }

}
