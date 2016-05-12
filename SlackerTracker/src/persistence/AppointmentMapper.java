package persistence;

import entities.Appointment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Bdub on 3/5/16.
 * this class is used to map the rows for the appointment table and object
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
        appointment.setStart(rs.getLong("start"));
        appointment.setEnd(rs.getLong("end"));

        return appointment;
    }
}
