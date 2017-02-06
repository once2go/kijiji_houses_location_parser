package data;

/**
 * Created by once2go on 02/02/17.
 */
public class SearchingZone {

    private String mLatitudeStart;
    private String mLatitudeEnd;
    private String mLongitudeStart;
    private String mLongitudeEnd;

    public SearchingZone(String latitudeStart, String latitudeEnd, String longitudeStart, String longitudeEnd) {
        mLatitudeStart = latitudeStart;
        mLatitudeEnd = latitudeEnd;
        mLongitudeStart = longitudeStart;
        mLongitudeEnd = longitudeEnd;
    }

    public double getLatitudeStart() {
        try {
            return Double.parseDouble(mLatitudeStart);
        } catch (Exception e) {
            return -1;
        }
    }

    public double getLatitudeEnd() {
        try {
            return Double.parseDouble(mLatitudeEnd);
        } catch (Exception e) {
            return -1;
        }
    }

    public double getLongitudeStart() {
        try {
            return Double.parseDouble(mLongitudeStart);
        } catch (Exception e) {
            return -1;
        }
    }

    public double getLongitudeEnd() {
        try {
            return Double.parseDouble(mLongitudeEnd);
        } catch (Exception e) {
            return -1;
        }
    }
}
