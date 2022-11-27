<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 11/26/2022
  Time: 5:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.servletexample.model.UserDTO" %>

<%
    String  sum = request.getParameter("sum");
    UserDTO currentUser = (UserDTO) session.getAttribute("currentUser");
    int points = currentUser.getPoints();
    int sumToPay=0;
    if(sum!=null){
         sumToPay = Integer.parseInt(sum);
    }
    if(sumToPay>=500){
        if(points >=100 && points<200){
            sumToPay-=5;
        } else if (points >=200 && points < 300) {
            sumToPay-=10;
        } else if (points >=300 && points <400) {
            sumToPay-=15;
        } else if (points>=400) {
            sumToPay-=20;
        }
    }
    int pointsToGain = sumToPay>=100 ? 10:0;

%>
<html>

<head>
    <title>Confirm Order</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div class="w-screen h-screen flex justify-center items-center
            bg-gradient-to-br from-purple-700 to-amber-700">
    <div class="p-10 bg-white rounded-xl drop-shadow-lg space-y-5">
        You will gain <%=pointsToGain%> points.

        You will pay <%=sumToPay%> RON.
        <br>

        <form method="POST" action="/confirmOrder">

            <input type="hidden" name = "sumToPay" value=<%=sumToPay%>>
            <input type="submit" name="confirm" value="Confirm Order" class="w-full px-10 py-2 bg-blue-600 text-white rounded-md
            hover:bg-blue-500 hover:drop-shadow-md duration-300 ease-in; cursor:pointer" style="cursor: pointer" />

            <br>
            <br>
            <input type="submit" name="back" value="Back" class="w-full bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4
                        border border-blue-500 hover:border-transparent rounded duration-300 ease-in" style="cursor: pointer"/>
        </form>

    </div>
</div>
</body>
</html>
