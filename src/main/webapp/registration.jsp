<%--
  Created by IntelliJ IDEA.
  User: sovarugby
  Date: 20.11.16
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$registration$</title>
  </head>
  <body>
    <form method="post" action="registration">
      <table>
        <tr>
          <td>Login: </td>
          <td><input type="text" name="login"></td>
        </tr>
        <tr>
          <td>password: </td>
          <td><input type="password" name="password"></td>
        </tr>
        <tr>
          <td>age: </td>
          <td><input type="number" name="age"></td>
        </tr>
        <tr>
          <td>
            Пол:
            <br><input type="radio" name="gender" value="M">Мужчина</input><br>
            <input type="radio" name="gender" value="W">Женьщина</input>
          </td>
        </tr>
        <tr>
          <td>school: </td>
          <td><input type="text" name="school"></td>
        </tr>
        <tr>
          <td><input type="submit" value="registration"></td>
        </tr>

      </table>
    </form>
  </body>
</html>
