package data;

/**
 * Created by once2go on 19/01/17.
 */
public class FitAddObject {

    private FitElement fitElement;
    private String date;
    private String address;
    private Location location;
    private boolean furnished;
    private String description;
    private String price;
    private String title;

    public FitAddObject(FitElement fitElement, String title, String date, String price, String address,
                        boolean furnished, String description, Location location) {
        this.date = date;
        this.address = address;
        this.location = location;
        this.fitElement = fitElement;
        this.furnished = furnished;
        this.description = description;
        this.price = price;
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public String getAddress() {
        return address;
    }

    public Location getLocation() {
        return location;
    }

    public FitElement getFitElement() {
        return fitElement;
    }


    public boolean isFurnished() {
        return furnished;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "FitAddObject{" +
                "fitElement=" + fitElement +
                ", date='" + date + '\'' +
                ", price='" + price + '\'' +
                ", address='" + address + '\'' +
                ", location=" + location +
                ", furnished=" + furnished +
                ", description='" + description + '\'' +
                '}';
    }
}
