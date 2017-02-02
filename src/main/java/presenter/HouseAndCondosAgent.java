package presenter;

import data.FitAddObject;
import data.FitElement;
import data.KiConfig;
import data.Location;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.omg.CORBA.portable.ApplicationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by once2go on 19/01/17.
 */
public class HouseAndCondosAgent implements Agent {

    public List<FitElement> parseContainer(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element body = doc.body();
        Elements infoContainers = body.getElementsByClass("info-container");
        List<FitElement> fitElementsList = new ArrayList<FitElement>();
        for (Element infoContainer : infoContainers) {
            Element title = infoContainer.getElementsByClass("title").first();
            Element link = title.getElementsByTag("a").first();
            String linkHref = link.attr("href");
            fitElementsList.add(new FitElement(linkHref));
        }
        return fitElementsList;
    }

    public FitAddObject parseTargetPage(FitElement element) {
        Document doc = null;
        String url = KiConfig.SERVER_URL + element.getLink();
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element body = doc.body();
        Element head = body.getElementsByClass("layout-0").first();
        head = head.select("h1").first();
        String title = head.text();
        Element paramTable = body.getElementsByClass("ad-attributes").first();
        Elements rows = paramTable.select("tr");
        String date = null;
        String addr = null;
        boolean isFurnished = false;
        String price = null;
        for (Element row : rows) {
            Elements colsHeader = row.select("th");
            Elements colsData = row.select("td");
            if (colsHeader.text().trim().equals("Date Listed")) {
                date = colsData.get(0).text();
            }
            if (colsHeader.text().trim().equals("Address")) {
                addr = colsData.get(0).text();
            }
            if (colsHeader.text().trim().equals("Price")) {
                price = colsData.get(0).text();
            }
            if (colsHeader.text().trim().equals("Furnished")) {
                isFurnished = "Yes".equals(colsData.get(0).text());
            }
        }
        String description = body.getElementById("UserContent").text();
        String script = doc.select("script").html();
        String scriptFuncKey = "Kj.Map.initMap";
        script = script.substring(script.indexOf(scriptFuncKey), script.length());
        script = script.substring(script.indexOf('('), script.indexOf(')'));
        String[] parts = script.split(",");
        boolean isPostalCode = false;
        double lat = 0;
        double lon = 0;

        for (String part : parts) {
            String[] subPart = part.split(":");
            if (subPart[0].trim().equals("isPostalCode")) {
                isPostalCode = Boolean.parseBoolean(subPart[1]);
            }
            if (subPart[0].trim().equals("latitude")) {
                lat = Double.parseDouble(subPart[1]);
            }
            if (subPart[0].trim().equals("longitude")) {
                lon = Double.parseDouble(subPart[1]);
            }
        }
        Location location = new Location(isPostalCode, lat, lon);

        return new FitAddObject(element, title, date, price, addr, isFurnished, description, location);
    }
}
