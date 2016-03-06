import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Bdub on 3/5/16.
 */


public class AppointmentMapper implements RowMapper
{
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Appointment appointment = new Appointment();

        appointment.setId(rs.getInt("id"));
        appointment.setLocationsId(rs.getInt("locations_id"));
        appointment.setTitle(rs.getString("title"));
        appointment.setUrl(rs.getString("url"));
        appointment.setApptClass(rs.getString("apptClass"));
        appointment.setStart(rs.getString("start"));
        appointment.setEnd(rs.getString("end"));

        return appointment;
    }
}
