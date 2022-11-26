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


        <p>YOU ARE ON HOMEPAGE YAY! </p>
        <br>
        <p>Welcome, <%=user.getEmail()%>,
            you currently have <%=user.getPoints()%> points
            and your account is
            <% if (user.isExternal() == true) { %>
            EXTERNAL
            <%} else { %>
            NOT EXTERNAL
            <% } %>
        </p>
        <p>Your current level is: <%if(user.getPoints()<100){%>
            0
            <%}
            else if (user.getPoints()>=100&& user.getPoints()<200) {%>
            1
            <%}
            else if (user.getPoints()>=200 && user.getPoints()<300){%>
            2
            <%}
            else if (user.getPoints()>=300 && user.getPoints()<400){%>
            3
            <%}
            else if(user.getPoints() >=400){%>
            4
            <%}%>
        </p>

        <form method="POST" action="/homeServlet">

            <div class="flex flex-col space-y-2">
            <label class="text-sm font-light" for="sum" >Money to spend: </label>
            <input class="w-96 px-3 py-2 rounded-md border border-slate-400" type="number" id ="sum" name="sum"  min="0">
            </div>

            <br>

            <input type="submit" name="order" value="Order" class="w-full px-10 py-2 bg-blue-600 text-white rounded-md
            hover:bg-blue-500 hover:drop-shadow-md duration-300 ease-in; cursor:pointer" style="cursor: pointer" />

            <br>
            <br>

            <input type="submit" name="logout" value="Log Out" class="w-full bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4
                        border border-blue-500 hover:border-transparent rounded duration-300 ease-in" style="cursor: pointer"/>
        </form>

    </div>
</div>
</body>
</html>
