package com.tka;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regForm")
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       PrintWriter out=  resp.getWriter();
       
		String myName = req.getParameter("name");
		String myEmail = req.getParameter("email");
		String myPass = req.getParameter("pass");
		String myGender = req.getParameter("gender");
		String myCity=req.getParameter("city");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root123");
			PreparedStatement pst=conn.prepareStatement("insert into register values(?,?,?,?,?)");
			
			pst.setString(1, myName);
			pst.setString(2, myEmail);
			pst.setString(3, myPass);
			pst.setString(4, myGender);
			pst.setString(5, myCity);
			
			int count=pst.executeUpdate();
			if(count>0)
			{
				resp.setContentType("text/html");
				out.print("<h3 style='color:green'>User Successfully Register</h3>");
				RequestDispatcher rd=req.getRequestDispatcher("/ragistration.jsp");
				rd.include(req, resp);
			}
			else
			{
				resp.setContentType("text/html");
				out.print("<h3 style='color:red'>Failed to  Register</h3>");
				RequestDispatcher rd=req.getRequestDispatcher("/ragistration.jsp");
				rd.include(req, resp);

			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'>Failed to  Register</h3>");
			RequestDispatcher rd=req.getRequestDispatcher("/ragistration.jsp");
			rd.include(req, resp);

		}catch(Exception e)
		{
			e.printStackTrace();
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'>Failed to  Register</h3>");
			RequestDispatcher rd=req.getRequestDispatcher("/ragistration.jsp");
			rd.include(req, resp);

		}
	}
}
