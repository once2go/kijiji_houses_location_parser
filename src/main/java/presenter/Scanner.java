package presenter;

import data.FitAddObject;
import data.FitElement;
import data.KiConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by once2go on 31/01/17.
 */
public class Scanner implements QueryScanListener {

    private final List<FitElement> fitElements = new ArrayList<>();
    private List<Integer> fitIDs = new ArrayList<>();
    private ScannerProgress listener;
    private String urlPattern;

    public interface ScannerProgress {
        void onProceeded(List<FitElement> result) throws InterruptedException;
    }

    public Scanner(String urlPattern, ScannerProgress listener) {
        this.listener = listener;
        this.urlPattern = urlPattern;
    }

    public void executeScope(int startPage, int endPage) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = startPage; i < endPage; i++) {
            Thread thread = new Thread(new QueryScanTask(String.format(urlPattern, i), this));
            executorService.execute(thread);
        }
        executorService.shutdown();
        boolean finished = executorService.awaitTermination(1, TimeUnit.MINUTES);
        if (finished && listener != null) {
            listener.onProceeded(fitElements);
        }

    }

    @Override
    public void onParseFinished(List<FitElement> result) {
        synchronized (fitElements) {
            for (FitElement element : result) {
                int id = element.getAddid();
                if (!fitIDs.contains(id)) {
                    fitIDs.add(id);
                    fitElements.add(element);
                }
            }
        }
    }
}
