import data.FitAddObject;
import data.FitElement;
import data.KiConfig;
import presenter.Agent;
import presenter.Executor;
import presenter.HouseAndCondosAgent;
import presenter.UrlHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by once2go on 19/01/17.
 */
public class Application {

    public static void main(String[] args) {
        try {
            new Server().init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //proceedSearch();
    }

    private static void proceedSearch() {
        final Executor executor = new Executor();
        executor.setExecutorProgressListener(new Executor.ExecutorProgress() {
            public void onProceeded(FitAddObject result) {
                print(KiConfig.SERVER_URL + result.getFitElement().getLink());
            }
        });
        List<Integer> checkedIdList = new ArrayList<Integer>();
        for (int i = 1; i < 15; i++) {
            List<FitElement> elements = getFitElementsFromPage(i);
            for (FitElement element : elements) {
                int id = element.getAddid();
                if (!checkedIdList.contains(id)) {
                    checkedIdList.add(id);
                    executor.executeNewSearch(element);
                }
            }
        }
    }


    private static List<FitElement> getFitElementsFromPage(int page) {
        Agent agent = new HouseAndCondosAgent();
        String URL = String.format(buildStubUrl(), page);
        return agent.parseContainer(URL);
    }


    private static String buildStubUrl() {
        UrlHelper.UrlBuilder builder = new UrlHelper.UrlBuilder(KiConfig.SERVER_URL, KiConfig.CAT_HOUSES, KiConfig.AREA_GTA, KiConfig.TOKEN);
        builder.addQuery(KiConfig.QUERY_OFFERING)
                .addQuery(UrlHelper.buildQueryPriceParameter(KiConfig.QUERY_PRICE_FORMAT, 1500, 2000));
        return builder.build();
    }

    private static void print(String log) {
        System.out.println(log);
    }
}
