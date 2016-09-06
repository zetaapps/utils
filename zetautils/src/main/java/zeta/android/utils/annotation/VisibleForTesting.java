package zeta.android.utils.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;

/**
 * Annotates any element which, exclusively for testing purposes, has been made more visible than
 * is otherwise necessary.
 *
 * See javadoc on {@link ExistsForTesting} for how this contrasts with {@link ExistsForTesting}
 * and {@link Hack}.
 */
@Documented
@Inherited
public @interface VisibleForTesting {
}