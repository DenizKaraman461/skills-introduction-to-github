class Route {
    String city1;
    String city2;
    int duration;

    public Route(String city1, String city2, int duration) {
        this.city1 = city1;
        this.city2 = city2;
        this.duration = duration;
    }

@Override
    public String toString() {
        return city1 + " -> " + city2 + "(Time:" + duration + ")";
    }
}