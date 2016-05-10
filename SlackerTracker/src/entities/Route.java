package entities;

/**
 * Created by Bdub on 5/10/16.
 */
public class Route
{
    private String busNumber;
    private String busDescription;
    private String departureTime;
    private String stopLocation;

    public String getBusNumber()
    {
        return busNumber;
    }

    public void setBusNumber(String busNumber)
    {
        this.busNumber = busNumber;
    }

    public String getBusDescription()
    {
        return busDescription;
    }

    public void setBusDescription(String busDescription)
    {
        this.busDescription = busDescription;
    }

    public String getDepartureTime()
    {
        return departureTime;
    }

    public void setDepartureTime(String departureTime)
    {
        this.departureTime = departureTime;
    }

    public String getStopLocation()
    {
        return stopLocation;
    }

    public void setStopLocation(String stopLocation)
    {
        this.stopLocation = stopLocation;
    }
}
