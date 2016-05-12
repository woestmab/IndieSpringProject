package entities;

import interfaces.Form;

/**
 * Created by Bdub on 3/6/16.
 */
public class Location implements Form
{
    private static final String type = "Location";

    private Integer id;
    private Integer streetNumber;
    private String streetName;
    private String city;
    private String state;
    private Integer zip;

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
     * Gets street number.
     *
     * @return the street number
     */
    public Integer getStreetNumber()
    {
        return streetNumber;
    }

    /**
     * Sets street number.
     *
     * @param streetNumber the street number
     */
    public void setStreetNumber(Integer streetNumber)
    {
        this.streetNumber = streetNumber;
    }

    /**
     * Gets street name.
     *
     * @return the street name
     */
    public String getStreetName()
    {
        return streetName;
    }

    /**
     * Sets street name.
     *
     * @param streetName the street name
     */
    public void setStreetName(String streetName)
    {
        this.streetName = streetName;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity()
    {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState()
    {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state)
    {
        this.state = state;
    }

    /**
     * Gets zip.
     *
     * @return the zip
     */
    public Integer getZip()
    {
        return zip;
    }

    /**
     * Sets zip.
     *
     * @param zip the zip
     */
    public void setZip(Integer zip)
    {
        this.zip = zip;
    }

    /**
     * this method strinifies the class
     * @return
     */

    public String toString(){
        String str;
        str = "id: " + id + ", streetNumber: " + streetNumber + ", streetName: " +
                streetName + ", city: " + city + ", state: " + state + ", zip: " + zip;
        return str;
    }
}
