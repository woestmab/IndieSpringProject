import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Bdub on 3/6/16.
 */
public class LocationJDBCTemplate
{
    private static final Logger log = Logger.getLogger("LocationJDBCTemplate");
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource)
    {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public int create(Location loc)
    {
        int streetNumber = loc.getStreetNumber();
        String streetName = loc.getStreetName();
        String city = loc.getCity();
        String state = loc.getState();
        int zip = loc.getZip();

        SimpleJdbcInsert insert = new SimpleJdbcInsert(dataSource)
                .withTableName("locations")
                .usingColumns("street_number", "street_name", "city", "state", "zip")
                .usingGeneratedKeyColumns("id");


        Map map = new HashMap<>();
        map.put("street_number", streetNumber);
        map.put("street_name", streetName);
        map.put("city", city);
        map.put("state", state);
        map.put("zip", zip);

        return insert.executeAndReturnKey(map).intValue();
    }

    public Location getLocation(Integer id)
    {
        ArrayList result;
        Location location;

        String sql = "SELECT id, street_number, street_name, city, state, zip FROM " +
                "locations WHERE id = ?";

        result = (ArrayList) jdbcTemplateObject.query(
                sql, new Object[]{id}, new LocationMapper());

        if (result.size() > 0)
        {
            return (Location) result.get(0);
        }
        else
        {
            return null;
        }

//        location.setId((Integer) result.get(0));
//        location.setStreetNumber((Integer) result.get(1));
    }

    public void deleteLocation(Number id)
    {
        String sql = "DELETE FROM locations WHERE id = ?";

        jdbcTemplateObject.update(sql, id);
    }
}
