package edu.mum.controller;

import edu.mum.domain.User;
import edu.mum.service.UserService;
import edu.mum.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userDetails")
public class UserDetailsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService service = new UserServiceImpl();

        List<User> users = service.getAllUser();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/WEB-INF/jsp/userDetails.jsp").forward(request, response);
    }
}
