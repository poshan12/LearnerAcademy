<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="com.database.DatabaseConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
  <div class="container">
  <div class="row">
    <div class="col">
      Add Class
     <form action= "MasterClass" method="post">
     	<input type ="text" name ="className"/>
     	<button>Send</button>
     </form>
      <%
     	if(request.getParameter("q")!=null)
     		out.print("Class already added");
     %>
     
    </div>
    <div class="col">
      <table class="table table-striped table-advance table-hover">
                <tbody>
                  <tr>
                    <th><i class="icon_profile"></i>Class ID</th>
                    <th><i class=""></i>Class Name</th>
                                  </tr>
                                  <% 
			Connection con = DatabaseConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select *from class");
			while(rs.next())
			{
		%>
                  <tr>
                    <td><%=rs.getInt(1) %></td>
                    <td><%=rs.getString(2) %></td>
                    <td><a href="DeleteClass?classId=<%=rs.getString(1) %> " >Delete</a></td>
                  </tr>
                  <%} %>
                </tbody>
              </table>
    </div>
    
  </div>
</div>
</body>
</html>