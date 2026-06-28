
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Properties DOT_ENV = loadDotEnv();


	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Control in servlet");
		
		String uname = request.getParameter("uname");
		String emailId = request.getParameter("email");
		String upassword = request.getParameter("password");
		String ucity = request.getParameter("ucity");
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver"); //add jar files to build path and development assembly both
			String url = requireConfig("DB_URL");
			String user = requireConfig("DB_USER");
			String password = requireConfig("DB_PASSWORD");
			Connection connect = DriverManager.getConnection(url, user, password);
			
			PreparedStatement pstmnt = connect.prepareStatement("INSERT INTO personalInfo (uname, email, upassword, ucity)"
					+ "VALUES(?, ?, ?, ?)");
			pstmnt.setString(1, uname);
			pstmnt.setString(2, emailId);
			pstmnt.setString(3, upassword);
			pstmnt.setString(4, ucity);
			
			int rowAffected = pstmnt.executeUpdate();
			
			PrintWriter writer = response.getWriter();
			
			if(rowAffected != 0) {
				writer.println("<h1> Registeration Success </h1>");
			}
			else {
				writer.println("<h1> Registeration Failed </h1>");
			}
			
			pstmnt.close();
			connect.close();
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
