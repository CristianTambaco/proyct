package model.Firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.IOException;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import utils.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Strings;

public class Connection {

    private static final Logger logger = LoggerFactory.getLogger(Connection.class);
    private static volatile boolean initialized = false;
    private static Firestore db;

    public static void connect() {
        if (initialized) return;

        synchronized (Connection.class) { // Bloque synchronized para evitar condiciones de carrera
            if (initialized) return;

            try {
                FileInputStream refreshToken = new FileInputStream(Paths.KEY.getPath());

                FirebaseOptions options = FirebaseOptions.builder()
                        .setCredentials(GoogleCredentials.fromStream(refreshToken))
                        .build();

                if (FirebaseApp.getApps().isEmpty()) FirebaseApp.initializeApp(options);

                db = FirestoreClient.getFirestore(); // 🔹 Se inicializa Firestore aquí 🔸
                logger.info(Strings.FIRESTORE_CONNECTED.getText());
                initialized = true;

            } catch (IOException e) {
                logger.error(Strings.KEY_FILE_ERROR.getText(), e);
                throw new RuntimeException("Error al inicializar Firebase", e);
            }
        }
    }

    public static Firestore getFirestoreInstance() {
        if (!initialized) connect();
        return db;
    }

    public static FirebaseAuth getAuthInstance() {
        if (!initialized) connect();
        return FirebaseAuth.getInstance();
    }
}