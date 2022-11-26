package com.example.servletexample.servlets;

import com.example.servletexample.model.User;
import com.example.servletexample.model.UserDTO;
import com.example.servletexample.runTimeRepository.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register/*")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("DO GET REGISTER");
        getServletContext().getRequestDispatcher("/jsp/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String isExternal = request.getParameter("external");

        if(isExternal!=null){
            isExternal = "true";
        }else{
            isExternal = "false";
        }


        System.out.println("REGISTER " + email + " + " + isExternal);
        UserDTO user = new UserDTO(email,0, Boolean.parseBoolean(isExternal));

        HttpSession session = request.getSession();
        boolean addResult = Users.INSTANCE.addUser(new User(user.getEmail()),isExternal);
        if(addResult == true){
            session.setAttribute("currentUser", user);
            getServletContext().getRequestDispatcher("/login").forward(request, response);
        }
        else{
            getServletContext().getRequestDispatcher("/jsp/errorRegister.jsp").forward(request,response);
        }

    }
}
