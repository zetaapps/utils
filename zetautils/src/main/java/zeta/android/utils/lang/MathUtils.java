package zeta.android.utils.lang;

public class MathUtils {

    /**
     * Are {@code firstValue} and {@code secondValue} within {@code affordance} of each other?
     */
    public static boolean approximately(float firstValue, float secondValue, float affordance) {
        float difference = Math.abs(firstValue - secondValue);
        return difference <= affordance;
    }

    /**
     * Are {@code firstValue} and {@code secondValue} within {@code affordance} of each other?
     */
    public static boolean approximately(double firstValue, double secondValue, double affordance) {
        double difference = Math.abs(firstValue - secondValue);
        return difference <= affordance;
    }
}
