package zeta.android.utils.view;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class Toaster {

    /**
     * Display a toast for a time of Toast.LENGTH_SHORT
     */
    public static void s(Context ctx, CharSequence msg) {
        showText(ctx, msg, Toast.LENGTH_SHORT);
    }

    /**
     * Display a toast for a time of Toast.LENGTH_LONG
     */
    public static void l(Context ctx, CharSequence msg) {
        showText(ctx, msg, Toast.LENGTH_LONG);
    }

    /**
     * Display a toast for a time of Toast.LENGTH_SHORT
     */
    public static void s(Fragment frag, CharSequence msg) {
        s(frag.getActivity(), msg);
    }

    /**
     * Display a toast for a time of Toast.LENGTH_LONG
     */
    public static void l(Fragment frag, CharSequence msg) {
        l(frag.getActivity(), msg);
    }

    /**
     * Display a toast for a time of Toast.LENGTH_SHORT
     */
    public static void s(Context ctx, @StringRes int stringRes) {
        s(ctx, ctx.getString(stringRes));
    }

    /**
     * Display a toast for a time of Toast.LENGTH_LONG
     */
    public static void l(Context ctx, @StringRes int stringRes) {
        l(ctx, ctx.getString(stringRes));
    }

    /**
     * Display a toast for a time of Toast.LENGTH_SHORT
     */
    public static void s(Fragment frag, @StringRes int stringRes) {
        s(frag, frag.getString(stringRes));
    }

    /**
     * Display a toast for a time of Toast.LENGTH_LONG
     */
    public static void l(Fragment frag, @StringRes int stringRes) {
        l(frag, frag.getString(stringRes));
    }


    private static void showText(Context ctx, CharSequence msg, int length) {
        Toast.makeText(ctx, msg, length).show();
    }
}

