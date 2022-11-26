package com.example.servletexample.servlets;

import com.example.servletexample.model.User;
import com.example.servletexample.model.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.websocket.Session;
import java.io.IOException;

@WebServlet(name = "HomeServlet", value = "/homeServlet")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDTO currentUser = (UserDTO) session.getAttribute("currentUser");
        System.out.println("GET HOME");
        getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            if(request.getParameter("action").equals("sex")){
                HttpSession session = request.getSession();
                session.invalidate();
                getServletContext().getRequestDispatcher("/login").forward(request, response);
            }
    }
}
