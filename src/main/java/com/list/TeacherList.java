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

/**
 * Servlet implementation class TeacherList
 */
@WebServlet("/TeacherList")
public class TeacherList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherList() {
        super();
        // TODO Auto-generated constructor stub
    }
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String teacherName = req.getParameter("teacherName");
			try {
				Connection con  = DatabaseConnection.getConnection();
				PreparedStatement pst;
				pst=con.prepareStatement("select * from teacher where teacherName=?");
				pst.setString(1, teacherName);
				ResultSet rs=pst.executeQuery();

				int count=0;
				while(rs.next()) {
					System.out.println(rs.getInt(1));
					count++;
				}
				if(count>0) {
					String message ="pass";
					resp.sendRedirect("teacher.jsp?q="+message);
				}
				else {
					pst = con.prepareStatement("insert into teacher values (teacherid.nextval,?)");
					pst.setString(1, teacherName);
					pst.execute();
					resp.sendRedirect("teacher.jsp");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			

}
