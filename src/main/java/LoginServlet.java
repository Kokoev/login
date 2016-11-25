import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by sovarugby on 20.11.16.
 */
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        InDb inDb2 = new InDb();
        String query = "select * from lol";
        HttpSession session =req.getSession();

        try {
            Statement statement = inDb2.getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            PrintWriter out = resp.getWriter();
            if(login.equals("login")) {
                while (resultSet.next()) {
                    out.println(resultSet.getInt("id") + " " +resultSet.getString("login") + " " +
                            resultSet.getString("password") + " " + resultSet.getInt("age") + " " +
                            resultSet.getString("gender") + " " + resultSet.getString("school"));
                }
                out.close();
            }

            boolean authorizationFalse = false;

            while (resultSet.next()){
                if(resultSet.getString("login").equals(login) && resultSet.getString("password").equals(password)){
//                    out.println("welcome<br>");
                    out.println("<a href='http://localhost:8080/editProfile.jsp'>editProfile</a><br>");
                    out.close();
                    session.setAttribute("id",resultSet.getInt("id"));
                    authorizationFalse = true;
                    break;
                }
            }

            if(!authorizationFalse) {
                out.println("invalid login or password ");
                out.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



//        String vhod = "select * from lol where login = 'login' and password = 'password'";




//        if (login.equals("login")) {
////            InDb inDb2 = new InDb();
////            String query = "select * from lol";
//
//            try {
////                Statement statement = inDb2.getConn().createStatement();
////                ResultSet resultSet = statement.executeQuery(query);
//                PrintWriter out = resp.getWriter();
//                while (resultSet.next()) {
//                    out.println(resultSet.getInt("id") + " " +resultSet.getString("login") + " " +
//                            resultSet.getString("password") + " " + resultSet.getInt("age") + " " +
//                            resultSet.getString("gender") + " " + resultSet.getString("school"));
//                }
//                out.close();
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }else{PrintWriter out = resp.getWriter();
//            out.println("invalid login or password ");
//            out.close();
//        }




//        HttpSession session =req.getSession();
//        if(req.getParameter("login").equals(session.getAttribute("login"))) {
//            PrintWriter out = resp.getWriter();
//            out.println("W E L C O M E");
//            out.close();
//        }else {
//            PrintWriter out = resp.getWriter();
//            out.println("invalid login or password ");
//            out.println("registrPASSWORD "+ session.getAttribute("login") );
//            out.println("vvodimiiPASSWORD"+ session.getAttribute("login") );
//            out.close();
//        }
    }
}
