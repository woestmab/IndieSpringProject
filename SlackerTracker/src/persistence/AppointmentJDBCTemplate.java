package persistence;

import entities.Appointment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
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
        String sql;

        int location;
        String title;
        String url;
        String apptClass;
        long start;
        long end;
        String date;

        location = appt.getLocationsId();
        title = appt.getTitle();
        url = appt.getUrl();
        apptClass = appt.getApptClass();
        start = appt.getStart();
        end = appt.getEnd();
        date = appt.getDate();

        sql = "INSERT INTO appointments (locations_id, title, url, apptClass, start, end, date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplateObject.update(sql, location, title, url, apptClass, start, end, date);
    }

    public List<Appointment> getAllAppointments()
    {
        String selectAll = "SELECT * FROM appointments";
        List<Appointment> appts;
        appts = jdbcTemplateObject.query(selectAll, new AppointmentMapper());
        return appts;
    }
}
