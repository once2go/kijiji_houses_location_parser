import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;
import data.KiConfig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by once2go on 19/01/17.
 */
public class Application {

    public static void main(String[] args) {

        FileInputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream(KiConfig.fbaseKP);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (serviceAccount == null)
            return;
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
                .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
                .build();
        FirebaseApp.initializeApp(options);
        try {
            new Server().init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
