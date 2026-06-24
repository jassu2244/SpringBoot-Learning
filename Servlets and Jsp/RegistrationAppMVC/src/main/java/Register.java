

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uname=request.getParameter("uname");
		String emailId=request.getParameter("email");
		String upassword=request.getParameter("password");
		String ucity=request.getParameter("ucity");
		
		Model model=new Model();
		model.setUname(uname);
		model.setEmail(emailId);
		model.setUpassword(upassword);
		model.setUcity(ucity);
		
		
		int row=model.register();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("name", uname);
		
		if(row==0)
		{
			response.sendRedirect("/RegistrationAppMVC/failure.jsp");
		}
		else
		{
			response.sendRedirect("/RegistrationAppMVC/success.jsp");
		}
	}

}
