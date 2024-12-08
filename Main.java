import java.io.File;
import java.io.FileNotFoundException;
import java.math.RoundingMode;
import java.util.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.readFile("map1.txt");

    }

    public void readFile(String fileName) {
        File file = new File(getClass().getResource(fileName).getPath());

        try {
            Scanner scanner = new Scanner(file);
            //1
            int cityCount = 0;
            if (scanner.hasNextLine()) {
                cityCount = Integer.parseInt(scanner.nextLine().trim());
                System.out.println("There is " + cityCount + " cities");
            }

            //2
            List<String> cityLabels = new ArrayList<>();
            if (scanner.hasNextLine()) {
                String[] labels = scanner.nextLine().trim().split("\\s+");
                cityLabels.addAll(Arrays.asList(labels));
                System.out.println("City Labels: " + cityLabels);
            }

            //3
            int routeCount = 0;
            if (scanner.hasNextLine()) {
                routeCount = Integer.parseInt(scanner.nextLine().trim());
                System.out.println("Route number is " + routeCount);
            }


            //4
            List<Route> routes = new ArrayList<>();
            for (int i = 0; i < routeCount; i++) {
                if (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();
                    String[] parts = line.split("\\s+");
                    String city1 = parts[0];
                    String city2 = parts[1];
                    int duration = Integer.parseInt(parts[2]);
                    routes.add(new Route(city1, city2, duration));
                }
            }

            //5
            String startCity = null, endCity = null;
            if (scanner.hasNextLine()) {
                String[] startEndcities = scanner.nextLine().trim().split("\\s+");
                startCity = startEndcities[0];
                endCity = startEndcities[1];
            }

            System.out.println("Starting city: "+ startCity);
            System.out.println("Ending city: "+ endCity);

            System.out.println("Routes");
            for(Route route : routes) {
                System.out.println(route);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        City city1 = new City("Istanbul",1);
        City city2 = new City("Ankara",2);
        City city3 = new City("Izmir",3);

        CountryMap countryMap = new CountryMap();
        countryMap.addCity(city1);
        countryMap.addCity(city2);
        countryMap.addCity(city3);

        countryMap.addRoute(city1, city2, 450);
        countryMap.addRoute(city2, city3, 350);

        WayFinder wayFinder = new WayFinder(countryMap);
        wayFinder.findShortestPath(city1, city3);
        wayFinder.findFastestRoute(city1, city3);


    }
}

