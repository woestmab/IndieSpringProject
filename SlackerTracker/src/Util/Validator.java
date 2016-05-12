package util;

import interfaces.Form;
import entities.Appointment;
import entities.Location;

import java.util.ArrayList;

/**
 * Created by Bdub on 5/6/16.
 * this class is used to validate forms
 */
public class Validator
{
    /**
     * Valid form boolean.
     *
     * @param form the form
     * @return the boolean
     */
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

    /**
     * Valid appointment boolean.
     *
     * @param appt the appt
     * @return the boolean
     */
    public boolean validAppointment(Appointment appt)
    {
        if (!validString(appt.getTitle())) return false;
        if (!validTime(appt.getStart())) return false;
        if (!validTime(appt.getEnd())) return false;
        if (!validDate(appt.getDate())) return false;
        if (appt.getEnd() < appt.getStart()) return false;
        return true;
    }

    /**
     * Valid time boolean.
     *
     * @param time the time
     * @return the boolean
     */
    public boolean validTime(long time)
    {
        return time > 0;
    }

    /**
     * Valid date boolean.
     *
     * @param date the date
     * @return the boolean
     */
    public boolean validDate(String date)
    {
        return date.matches("\\d{4}[-]\\d{2}[-]\\d{2}");
    }

    //location validation methods

    /**
     * Valid location boolean.
     *
     * @param loc the loc
     * @return the boolean
     */
    public boolean validLocation(Location loc)
    {
        if (!validStreetNumber(loc.getStreetNumber())) return false;
        if (!validString(loc.getStreetName())) return false;
        if (!validString(loc.getCity())) return false;
        if (!validString(loc.getState())) return false;
        if (!validZip(loc.getZip())) return false;
        return true;
    }

    /**
     * Valid street number boolean.
     *
     * @param streetNumber the street number
     * @return the boolean
     */
    public boolean validStreetNumber(int streetNumber)
    {
        return streetNumber > 0;
    }

    /**
     * Valid zip boolean.
     *
     * @param input the input
     * @return the boolean
     */
    public boolean validZip(int input)
    {
        return input > 9999;
    }

    //shared validation methods

    /**
     * Valid string boolean.
     *
     * @param input the input
     * @return the boolean
     */
    public boolean validString(String input)
    {
        if (input != null)
        {
            int length = input.length();
            return length > 0 && length <= 100;
        }
        return false;
    }

    /**
     * Is empty boolean.
     *
     * @param inputs the inputs
     * @return the boolean
     */
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
