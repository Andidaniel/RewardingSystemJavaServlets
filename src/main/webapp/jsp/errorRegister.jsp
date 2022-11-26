<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 11/26/2022
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>ERROR</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div class="w-screen h-screen flex justify-center items-center
            bg-gradient-to-br from-purple-700 to-amber-700">
  <div class="p-10 bg-white rounded-xl drop-shadow-lg space-y-5">
  <p style="background: crimson ;
  padding: 10px ;
  border-radius: 6px ;
  position: relative;
  display: inline-block;
  box-shadow: 2px 2px 2px #aaaaaa;
  margin-top: 10px;
  color: antiquewhite"> Error, email already exists or is invalid</p>


<form action="/register" method="GET">
  <button class="w-full px-10 py-2 bg-blue-600 text-white rounded-md
                        hover:bg-blue-500 hover:drop-shadow-md duration-300 ease-in" type="submit">
    Register
  </button>
</form>
  </div>
</div>
</body>
</html>