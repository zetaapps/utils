package zeta.android.utils.lang;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LangUtilsTest {

    @Test
    public void testConstructor() {
        CollectionUtils util = new CollectionUtils();
        Assert.assertNotNull(util);
    }

    @Test
    public void testListHasElements() throws Exception {
        List<String> someList = new ArrayList<>();
        someList.add("one");
        someList.add("two");
        List<String> emptyList = Collections.emptyList();
        List<String> nullList = null;

        Assert.assertTrue("hasElements returns true for populated list", CollectionUtils.hasElements(someList));
        Assert.assertFalse("hasElements returns false for empty list", CollectionUtils.hasElements(emptyList));
        Assert.assertFalse("hasElements returns false for null list", CollectionUtils.hasElements(nullList));
    }

    @Test
    public void testArrayHasElements() throws Exception {
        String[] someArray = new String[]{"souper", "seekrit"};
        String[] emptyArray = new String[]{};
        String[] nullArray = null;

        Assert.assertTrue("hasElements returns true for populated array", CollectionUtils.hasElements(someArray));
        Assert.assertFalse("hasElements returns false for empty array", CollectionUtils.hasElements(emptyArray));
        Assert.assertFalse("hasElements returns false for null array", CollectionUtils.hasElements(nullArray));
    }
}