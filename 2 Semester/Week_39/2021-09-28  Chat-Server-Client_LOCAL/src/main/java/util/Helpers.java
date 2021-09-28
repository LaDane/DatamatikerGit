package util;

public class Helpers {

    public static String[] recipientsToList(String recipientsToken) {
        return recipientsToken.trim().split(",");
    }
}
