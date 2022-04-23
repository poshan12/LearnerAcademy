package com.list;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DatabaseConnection;


@WebServlet("/MasterClass")
public class MasterClass extends HttpServlet {
	public MasterClass() {
		// TODO Auto-generated constructor stub
	}
	
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String className = request.getParameter("className");
		try {
			Connection con  = DatabaseConnection.getConnection();
			PreparedStatement pst;
			pst=con.prepareStatement("select * from class where className=?");
			pst.setString(1, className);
			ResultSet rs=pst.executeQuery();

			int count=0;
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				count++;
			}
			if(count>0) {
				String message ="pass";
				response.sendRedirect("class.jsp?q="+message);
			}
			else {
				pst = con.prepareStatement("insert into class values (classid.nextval,?)");
				pst.setString(1, className);
				pst.execute();
				response.sendRedirect("class.jsp");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
