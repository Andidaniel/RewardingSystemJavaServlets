<%@ page import="com.example.servletexample.model.UserDTO" %><%--
  Created by IntelliJ IDEA.
  User: Ritan
  Date: 10/15/2022
  Time: 11:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% UserDTO user = (UserDTO) session.getAttribute("currentUser");%>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body>
<div>
    <h1>YOU ARE ON HOMEPAGE YAY! </h1>
    <br>
    <h2>Welcome, <%=user.getEmail()%>,
        you currently have <%=user.getPoints()%> points
        and your account is
        <% if (user.isExternal() == true) { %>
        EXTERNAL
        <%} else { %>
        NOT EXTERNAL
        <% } %>
    </h2>
</div>
</body>
</html>
