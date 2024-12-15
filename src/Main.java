import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.readFile("map1.txt");
    }

    public void readFile(String fileName) {
        try {
            File file = new File(getClass().getResource(fileName).getPath());
            Scanner scanner = new Scanner(file);

            //1
            int cityCount = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Number of cities: " + cityCount);

            //2
            String[] cities = scanner.nextLine().trim().split(" ");
            System.out.println("City labels: ");
            for (String city : cities) {
                System.out.print(city + " ");
            }
            System.out.println();

            //3
            int routeCount = Integer.parseInt(scanner.nextLine().trim());
            System.out.println("Number of routes: " + routeCount);

            System.out.println("Routes:");
            for (int i = 0; i < routeCount; i++) {
                String route = scanner.nextLine().trim();
                System.out.println(route);
            }

            //4
            String[] startAndEnd = scanner.nextLine().trim().split(" ");
            String startCity = startAndEnd[0];
            String endCity = startAndEnd[1];
            System.out.println("Start city: " + startCity);
            System.out.println("End city: " + endCity);

            System.out.println("File read is successful!");
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format in file.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
