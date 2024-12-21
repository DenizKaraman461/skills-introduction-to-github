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
