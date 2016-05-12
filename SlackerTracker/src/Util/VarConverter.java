package util;

import com.oracle.tools.packager.Log;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by Bdub on 5/7/16.
 * this class converts variables to other types
 */
public class VarConverter
{
    private static Logger log = Logger.getLogger("servlets.VarConverter");

    /**
     * String to local date.
     *
     * @param dateInput the date input
     * @return the local date
     */
    public LocalDate stringToLocalDate(String dateInput)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-d-MM", Locale.ENGLISH);
        return LocalDate.parse(dateInput, formatter);
    }

    /**
     * String to time in ms.
     *
     * @param timeInput the time input
     * @param dateInput the date input
     * @return the long
     */
    public long stringToTimeInMs(String timeInput, String dateInput)
    {
        DateTime date = DateTime.parse(dateInput + " " + timeInput,
                DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));

        log.debug(date.getMillis());

        return date.getMillis();
    }
}
