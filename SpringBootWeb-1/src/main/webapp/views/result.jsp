<%--
<%@ page language="java" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

    <!-- using plain Java -->
    <h2>Result is: <%= session.getAttribute("result") %></h2>

    <!-- using JSTL/Expression Language -->
    <h2>Result is: ${result}</h2>

</body>
</html>
--%>

<%@ page language="java" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

    <h2>Welcome To Telusko</h2>
    <p>${alien}</p>

</body>
</html>