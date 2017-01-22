package data;

/**
 * Created by once2go on 19/01/17.
 */
public class Location {

    private boolean isPostalCode;
    private double lat;
    private double lon;

    public Location(boolean isPostalCode, double lat, double lon) {
        this.isPostalCode = isPostalCode;
        this.lat = lat;
        this.lon = lon;
    }

    public boolean isPostalCode() {
        return isPostalCode;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }


    @Override
    public String toString() {
        return "Location{" +
                "isPostalCode=" + isPostalCode +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
