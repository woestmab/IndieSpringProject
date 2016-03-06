import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

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

    public void create(String title, String url, String apptClass, String start,
                       String end)
    {
        String SQL = "INSERT INTO appointments (title, url, apptClass, start, end) " +
                "values (?, ?, ?, ?, ?)";

        jdbcTemplateObject.update(SQL, title, url, apptClass, start, end);
    }
}
