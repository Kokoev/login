import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

/**
 * Created by sovarugby on 23.11.16.
 */
public class InDb {

//    public static final String PREPARED_INSERT_QUERY =
//            "insert into lol (login, password, age,gender,school) values (?,?,?,?,?);";

    private Connection conn;

    public Connection getConn() {
        return conn;
    }

    public InDb() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sovarugby");
//            PreparedStatement statement = conn.prepareStatement(PREPARED_INSERT_QUERY);
//            Statement statement1 = conn.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

