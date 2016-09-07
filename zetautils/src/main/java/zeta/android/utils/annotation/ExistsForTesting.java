package zeta.android.utils.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;

/**
 * Annotates any element which:
 * <ol>
 * <li>exists solely for testing purposes, AND</li>
 * <li>would not exist at all if not for testing</li>
 * </ol>
 * <p>
 * Contrast with:
 * <ul>
 * <li>{@link Hack}: use {@link ExistsForTesting} instead of {@link Hack} when the code in
 * question isn't a "hack", but is considered to be genuinely the only reasonable
 * approach.</li>
 * <li>nlike {@link android.support.annotation.VisibleForTesting}, which is for elements that are
 * part of an implementation, but are being made <em>more visible</em> for testing,
 * {@link ExistsForTesting} is for elements which, if not for testing purposes, <em>wouldn't
 * exist at all.</em></li>
 * </ul>
 */
@Documented
@Inherited
public @interface ExistsForTesting {
}
