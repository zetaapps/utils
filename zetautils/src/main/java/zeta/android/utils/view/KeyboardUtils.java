package zeta.android.utils.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

public class KeyboardUtils {

    /**
     * This api takes care of showing the keyboard when the dialog fragment starts.
     *
     * @param dialog the dialog which needs to show the keyboard.
     * @see WindowManager.LayoutParams#SOFT_INPUT_STATE_VISIBLE
     */
    public static void showKeyboard(Dialog dialog) {
        showKeyboardFromDialogInternal(
                dialog,
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    public static void showKeyboard(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        Window window = fragment.getActivity().getWindow();
        if (window != null) {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }
    }

    public static void showKeyboard(View view) {
        if (view == null) {
            return;
        }
        Activity activity = (Activity) view.getContext();
        Window window = activity.getWindow();
        if (window != null) {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        }
    }

    /**
     * Like {@link #showKeyboard(Dialog)}, but will always show the keyboard when input
     * in the window is focused.
     *
     * @param dialog the dialog which needs to show the keyboard
     * @see WindowManager.LayoutParams#SOFT_INPUT_STATE_ALWAYS_VISIBLE
     */
    public static void showKeyboardFromDialogAlways(@Nullable Dialog dialog) {
        showKeyboardFromDialogInternal(
                dialog,
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }


    public static void hideKeyboard(DialogFragment dialog) {
        if (dialog == null) {
            return;
        }

        final InputMethodManager imm = getImm(dialog.getActivity());
        Window window = dialog.getDialog().getWindow();
        if (window != null) {
            imm.hideSoftInputFromWindow(window.getDecorView().getWindowToken(), 0);
        }
    }

    public static void hideKeyboard(Fragment fragment) {
        if (fragment == null) {
            return;
        }

        final InputMethodManager imm = getImm(fragment.getActivity());
        if (fragment.getView() != null) {
            imm.hideSoftInputFromWindow(fragment.getView().getWindowToken(), 0);
        }
    }

    public static void hideKeyboard(Activity activity) {
        if (activity == null) {
            return;
        }

        final InputMethodManager imm = getImm(activity);
        if (activity.getWindow() != null) {
            imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    public static void hideKeyboard(View view) {
        if (view == null) {
            return;
        }

        final InputMethodManager imm = getImm(view.getContext());
        imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }


    private static void showKeyboardFromDialogInternal(Dialog dialog, int flag) {
        if (dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(flag);
        }
    }

    private static InputMethodManager getImm(Context context) {
        return (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
    }
}
