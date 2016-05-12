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
 * this class is used for database operations on the appointment table
 */
public class AppointmentJDBCTemplate
{
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
     * Insert to the database
     *
     * @param appt the appt
     */
    public void insert(Appointment appt)
    {
        String insert;

        insert = "INSERT INTO appointments (locations_id, title, url, apptClass, start, end, date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplateObject.update(insert, appt.getLocationsId(), appt.getTitle(), appt.getUrl(),
                appt.getApptClass(), appt.getStart(), appt.getEnd(), appt.getDate());
    }

    /**
     * Gets all appointments.
     *
     * @return the all appointments
     */
    public List getAllAppointments()
    {
        String sql = "SELECT * FROM appointments ORDER BY start ASC";
        List appts;
        appts = jdbcTemplateObject.query(sql, new AppointmentMapper());
        return appts;
    }

    /**
     * Gets appts by date.
     *
     * @param date the date
     * @return the appts by date
     */
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

    /**
     * Gets appointment by id.
     *
     * @param id the id
     * @return the appointment
     */
    public Appointment getAppointment(int id)
    {
        List appt;
        String sql = "SELECT id, title, locations_id, start, end, date FROM appointments WHERE id=" + id;

        appt = jdbcTemplateObject.query(sql, new AppointmentMapper());
        return (Appointment) appt.get(0);
    }
}
