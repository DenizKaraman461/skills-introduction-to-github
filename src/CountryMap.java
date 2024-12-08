import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryMap {
    private List<City> cities;
    private Map<Integer, Map<Integer, Integer>> routes;

    public CountryMap() {
        cities = new ArrayList<>();
        routes = new HashMap<>();
    }

    public void addCity(City city) {
        cities.add(city);
        routes.put(city.getCityId(), new HashMap<>());
    }

    public void addRoute(City city1, City city2, int distance) {
        routes.get(city1.getCityId()).put(city2.getCityId(), distance);
        routes.get(city2.getCityId()).put(city1.getCityId(), distance);
    }

    public Map<Integer, Integer> getNeighbors(City city) {
        return routes.get(city.getCityId());
    }

    public List<City> getCities() {return cities;}
}