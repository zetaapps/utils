package zeta.android.utils.lang;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import zeta.android.utils.lang.response.TryParseResponse;

public class DateTimeUtils {
    /**
     * Attempts to parse a string using the provided formatter and returns a
     * response object with success indicator and value if applicable
     *
     * @param format     DateFormat object to try and parse the string with
     * @param dateString Date string to be parsed
     * @return Response object containing success indicator and value
     */
    public static TryParseResponse<Date> tryParse(DateFormat format, String dateString) {
        TryParseResponse<Date> response = new TryParseResponse<>(null, false);

        if (format != null && !StringUtils.isNullOrWhitespace(dateString)) {
            try {
                Date date = format.parse(dateString);
                response = new TryParseResponse<>(date, true);
            } catch (ParseException e) {
                response = new TryParseResponse<>(null, false);
            }
        }

        return response;
    }

    /**
     * Calendar object set to today's date +- addDays
     *
     * @param addDays number of days to add to today's date
     * @return Calendar object representing the calculated date
     */
    public static Calendar getTodaysCalendarDate(int addDays) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, addDays);

        return cal;
    }

    /**
     * Calendar object set to today's date
     *
     * @return Calendar object representing today's date
     */
    public static Calendar getTodaysCalendarDate() {
        return getTodaysCalendarDate(0);
    }

    /**
     * Adds the given number of days to a date object
     *
     * @param date Starting date object
     * @param days Number of days to add to current date
     * @return A new date object x days away from the original date
     */
    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);

        return cal.getTime();
    }

    /**
     * Simple method to clearly define a given time interval in milliseconds
     *
     * @return int containing the number of milliseconds of the hours, minutes, seconds and milliseconds passed in
     */
    public static int convertToMilliseconds(int hours, int minutes, int seconds, int milliseconds) {
        int hourMinutes = hours * 60;
        int totalSeconds = (minutes + hourMinutes) * 60 + seconds;
        return totalSeconds * 1000 + milliseconds;
    }

    /**
     * Returns the number of days a given date is from the current date
     *
     * @param date
     * @return int of the number of days away from today
     */
    public static int daysAwayFromToday(Date date) {
        Date today = getTodaysCalendarDate().getTime();
        return daysDifference(today, date);
    }

    /**
     * Day2 - Day1 returned as a number of days
     *
     * @param day1
     * @param day2
     * @return integer representation of the differences between day 2 and day1
     */
    public static int daysDifference(Date day1, Date day2) {
        if (day1 == null || day2 == null) {
            return 0;
        }
        Date startDate = getSimpleDate(day1);
        Date endDate = getSimpleDate(day2);

        long timeDiff = endDate.getTime() - startDate.getTime();

        int daysDifference = (int) (timeDiff / convertToMilliseconds(24, 0, 0, 0));

        return daysDifference;
    }

    /**
     * Checks to see if day1 and day2 are the same day, ignoring the time
     *
     * @param day1
     * @param day2
     * @return true if day1 and day2 are the same calendar date
     */
    public static boolean isSameDay(Date day1, Date day2) {
        if (day1 == null || day2 == null) return false;

        Date firstDay = getSimpleDate(day1);
        Date secondDay = getSimpleDate(day2);

        return firstDay.equals(secondDay);
    }

    /**
     * Checks to see if the given date is within the specified variance of the current date/time
     *
     * @param date     date to check
     * @param variance allowable variance in ms
     * @return true if the given date is within the variance
     */
    public static boolean isCurrent(Date date, long variance) {
        return isCurrent(date.getTime(), variance, variance);
    }

    /**
     * Checks to see if the given date is within the specified variance of the current date/time
     *
     * @param date     date in ms to check
     * @param variance allowable variance in ms
     * @return true if the given date is within the variance
     */
    public static boolean isCurrent(long date, long variance) {
        return isCurrent(date, variance, variance);
    }

    /**
     * Checks to see if the given date is within the specified variance of the current date/time
     *
     * @param date         date to check
     * @param msBeforeDate allowable variance before the current time in ms
     * @param msAfterDate  allowable variance after the current time in ms
     * @return true if the given date is within the variance
     */
    public static boolean isCurrent(Date date, long msBeforeDate, long msAfterDate) {
        return isCurrent(date.getTime(), msBeforeDate, msAfterDate);
    }

    /**
     * Checks to see if the given date is within the specified variance of the current date/time
     *
     * @param date         date, in ms, to check
     * @param msBeforeDate allowable variance before the current time in ms
     * @param msAfterDate  allowable variance after the current time in ms
     * @return true if the given date is within the variance
     */
    public static boolean isCurrent(long date, long msBeforeDate, long msAfterDate) {
        long time = Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis();

        long historyMs = time - msBeforeDate;
        long futureMs = time + msAfterDate;

        return (date > historyMs) && (date < futureMs);
    }

    /**
     * Converts a given date to a date object with the hour, minute, second, and millisecond set to 0
     *
     * @param date
     * @return New date object with the day, month and year set from the given date
     */
    public static Date getSimpleDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }
}
