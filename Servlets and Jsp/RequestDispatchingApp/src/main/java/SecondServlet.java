

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Control in second servlet");
		
		HttpSession session = request.getSession(false); //specified false here because i don't want to create new session, i want to use existing session.
		String name = (String) session.getAttribute("name");
		
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Response from Second Servlet</h1>" + "<h1>" + name + "</h1>");
		writer.close();
//		System.out.println("Response in second servlet here");
	}

}
