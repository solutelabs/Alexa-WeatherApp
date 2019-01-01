package com.stllpt.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Time Related Utils
 */
public class TimingUtils {

    /**
     * All Timing Date format
     */
    public static final String All_TIMING_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String Booking_TIMING_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * Club timings format
     */
    public static final String FORMAT_HOUR_MINUTE = "HH:mm";
    /**
     * Going to Club send format
     */
    public static final String GOING_CLUB_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    /**
     * Message Display format date time
     */
    public static final String NOTIFICATION_DATETIME_FORMAT = "EEEE dd MMMM HH:mm";
    /**
     * Message disaplay with day name
     */
    public static final String NOTIFICATION_DATE_FORMAT = "EEEE dd MMMM";
    /**
     * Message time format
     */
    public static final String NOTIFICATION_TIME_FORMAT = "HH:mm";
    /**
     * Booking Ahead message time format
     */
    public static final String BOOKING_AHEAD_TIME_FORMAT = "h:mm a";
    /**
     * Booking ahead message Date format
     */
    public static final String BOOKING_AHEAD_DATE_FORMAT = "M dd,yyyy";
    /**
     * Feedback date format
     */
    public static final String FEEDBACK_DATE_FORMAT = "dd MMM yyyy";
    /**
     * Scheduler date format
     */
    public static final String SCHEDULER_TIME_FORMAT = "HH:mm";
    /**
     * Joda DateTime format
     */
    public static final String JODA_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    /**
     * Message disaplay with day name
     */
    public static final String BOOKING_DATE_FORMAT = "EEEE dd MMMM";
    /**
     * Message time format
     */
    public static final String BOOKING_TIME_FORMAT = "HH:mm";

    public static final String NOTIFICATION_LIST_DATE_FORMAT = "dd MMMM yyyy";
    /**
     * Message time format
     */
    public static final String CHECK_BOOKING_TIME_FORMAT = "HH:mm:ss";
    public static final String ALEXA_DATE_FORMAT = "yyyy-MM-dd";

    /**
     * Special closing hour message date format
     */
    public static final String SPECIAL_HOUR_MESSAGE_DATE_FORMAT = "dd/MM/yyyy";
    /**
     * Special closing hour message time format
     */
    public static final String SPECIAL_HOUR_MESSAGE_TIME_FORMAT = "HH:mm";

    private static final String TAG = "TimingUtils";
    private static final String UTC_LABEL = "UTC";
    private static final String DEFAULT_TIME = "00:00";
    private static boolean isBookingValid = false;
    private static boolean isDeleteValid = false;

    private static String eventMessage;

    private static int getFormattedTime(int time) {
        try {
            NumberFormat formatter = new DecimalFormat("00");
            String s = formatter.format(time);
            return Integer.parseInt(s);
        } catch (Exception e) {
            return time;
        }
    }

    public static String getTimeOffset() {
        final Date currentTime = new Date();

        final SimpleDateFormat sdf =
                new SimpleDateFormat("EEE, MMM d, yyyy hh:mm:ss a z");

        // Give it to me in GMT time.
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        return sdf.format(currentTime);
    }

    public static Date getWeekStartDate() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
        c.add(Calendar.DAY_OF_MONTH, -dayOfWeek);
        c.set(Calendar.HOUR_OF_DAY, 00);
        c.set(Calendar.MINUTE, 00);
        c.set(Calendar.SECOND, 00);
        c.set(Calendar.MILLISECOND, 000);
        Date weekStart = c.getTime();


