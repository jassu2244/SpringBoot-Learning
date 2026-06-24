

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Register")
public class RegisterServletApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public RegisterServletApp() {
		System.out.println("Servlet object is created internally by container");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("uname");
		String ucity = request.getParameter("ucity");
		System.out.println("Name " + name + " City " + ucity);
		
//		PrintWriter writer = response.getWriter();
		
		response.sendRedirect("/FourthServletAppRegister/success.jsp"); //redirecting to jsp page
		
//		writer.println("Hello " + name);
//		writer.println("I know you are from " + ucity);
		
//		writer.println("<html> <head> <title> Second App</title></head>");
//		writer.println("<body bgcolor = 'cyan'> <h1><marquee> Welcome to our dynamic app </marquee></h1>");
//		writer.println("<table>");
//		writer.println("<tr> <th> Name </th> <th> City </th> </tr>");
//		writer.println("<tr> <td>" + name + "</td> <td> " + ucity + "</td> </tr>");
//		
//		writer.println("</table></body>");
//
//		writer.println("</html>");
//
//
//		
//		writer.close();
	}

}
