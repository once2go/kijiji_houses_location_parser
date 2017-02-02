package data;

/**
 * Created by once2go on 02/02/17.
 */
public class SearchingZone {

    private double mLatitudeStart;
    private double mLatitudeEnd;
    private double mLongitudeStart;
    private double mLongitudeEnd;

    public SearchingZone(String latitudeStart, String latitudeEnd, String longitudeStart, String longitudeEnd) {
        mLatitudeStart = Double.parseDouble(latitudeStart);
        mLatitudeEnd = Double.parseDouble(latitudeEnd);
        mLongitudeStart = Double.parseDouble(longitudeStart);
        mLongitudeEnd = Double.parseDouble(longitudeEnd);
    }

    public double getLatitudeStart() {
        return mLatitudeStart;
    }

    public double getLatitudeEnd() {
        return mLatitudeEnd;
    }

    public double getLongitudeStart() {
        return mLongitudeStart;
    }

    public double getLongitudeEnd() {
        return mLongitudeEnd;
    }
}
