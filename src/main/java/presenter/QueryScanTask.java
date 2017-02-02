package presenter;

import data.FitElement;

import java.util.List;

/**
 * Created by once2go on 31/01/17.
 */
public class QueryScanTask implements Runnable {

    private String URL;
    private QueryScanListener listener;

    public QueryScanTask(String url, QueryScanListener listener) {
        this.URL = url;
        this.listener = listener;
    }

    @Override
    public void run() {
        Agent agent = new HouseAndCondosAgent();
        List<FitElement> res = agent.parseContainer(URL);
        if (listener != null) {
            listener.onParseFinished(res);
        }
    }
}
