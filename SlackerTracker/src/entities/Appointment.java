package entities;

import Interfaces.Form;

import java.util.Date;

/**
 * Created by Bdub on 3/5/16.
 */
public class Appointment implements Form
{
    private static final String type = "Appointment";

    private Integer id;
    private Integer locationsId;
    private String title;
    private String url;
    private String apptClass;
    private String start;
    private String end;

    public String getType()
    {
        return type;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId()
    {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id)
    {
        this.id = id;
    }

    /**
     * Gets locations id.
     *
     * @return the locations id
     */
    public Integer getLocationsId()
    {
        return locationsId;
    }

    /**
     * Sets locations id.
     *
     * @param locationsId the locations id
     */
    public void setLocationsId(Integer locationsId)
    {
        this.locationsId = locationsId;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl()
    {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url)
    {
        this.url = url;
    }

    /**
     * Gets appt class.
     *
     * @return the appt class
     */
    public String getApptClass()
    {
        return apptClass;
    }

    /**
     * Sets appt class.
     *
     * @param apptClass the appt class
     */
    public void setApptClass(String apptClass)
    {
        this.apptClass = apptClass;
    }

    public String getStart()
    {
        return start;
    }

    public void setStart(String start)
    {
        this.start = start;
    }

    public String getEnd()
    {
        return end;
    }

    public void setEnd(String end)
    {
        this.end = end;
    }

    public String toString()
    {
        String string;
        string = "id: " + id + ", locationId: " + locationsId + ", title: " + title +
                ", url: " + url + ", apptClass: " + apptClass + ", start: " + start +
                "," +
                " end: " + end;
        return string;
    }
}
