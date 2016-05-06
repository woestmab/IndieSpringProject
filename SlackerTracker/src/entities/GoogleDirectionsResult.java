package entities;

/**
 * Created by Bdub on 5/6/16.
 */
public class GoogleDirectionsResult
{
    public Routes routes[];
    public String status;

    public class Routes
    {
        public Legs legs[];

        public class Legs
        {
            public Steps steps[];

            public class Steps
            {
                public String travel_mode;
                public String html_instructions;
                public Transit_Details transit_details;

                public class Transit_Details
                {
                    public Line line;
                    public ArrivalStop arrival_stop;
                    public ArrivalTime arrival_time;
                    public DepartureStop departure_stop;
                    public DepartureTime departure_time;
                    public String headsign;

                    public class Line
                    {
                        public String short_name;
                    }

                    public class ArrivalStop
                    {
                        public String name;
                    }

                    public class ArrivalTime
                    {
                        public String text;
                        public Long value;
                    }

                    public class DepartureStop
                    {
                        public String name;
                    }

                    public class DepartureTime
                    {
                        public String text;
                        public Long value;
                    }
                }
            }
        }
    }
}
