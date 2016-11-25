import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.PrintWriter;

/**
 * Created by sovarugby on 25.11.16.
 */
public class EditProfileServlet extends HttpServlet {

    public static final String PREPARED_UPDATE_QUERY =
            "update lol set login = ?, password = ?, age = ?, gender = ?, school = ? WHERE id=? ";

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String newLogin = req.getParameter("login");
        String newPassword = req.getParameter("password");
        Integer newAge = Integer.valueOf(req.getParameter("age"));
        String newSchool = req.getParameter("school");
        String newGender = req.getParameter("gender");

        //подключаем БД через класс InDb
        InDb inDb = new InDb();

        try {
            PreparedStatement statement = inDb.getConn().prepareStatement(PREPARED_UPDATE_QUERY);

            statement.setString(1, newLogin);
            statement.setString(2, newPassword);
            statement.setInt(3, newAge);
            statement.setString(4, newGender);
            statement.setString(5, newSchool);
            statement.setInt(6, (Integer) session.getAttribute("id"));
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        PrintWriter out = resp.getWriter();
        out.println("<a href='http://localhost:8080/login.jsp'>edit successful<a/><br>");
        out.close();


    }
}