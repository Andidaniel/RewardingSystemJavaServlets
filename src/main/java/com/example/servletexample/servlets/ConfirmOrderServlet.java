package com.example.servletexample.servlets;

import com.example.servletexample.model.UserDTO;
import com.example.servletexample.runTimeRepository.Users;

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
        System.out.println("GET CONFIRM ORDER: " + currentUser);
        if(currentUser!=null){
            getServletContext().getRequestDispatcher("/jsp/confirmOrder.jsp").forward(request, response);
        }
        else{
            getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDTO currentUser = (UserDTO) session.getAttribute("currentUser");
        if(currentUser==null){
            getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
        else{
            if(request.getParameter("back")!=null){
                getServletContext().getRequestDispatcher("/home").forward(request, response);
            }
            else{
                if(Integer.parseInt(request.getParameter("sumToPay"))>=100){
                    Users.INSTANCE.addPoints(currentUser.getEmail());
                }
                System.out.println("CONFIRM BUTTON PRESSED");
                getServletContext().getRequestDispatcher("/home").forward(request, response);

            }
        }

    }
}
