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
 */
public class VarConverter
{
    private static Logger log = Logger.getLogger("servlets.MakeLocationServlet");

    public LocalDate stringToLocalDate(String dateInput)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-d-MM", Locale.ENGLISH);
        return LocalDate.parse(dateInput, formatter);
    }

    public long stringToTimeInMs(String timeInput, String dateInput)
    {
        DateTime date = DateTime.parse(dateInput + " " + timeInput,
                DateTimeFormat.forPattern("yyyy-MM-dd HH:mm"));

        log.debug(date.getMillis());

        return date.getMillis();
    }
}