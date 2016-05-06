package persistence;

import entities.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Bdub on 3/6/16.
 */


public class LocationMapper implements RowMapper<Location>
{
    @Override
    public Location mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Location location = new Location();

        location.setId(rs.getInt("id"));
        location.setStreetNumber(rs.getInt("street_number"));
        location.setStreetName(rs.getString("street_name"));
        location.setCity(rs.getString("city"));
        location.setState(rs.getString("state"));
        location.setZip(rs.getInt("zip"));

        return location;
    }
}
