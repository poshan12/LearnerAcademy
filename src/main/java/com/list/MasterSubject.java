package com.list;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DatabaseConnection;


@WebServlet("/MasterSubject")
public class MasterSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("subjectName");
		int classId = Integer.parseInt(request.getParameter("classid"));
		try {
			Connection con  = DatabaseConnection.getConnection();
			PreparedStatement pst;
			pst=con.prepareStatement("select * from subject where subjectName=? & classid=?");
			pst.setString(1, name);
			pst.setInt(2, classId);
			ResultSet rs=pst.executeQuery();

			int count=0;
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				count++;
			}
			if(count>0) {
				String message ="pass";
				response.sendRedirect("subject.jsp?q="+message);
			}
			else {
				pst = con.prepareStatement("insert into subject values (subjectId.nextval,?,?)");
				pst.setString(1, name);
				pst.setInt(2, classId);
				pst.execute();
				response.sendRedirect("subject.jsp");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
