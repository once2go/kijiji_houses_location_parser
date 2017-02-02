package presenter;

import data.FitAddObject;
import data.FitElement;
import data.SearchingZone;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by once2go on 20/01/17.
 */
public class Executor implements TaskResultListener {

    private final List<FitAddObject> matchedList = new ArrayList<>();
    private ExecutorProgress listener;
    private SearchingZone mSearchingZone;

    Executor(SearchingZone searchingZone) {
        mSearchingZone = searchingZone;
    }

    public interface ExecutorProgress {
        void onProceeded(List<FitAddObject> result);
    }

    void setExecutorProgressListener(ExecutorProgress listener) {
        this.listener = listener;
    }

    void executeNewSearch(List<FitElement> fitElement) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (FitElement element : fitElement) {
            Thread parseThread = new Thread(new AgentTask(mSearchingZone, element, this));
            executorService.execute(parseThread);
        }
        executorService.shutdown();
        boolean finished = executorService.awaitTermination(1, TimeUnit.MINUTES);
        if (finished && listener != null) {
            listener.onProceeded(matchedList);
        }
    }

    @Override
    public void onParseFinished(FitAddObject result) {
        synchronized (matchedList) {
            matchedList.add(result);
        }
    }
}

