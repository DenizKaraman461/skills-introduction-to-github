public class City {
    private String name;

    public City(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj.getClass().equals(City.class))) {
            return false;
        }
        return name.equals(((City)obj).name);
    }
}
