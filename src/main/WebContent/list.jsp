<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lists</title>
    <link rel="stylesheet" type="text/css" href="style1.css">
</head>
<body>

    <div class="form_box">
        
        <p align="center" style="font-size:25px">Here we have all the users</p>

        <p align="left" class="MariaTxt">MariaDB Data:</p>
         <form name="personListTable" method="GET" action="personListServlet">
        <table name="Maria_DB_Table" class="MariaTable">
          <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Age</th>
        </tr>
       <c:forEach var="user" items="${listUsersMar}">
                <tr>
                 <td><c:out value="${user.getId()}"/></td>

                 <td><c:out value="${user.getFirstName()}"/></td>

                <td> <c:out value="${user.getLastName()}"/></td>

                 <td><c:out value="${user.getAge()}"/></td>
                </tr>
            </c:forEach>
    </table>

    <p align="left" class="PostTxt">PostgreSQL Data:</p>

    <table name="Pos_Table" class="PosTable" method="get">
      <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
      </tr>


     <c:forEach var="user" items="${listUsers}">
         <tr>
          <td><c:out value="${user.getId()}"/></td>

          <td><c:out value="${user.getFirstName()}"/></td>

         <td> <c:out value="${user.getLastName()}"/></td>

          <td><c:out value="${user.getAge()}"/></td>
         </tr>
     </c:forEach>


</table>
</form>

    <form name="personListBack" method="POST" action="personListServlet">
     <input type="submit" class="btn_back" value="Back" align="left" name="backBtn" />
     </form>



</div>

</body>
</html>