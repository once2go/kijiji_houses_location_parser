package data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by once2go on 02/02/17.
 */
public class FitResponse {

    @SerializedName("id")
    private int mAddId;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("link")
    private String mLink;

    @SerializedName("price")
    private String mPrice;


    public FitResponse(FitAddObject fitAddObject) {
        mAddId = fitAddObject.getFitElement().getAddid();
        mLink = KiConfig.SERVER_URL + fitAddObject.getFitElement().getLink();
        mPrice = fitAddObject.getPrice();
        mTitle = fitAddObject.getTitle();
    }
}
