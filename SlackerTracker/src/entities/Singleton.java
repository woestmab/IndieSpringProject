package entities;

import java.util.Properties;

/**
 * Created by Bdub on 5/12/16.
 * this class is the singleton for the SlackerTracker app
 */

public class Singleton
{
    private static Singleton instance = null;

    private Properties properties;

    /**
     * Instantiates a new Singleton.
     */
    protected Singleton()
    {

    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Singleton getInstance()
    {
        if (instance == null)
        {
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * Gets properties.
     *
     * @return the properties
     */
    public Properties getProperties()
    {
        return properties;
    }

    /**
     * Sets properties.
     *
     * @param properties the properties
     */
    public void setProperties(Properties properties)
    {
        this.properties = properties;
    }
}
