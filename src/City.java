public class City {
    private String name;
    private int cityId;

    public City(String name, int cityId) {
        this.name = name;
        this.cityId = cityId;
    }

    public String getName() {return name;}
    public int getCityId() {return cityId;}
    @Override
    public String toString() {return name;}

}
