package presenter;

/**
 * Created by once2go on 20/01/17.
 */
public class UrlHelper {

    public static String buildQueryPriceParameter(String pattern, int from, int till) {
        return String.format(pattern, from, till);
    }


    public static class UrlBuilder {

        private String url;

        public UrlBuilder(String server, String type, String area, String token) {
            this(server, type, area, "page-%d", token);
        }

        public UrlBuilder(String server, String type, String area, String pageQuery, String token) {
            url = String.format(server + "/%s/%s/%s/%s", type, area, pageQuery, token);
        }

        public UrlBuilder addQuery(String query) {
            setQuerySeparator();
            url += query;
            return this;
        }

        public String build() {
            return url;
        }

        private String setQuerySeparator() {
            if (!url.contains("?"))
                return url += "?";
            else
                return url += "&";
        }

    }
}
