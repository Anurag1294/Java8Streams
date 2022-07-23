import java.util.List;

public class Institute {
    String name;
    List<String> locations;

    public Institute() {
    }

    public Institute(String name, List<String> locations) {
        this.name = name;
        this.locations = locations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }
}
