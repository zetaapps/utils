package zeta.android.utils.lang;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import zeta.android.utils.lang.response.TryParseResponse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DateTimeUtilsTest {
    @Test
    public void DateTimeUtils_constructor() {
        DateTimeUtils util = new DateTimeUtils();
        assertNotNull(util);
    }

    @Test
    public void TryParse_isValid() {
        String inputTime = "2016-01-11T16:00:00Z";
        DateFormat format = new SimpleDateFormat("yyyy-dd-MM'T'HH:mm:ss'Z'", Locale.getDefault());

        TryParseResponse<Date> response = DateTimeUtils.tryParse(format, inputTime);
        assertNotNull(response);
        assertEquals(true, response.isSuccess());
    }

    @Test
    public void TryParse_isNotValid() {
        String inputTime = "2016-01-11";
        DateFormat format = new SimpleDateFormat("yyyy-dd-MM'T'HH:mm:ss.SSSSSSS'Z'", Locale.getDefault());

        TryParseResponse<Date> response = DateTimeUtils.tryParse(format, inputTime);
        assertNotNull(response);
        assertEquals(false, response.isSuccess());
    }

    @Test
    public void TryParse_nullFormatter() {
        String inputTime = "2016-01-11";
        DateFormat format = null;

        TryParseResponse<Date> response = DateTimeUtils.tryParse(format, inputTime);
        assertNotNull(response);
        assertEquals(false, response.isSuccess());
    }

    @Test
    public void TryParse_emptyString() {
        String inputTime = "";
        DateFormat format = new SimpleDateFormat("yyyy-dd-MM'T'HH:mm:ss.SSSSSSS'Z'", Locale.getDefault());

        TryParseResponse<Date> response = DateTimeUtils.tryParse(format, inputTime);
        assertNotNull(response);
        assertEquals(false, response.isSuccess());
    }

    @Test
    public void TryParse_nullString() {
        String inputTime = null;
        DateFormat format = new SimpleDateFormat("yyyy-dd-MM'T'HH:mm:ss.SSSSSSS'Z'", Locale.getDefault());

        TryParseResponse<Date> response = DateTimeUtils.tryParse(format, inputTime);
        assertNotNull(response);
        assertEquals(false, response.isSuccess());
    }

    @Test
    public void GetTodaysDate_isNotValid() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        boolean equal = cal.get(Calendar.DATE) == DateTimeUtils.getTodaysCalendarDate().get(Calendar.DATE);
        assertEquals(false, equal);
    }

    @Test
    public void GetTodaysDate_isValid() {
        Calendar cal = Calendar.getInstance();

        boolean equal = cal.get(Calendar.DATE) == DateTimeUtils.getTodaysCalendarDate().get(Calendar.DATE);
        assertEquals(true, equal);
    }

    @Test
    public void AddTime_addedCorrectTime() {
        int daysToAdd = 2;
        Calendar cal = Calendar.getInstance();
        cal.set(2016, 01, 01);
        Date future = DateTimeUtils.addDays(cal.getTime(), daysToAdd);

        cal.add(Calendar.DATE, daysToAdd);
        int date1 = cal.get(Calendar.DATE);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(future);
        int date2 = cal2.get(Calendar.DATE);

        assertEquals(date1, date2);


    }

    @Test
    public void calculateMilliseconds_millisecondsSimple() {
        int value = DateTimeUtils.convertToMilliseconds(0, 0, 0, 100);
        assertEquals(100, value);
    }

    @Test
    public void calculateMilliseconds_secondsSimple() {
        int value = DateTimeUtils.convertToMilliseconds(0, 0, 1, 0);
        assertEquals(1000, value);
    }

    @Test
    public void calculateMilliseconds_secondsSimpleNegative() {
        int value = DateTimeUtils.convertToMilliseconds(0, 0, -1, 0);
        assertEquals(-1000, value);
    }

    @Test
    public void calculateMilliseconds_minutesSimple() {
        int value = DateTimeUtils.convertToMilliseconds(0, 1, 0, 0);
        assertEquals(60000, value);
    }

    @Test
    public void calculateMilliseconds_minutesSimpleNegative() {
        int value = DateTimeUtils.convertToMilliseconds(0, -1, 0, 0);
        assertEquals(-60000, value);
    }

    @Test
    public void calculateMilliseconds_hourSimple() {
        int value = DateTimeUtils.convertToMilliseconds(1, 0, 0, 0);
        assertEquals(3600000, value);
    }

    @Test
    public void calculateMilliseconds_hourSimpleNegative() {
        int value = DateTimeUtils.convertToMilliseconds(-1, 0, 0, 0);
        assertEquals(-3600000, value);
    }

    @Test
    public void calculateMilliseconds_Zero() {
        int value = DateTimeUtils.convertToMilliseconds(0, 0, 0, 0);
        assertEquals(0, value);
    }

    @Test
    public void calculateMilliseconds_hourSecondMix() {
        int value = DateTimeUtils.convertToMilliseconds(1, 0, 1, 0);
        assertEquals(3601000, value);
    }

    @Test
    public void isSameDay_isSame() {
        Date day1 = Calendar.getInstance().getTime();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 3);

        Date day2 = cal.getTime();

        assertEquals(true, DateTimeUtils.isSameDay(day1, day2));
    }

    @Test
    public void isSameDay_isNotSame() {
        Date day1 = Calendar.getInstance().getTime();
        Calendar calTest = Calendar.getInstance();
        calTest.set(Calendar.YEAR, 2016);
        calTest.set(Calendar.MONTH, 2);
        calTest.set(Calendar.DAY_OF_MONTH, 5);
        calTest.set(Calendar.HOUR_OF_DAY, 13);
        calTest.set(Calendar.MINUTE, 23);

        Date day2 = calTest.getTime();

        assertNotEquals(true, DateTimeUtils.isSameDay(day1, day2));
    }

    @Test
    public void getSimpleDate_midnight() {
        Calendar calTest = Calendar.getInstance();
        calTest.set(Calendar.YEAR, 2016);
        calTest.set(Calendar.MONTH, 2);
        calTest.set(Calendar.DAY_OF_MONTH, 5);
        calTest.set(Calendar.HOUR_OF_DAY, 13);
        calTest.set(Calendar.MINUTE, 23);

        Calendar control = Calendar.getInstance();
        control.set(Calendar.YEAR, 2016);
        control.set(Calendar.MONTH, 2);
        control.set(Calendar.DAY_OF_MONTH, 5);
        control.set(Calendar.HOUR_OF_DAY, 0);
        control.set(Calendar.MINUTE, 0);
        control.set(Calendar.SECOND, 0);
        control.set(Calendar.MILLISECOND, 0);

        assertEquals(control.getTime(), DateTimeUtils.getSimpleDate(calTest.getTime()));
    }

    @Test
    public void daysDifference_sameDay() {
        Calendar dayOne = Calendar.getInstance();
        dayOne.set(Calendar.YEAR, 2016);
        dayOne.set(Calendar.MONTH, 2);
        dayOne.set(Calendar.DAY_OF_MONTH, 5);
        dayOne.set(Calendar.HOUR_OF_DAY, 13);
        dayOne.set(Calendar.MINUTE, 23);

        Calendar dayTwo = Calendar.getInstance();
        dayTwo.set(Calendar.YEAR, 2016);
        dayTwo.set(Calendar.MONTH, 2);
        dayTwo.set(Calendar.DAY_OF_MONTH, 5);
        dayTwo.set(Calendar.HOUR_OF_DAY, 1);
        dayTwo.set(Calendar.MINUTE, 0);
        dayTwo.set(Calendar.SECOND, 0);
        dayTwo.set(Calendar.MILLISECOND, 1);

        assertEquals(0, DateTimeUtils.daysDifference(dayOne.getTime(), dayTwo.getTime()));
    }

    @Test
    public void daysDifference_minusOne() {
        Calendar dayOne = Calendar.getInstance();
        dayOne.set(Calendar.YEAR, 2016);
        dayOne.set(Calendar.MONTH, 2);
        dayOne.set(Calendar.DAY_OF_MONTH, 6);
        dayOne.set(Calendar.HOUR_OF_DAY, 13);
        dayOne.set(Calendar.MINUTE, 23);

        Calendar dayTwo = Calendar.getInstance();
        dayTwo.set(Calendar.YEAR, 2016);
        dayTwo.set(Calendar.MONTH, 2);
        dayTwo.set(Calendar.DAY_OF_MONTH, 5);
        dayTwo.set(Calendar.HOUR_OF_DAY, 1);
        dayTwo.set(Calendar.MINUTE, 0);
        dayTwo.set(Calendar.SECOND, 0);
        dayTwo.set(Calendar.MILLISECOND, 1);

        assertEquals(-1, DateTimeUtils.daysDifference(dayOne.getTime(), dayTwo.getTime()));
    }

    @Test
    public void daysDifference_plusOne() {
        Calendar dayOne = Calendar.getInstance();
        dayOne.set(Calendar.YEAR, 2016);
        dayOne.set(Calendar.MONTH, 2);
        dayOne.set(Calendar.DAY_OF_MONTH, 4);
        dayOne.set(Calendar.HOUR_OF_DAY, 13);
        dayOne.set(Calendar.MINUTE, 23);

        Calendar dayTwo = Calendar.getInstance();
        dayTwo.set(Calendar.YEAR, 2016);
        dayTwo.set(Calendar.MONTH, 2);
        dayTwo.set(Calendar.DAY_OF_MONTH, 5);
        dayTwo.set(Calendar.HOUR_OF_DAY, 1);
        dayTwo.set(Calendar.MINUTE, 0);
        dayTwo.set(Calendar.SECOND, 0);
        dayTwo.set(Calendar.MILLISECOND, 1);

        assertEquals(1, DateTimeUtils.daysDifference(dayOne.getTime(), dayTwo.getTime()));
    }

    @Test
    public void daysAwayFromToday_yesterday() {
        Calendar yesterday = DateTimeUtils.getTodaysCalendarDate(-1);

        assertEquals(-1, DateTimeUtils.daysAwayFromToday(yesterday.getTime()));
    }

    @Test
    public void daysAwayFromToday_tomorrow() {
        Calendar yesterday = DateTimeUtils.getTodaysCalendarDate(1);

        assertEquals(1, DateTimeUtils.daysAwayFromToday(yesterday.getTime()));
    }

    @Test
    public void isCurrent_isTrueFuture_LongArgument() {
        Date testDate = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTime();
        testDate.setTime(testDate.getTime() + 100);
        boolean current = DateTimeUtils.isCurrent(testDate.getTime(), 500);
        assertTrue(current);
    }

    @Test
    public void isCurrent_isTrueFuture() {
        Date testDate = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTime();
        testDate.setTime(testDate.getTime() + 100);
        boolean current = DateTimeUtils.isCurrent(testDate, 500);
        assertTrue(current);
    }

    @Test
    public void isCurrent_isTruePast() {
        Date testDate = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTime();
        testDate.setTime(testDate.getTime() - 100);
        boolean current = DateTimeUtils.isCurrent(testDate, 500);
        assertTrue(current);
    }

    @Test
    public void isCurrent_isFalseFuture() {
        Date testDate = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTime();
        testDate.setTime(testDate.getTime() + 1000);
        boolean current = DateTimeUtils.isCurrent(testDate, 500);
        assertFalse(current);
    }

    @Test
    public void isCurrent_isFalsePast() {
        Date testDate = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTime();
        testDate.setTime(testDate.getTime() - 1000);
        boolean current = DateTimeUtils.isCurrent(testDate, 500);
        assertFalse("IsFalsePast", current);
    }

    @Test
    public void isCurrent_isFalsePastWithFuture() {
        Date testDate = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTime();
        testDate.setTime(testDate.getTime() - 500);
        boolean current = DateTimeUtils.isCurrent(testDate, 0, 2000);
        assertFalse(current);
    }

    @Test
    public void isCurrent_isFalseFutureWithPast() {
        Date testDate = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTime();
        testDate.setTime(testDate.getTime() + 500);
        boolean current = DateTimeUtils.isCurrent(testDate, 2000, 0);
        assertFalse(current);
    }

    @Test
    public void isCurrent_isTruePastWithFuture() {
        Date testDate = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTime();
        testDate.setTime(testDate.getTime() + 500);
        boolean current = DateTimeUtils.isCurrent(testDate, 0, 2000);
        assertTrue(current);
    }

    @Test
    public void isCurrent_isTrueFutureWithPast() {
        Date testDate = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTime();
        testDate.setTime(testDate.getTime() - 500);
        boolean current = DateTimeUtils.isCurrent(testDate, 2000, 0);
        assertTrue(current);
    }

}
