package entities;

/**
 * Created by Bdub on 5/6/16.
 * this is the pojo for the returned google directions steps
 */
public class Step
{
    private String travelMode;
    private String htmlInstructions;
    private GoogleDirectionsResult.Routes.Legs.Steps.Transit_Details transitDetails;

    /**
     * Gets travel mode.
     *
     * @return the travel mode
     */
    public String getTravelMode()
    {
        return travelMode;
    }

    /**
     * Sets travel mode.
     *
     * @param travelMode the travel mode
     */
    public void setTravelMode(String travelMode)
    {
        this.travelMode = travelMode;
    }

    /**
     * Gets html instructions.
     *
     * @return the html instructions
     */
    public String getHtmlInstructions()
    {
        return htmlInstructions;
    }

    /**
     * Sets html instructions.
     *
     * @param htmlInstructions the html instructions
     */
    public void setHtmlInstructions(String htmlInstructions)
    {
        this.htmlInstructions = htmlInstructions;
    }

    /**
     * Gets transit details.
     *
     * @return the transit details
     */
    public GoogleDirectionsResult.Routes.Legs.Steps.Transit_Details getTransitDetails()
    {
        return transitDetails;
    }

    /**
     * Sets transit details.
     *
     * @param transitDetails the transit details
     */
    public void setTransitDetails(GoogleDirectionsResult.Routes.Legs.Steps.Transit_Details transitDetails)
    {
        this.transitDetails = transitDetails;
    }
}
