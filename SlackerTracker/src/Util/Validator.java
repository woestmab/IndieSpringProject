package util;

import interfaces.Form;
import entities.Appointment;
import entities.Location;

import java.util.ArrayList;

/**
 * Created by Bdub on 5/6/16.
 */

public class Validator
{
    public boolean validForm(Form form)
    {
        switch (form.getType())
        {
            case "Appointment":
                return validAppointment((Appointment)form);
            case "Location":
                return validLocation((Location)form);
            default:
                return false;
        }
    }

    //appointment validation methods

    public boolean validAppointment(Appointment appt)
    {
        if (!validString(appt.getTitle())) return false;
        if (!validTime(appt.getStart())) return false;
        if (!validTime(appt.getEnd())) return false;
        if (!validDate(appt.getDate())) return false;
        if (appt.getEnd() < appt.getStart()) return false;
        return true;
    }

    public boolean validTime(long time)
    {
        return time > 0;
    }

    public boolean validDate(String date)
    {
        return date.matches("\\d{4}[-]\\d{2}[-]\\d{2}");
    }

    //location validation methods

    public boolean validLocation(Location loc)
    {
        if (!validStreetNumber(loc.getStreetNumber())) return false;
        if (!validString(loc.getStreetName())) return false;
        if (!validString(loc.getCity())) return false;
        if (!validString(loc.getState())) return false;
        if (!validZip(loc.getZip())) return false;
        return true;
    }

    public boolean validStreetNumber(int streetNumber)
    {
        return streetNumber > 0;
    }

    public boolean validZip(int input)
    {
        return input > 9999;
    }

    //shared validation methods

    public boolean validString(String input)
    {
        if (input != null)
        {
            int length = input.length();
            // TODO: 5/8/16 properties file
            return length > 0 && length <= 100;
        }
        return false;
    }

    public boolean isEmpty(ArrayList<String> inputs)
    {
        for (String s : inputs)
        {
            if (s == null || s.length() == 0)
            {
                return true;
            }
        }
        return false;
    }
}
