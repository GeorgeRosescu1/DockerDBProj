package utils;

public class MyConstants {

    private static MyConstants instance = null;
    public final String INVALID_DATABASE = "Invalid Database option";
    private MyConstants() {

    }

    public static MyConstants getInstance() {
        if (instance == null)
            instance = new MyConstants();
        return instance;
    }


}
