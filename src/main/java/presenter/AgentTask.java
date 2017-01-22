package presenter;

import data.FitAddObject;
import data.FitElement;

/**
 * Created by once2go on 20/01/17.
 */
public class AgentTask implements Runnable {

    private FitElement element;
    private TaskResultListener taskResultListener;

    public AgentTask(FitElement element, TaskResultListener taskResultListener) {
        this.element = element;
        this.taskResultListener = taskResultListener;
    }

    public void run() {
        Agent agent = new HouseAndCondosAgent();
        FitAddObject target = agent.parseTargetPage(element);
        if (LocationMatcher.isInMatchedZone(target.getLocation())) {
            taskResultListener.onParseFinished(target);
        }
    }
}
