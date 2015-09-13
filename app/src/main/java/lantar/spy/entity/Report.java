package lantar.spy.entity;

import java.util.Date;

/**
 * Created by Lantar on 07.09.2015.
 */
public class Report {

    private String start;
    private String finish;
    private String objectId;
    private String name;
    private int number;
    private int countMember;
    private String raiting;
    private int route;
    private String descrioption;
    private boolean violation;
    private String spyName;
    private String violationDescriprion;
    private String ulrSpyRepozitory;
    private String urlFile;
    private String violationsMarks;
    private int brigade;
    private Date createAt;


    public Report(String start, String finish, String objectId, String name, int number, int countMember, String raiting, int route, String descrioption, boolean violation) {
        this.start = start;
        this.finish = finish;
        this.objectId = objectId;
        this.name = name;
        this.number = number;
        this.countMember = countMember;
        this.raiting = raiting;
        this.route = route;
        this.descrioption = descrioption;
        this.violation = violation;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public int getBrigade() {
        return brigade;
    }

    public void setBrigade(int brigade) {
        this.brigade = brigade;
    }

    public String getViolationsMarks() {
        return violationsMarks;
    }

    public void setViolationsMarks(String violationsMarks) {
        this.violationsMarks = violationsMarks;
    }

    public String getViolationDescriprion() {
        return violationDescriprion;
    }

    public void setViolationDescriprion(String violationDescriprion) {
        this.violationDescriprion = violationDescriprion;
    }

    public String getUlrSpyRepozitory() {
        return ulrSpyRepozitory;
    }

    public void setUlrSpyRepozitory(String ulrSpyRepozitory) {
        this.ulrSpyRepozitory = ulrSpyRepozitory;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public String getSpyName() {
        return spyName;
    }

    public void setSpyName(String spyName) {
        this.spyName = spyName;
    }

    public Report() {
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCountMember() {
        return countMember;
    }

    public void setCountMember(int countMember) {
        this.countMember = countMember;
    }

    public String getRaiting() {
        return raiting;
    }

    public void setRaiting(String raiting) {
        this.raiting = raiting;
    }

    public int getRoute() {
        return route;
    }

    public void setRoute(int route) {
        this.route = route;
    }

    public String getDescrioption() {
        return descrioption;
    }

    public void setDescrioption(String descrioption) {
        this.descrioption = descrioption;
    }

    public boolean isViolation() {
        return violation;
    }

    public void setViolation(boolean violation) {
        this.violation = violation;
    }

    @Override
    public String toString() {
        return "Report{" +
                "start=" + start +
                ", finish=" + finish +
                ", objectId='" + objectId + '\'' +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", countMember=" + countMember +
                ", raiting=" + raiting +
                ", route=" + route +
                ", descrioption='" + descrioption + '\'' +
                ", violation=" + violation +
                '}';
    }
}
