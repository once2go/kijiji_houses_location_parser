package presenter;

import data.FitAddObject;
import data.FitElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by once2go on 20/01/17.
 */
public class Executor implements TaskResultListener {

    private final List<FitAddObject> matchedList = new ArrayList<FitAddObject>();
    private ExecutorProgress listener;

    public interface ExecutorProgress {
        void onProceeded(FitAddObject result);
    }

    public void setExecutorProgressListener(ExecutorProgress listener) {
        this.listener = listener;
    }

    public void executeNewSearch(FitElement fitElement) {
        Thread parseThread = new Thread(new AgentTask(fitElement, this));
        parseThread.start();
    }

    public void onParseFinished(FitAddObject result) {
        synchronized (matchedList) {
            matchedList.add(result);
            if (listener != null) {
                listener.onProceeded(result);
            }
        }
    }

    public List<FitAddObject> getMatchedList() {
        return matchedList;
    }
}
