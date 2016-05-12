package entities;

import java.util.Properties;

/**
 * Created by Bdub on 5/12/16.
 */
public class Singleton
{
    private static Singleton instance = null;

    private Properties properties;

    protected Singleton()
    {

    }

    public static Singleton getInstance()
    {
        if (instance == null)
        {
            instance = new Singleton();
        }
        return instance;
    }

    public Properties getProperties()
    {
        return properties;
    }

    public void setProperties(Properties properties)
    {
        this.properties = properties;
    }
}
