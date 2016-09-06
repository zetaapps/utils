package zeta.android.utils.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StringUtilsTest {

    @Test
    public void stringUtils_constructor() {
        StringUtils utils = new StringUtils();
        assertNotNull(utils);
    }

    @Test
    public void emptyString_verifyValue() {
        String empt = StringUtils.EMPTY_STRING;
        assertNotNull(empt);
        assertEquals("Checking to make sure the definition of EMPTY_STRING stays consistent", "", empt);
    }

    @Test
    public void isNull_isNull() {
        assertEquals(true, StringUtils.isNull(null));
    }

    @Test
    public void isNull_isEmpty() {
        String empt = "";
        assertEquals(false, StringUtils.isNull(empt));
    }

    @Test
    public void isNull_isWhitespace() {
        String empt = "  ";
        assertEquals(false, StringUtils.isNull(empt));
    }

    @Test
    public void isNull_hasContent() {
        String cont = "null";
        assertEquals(false, StringUtils.isNull(cont));
    }

    @Test
    public void isNotNull_isNotNull() {
        String cont = "null";
        assertEquals(true, StringUtils.isNotNull(cont));
    }

    @Test
    public void isNotNull_isEmpty() {
        String cont = "";
        assertEquals(true, StringUtils.isNotNull(cont));
    }

    @Test
    public void isNotNull_isWhitespace() {
        String cont = "  ";
        assertEquals(true, StringUtils.isNotNull(cont));
    }

    @Test
    public void isNotNull_isNull() {
        assertEquals(false, StringUtils.isNotNull(null));
    }

    @Test
    public void isNullOrEmpty_isEmpty() {
        String empt = "";
        assertEquals(true, StringUtils.isNullOrEmpty(empt));
    }

    @Test
    public void isNullOrEmpty_isNull() {
        assertEquals(true, StringUtils.isNullOrEmpty(null));
    }

    @Test
    public void isNullOrEmpty_isNotEmpty() {
        String empt = "null";
        assertEquals(false, StringUtils.isNullOrEmpty(empt));
    }

    @Test
    public void isNullOrEmpty_isWhitespace() {
        String cont = "  ";
        assertEquals(false, StringUtils.isNullOrEmpty(cont));
    }

    @Test
    public void isNotNullOrEmpty_isEmpty() {
        String empt = "";
        assertEquals(false, StringUtils.isNotNullOrEmpty(empt));
    }

    @Test
    public void isNotNullOrEmpty_isNull() {
        assertEquals(false, StringUtils.isNotNullOrEmpty(null));
    }

    @Test
    public void isNotNullOrEmpty_isNotEmpty() {
        String empt = "null";
        assertEquals(true, StringUtils.isNotNullOrEmpty(empt));
    }

    @Test
    public void isNullOrWhitespace_isWhitespace() {
        String cont = "  ";
        assertEquals(true, StringUtils.isNullOrWhitespace(cont));
    }

    @Test
    public void isNullOrWhitespace_isEmpty() {
        String empt = "";
        assertEquals(true, StringUtils.isNullOrWhitespace(empt));
    }

    @Test
    public void isNullOrWhitespace_isNull() {
        assertEquals(true, StringUtils.isNullOrWhitespace(null));
    }

    @Test
    public void isNullOrWhitespace_isNotEmpty() {
        String cont = " null ";
        assertEquals(false, StringUtils.isNullOrWhitespace(cont));
    }

    @Test
    public void isNotNullOrWhitespace_isWhitespace() {
        String cont = "  ";
        assertEquals(false, StringUtils.isNotNullOrWhitespace(cont));
    }

    @Test
    public void isNotNullOrWhitespace_isEmpty() {
        String empt = "";
        assertEquals(false, StringUtils.isNotNullOrWhitespace(empt));
    }

    @Test
    public void isNotNullOrWhitespace_isNull() {
        assertEquals(false, StringUtils.isNotNullOrWhitespace(null));
    }

    @Test
    public void isNotNullOrWhitespace_isNotEmpty() {
        String cont = " null ";
        assertEquals(true, StringUtils.isNotNullOrWhitespace(cont));
    }

    @Test
    public void trimToLength_negativeLength() {
        String value = StringUtils.trimToLength("test", -1);
        assertEquals(StringUtils.EMPTY_STRING, value);
    }

    @Test
    public void trimToLength_nullString() {
        String value = StringUtils.trimToLength(null, 5);
        assertEquals(StringUtils.EMPTY_STRING, value);
    }

    @Test
    public void trimToLength_validTrim() {
        String trimmable = "testing";
        String value = StringUtils.trimToLength(trimmable, 4);
        assertEquals("test", value);
    }

    @Test
    public void trimToLength_noTrim() {
        String trimmable = "test";
        String value = StringUtils.trimToLength(trimmable, 5);
        assertEquals("test", value);
    }

    @Test
    public void ellipseText_noTrim() {
        String trimmable = "test";
        String value = StringUtils.ellipseText(trimmable, 4);
        assertEquals("test", value);
    }

    @Test
    public void ellipseText_Trim() {
        String trimmable = "testing";
        String value = StringUtils.ellipseText(trimmable, 4);
        assertEquals("test..", value);
    }

    @Test
    public void capitalizeFirstLetter() {
        String str = "cOOLSTORYBRO";

        String capitalized = StringUtils.capitalizeFirstLetter(str);

        assertEquals("Coolstorybro", capitalized);
    }

    @Test
    public void capitalizeFirstLetter_lengthOne() {
        String str = "c";

        String capitalized = StringUtils.capitalizeFirstLetter(str);

        assertEquals("C", capitalized);
    }

    @Test
    public void capitalizeFirstLetter_nullOrEmpty() throws Exception {
        String capitalized = StringUtils.capitalizeFirstLetter(null);

        assertEquals("", capitalized);
    }

    @Test
    public void capitalizeFirstLetters() {
        String str = "cool story bro";

        String capitalized = StringUtils.capitalizeFirstLetters(str);

        assertEquals("Cool Story Bro", capitalized);
    }
}
