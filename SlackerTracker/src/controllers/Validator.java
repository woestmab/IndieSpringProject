package controllers;

import Interfaces.Form;
import entities.Appointment;
import entities.Location;

import java.util.Date;

/**
 * Created by Bdub on 5/6/16.
 */

public class Validator
{
    private Form form;

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

    private boolean validZip(int input)
    {
        return input > 9999;
    }
}
