import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by Bdub on 3/6/16.
 */
public class LocationJDBCTemplate
{
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
        String sql = "INSERT INTO locations (street_number, street_name, city, state, " +
                "zip) VALUES (?, ?, ?, ?, ?)";

        return jdbcTemplateObject.update(sql, streetNumber, streetName, city, state, zip);
    }

    public Location getLocation(Integer id)
    {
        String sql = "SELECT * from locations where id = ?";
        return (Location) jdbcTemplateObject.queryForObject(sql, new Object[]{id},
                new LocationMapper());
    }

    public void delete(Integer id)
    {
        String sql = "DELETE FROM locations WHERE id = ?";

        jdbcTemplateObject.update(sql, id);
    }
}
