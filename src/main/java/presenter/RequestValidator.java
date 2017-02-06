package presenter;

import data.KiConfig;
import data.RequestData;
import data.SearchType;
import data.SearchingZone;

/**
 * Created by once2go on 02/02/17.
 */
public class RequestValidator {

    public static String validate(RequestData requestData) {
        StringBuilder builder = new StringBuilder();
        int fromPrice = requestData.getPriceStartFrom();
        int tillPrice = requestData.getPriceStartTill();
        if (fromPrice < 0) {
            builder.append("Price 'from' not valid;");
        }
        if (tillPrice < 0) {
            builder.append("Price 'to' not valid;");
        }
        if (tillPrice <= fromPrice) {
            builder.append("Price 'from' must be less than price 'to';");
        }

        if (requestData.getSearchType() != SearchType.CONDOS
                && requestData.getSearchType() != SearchType.HOUSES
                && requestData.getSearchType() != SearchType.ROOMS) {
            builder.append("Search query not valid;");
        }

        SearchingZone zone = requestData.getSearchingZone();
        if (zone.getLatitudeStart() <= 0) {
            builder.append("Start X point not valid;");
        }

        if (zone.getLongitudeStart() == -1 || zone.getLongitudeStart() >= 0) {
            builder.append("Start Y point not valid;");
        }

        if (zone.getLatitudeEnd() < 0) {
            builder.append("End X point not valid;");
        }

        if (zone.getLongitudeEnd() == -1 || zone.getLongitudeEnd() >= 0) {
            builder.append("End Y point not valid;");
        }

        if (zone.getLatitudeStart() > KiConfig.LAT_END || zone.getLatitudeStart() < KiConfig.LAT_START) {
            builder.append("Start X point is wrong. GTA only available;");
        }

        if (zone.getLatitudeEnd() > KiConfig.LAT_END || zone.getLatitudeEnd() < KiConfig.LAT_START) {
            builder.append("End X point is wrong. GTA only available;");
        }

        if (zone.getLongitudeStart() < KiConfig.LON_START || zone.getLongitudeStart() > KiConfig.LON_END) {
            builder.append("Start Y point is wrong. GTA only available;");
        }

        if (zone.getLongitudeEnd() < KiConfig.LON_START || zone.getLongitudeEnd() > KiConfig.LON_END) {
            builder.append("End Y point is wrong. GTA only available;");
        }

        if (zone.getLatitudeEnd() < zone.getLatitudeStart()) {
            builder.append("Start X point must be less than End X point. See instructions, please;");
        }

        if (zone.getLongitudeEnd() < zone.getLongitudeStart()) {
            builder.append("Start Y point must be less than End Y point. Mind the '-' minus value;");
        }

        return builder.toString().isEmpty() ? null : builder.toString();
    }

}
