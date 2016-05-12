package persistence;

import entities.Location;
import persistence.LocationMapper;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.*;

/**
 * Created by Bdub on 3/6/16.
 * this class is does the database handling for the location table
 */
public class LocationJDBCTemplate
{
    private static final Logger log = Logger.getLogger("persistence.LocationJDBCTemplate");
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    /**
     * Sets data source.
     *
     * @param dataSource the data source
     */

    public void setDataSource(DataSource dataSource)
    {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    /**
     * Insert location in the database
     *
     * @param loc the loc
     * @return the int
     */
    public int insert(Location loc)
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

    /**
     * Gets location by id
     *
     * @param id the id
     * @return the location
     */
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
        } else
        {
            return null;
        }
    }

    /**
     * Gets all locations.
     *
     * @return the all locations
     */
    public List<Location> getAllLocations()
    {
        ArrayList result;

        String sql = "SELECT * FROM locations";

        return jdbcTemplateObject.query(sql, new LocationMapper());
    }

    /**
     * Delete location by id
     *
     * @param id the id
     */

    public void deleteLocation(Number id)
    {
        String sql = "DELETE FROM locations WHERE id = ?";

        jdbcTemplateObject.update(sql, id);
    }

    /**
     * Gets location id for all entries matching the input
     *
     * @param loc the loc
     * @return the location id
     */
    public List getLocationId(Location loc)
    {
        List results;
        String sql;
        Object[] inputs;

        sql = "SELECT id FROM locations WHERE street_number = ? " +
                "AND street_name = ? " +
                "AND city = ? " +
                "AND state = ? " +
                "AND zip = ?";

        inputs = new Object[]{loc.getStreetNumber(), loc.getStreetName(), loc.getCity(),
                loc.getState(), loc.getZip()};

        results = jdbcTemplateObject.queryForList(sql, inputs, Integer.class);

        return results;
    }
}
