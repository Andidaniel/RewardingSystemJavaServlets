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
    <title>Purchase</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body>
<div class="w-screen h-screen flex justify-center items-center
            bg-gradient-to-br from-purple-700 to-amber-700">
    <div class="p-10 bg-white rounded-xl drop-shadow-lg space-y-5">


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

<form method="POST" action="login">
    <button class="w-full px-10 py-2 bg-blue-600 text-white rounded-md
            hover:bg-blue-500 hover:drop-shadow-md duration-300 ease-in" type="submit">
    Log Out
    </button>
</form>
    </div>
</div>
</body>
</html>
