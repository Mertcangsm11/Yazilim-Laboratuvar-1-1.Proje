
import java.util.ArrayList;
import java.util.Arrays;


public class nearestNeighbor {

public Route findShortestRoute(ArrayList<city> cities){
    ArrayList<city> shortestRouteCities = new ArrayList<city>(cities.size());
    System.out.println("--------------------------------------------------------------------");
    System.out.println("Initial Route            ==> "+ Arrays.toString(cities.toArray()));
    System.out.println("w/ total distance: "+ new Route(cities).calculateTotalDistance());
    System.out.println("--------------------------------------------------------------------");
    city city2 = cities.get((int)(cities.size()*Math.random()));
    updateRoutes(shortestRouteCities, cities, city2);
    while(cities.size()>= 1){
        city2 = getNextCity(cities,city2);
        updateRoutes(shortestRouteCities, cities, city2);
    }
    return new Route(shortestRouteCities);
}    

    private void updateRoutes(ArrayList<city> shortestRouteCities, ArrayList<city> cities, city city2) {
        shortestRouteCities.add(city2);
        cities.remove(city2);
        System.out.println("En Kısa Rota: "+ Arrays.toString(shortestRouteCities.toArray()));
        System.out.println("Kalan Şehirler: "+ Arrays.toString(cities.toArray())+"\n");
    }

    private city getNextCity(ArrayList<city> cities, city city2) {
        return cities.stream().min((citya,cityb) -> {
            int flag = 0;
            if(citya.measuredistance(city2) < cityb.measuredistance(city2)) flag = -1;
            else if(citya.measuredistance(city2) > cityb.measuredistance(city2)) flag = 1;
            return flag;
        }).get();
    }
}
