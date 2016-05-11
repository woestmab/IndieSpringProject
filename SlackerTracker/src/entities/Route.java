package entities;

/**
 * Created by Bdub on 5/10/16.
 */
public class Route
{
    private String busNumber;
    private String stopLocation;
    private String departureStop;
    private String departureTime;
    private String arrivalStop;
    private String arrivalTime;

    public String getBusNumber()
    {
        return busNumber;
    }

    public void setBusNumber(String busNumber)
    {
        this.busNumber = busNumber;
    }

    public String getArrivalStop()
    {
        return arrivalStop;
    }

    public void setArrivalStop(String arrivalStop)
    {
        this.arrivalStop = arrivalStop;
    }

    public String getDepartureStop()
    {
        return departureStop;
    }

    public void setDepartureStop(String departureStop)
    {
        this.departureStop = departureStop;
    }

    public String getArrivalTime()
    {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime)
    {
        this.arrivalTime = arrivalTime;
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
