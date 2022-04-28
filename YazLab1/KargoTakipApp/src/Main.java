
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sİnan
 */
public class Main {
    
   static secondGui ekran = new secondGui();
   static deneme2 deneme=new deneme2();
   static GirisEkrani1 menu3= new GirisEkrani1();
    public static void main(String[] args) {
              
                menu3.setSize(570, 750);
                menu3.setVisible(true);
                for (int i = 0; i <ekran.a ; i++) {
               ekran.initialCities.add(new city(ekran.adlist3.get(i),ekran.adlist.get(i),ekran.adlist2.get(i)));
        }
               Main.deneme.initialCities2.addAll(ekran.initialCities);
               ekran.printShortestRoute(new nearestNeighbor().findShortestRoute((ArrayList<city>) ekran.initialCities));
                
               
    }
}
