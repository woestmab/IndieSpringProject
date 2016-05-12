package entities;

/**
 * Created by Bdub on 5/6/16.
 */

/**
 * this class is a pojo to hold the returned data from google after a request to the
 * directions api
 */
public class GoogleDirectionsResult
{
    /**
     * The Routes.
     */
    public Routes routes[];
    /**
     * The Status.
     */
    public String status;

    /**
     * The type Routes.
     */
    public class Routes
    {
        /**
         * The Legs.
         */
        public Legs legs[];

        /**
         * The type Legs.
         */
        public class Legs
        {
            /**
             * The Steps.
             */
            public Steps steps[];

            /**
             * The type Steps.
             */
            public class Steps
            {
                /**
                 * The Travel mode.
                 */
                public String travel_mode;
                /**
                 * The Html instructions.
                 */
                public String html_instructions;
                /**
                 * The Transit details.
                 */
                public Transit_Details transit_details;

                /**
                 * The type Transit details.
                 */
                public class Transit_Details
                {
                    /**
                     * The Line.
                     */
                    public Line line;
                    /**
                     * The Arrival stop.
                     */
                    public ArrivalStop arrival_stop;
                    /**
                     * The Arrival time.
                     */
                    public ArrivalTime arrival_time;
                    /**
                     * The Departure stop.
                     */
                    public DepartureStop departure_stop;
                    /**
                     * The Departure time.
                     */
                    public DepartureTime departure_time;
                    /**
                     * The Headsign.
                     */
                    public String headsign;

                    /**
                     * The type Line.
                     */
                    public class Line
                    {
                        /**
                         * The Short name.
                         */
                        public String short_name;
                    }

                    /**
                     * The type Arrival stop.
                     */
                    public class ArrivalStop
                    {
                        /**
                         * The Name.
                         */
                        public String name;
                    }

                    /**
                     * The type Arrival time.
                     */
                    public class ArrivalTime
                    {
                        /**
                         * The Text.
                         */
                        public String text;
                        /**
                         * The Value.
                         */
                        public Long value;
                    }

                    /**
                     * The type Departure stop.
                     */
                    public class DepartureStop
                    {
                        /**
                         * The Name.
                         */
                        public String name;
                    }

                    /**
                     * The type Departure time.
                     */
                    public class DepartureTime
                    {
                        /**
                         * The Text.
                         */
                        public String text;
                        /**
                         * The Value.
                         */
                        public Long value;
                    }
                }
            }
        }
    }
}
