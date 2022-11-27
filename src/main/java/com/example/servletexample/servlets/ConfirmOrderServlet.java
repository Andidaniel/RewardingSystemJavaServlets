package com.example.servletexample.servlets;

import com.example.servletexample.model.UserDTO;
import com.example.servletexample.runTimeRepository.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@WebServlet(name = "ConfirmOrderServlet", urlPatterns ={"/confirmOrder","/confirmOrder/*"} )
public class ConfirmOrderServlet extends HttpServlet {
    private static final String[] prizes = {
            "a chocolate",
            "a Man UTD keychain",
    "a Barcelona keychain",
    "a $5 FREE BET",
    "3 more hours to write code in Java",
    "nothing",
    "a Rolls Royce",
    "a $50 voucher",
    "a FIFA 23 CD Key"};
    private static Random random = new Random();
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
                    int previousPoints = currentUser.getPoints();
                    int futurePoints = previousPoints + 10;
                    Users.INSTANCE.addPoints(currentUser.getEmail());
                    boolean levelUp=false;
                    if(previousPoints<100 && futurePoints>=100 ||
                    previousPoints<200 && futurePoints >=200 ||
                    previousPoints < 300 && futurePoints >=300 ||
                    previousPoints <400 && futurePoints >=400){
                        levelUp= true;
                    }
                    if(levelUp && currentUser.isExternal()){
                        session.setAttribute("prize",prizes[random.nextInt(9)]);
                        currentUser.setPoints(10);
                        getServletContext().getRequestDispatcher("/jsp/getPrize.jsp").forward(request, response);
                    }


                }
                System.out.println("CONFIRM BUTTON PRESSED");
                getServletContext().getRequestDispatcher("/home").forward(request, response);

            }
        }

    }
}
