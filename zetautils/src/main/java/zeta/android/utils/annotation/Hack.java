package zeta.android.utils.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;

/**
 * Annotates any element which represents some solution that you or the team overall are
 * unhappy with, but which you intend to ship anyhow because a better solution is blocked on
 * something.
 */
@Documented
@Inherited
public @interface Hack {
    /**
     * Specific details about what's blocking a proper solution, how the hack works, etc.
     */
    String explanation();
}
