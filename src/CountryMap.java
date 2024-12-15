public class CountryMap {
    private City[] cities;
    private Route[] routes;
    private int cityCount;
    private int routeCount;

    public CountryMap(int cityCapacity, int routeCapacity) {
        cities = new City[cityCapacity];
        routes = new Route[routeCapacity];
        cityCount = 0;
        routeCount = 0;
    }

    public void addCity(City city) {
        if (cityCount < cities.length) {
            cities[cityCount++] = city;
        }
    }

    public void addRoute(Route route) {
        if (routeCount < routes.length) {
            routes[routeCount++] = route;
        }
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cities: ");
        for (int i = 0; i < cityCount; i++) {
            sb.append(cities[i].getName()).append(" ");
        }
        sb.append("\nRoutes: ");
        for (int i = 0; i < routeCount; i++) {
            sb.append(routes[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
