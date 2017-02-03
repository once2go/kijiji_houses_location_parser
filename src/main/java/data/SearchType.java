package data;

/**
 * Created by once2go on 01/02/17.
 */
public enum SearchType {

    CONDOS("condos"),
    ROOMS("rooms"),
    HOUSES("houses");

    private String mType;

    SearchType(String type) {
        mType = type;
    }

    public static SearchType getByName(String name) {
        return SearchType.valueOf(name.toUpperCase());
    }
}
