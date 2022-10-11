package me.godofpro.noxy.utils;

public class StringUtil {
    public static String cleanColor(String in) {
        return in.replaceAll("(?i)\\u00A7.", "");
    }
}
