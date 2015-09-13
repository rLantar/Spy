package lantar.spy.entity;

/**
 * Created by Lantar on 07.09.2015.
 */
public class Spy {

    private String objectId;
    private String fio;
    private String email;
    private String pass;
    private String phone;
    private String Url;
    private int route;
    private String role;
    private int Brigade;


    public Spy(String objectId, String fio, String email, String pass, String phone, int route) {
        this.objectId = objectId;
        this.fio = fio;
        this.email = email;
        this.pass = pass;
        this.phone = phone;
        this.route = route;
    }

    public int getBrigade() {
        return Brigade;
    }

    public void setBrigade(int brigade) {
        Brigade = brigade;
    }

    public Spy() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getId() {
        return objectId;
    }

    public void setId(String objectId) {
        this.objectId = objectId;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRoute() {
        return route;
    }

    public void setRoute(int route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Spy{" +
                "objectId='" + objectId + '\'' +
                ", fio='" + fio + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", phone='" + phone + '\'' +
                ", route=" + route +
                '}';
    }
}
