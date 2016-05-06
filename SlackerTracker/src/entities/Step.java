package entities;

/**
 * Created by Bdub on 5/6/16.
 */
public class Step
{
    private String travelMode;
    private String htmlInstructions;
    private GoogleDirectionsResult.Routes.Legs.Steps.Transit_Details transitDetails;

    public String getTravelMode()
    {
        return travelMode;
    }

    public void setTravelMode(String travelMode)
    {
        this.travelMode = travelMode;
    }

    public String getHtmlInstructions()
    {
        return htmlInstructions;
    }

    public void setHtmlInstructions(String htmlInstructions)
    {
        this.htmlInstructions = htmlInstructions;
    }

    public GoogleDirectionsResult.Routes.Legs.Steps.Transit_Details getTransitDetails()
    {
        return transitDetails;
    }

    public void setTransitDetails(GoogleDirectionsResult.Routes.Legs.Steps.Transit_Details transitDetails)
    {
        this.transitDetails = transitDetails;
    }
}
