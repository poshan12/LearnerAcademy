package com.list;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ShowClass")
public class ShowClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con;
	PreparedStatement pst;
	Statement st;
	ServletContext context;
    public ShowClass() {
        super();
        System.out.println("Lest see");
    }

    public void init(ServletConfig config, HttpServletRequest req, HttpServletResponse res ) throws ServletException {
		context= config.getServletContext();
		try {
			//loading the driver
			Class.forName(context.getInitParameter("driver"));
			//creating the connection 
			con=DriverManager.getConnection(context.getInitParameter("url"), 
					context.getInitParameter("userName"),context.getInitParameter("password"));
			System.out.println("COn"+con);
			st=con.createStatement();
			

		} catch (ClassNotFoundException e) {
				System.out.println("message"+e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	System.out.println("df");
    	ResultSet rs =null;
		try {
			rs = st.executeQuery("select *from class");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("rs"+rs);
    }
 
}
