package presenter;

import data.KiConfig;
import data.Location;

/**
 * Created by once2go on 20/01/17.
 */
public class LocationMatcher {

    public static boolean isInMatchedZone(Location location) {
        return isMatchedInLatitude(location.getLat()) && isMatchedInLongitude(location.getLon());
    }

    private static boolean isMatchedInLatitude(double latitude) {
        return (KiConfig.LAT_END >= latitude) && (latitude > KiConfig.LAT_START);
    }

    private static boolean isMatchedInLongitude(double longitude) {
        return (longitude <= KiConfig.LON_END ) && (longitude > KiConfig.LON_START);
    }
}
