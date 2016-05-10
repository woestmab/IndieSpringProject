package entities;

import interfaces.Form;

/**
 * Created by Bdub on 3/5/16.
 */
public class Appointment implements Form
{
    private static final String type = "Appointment";

    // TODO: 5/8/16 transients won't be serialized and converted to json
    private Integer id;
    private transient Integer locationsId;
    private transient Location location;

    private String title;

    private transient String url;
    private transient String apptClass;

    private long start;
    private long end;


    private transient String date;

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

    public Location getLocation()
    {
        return location;
    }

    public void setLocation(Location location)
    {
        this.location = location;
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

    public long getStart()
    {
        return start;
    }

    public void setStart(long start)
    {
        this.start = start;
    }

    public long getEnd()
    {
        return end;
    }

    public void setEnd(long end)
    {
        this.end = end;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
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
