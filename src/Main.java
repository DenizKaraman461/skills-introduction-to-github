import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Main <input_file> <output_file>");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        try (Scanner readInput = new Scanner(Paths.get(inputFile));
             FileWriter outputWriter = new FileWriter(outputFile)) {

            // Şehir bilgilerini al
            int cityCount = Integer.parseInt(readInput.nextLine().trim());
            String[] cityNames = readInput.nextLine().trim().split(" ");

            City[] cities = new City[cityCount];
            for (int i = 0; i < cityCount; i++) {
                cities[i] = new City(cityNames[i]);
            }

            // Rota bilgilerini al
            int routeCount = Integer.parseInt(readInput.nextLine().trim());
            Route[] routes = new Route[routeCount];

            for (int i = 0; i < routeCount; i++) {
                String[] routeData = readInput.nextLine().trim().split(" ");
                City city1 = new City(routeData[0]);
                City city2 = new City(routeData[1]);
                int time = Integer.parseInt(routeData[2]);
                routes[i] = new Route(city1, city2, time);
            }

            // Başlangıç ve bitiş şehirlerini al
            String[] startAndEnd = readInput.nextLine().trim().split(" ");
            String startCity = startAndEnd[0];
            String endCity = startAndEnd[1];

            System.out.println("File read is successful!");

            CountryMap countryMap = new CountryMap(cities, routes, cityCount, routeCount, startCity, endCity);
            WayFinder wayFinder = new WayFinder(countryMap);

            City start = new City(countryMap.getStartCity());
            City end = new City(countryMap.getEndCity());

            City[] fastestRoute = wayFinder.findFastestRoute(start, end);

            // Çıktıyı yazdırma
            if (fastestRoute.length > 0) {
                StringBuilder result = new StringBuilder();
                result.append("Fastest Way: ");
                for (int i = 0; i < fastestRoute.length; i++) {
                    result.append(fastestRoute[i].getName());
                    if (i < fastestRoute.length - 1) {
                        result.append(" -> ");
                    }
                }
                result.append("\n");

                int totalTime = wayFinder.calculateTotalTime(fastestRoute);
                result.append("Total Time: ").append(totalTime).append(" min");

                // Konsola yazdır
                System.out.println(result);

                // Output dosyasına yaz
                outputWriter.write(result.toString());
                System.out.println("Output written to: " + outputFile);
            } else {
                System.out.println("No route found.");
                outputWriter.write("No route found.");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
