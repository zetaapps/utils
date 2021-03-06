package zeta.android.utils.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.EditText;

import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import zeta.android.utils.device.DeviceUtils;

@ParametersAreNonnullByDefault
public class ViewUtils {
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    /**
     * @param visibleView The view to set to visibility = View.VISIBLE
     * @param goneViews   The views to set to visibility = View.GONE
     */
    public static void showFirstAndHideOthers(View visibleView, View... goneViews) {
        setMultipleToGone(goneViews);
        setToVisible(visibleView);
    }

    public static void setMultipleToGone(View... goneViews) {
        setMultipleVisibilityInternal(View.GONE, goneViews);
    }

    public static void setMultipleToVisible(View... visibleViews) {
        setMultipleVisibilityInternal(View.VISIBLE, visibleViews);
    }

    public static void setMultipleToInvisible(View... invisibleViews) {
        setMultipleVisibilityInternal(View.INVISIBLE, invisibleViews);
    }

    public static boolean isVisible(@Nullable View view) {
        return view != null && (view.getVisibility() == View.VISIBLE);
    }

    private static void setMultipleVisibilityInternal(int visibility, @Nullable View... views) {
        if (views == null) {
            return;
        }
        for (View view : views) {
            setVisibilityInternal(view, visibility);
        }
    }

    public static void setToVisible(View view) {
        setVisibilityInternal(view, View.VISIBLE);
    }

    public static void setToGone(View view) {
        setVisibilityInternal(view, View.GONE);
    }

    public static void setToInvisible(View view) {
        setVisibilityInternal(view, View.INVISIBLE);
    }

    private static void setVisibilityInternal(@Nullable View view, int visibility) {
        if (view != null && view.getVisibility() != visibility) {
            view.setVisibility(visibility);
        }
    }

    public static boolean isEmpty(EditText editText) {
        return editText.getText().toString().trim().length() == 0;
    }

    /**
     * Allows for a view to be set to either visible or gone using a boolean flag.
     *
     * @param view    the view to change the visibility of
     * @param visible true if the view should be set to VISIBLE, false if it should be set to GONE
     */
    public static void setVisibility(@Nullable View view, boolean visible) {
        if (view != null) {
            view.setVisibility(visible ? View.VISIBLE : View.GONE);
        }
    }

    public static View ensureInflated(ViewGroup layout, int id) {
        return ensureInflated(layout.findViewById(id));
    }

    public static View ensureInflated(ViewGroup layout, int id, int inflatedId) {
        View stub = ensureInflated(layout.findViewById(id));
        if (stub == null) {
            return layout.findViewById(inflatedId);
        }
        return stub;
    }

    public static View ensureInflated(View v) {
        if (v instanceof ViewStub) {
            return ((ViewStub) v).inflate();
        }
        return v;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("Deprecation")
    @SuppressWarnings("deprecation")
    public static void removeOnGlobalLayoutListener(View v, ViewTreeObserver.OnGlobalLayoutListener listener) {
        if (DeviceUtils.hasJellyBean()) {
            v.getViewTreeObserver().removeOnGlobalLayoutListener(listener);
        } else {
            v.getViewTreeObserver().removeGlobalOnLayoutListener(listener);
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("Deprecation")
    @SuppressWarnings("deprecation")
    public static void setBackground(View view, Drawable drawable) {
        if (DeviceUtils.hasJellyBean()) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @SuppressLint("Deprecation")
    @SuppressWarnings("deprecation")
    public static int generateViewId() {
        if (DeviceUtils.hasJellyBeanMR1()) {
            return View.generateViewId();
        } else {
            return generateInternalId();
        }
    }

    private static int generateInternalId() {
        for (; ; ) {
            final int result = sNextGeneratedId.get();
            // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
            int newValue = result + 1;
            if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
            if (sNextGeneratedId.compareAndSet(result, newValue)) {
                return result;
            }
        }
    }
}