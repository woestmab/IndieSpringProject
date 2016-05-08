package persistence;

import entities.Appointment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
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

    public void create(int location, String title, String url, String apptClass, long
            start, long end)
    {
        String SQL = "INSERT INTO appointments (locations_id, title, url, apptClass, start, end) " +
                "values (?, ?, ?, ?, ?, ?)";

        jdbcTemplateObject.update(SQL, location, title, url, apptClass, start, end);
    }

    public List<Appointment> getAllAppointments()
    {
        String selectAll = "SELECT * FROM appointments";
        List<Appointment> appts = jdbcTemplateObject.query(selectAll, new AppointmentMapper());
        return appts;
    }
}
