package controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by Bdub on 5/7/16.
 */
public class VarConverter
{
    public LocalDate stringToLocalDate(String dateInput)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-d-MM", Locale.ENGLISH);
        return LocalDate.parse(dateInput, formatter);
    }
}
