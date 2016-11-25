import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by sovarugby on 20.11.16.
 */
public class RegistrationServlet extends HttpServlet {

    public static final String PREPARED_INSERT_QUERY =
            "insert into lol (login, password, age,gender,school) values (?,?,?,?,?);";



    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String  login = req.getParameter("login");
            String password = req.getParameter("password");
            Integer age = Integer.valueOf(req.getParameter("age"));
            String school = req.getParameter("school");
            String gender = req.getParameter("gender");

                if(login!="" && login!=null && login!="login"){
                    //подключаем БД через класс InDb
                    InDb inDb = new InDb();
                    try {
                        PreparedStatement statement = inDb.getConn().prepareStatement(PREPARED_INSERT_QUERY);
//                        Statement statement1 = inDb.getConn().createStatement();
                        statement.setString(1, login);
                        statement.setString(2, password);
                        statement.setInt(3, age);
                        statement.setString(4, gender);
                        statement.setString(5, school);
                        statement.executeUpdate();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }


            System.out.println("login: " + login);
            System.out.println("password: " + password);

            PrintWriter out = resp.getWriter();
            out.println("<a href='http://localhost:8080/login.jsp'>registration successful</a><br>");
            out.close();
        }
    }