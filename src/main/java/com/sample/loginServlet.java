package com.sample;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(
        name = "login",
        urlPatterns = "/loginServlet"
)

public class loginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String username = req.getParameter("userName");
        String password = req.getParameter("password");

        login l = new login();
        boolean result = l.check(username, password);


        req.setAttribute("result", result);
        RequestDispatcher view = req.getRequestDispatcher("result.jsp");
        view.forward(req, resp);

    }
}
