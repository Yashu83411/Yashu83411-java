<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

       <div align="center">
  <h1>Employee Register Form</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="with: 80%">
    <tr>
     <td>id</td>
     <td><input type="int" name="id" /></td>
    </tr>
    <tr>
     <td>First Name</td>
     <td><input type="text" name="Firstname" /></td>
    </tr>
    <tr>
     <td>Last Name</td>
     <td><input type="text" name="Lastname" /></td>
    </tr>
    <tr>
     <td>UserName</td>
     <td><input type="text" name="Username" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="Password" /></td>
    </tr>
    <tr>
     <td>Address</td>
     <td><input type="text" name="Address" /></td>
    </tr>
    <tr>
     <td>Contact No</td>
     <td><input type="text" name="Contact" /></td>
    </tr>
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>

</body>
</html>