package model.Firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import utils.Strings;

import java.util.Map;

public class Provider {

    // Firestore ya está inicializado en Connection
    private static final Firestore db = Connection.getFirestoreInstance();

    public static void save(String collection, String document, Map<String, Object> data) {
        try {
            DocumentReference documentReference = db.collection(collection).document(document);
            ApiFuture<WriteResult> result = documentReference.set(data);
            System.out.println(Strings.SAVE_SUCCESS.getText());
        } catch (Exception e) {
            System.err.println(Strings.ERROR_WRITING.getText() + e.getMessage());
        }
    }

    public static void update(String collection, String document, Map<String, Object> data) {
        try {
            DocumentReference documentReference = db.collection(collection).document(document);
            ApiFuture<WriteResult> result = documentReference.update(data);
            System.out.println(Strings.UPDATE_SUCCESS.getText());
        } catch (Exception e) {
            System.err.println(Strings.ERROR_WRITING.getText() + e.getMessage());
        }
    }


    public static void delete(String collection, String document) {
        try {
            DocumentReference documentReference = db.collection(collection).document(document);
            ApiFuture<WriteResult> result = documentReference.delete(Precondition.NONE);
            System.out.println(Strings.DELETE_SUCCESS.getText());
        } catch (Exception e) {
            System.err.println(Strings.ERROR_WRITING.getText() + e.getMessage());
        }
    }

    public static void getInfo() {

        try {
            CollectionReference people = db.collection("People");
            ApiFuture<QuerySnapshot> querySnapshot = people.get();
            for (DocumentSnapshot documentSnapshot : querySnapshot.get().getDocuments()) {
                documentSnapshot.getId();
                documentSnapshot.getString("Email");
                documentSnapshot.getString("User");
                documentSnapshot.getString("Password");
                documentSnapshot.getString("Security Question");
                documentSnapshot.getString("Security Answer");

            }


        } catch (Exception e) {

        }

    }

}