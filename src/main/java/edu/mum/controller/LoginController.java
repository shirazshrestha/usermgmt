package edu.mum.controller;

import edu.mum.domain.User;
import edu.mum.service.UserService;
import edu.mum.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService service = new UserServiceImpl();

        //get username and password from login form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = service.findUserByUserNameAndPassword(username, password);

        if (user != null){
            List<User> users = service.getAllUser();

            //start session is the user is foundAuthFilter
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            request.setAttribute("users", users);
            request.getRequestDispatcher("/WEB-INF/jsp/userDetails.jsp").forward(request, response);
        }else{
            request.setAttribute("msg", "User not found with that username and password");
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        }

    }
}
