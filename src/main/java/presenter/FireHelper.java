package presenter;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by once2go on 06/02/17.
 */
public class FireHelper {


    public static class FetchUIDTask implements Runnable {
        private String mToken;
        private String uId;

        FetchUIDTask(String token) {
            mToken = token;
        }

        @Override
        public void run() {
            FirebaseAuth.getInstance().verifyIdToken(mToken)
                    .addOnSuccessListener(firebaseToken -> {
                        System.out.print(firebaseToken.getUid());
                        uId = firebaseToken.getUid();
                    });
        }

        String getUId() {
            return uId;
        }
    }
}
