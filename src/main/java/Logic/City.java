package Logic;

public class City implements Comparable {

    private String name;
    private int city_id;

    public City(String name , int city_id) {

        this.name = name;
        this.city_id = city_id;
    }

    public City() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    @Override
    public String toString() {
        return  city_id + " " + name ;
    }

    @Override
    public int compareTo(Object o) {

        return this.name.compareTo(((City) o).name);
    }
}
