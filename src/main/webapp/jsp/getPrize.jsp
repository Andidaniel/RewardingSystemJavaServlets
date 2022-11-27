<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 11/27/2022
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String prize = session.getAttribute("prize").toString(); %>
<html>
<head>
    <title>Prize</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div class="w-screen h-screen flex justify-center items-center
            bg-gradient-to-br from-purple-700 to-amber-700">

    <div class="p-10 bg-white rounded-xl drop-shadow-lg space-y-5">
        <label style="
        background: mediumseagreen ;
        padding: 10px ;
        border-radius: 6px ;
        position: relative;
        display: inline-block;
        box-shadow: 2px 2px 2px #aaaaaa;
        margin-top: 10px;
        color: mintcream">Congratulations, you won <%=prize%>!</label>

        <form method="GET" action="/homeServlet">
            <input type="submit" name="logout" value="Home" class="w-full bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4
                        border border-blue-500 hover:border-transparent rounded duration-300 ease-in" style="cursor: pointer"/>
        </form>
    </div>
</div>
</body>
</html>
