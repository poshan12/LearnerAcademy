package com.list;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.DatabaseConnection;

/**
 * Servlet implementation class DeleteClass
 */
@WebServlet("/DeleteClass")
public class DeleteClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int  id = Integer.parseInt(request.getParameter("classId"));
		System.out.println("Id "+id);
		try {
			Connection con = DatabaseConnection.getConnection();
			String sql = "delete class where classId ="+id;
			Statement st = con.createStatement();
			System.out.println(st.execute(sql));
			response.sendRedirect("class.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
