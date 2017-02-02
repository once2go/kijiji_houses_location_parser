package presenter;

import data.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by once2go on 31/01/17.
 */
public class SearchWorker implements Runnable {

    private String urlPattern;
    private SearchingZone mSearchingZone;
    private List<FitAddObject> mFitAddObjects = new ArrayList<>();

    private int startPage = 1;
    private int endPage = 3;

    public SearchWorker(RequestData requestData) {
        String searchTypeQuery;
        switch (requestData.getSearchType()) {
            case HOUSES:
                searchTypeQuery = KiConfig.CAT_HOUSES;
                break;
            default:
                searchTypeQuery = KiConfig.CAT_APARTMENTS_CONDOS;
        }
        int startPrice = requestData.getPriceStartFrom();
        int endPrice = requestData.getPriceStartTill();
        UrlHelper.UrlBuilder builder = new UrlHelper.UrlBuilder(KiConfig.SERVER_URL, searchTypeQuery, KiConfig.AREA_GTA, KiConfig.TOKEN);
        builder.addQuery(KiConfig.QUERY_OFFERING)
                .addQuery(UrlHelper.buildQueryPriceParameter(KiConfig.QUERY_PRICE_FORMAT, startPrice, endPrice));
        urlPattern = builder.build();
        mSearchingZone = requestData.getSearchingZone();
    }

    @Override
    public void run() {
        final Executor executor = new Executor(mSearchingZone);
        executor.setExecutorProgressListener(result -> mFitAddObjects = result);
        try {
            new Scanner(urlPattern, result -> executor.executeNewSearch(result)).executeScope(startPage, endPage);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<FitResponse> getResult() {
        List<FitResponse> responses = new ArrayList<>();
        for (FitAddObject fitAddObject : mFitAddObjects) {
            responses.add(new FitResponse(fitAddObject));
        }
        return responses;
    }

}
