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
    }
}
