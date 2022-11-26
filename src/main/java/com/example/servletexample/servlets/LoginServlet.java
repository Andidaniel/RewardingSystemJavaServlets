package com.example.servletexample.servlets;

import com.example.servletexample.model.User;
import com.example.servletexample.model.UserDTO;
import com.example.servletexample.runTimeRepository.Users;
import org.thymeleaf.util.ObjectUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@WebServlet(name = "IndexServlet", urlPatterns = {"/","/login/*"})
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Check if user is already connected, if not show login page */
        System.out.println("GET   LOGIN");
        HttpSession session = request.getSession();
        UserDTO currentUser = (UserDTO) session.getAttribute("currentUser");
        System.out.println("USER " + currentUser);

        System.out.println("ALL USERS");
        Users.INSTANCE.getUsers().forEach(System.out::println);
        /* If not logged */
        if(Objects.isNull(currentUser)) {
            getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
        else {
            getServletContext().getRequestDispatcher("/homeServlet").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserDTO currentUser = (UserDTO) session.getAttribute("currentUser");
        String email = new String();
    if(currentUser!=null){
        email = currentUser.getEmail();
    }
    else{
        email = request.getParameter("email");
    }


        UserDTO userByEmailAndPassword = Users.INSTANCE.findUserByEmail(email);
        if (userByEmailAndPassword != null){
            session.setAttribute("currentUser",userByEmailAndPassword);
            getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(request, response);
         }
        else {
            /* Otherwise, reload the form  */
            getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
    }
}