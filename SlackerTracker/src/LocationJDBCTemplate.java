import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
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

    public int create(Integer streetNumber, String streetName, String city, String
            state, Integer zip)
    {
        //String sql = "INSERT INTO locations (street_number, street_name, city, state,
        // " + "zip) VALUES (?, ?, ?, ?, ?)";

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
        String sql = "SELECT id, street_number, street_name, city, state, zip from " +
                "locations where id = ?";
        return (Location) jdbcTemplateObject.queryForObject(sql, new Object[]{id},
                new LocationMapper());
    }

    public void delete(Number id)
    {
        String sql = "DELETE FROM locations WHERE id = ?";

        jdbcTemplateObject.update(sql, id);
    }
}
