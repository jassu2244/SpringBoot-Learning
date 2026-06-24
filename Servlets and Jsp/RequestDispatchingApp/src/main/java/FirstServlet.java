

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Control in first servlet");
		
		String name = request.getParameter("uname");
		String city = request.getParameter("ucity");
		
		RequestDispatcher reqDispatch = request.getRequestDispatcher("/SecondServlet");
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		
		//session.setMaxInactiveInterval(10000);
		
		reqDispatch.forward(request, response);
//		reqDispatch.include(request, response);
		
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Response from Servlet One</h1>");
		
		writer.close();
//		System.out.println("Control again in first servlet");
	}

}
