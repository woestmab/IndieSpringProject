import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonGenerator;
import com.google.api.client.json.JsonParser;
import com.google.maps.*;
import com.sun.deploy.net.HttpResponse;

import org.apache.http.client.methods.HttpGet;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by Bdub on 2/19/16.
 */
public class Google
{
    private static final HttpTransport HTTP_TRANSPORT = new HttpTransport()
    {
        @Override
        protected LowLevelHttpRequest buildRequest(String method, String url) throws IOException
        {
            return null;
        }
    };

    static final JsonFactory JSON_FACTORY = new JsonFactory()
    {
        @Override
        public JsonParser createJsonParser(InputStream in) throws IOException
        {
            return null;
        }

        @Override
        public JsonParser createJsonParser(InputStream in, Charset charset) throws IOException
        {
            return null;
        }

        @Override
        public JsonParser createJsonParser(String value) throws IOException
        {
            return null;
        }

        @Override
        public JsonParser createJsonParser(Reader reader) throws IOException
        {
            return null;
        }

        @Override
        public JsonGenerator createJsonGenerator(OutputStream out, Charset enc) throws IOException
        {
            return null;
        }

        @Override
        public JsonGenerator createJsonGenerator(Writer writer) throws IOException
        {
            return null;
        }
    };

    private static final String GOOGLE_API_KEY = "AIzaSyBKXLe2ChocA8-es3OiIGlKcPnFtELUBH4\t\n";

    public static void main(String[] args)
    {
        //get context
        GeoApiContext geoApiContext = new GeoApiContext();
        //server key
        geoApiContext.setApiKey(GOOGLE_API_KEY);

        //test addresses
        String origin = "75 9th Ave, New York, NY";
        String destination = "MetLife Stadium Dr East Rutherford, NJ 07073";

        //create a request
//        DirectionsApiRequest directionsApiRequest =
//                DirectionsApi.getDirections(geoApiContext, origin, destination);

        DirectionsApiRequest directionsApiRequest1 = DirectionsApi.newRequest(geoApiContext);
    }

}
