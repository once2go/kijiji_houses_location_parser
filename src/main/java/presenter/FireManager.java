package presenter;

/**
 * Created by once2go on 06/02/17.
 */
public class FireManager {

    public String getUId(String token) {
        FireHelper.FetchUIDTask task = new FireHelper.FetchUIDTask(token);
        Thread tThread = new Thread(task);
        tThread.start();
        try {
            tThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return task.getUId();
    }
}
