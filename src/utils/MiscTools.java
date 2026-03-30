package utils;

import java.util.Random;

public class MiscTools {

    static final String ALPHABET_US_EN = "abcdefghijklmnopqrstuvwxyz0123456789";

    // Returns a random string
    public static String getRandomString(int length){
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++ ){
            sb.append(ALPHABET_US_EN.charAt(random.nextInt(ALPHABET_US_EN.length())));
        }
        return sb.toString();
    }
}
