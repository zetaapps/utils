package zeta.android.utils.lang;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Locale;

public class StringUtils {
    public static final String TAG = StringUtils.class.getSimpleName();

    public static final String SPACE = " ";
    public static final String EMPTY_STRING = "";

    public static boolean isNull(String value) {
        return value == null;
    }

    public static boolean isNotNull(String value) {
        return !isNull(value);
    }

    /**
     * Checks if a String is empty ("") or null.
     * <p/>
     * <pre>
     * StringUtils.isNullOrEmpty(null)      = true
     * StringUtils.isNullOrEmpty("")        = true
     * StringUtils.isNullOrEmpty(" ")       = false
     * StringUtils.isNullOrEmpty("bob")     = false
     * StringUtils.isNullOrEmpty("  bob  ") = false
     * </pre>
     *
     * @param value the String to check, may be null
     * @return <code>true</code> if the String is empty or null
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.length() == 0;
    }

    /**
     * Checks if a String is not empty ("") and not null.
     * <p/>
     * <pre>
     * StringUtils.isNotNullOrEmpty(null)      = false
     * StringUtils.isNotNullOrEmpty("")        = false
     * StringUtils.isNotNullOrEmpty(" ")       = true
     * StringUtils.isNotNullOrEmpty("bob")     = true
     * StringUtils.isNotNullOrEmpty("  bob  ") = true
     * </pre>
     *
     * @param value the String to check, may be null
     * @return <code>true</code> if the String is not empty and not null
     */
    public static boolean isNotNullOrEmpty(String value) {
        return !isNullOrEmpty(value);
    }

    /**
     * Checks if a String is whitespace, empty ("") or null.
     * <p/>
     * <pre>
     *  StringUtils.isNullOrWhitespace(null)      = true
     *  StringUtils.isNullOrWhitespace("")        = true
     *  StringUtils.isNullOrWhitespace(" ")       = true
     *  StringUtils.isNullOrWhitespace("bob")     = false
     *  StringUtils.isNullOrWhitespace("  bob  ") = false
     * </pre>
     *
     * @param value the String to check, may be null
     * @return <code>true</code> if the String is null, empty or whitespace
     */
    public static boolean isNullOrWhitespace(String value) {
        return value == null || value.trim().length() == 0;
    }

    /**
     * Checks if a String is not empty (""), not null and not whitespace only.
     * <p/>
     * <pre>
     *  StringUtils.isNotNullOrWhitespace(null)      = false
     *  StringUtils.isNotNullOrWhitespace("")        = false
     *  StringUtils.isNotNullOrWhitespace(" ")       = false
     *  StringUtils.isNotNullOrWhitespace("bob")     = true
     *  StringUtils.isNotNullOrWhitespace("  bob  ") = true
     * </pre>
     *
     * @param value the String to check, may be null
     * @return <code>true</code> if the String is not empty and not null and not whitespace
     */
    public static boolean isNotNullOrWhitespace(String value) {
        return !isNullOrWhitespace(value);
    }

    /**
     * Chop off all characters in <code>trimMe</code> past <code>maxLength</code>.  Returns an empty
     * string if the max length is negative or <code>trimMe</code> is empty/null.
     *
     * @param trimMe    The string to trim
     * @param maxLength the desired maximum length
     */
    public static String trimToLength(String trimMe, int maxLength) {
        if (StringUtils.isNullOrWhitespace(trimMe) || maxLength < 0) {
            return StringUtils.EMPTY_STRING;
        }

        if (trimMe.length() <= maxLength) {
            return trimMe;
        }

        return trimMe.substring(0, maxLength);
    }


    /**
     * If the given string exceeds the max length trim the string to the max length and add ".." to it
     * <p/>
     * This means the strings new length will be maxLength+2
     *
     * @param ellipseMe
     * @param maxLength
     * @return
     */
    public static String ellipseText(String ellipseMe, int maxLength) {
        if (ellipseMe.length() > maxLength) {
            return StringUtils.trimToLength(ellipseMe, maxLength) + "..";
        }
        return ellipseMe;
    }

    @NonNull
    public static String capitalizeFirstLetter(@Nullable final String str) {
        if (isNullOrEmpty(str)) {
            return EMPTY_STRING;
        }

        String tmpStr = str.toLowerCase(Locale.getDefault());
        return Character.toUpperCase(tmpStr.charAt(0)) + tmpStr.substring(1);
    }

    @NonNull
    public static String capitalizeFirstLetters(@Nullable final String str) {
        if (isNullOrEmpty(str)) {
            return EMPTY_STRING;
        }

        StringBuilder sb = new StringBuilder();
        String[] strArray = str.split(" ");
        for (String s : strArray) {
            sb.append(capitalizeFirstLetter(s)).append(" ");
        }

        return sb.toString().trim();
    }
}