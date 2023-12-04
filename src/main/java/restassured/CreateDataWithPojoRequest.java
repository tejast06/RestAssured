package restassured;

public class CreateDataWithPojoRequest {

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getlocation() {
        return Location;
    }

    public void setLOcation(String location) {
        Location = location;
    }

    String Name;
    String Location;
}
