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
    private Form form;

    private boolean validAppointment(Appointment appt)
    {
        if (!validString(appt.getTitle())) return false;
        if (!validDate(appt.getStart())) return false;
        return false;
    }

    private boolean validLocation(Location loc)
    {
        return false;
    }

    private boolean validDate(String date)
    {
        return false;
    }

    private boolean validString(String input)
    {
        int length;
        length = input.length();
        return length > 0 && length <= 100;
    }

    public boolean validZip(int input)
    {
        return input > 9999;
    }

    public boolean isEmpty(ArrayList<String> inputs)
    {
        for (String input : inputs)
        {
            if (input.length() == 0)
            {
                return true;
            }
        }
        return false;
    }

    public boolean validate(Form form)
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
}
