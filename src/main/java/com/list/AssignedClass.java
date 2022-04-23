package com.list;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DatabaseConnection;

/**
 * Servlet implementation class AssignedClass
 */
@WebServlet("/AssignedClass")
public class AssignedClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignedClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String className = request.getParameter("className");
		String teacherName = request.getParameter("teacherName");
		String subjectName = request.getParameter("subjectName");
		
		
		try {
			Connection con = DatabaseConnection.getConnection();

			PreparedStatement pstd = con.prepareStatement("insert into assignclass values(assignid.nextval,?,?,?)");
			pstd.setString(1, className);
			pstd.setString(2, subjectName);
			pstd.setString(3, teacherName);
			pstd.execute();
			response.sendRedirect("assignclass.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