        return weekStart;
    }

    /**
     * Get Calendar instance to fetch today's day of week
     *
     * @return Returns
     */
    public static int getCurrentDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * Get Calendar instance to fetch Current Month
     *
     * @return Returns
     */
    public static int getCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH);
    }

    /**
     * Get Month from date
     *
     * @return Returns
     */
    public static int getMonthFromDate(Date date) {
        String formatted = new SimpleDateFormat("MM").format(date);
        int month = Integer.parseInt(formatted);
        return month - 1;
    }

    public static int getDayOfMonthFromDate(String date) {
        return getDayOfMonthFromDate(getDateObj(date));
    }

    public static int getDayOfMonthFromDate(Date date) {
        String formatted = new SimpleDateFormat("dd").format(date);
        int dayOfMonth = Integer.parseInt(formatted);
        return dayOfMonth;
    }

    public static int getDayOfWeekFromDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * get date obj from date string
     *
     * @param ourDate
     * @return
     */
    public static Date getDateObj(String ourDate) {
        SimpleDateFormat formatter = new SimpleDateFormat(ALEXA_DATE_FORMAT);
        formatter.setTimeZone(TimeZone.getTimeZone(UTC_LABEL));
        try {
            Date value = formatter.parse(ourDate);
            return value;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    /**
     * Check if Club Timing date is valid
     *
     * @param date date in string format
     * @return Returns
     */
    public static boolean isDateValid(String date) {
        try {
            DateFormat df = new SimpleDateFormat(All_TIMING_DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * Convert Club Timing date in proper format
     *
     * @param ourDate Date in ISO format
     * @return Returns
     */
    public static String getLocalTime(Date ourDate) {
        String resultDate = "";
        try {
            SimpleDateFormat dateFormatter = new SimpleDateFormat(FORMAT_HOUR_MINUTE);
            dateFormatter.setTimeZone(TimeZone.getDefault());
            resultDate = dateFormatter.format(ourDate);
        } catch (Exception e) {
            resultDate = DEFAULT_TIME;
        }
        return resultDate;
    }

    /**
     * Convert Club Timing date in proper format
     *
     * @param ourDate Date in ISO format
     * @return Returns
     */
    public static String getUTCtoLocalDate(String ourDate) {
        String resultDate = "";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(All_TIMING_DATE_FORMAT);
            formatter.setTimeZone(TimeZone.getTimeZone(UTC_LABEL));
            Date value = formatter.parse(ourDate);

            SimpleDateFormat dateFormatter = new SimpleDateFormat(All_TIMING_DATE_FORMAT);
            dateFormatter.setTimeZone(TimeZone.getDefault());
            resultDate = dateFormatter.format(value);
        } catch (Exception e) {
            resultDate = DEFAULT_TIME;
        }
        return resultDate;
    }

    /**
     * Convert Joda date in proper format
     *
     * @param ourDate Date in Joda format
     * @return Returns
     */
    public static String convertJodaToProperFormat(String ourDate) {
        String resultDate = "";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(JODA_DATE_FORMAT);
            formatter.setTimeZone(TimeZone.getDefault());
            Date value = formatter.parse(ourDate);

            SimpleDateFormat dateFormatter = new SimpleDateFormat(All_TIMING_DATE_FORMAT);
            dateFormatter.setTimeZone(TimeZone.getDefault());
            resultDate = dateFormatter.format(value);
        } catch (Exception e) {
            resultDate = DEFAULT_TIME;
        }
        return resultDate;
    }

    /**
     * Convert Scheduler date in DateTime format
     *
     * @param ourDate Date
     * @return Returns
     */
    public static DateTime getSchedulerDateFormat(String ourDate) {
        return DateTime.parse(ourDate);
    }

    /**
     * Convert Current date for Going to Club Format
     *
     * @return Returns
     */
    public static String getCurrentDateInGoingToClubFormat() {
        String currentDateTimeString = new SimpleDateFormat(
                GOING_CLUB_DATETIME_FORMAT).format(new Date());
        return currentDateTimeString;
    }

    /**
     * Convert Notification Date in proper format
     *
     * @param ourDate Date in ISO format
     * @return Returns
     */
    public static String getNotificationDate(String ourDate) {
        String resultDate = "";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(All_TIMING_DATE_FORMAT);
            formatter.setTimeZone(TimeZone.getTimeZone(UTC_LABEL));
            Date value = formatter.parse(ourDate);

            SimpleDateFormat dateFormatter = new SimpleDateFormat(NOTIFICATION_DATETIME_FORMAT);
            dateFormatter.setTimeZone(TimeZone.getDefault());
            resultDate = dateFormatter.format(value);
        } catch (Exception e) {
            resultDate = DEFAULT_TIME;
        }
        return resultDate;
    }

    /**
     * Convert Notification Date in proper format
     *
     * @param ourDate Date in ISO format
     * @return Returns
     */
    public static String getFeedbackDateFormat(String ourDate) {
        String resultDate = "";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(All_TIMING_DATE_FORMAT);
            formatter.setTimeZone(TimeZone.getTimeZone(UTC_LABEL));
            Date value = formatter.parse(ourDate);

            SimpleDateFormat dateFormatter = new SimpleDateFormat(FEEDBACK_DATE_FORMAT);
            dateFormatter.setTimeZone(TimeZone.getDefault());
            resultDate = dateFormatter.format(value);
        } catch (Exception e) {
            resultDate = DEFAULT_TIME;
        }
        return resultDate;
    }

    /**
     * Get Club Message date and time
     *
     * @param ourDate Date in ISO Format
     * @return Returns
     */
    public static String getClubMessageDateTimings(String ourDate) {
        String resultDate = "";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(All_TIMING_DATE_FORMAT);
            formatter.setTimeZone(TimeZone.getTimeZone(UTC_LABEL));
            Date value = formatter.parse(ourDate);

            SimpleDateFormat dateFormatter = new SimpleDateFormat(NOTIFICATION_DATE_FORMAT);
            dateFormatter.setTimeZone(TimeZone.getDefault());
            String date = dateFormatter.format(value);

            SimpleDateFormat dateFormatter1 = new SimpleDateFormat(NOTIFICATION_TIME_FORMAT);
            dateFormatter1.setTimeZone(TimeZone.getDefault());
            String time = dateFormatter1.format(value);

            resultDate = date + ", " + time;
        } catch (Exception e) {
            resultDate = DEFAULT_TIME;
        }
        return resultDate;
    }

    public static String getBookingDate(String ourDate) {
        String resultDate = "";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(All_TIMING_DATE_FORMAT);
            formatter.setTimeZone(TimeZone.getTimeZone(UTC_LABEL));
            Date value = formatter.parse(ourDate);

            SimpleDateFormat dateFormatter = new SimpleDateFormat(BOOKING_DATE_FORMAT);
            dateFormatter.setTimeZone(TimeZone.getDefault());
            String date = dateFormatter.format(value);

            resultDate = date;
        } catch (Exception e) {
            resultDate = DEFAULT_TIME;
        }
        return resultDate;
    }

    public static String getBookingTimings(String ourDate) {
        String resultDate = "";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(All_TIMING_DATE_FORMAT);
            formatter.setTimeZone(TimeZone.getTimeZone(UTC_LABEL));
            Date value = formatter.parse(ourDate);

            SimpleDateFormat dateFormatter1 = new SimpleDateFormat(BOOKING_TIME_FORMAT);
            dateFormatter1.setTimeZone(TimeZone.getDefault());
            String time = dateFormatter1.format(value);

            resultDate = time;
        } catch (Exception e) {
            resultDate = DEFAULT_TIME;
        }
        return resultDate;
    }

    public static String getNotificationListDate(String ourDate) {
        String resultDate = "";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(All_TIMING_DATE_FORMAT);
            formatter.setTimeZone(TimeZone.getTimeZone(UTC_LABEL));
            Date value = formatter.parse(ourDate);

            SimpleDateFormat dateFormatter1 = new SimpleDateFormat(NOTIFICATION_LIST_DATE_FORMAT);
            dateFormatter1.setTimeZone(TimeZone.getDefault());
            String time = dateFormatter1.format(value);

            resultDate = time;
        } catch (Exception e) {
            resultDate = DEFAULT_TIME;
        }
        return resultDate;
    }

    public static String getCheckBookingTimings(String ourDate) {
        String resultDate = "";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(All_TIMING_DATE_FORMAT);
            formatter.setTimeZone(TimeZone.getTimeZone(UTC_LABEL));
            Date value = formatter.parse(ourDate);

            SimpleDateFormat dateFormatter1 = new SimpleDateFormat(CHECK_BOOKING_TIME_FORMAT);
            dateFormatter1.setTimeZone(TimeZone.getDefault());
            String time = dateFormatter1.format(value);

            resultDate = time;
        } catch (Exception e) {
            resultDate = DEFAULT_TIME;
        }
        return resultDate;
    }

    public static String getCheckBookingDate(String ourDate) {
        String resultDate = "";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(All_TIMING_DATE_FORMAT);
            formatter.setTimeZone(TimeZone.getTimeZone(UTC_LABEL));
            Date value = formatter.parse(ourDate);

            SimpleDateFormat dateFormatter1 = new SimpleDateFormat(ALEXA_DATE_FORMAT);
            dateFormatter1.setTimeZone(TimeZone.getDefault());
            String time = dateFormatter1.format(value);

            resultDate = time;
        } catch (Exception e) {
            resultDate = DEFAULT_TIME;
        }
        return resultDate;
    }

    /**
     * Get Scheduler Activity time
     *
     * @param ourDate Date in ISO Format
     * @return Returns
     */
    public static String getSchedulerTimings(String ourDate) {
        String resultDate = "";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(All_TIMING_DATE_FORMAT);
            formatter.setTimeZone(TimeZone.getTimeZone(UTC_LABEL));
            Date value = formatter.parse(ourDate);

            SimpleDateFormat dateFormatter1 = new SimpleDateFormat(SCHEDULER_TIME_FORMAT);
            dateFormatter1.setTimeZone(TimeZone.getDefault());
            String time = dateFormatter1.format(value);

            resultDate = time;
        } catch (Exception e) {
            resultDate = DEFAULT_TIME;
        }
        return resultDate;
    }

    public static String convertBookingDateTime(String ourDate) {
        String resultDate = "";
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(Booking_TIMING_DATE_FORMAT);
            formatter.setTimeZone(TimeZone.getDefault());
            Date value = formatter.parse(ourDate);

            SimpleDateFormat dateFormatter1 = new SimpleDateFormat(All_TIMING_DATE_FORMAT);
            dateFormatter1.setTimeZone(TimeZone.getDefault());
            String time = dateFormatter1.format(value);

            resultDate = time;
        } catch (Exception e) {
            resultDate = DEFAULT_TIME;
        }
        return resultDate;
    }


    /**
     * @param deleteDate
     * @param deleteTime
     * @param aheadhours
     * @return
     */
    public static boolean checkDeleteAheadTime(String deleteDate, String deleteTime, int aheadhours) {
        isDeleteValid = false;
        SimpleDateFormat deleteDateFormat = new SimpleDateFormat(Booking_TIMING_DATE_FORMAT);
        SimpleDateFormat dfDate = new SimpleDateFormat(All_TIMING_DATE_FORMAT);
        try {
            Date deleteDateObj = deleteDateFormat.parse(deleteDate + " " + deleteTime);
            DateTime deleteDateTimeObj = new DateTime(deleteDateObj);
            deleteDateTimeObj = deleteDateTimeObj.minusHours(aheadhours);
            String deleteDateTime = convertJodaToProperFormat(deleteDateTimeObj.toString());
            Date finaldeleteDateTime = dfDate.parse(deleteDateTime);

            DateTime dateTime = new DateTime();
            String currentDate = dateTime.toString();
            String currentDateTime = convertJodaToProperFormat(currentDate);
            Date finalCurrentDateTime = dfDate.parse(currentDateTime);

            if (finalCurrentDateTime.before(finaldeleteDateTime)) {
                isDeleteValid = true;
            } else if (finalCurrentDateTime.equals(finaldeleteDateTime)) {
                isDeleteValid = true;
            } else {
                isDeleteValid = false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return isDeleteValid;
    }

    private static String getAM_PM(Calendar c) {
        String AM_PM = String.valueOf(c.get(Calendar.AM_PM));
        String AM_PM_TIME = "";
        if (AM_PM.equals("0")) {
            AM_PM_TIME = "AM";
        } else {
            AM_PM_TIME = "PM";
        }
        return AM_PM_TIME;
    }

    private static String getBookingAheaddTime(Date bookingDate) {
        SimpleDateFormat dfBookingAheadFormat = new SimpleDateFormat(BOOKING_AHEAD_TIME_FORMAT);
        String time = dfBookingAheadFormat.format(bookingDate);
        return time;
    }

    private static boolean isEventToday(Date bookingBookingDateTimeLimit) {
        Calendar c = Calendar.getInstance();
        Calendar bookingCalender = Calendar.getInstance();
        bookingCalender.setTime(bookingBookingDateTimeLimit); // booking date

        if (c.get(Calendar.YEAR) == bookingCalender.get(Calendar.YEAR)
                && c.get(Calendar.DAY_OF_YEAR) == bookingCalender.get(Calendar.DAY_OF_YEAR)) {
            if (bookingCalender.after(c)) {
                return true;
            }
            return false;
        }

        return false;
    }

    private static boolean isEventTomorrow(Date bookingBookingDateTimeLimit) {
        Calendar c1 = Calendar.getInstance(); // today

        Calendar bookingCalender = Calendar.getInstance();
        bookingCalender.setTime(bookingBookingDateTimeLimit); // booking date
        bookingCalender.add(Calendar.DAY_OF_YEAR, -1); // 1 day before booking date

        if (c1.get(Calendar.YEAR) == bookingCalender.get(Calendar.YEAR)
                && c1.get(Calendar.DAY_OF_YEAR) == bookingCalender.get(Calendar.DAY_OF_YEAR)) {
            return true;
        }
        return false;
    }

    private static boolean isEventAfterMorethanOneDay(Date bookingBookingDateTimeLimit) {
        Calendar currentCalender = Calendar.getInstance(); // current date

        Calendar bookingCalender = Calendar.getInstance();
        bookingCalender.setTime(bookingBookingDateTimeLimit); // booking date
        bookingCalender.add(Calendar.DAY_OF_YEAR, -2);// 2 day before booking date
        if ((currentCalender.get(Calendar.YEAR) == bookingCalender.get(Calendar.YEAR) && currentCalender.get(Calendar.DAY_OF_YEAR) == bookingCalender.get(Calendar.DAY_OF_YEAR))
                || bookingCalender.after(currentCalender)) {
            return true;
        }
        return false;
    }

    public static DateTime convertStringtoJoda(String string) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(All_TIMING_DATE_FORMAT);
        DateTime dt = formatter.parseDateTime(string);
        return dt;
    }
}
