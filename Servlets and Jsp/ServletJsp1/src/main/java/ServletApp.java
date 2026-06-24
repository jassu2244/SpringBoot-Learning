import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/ServletApp")
public class ServletApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int age = 18;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("uname");
		String ucity = request.getParameter("ucity");

		Date date = new Date();

		response.setContentType("text/html");

		PrintWriter writer = response.getWriter();

		writer.println("<html>");
		writer.println("<head><title>Second App</title></head>");

		writer.println("<body bgcolor='cyan'>");

		writer.println("<h1><marquee>Welcome to our dynamic app</marquee></h1>");

		writer.println("<h2>Today's Date : " + date + "</h2>");

		writer.println("<h1>Hello changes in servlet</h1>");

		writer.println("<table border='1'>");
		writer.println("<tr>");
		writer.println("<th>NAME</th>");
		writer.println("<th>CITY</th>");
		writer.println("</tr>");

		writer.println("<tr>");
		writer.println("<td>" + name + "</td>");
		writer.println("<td>" + ucity + "</td>");
		writer.println("</tr>");

		writer.println("</table>");

		writer.println("</body>");
		writer.println("</html>");

		writer.close();
	}
}