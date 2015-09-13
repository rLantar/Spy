package lantar.spy.entity;

/**
 * Created by Lantar on 08.09.2015.
 */
public class Route {

    private String objectId;
    private int number;
    private String name;
    private int route;


    public Route(String objectId, int number, String name, int route) {
        this.objectId = objectId;
        this.number = number;
        this.name = name;
        this.route = route;
    }

    public Route() {
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoute() {
        return route;
    }

    public void setRoute(int route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Route{" +
                "objectId='" + objectId + '\'' +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", route=" + route +
                '}';
    }
}
