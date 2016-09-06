package zeta.android.utils.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MathUtilsTest {

    @Test
    public void mathUtils_constructor() {
        MathUtils utils = new MathUtils();
        assertNotNull(utils);
    }

    @Test
    public void floatCompare_isZero() {
        float first = 7.0f;
        float second = 7.0f;
        boolean result = MathUtils.approximately(first, second, 0.1f);

        assertEquals(true, result);
    }

    @Test
    public void floatCompare_isAlmostZero() {
        float first = 7.002f;
        float second = 7.001f;
        boolean result = MathUtils.approximately(first, second, 0.001f);

        assertEquals(true, result);
    }

    @Test
    public void floatCompare_isNotZero() {
        float first = 7.002f;
        float second = 7.001f;
        boolean result = MathUtils.approximately(first, second, 0.0001f);

        assertEquals(false, result);
    }

    @Test
    public void floatCompare_ZeroIsZero() {
        float first = 0f;
        float second = 0f;
        boolean result = MathUtils.approximately(first, second, 0.1f);

        assertEquals(true, result);
    }


    @Test
    public void doubleCompare_isZero() {
        double first = 7.0;
        double second = 7.0;
        boolean result = MathUtils.approximately(first, second, 0.1);

        assertEquals(true, result);
    }

    @Test
    public void doubleCompare_isAlmostZero() {
        double first = 7.002;
        double second = 7.001;
        boolean result = MathUtils.approximately(first, second, 0.001);

        assertEquals(true, result);
    }

    @Test
    public void doubleCompare_isNotZero() {
        double first = 7.002;
        double second = 7.001;
        boolean result = MathUtils.approximately(first, second, 0.0001);

        assertEquals(false, result);
    }

    @Test
    public void doubleCompare_ZeroIsZero() {
        double first = 0.0;
        double second = 0.0;
        boolean result = MathUtils.approximately(first, second, 0.1);

        assertEquals(true, result);
    }

    @Test
    public void doubleCompare_NoTolerance_True() {
        double first = -1;
        double second = -1;
        boolean result = MathUtils.approximately(first, second, 0);

        assertTrue(result);
    }

    @Test
    public void doubleCompare_NoTolerance_False() {
        double first = -1;
        double second = -1.00000000001;
        boolean result = MathUtils.approximately(first, second, 0);

        assertFalse(result);
    }
}
