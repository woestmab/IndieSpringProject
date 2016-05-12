package entities;

/**
 * Created by Bdub on 5/10/16.
 * this class is the pojo for the route information
 */
public class Route
{
    private String busNumber;
    private String stopLocation;
    private String departureStop;
    private String departureTime;
    private String arrivalStop;
    private String arrivalTime;

    /**
     * Gets bus number.
     *
     * @return the bus number
     */
    public String getBusNumber()
    {
        return busNumber;
    }

    /**
     * Sets bus number.
     *
     * @param busNumber the bus number
     */
    public void setBusNumber(String busNumber)
    {
        this.busNumber = busNumber;
    }

    /**
     * Gets arrival stop.
     *
     * @return the arrival stop
     */
    public String getArrivalStop()
    {
        return arrivalStop;
    }

    /**
     * Sets arrival stop.
     *
     * @param arrivalStop the arrival stop
     */
    public void setArrivalStop(String arrivalStop)
    {
        this.arrivalStop = arrivalStop;
    }

    /**
     * Gets departure stop.
     *
     * @return the departure stop
     */
    public String getDepartureStop()
    {
        return departureStop;
    }

    /**
     * Sets departure stop.
     *
     * @param departureStop the departure stop
     */
    public void setDepartureStop(String departureStop)
    {
        this.departureStop = departureStop;
    }

    /**
     * Gets arrival time.
     *
     * @return the arrival time
     */
    public String getArrivalTime()
    {
        return arrivalTime;
    }

    /**
     * Sets arrival time.
     *
     * @param arrivalTime the arrival time
     */
    public void setArrivalTime(String arrivalTime)
    {
        this.arrivalTime = arrivalTime;
    }

    /**
     * Gets departure time.
     *
     * @return the departure time
     */
    public String getDepartureTime()
    {
        return departureTime;
    }

    /**
     * Sets departure time.
     *
     * @param departureTime the departure time
     */
    public void setDepartureTime(String departureTime)
    {
        this.departureTime = departureTime;
    }

    /**
     * Gets stop location.
     *
     * @return the stop location
     */
    public String getStopLocation()
    {
        return stopLocation;
    }

    /**
     * Sets stop location.
     *
     * @param stopLocation the stop location
     */
    public void setStopLocation(String stopLocation)
    {
        this.stopLocation = stopLocation;
    }
}
