package kg.nurga.util;

public interface SharedStorage {

    int getInt(String key);

    boolean getBoolean(String key, boolean defaultValue);

    void setBoolean(String key, boolean value);

    boolean contains(String key);


}
