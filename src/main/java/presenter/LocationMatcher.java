package presenter;

import data.Location;
import data.SearchingZone;

/**
 * Created by once2go on 20/01/17.
 */
public class LocationMatcher {

    public static boolean isInMatchedZone(SearchingZone searchingZone, Location location) {
        return isMatchedInLatitude(searchingZone, location.getLat()) && isMatchedInLongitude(searchingZone, location.getLon());
    }

    private static boolean isMatchedInLatitude(SearchingZone searchingZone, double latitude) {
        return (searchingZone.getLatitudeEnd() >= latitude) && (latitude > searchingZone.getLatitudeStart());
    }

    private static boolean isMatchedInLongitude(SearchingZone searchingZone, double longitude) {
        return (longitude <= searchingZone.getLongitudeEnd()) && (longitude > searchingZone.getLongitudeStart());
    }
}
