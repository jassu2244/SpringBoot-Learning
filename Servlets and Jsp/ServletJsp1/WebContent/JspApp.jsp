<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP WEB APP</title>
</head>
<body>
<h1>JSP Web App to generate Dynamic Response</h1>

<%@ 
    page import="java.util.Date" 
%>

<%! //Declaration Tag , <%@> This is Directive Tag, and <%=> this is Expression tag used to print things
    int age=18;
%>

<% // Scriptlet Tag - everything inside this is service method of servlet. This entire jsp file is converting to servlet then giving the response.
    String name=request.getParameter("uname");
    String ucity=request.getParameter("ucity");

    Date date=new Date();
	out.println("Hello "+ name);

%>
<h1><%= date %></h1>
<h2>Hello I know you're from <%= ucity %></h2>
<h2>Hello I know your age is <%= age %></h2>
</body>
</html>