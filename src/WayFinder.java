import java.util.Arrays;

public class WayFinder {
    private CountryMap countryMap;

    public WayFinder(CountryMap countryMap) {
        this.countryMap = countryMap;
    }

    public City[] findFastestRoute(City startCity, City endCity) {
        int cityCount = countryMap.getCityCount();
        City[] cities = countryMap.getCities();
        Route[] routes = countryMap.getRoutes();

        int startIndex = -1;
        int endIndex = -1;

        for (int i = 0; i < cityCount; i++) {
            if (cities[i].getName().equals(startCity.getName())) {
                startIndex = i;
            }
            if (cities[i].getName().equals(endCity.getName())) {
                endIndex = i;
            }
        }

        if (startIndex == -1 || endIndex == -1) {
            System.out.println("Error: Start or End city not found.");
            return new City[0];
        }

        boolean[] visited = new boolean[cityCount];
        int[] distances = new int[cityCount];
        int[] previous = new int[cityCount];

        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(previous, -1);
        distances[startIndex] = 0;

        for (int i = 0; i < cityCount; i++) {

            int currentCityIndex = findMinimumDistanceCity(distances, visited);

            if (currentCityIndex == -1) {
                break;
            }

            visited[currentCityIndex] = true;


            for (Route route : routes) {
                int neighborIndex = -1;
                if (route.getCity1().equals(cities[currentCityIndex])) {
                    neighborIndex = findCityIndex(route.getCity2());
                } else if (route.getCity2().equals(cities[currentCityIndex])) {
                    neighborIndex = findCityIndex(route.getCity1());
                }

                if (neighborIndex != -1 && !visited[neighborIndex]) {
                    int newDistance = distances[currentCityIndex] + route.getTime();
                    if (newDistance < distances[neighborIndex]) {
                        distances[neighborIndex] = newDistance;
                        previous[neighborIndex] = currentCityIndex;
                    }
                }
            }
        }


        return constructRoute(previous, startIndex, endIndex, cities);
    }

    private int findMinimumDistanceCity(int[] distances, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && distances[i] < minDistance) {
                minDistance = distances[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private int findCityIndex(City city) {
        for (int i = 0; i < countryMap.getCityCount(); i++) {
            if (countryMap.getCities()[i].equals(city)) {
                return i;
            }
        }
        return -1;
    }

    private City[] constructRoute(int[] previous, int startIndex, int endIndex, City[] cities) {
        if (previous[endIndex] == -1) {
            System.out.println("No route found between the cities.");
            return new City[0];
        }

        int currentIndex = endIndex;
        City[] route = new City[cities.length];
        int routeLength = 0;

        while (currentIndex != -1) {
            route[routeLength++] = cities[currentIndex];
            currentIndex = previous[currentIndex];
        }


        City[] shortestRoute = new City[routeLength];
        for (int i = 0; i < routeLength; i++) {
            shortestRoute[i] = route[routeLength - 1 - i];
        }

        return shortestRoute;
    }
    public int calculateTotalTime(City[] route) {
        int totalTime = 0;
        for (int i = 0; i < route.length - 1; i++) {
            for (Route r : countryMap.getRoutes()) {
                if ((r.getCity1().equals(route[i]) && r.getCity2().equals(route[i + 1])) ||
                        (r.getCity2().equals(route[i]) && r.getCity1().equals(route[i + 1]))) {
                    totalTime += r.getTime();
                    break;
                }
            }
        }
        return totalTime;
    }

}