package zeta.android.utils.view;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;

public class DeviceUtils {
    public static boolean hasJellyBean() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
    }

    public static boolean hasJellyBeanMR1() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1;
    }

    public static boolean hasJellyBeanMR2() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2;
    }

    public static boolean hasKitKat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

    public static boolean hasLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    public static boolean hasMarshmallow() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    public static int getCurrentAppVersionCode(Context ctx) {
        return getPackageInfo(ctx).versionCode;
    }

    /**
     * Convenience function which returns the {@link PackageInfo} for this package.
     *
     * @throws IllegalStateException in the seemingly impossible scenario that we cannot retrieve
     *                               this information.
     */
    @NonNull
    public static PackageInfo getPackageInfo(@NonNull Context ctx) {
        try {
            return ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            // There should be no reason that this will ever fail.
            throw new IllegalStateException("Somehow failed to retrieve package information.", e);
        }
    }

}
