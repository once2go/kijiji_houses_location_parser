package data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by once2go on 01/02/17.
 */
public class RequestData {

    @SerializedName("search_type")
    private String mSearchType;

    @SerializedName("price_from")
    private String mPriceStartFrom;

    @SerializedName("price_till")
    private String mPriceStartTill;

    @SerializedName("lat_start")
    private String mLatitudeStart;

    @SerializedName("lat_end")
    private String mLatitudeEnd;

    @SerializedName("lon_start")
    private String mLongitudeStart;

    @SerializedName("lon_end")
    private String mLongitudeEnd;


    public SearchType getSearchType() {
        return SearchType.getByName(mSearchType);
    }

    public int getPriceStartFrom() {
        return Integer.parseInt(mPriceStartFrom);
    }

    public int getPriceStartTill() {
        return Integer.parseInt(mPriceStartTill);
    }

    public SearchingZone getSearchingZone() {
        return new SearchingZone(mLatitudeStart, mLatitudeEnd, mLongitudeStart, mLongitudeEnd);
    }
}
