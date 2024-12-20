import java.util.Scanner;

class CountryMap {
    private City[] cities;
    private Route[] routes;
    private int cityCount;
    private int routeCount;
    private String startCity;
    private String endCity;

    public CountryMap(City[] cities, Route[] routes, int cityCount, int routeCount, String startCity, String endCity) {
        this.cities = cities;
        this.routes = routes;
        this.cityCount = cityCount;
        this.routeCount = routeCount;
        this.startCity = startCity;
        this.endCity = endCity;
    }

    public static CountryMap createCountryMap() {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter number of cities: ");
        int cityCount = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Enter city labels separated by space: ");
        String[] cityNames = scanner.nextLine().trim().split(" ");

        City[] cities = new City[cityCount];
        for (int i = 0; i < cityCount; i++) {
            cities[i] = new City(cityNames[i]);
        }


        System.out.print("Enter number of routes: ");
        int routeCount = Integer.parseInt(scanner.nextLine().trim());

        Route[] routes = new Route[routeCount];
        System.out.println("Enter routes in format <City1> <City2> <Time>: ");
        for (int i = 0; i < routeCount; i++) {
            String[] routeData = scanner.nextLine().trim().split(" ");
            City city1 = new City(routeData[0]);
            City city2 = new City(routeData[1]);
            int time = Integer.parseInt(routeData[2]);
            routes[i] = new Route(city1, city2, time);
        }


        System.out.println("Enter start and end city: ");
        String[] startAndEnd = scanner.nextLine().trim().split(" ");
        String startCity = startAndEnd[0];
        String endCity = startAndEnd[1];

        System.out.println("Input is successful!");
        return new CountryMap(cities, routes, cityCount, routeCount, startCity, endCity);
    }

    public String getStartCity() {
        return startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public City[] getCities() {
        return cities;
    }

    public Route[] getRoutes() {
        return routes;
    }

    public int getCityCount() {
        return cityCount;
    }

    public int getRouteCount() {
        return routeCount;
    }
}
