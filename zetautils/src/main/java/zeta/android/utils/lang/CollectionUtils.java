package zeta.android.utils.lang;

import java.util.Collection;

public class CollectionUtils {

    public static boolean hasElements(Collection<?> collection) {
        return collection != null && !collection.isEmpty();
    }

    public static boolean hasElements(Object[] array) {
        return array != null && array.length > 0;
    }
}
