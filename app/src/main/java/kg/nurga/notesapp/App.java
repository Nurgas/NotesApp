package kg.nurga.notesapp;

import android.app.Application;

import kg.nurga.util.SharedStorage;
import kg.nurga.util.SharedStorageImpl;

public class App extends Application {

    private final String SHARED_FILE_NAME = "shared_prefs";


    public static SharedStorage sharedStorage;

    @Override
    public void onCreate() {
        super.onCreate();
        sharedStorage = new SharedStorageImpl(
                this,
                SHARED_FILE_NAME
        );
    }
}
