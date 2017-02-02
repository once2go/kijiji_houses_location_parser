package presenter;

import data.FitAddObject;
import data.FitElement;
import data.SearchingZone;

/**
 * Created by once2go on 20/01/17.
 */
public class AgentTask implements Runnable {

    private FitElement element;
    private TaskResultListener taskResultListener;
    private SearchingZone mSearchingZone;

    public AgentTask(SearchingZone searchingZone, FitElement element, TaskResultListener taskResultListener) {
        this.element = element;
        this.taskResultListener = taskResultListener;
        mSearchingZone = searchingZone;
    }

    public void run() {
        Agent agent = new HouseAndCondosAgent();
        FitAddObject target = agent.parseTargetPage(element);
        if (LocationMatcher.isInMatchedZone(mSearchingZone, target.getLocation())) {
            taskResultListener.onParseFinished(target);
        }
    }
}
