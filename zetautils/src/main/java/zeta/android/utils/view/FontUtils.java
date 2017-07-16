package zeta.android.utils.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class FontUtils {

    public interface FontAsset {
        /**
         * Supply the path to your custom font.  This will typically be something like,<br>
         * <pre>font/Helvetica-Regular.ttf</pre>
         */
        String getFontPath();
    }

    /**
     * Returns the custom typeface corresponding to the given font style.
     */
    public static Typeface getTypeface(Context context, FontAsset font) {
        AssetManager assets = context.getAssets();
        return Typeface.createFromAsset(assets, font.getFontPath());
    }

}
