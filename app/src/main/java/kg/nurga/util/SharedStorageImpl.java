package kg.nurga.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedStorageImpl implements SharedStorage {


    private SharedPreferences sharedPreference;


    public SharedStorageImpl(Context context, String fileName){
       context.getApplicationContext()
               .getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }


    @Override
    public int getInt(String key) {
        return sharedPreference.getInt(key,-1);
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {
        return sharedPreference.getBoolean(key,defaultValue);
    }

    @Override
    public void setBoolean(String key, boolean value) {
        sharedPreference.edit().putBoolean(key, value).apply();
    }

    @Override
    public boolean contains(String key) {
        return false;
    }
}
