package com.example.servletexample.servlets;

import com.example.servletexample.model.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ConfirmOrderServlet", urlPatterns ={"/confirmOrder","/confirmOrder/*"} )
public class ConfirmOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDTO currentUser = (UserDTO) session.getAttribute("currentUser");
        System.out.println("GET HOME:" + currentUser);
        if(currentUser!=null){
            getServletContext().getRequestDispatcher("/jsp/confirmOrder.jsp").forward(request, response);
        }
        else{
            getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
