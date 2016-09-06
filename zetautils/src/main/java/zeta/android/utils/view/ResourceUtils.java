package zeta.android.utils.view;

import android.content.res.Resources;
import android.util.TypedValue;

public class ResourceUtils {
    public static int getPixelDimensionsFromDp(Resources resources, int dpMeasurement) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dpMeasurement,
                resources.getDisplayMetrics()
        );
    }
}
