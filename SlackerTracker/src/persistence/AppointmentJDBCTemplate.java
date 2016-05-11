package persistence;

import entities.Appointment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Bdub on 3/5/16.
 */
public class AppointmentJDBCTemplate
{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource)
    {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void insert(Appointment appt)
    {
        String insert;

        insert = "INSERT INTO appointments (locations_id, title, url, apptClass, start, end, date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplateObject.update(insert, appt.getLocationsId(), appt.getTitle(), appt.getUrl(),
                appt.getApptClass(), appt.getStart(), appt.getEnd(), appt.getDate());
    }

    public List getAllAppointments()
    {
        String sql = "SELECT * FROM appointments";
        List appts;
        appts = jdbcTemplateObject.query(sql, new AppointmentMapper());
        return appts;
    }

    public List getApptsByDate(String date)
    {
        ArrayList<Appointment> results;
        String sql;
        Object[] inputs;

        sql = "SELECT id, locations_id, title, start, end FROM appointments WHERE " +
                "date = ? ORDER BY start ASC";

        inputs = new Object[]{date};

        results = (ArrayList<Appointment>) jdbcTemplateObject.query(sql, inputs, new AppointmentMapper());

        return results;
    }
}
