package zeta.android.utils.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;

/**
 * Annotates an element to indicate that there is a known preferred implementation
 * pending, but for any number of reasons we haven't had time to do it yet.
 */
@Documented
@Inherited
public @interface NeedsRefactor {

    /**
     * What should be refactored, and how?
     */
    String explanation();
}
