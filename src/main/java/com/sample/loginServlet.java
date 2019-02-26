package com.sample;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.sql.*;

@WebServlet(
        name = "login",
        urlPatterns = "/loginServlet"
)

public class loginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean rowRetrieved = false;

        String username = req.getParameter("userName");
        String password = req.getParameter("password");
        String name = null;
        String email = null;



        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_db","root",null);
            String sql = "SELECT * FROM login WHERE username = ?";
            PreparedStatement statement=con.prepareStatement(sql);
            statement.setString(1, username);

            ResultSet rs=statement.executeQuery();

            while(rs.next()) {
                username = rs.getString(1);
                password = rs.getString(2);
                email = rs.getString(3);
                name = rs.getString(4);

            }
            con.close();
        }
        catch
                (Exception e){ System.out.println(e);}



        login l = new login();
        boolean result = l.check(username, password);



        if (result) {
            HttpSession oldSession = req.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }

            HttpSession newSession = req.getSession(true);




            newSession.setMaxInactiveInterval(5*60);
            req.setAttribute("userName", username);
            req.setAttribute("email", email);
            req.setAttribute("name", name);

            RequestDispatcher view = req.getRequestDispatcher("result.jsp");
            view.forward(req, resp);
        //    Cookie message = new Cookie("message", "Welcome");
        //    resp.addCookie(message);
         //   resp.sendRedirect("result.jsp");
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
            PrintWriter out = resp.getWriter();
            out.println("<font color=red><b>Either username or password is wrong.</b></font>");
            rd.include(req, resp);
        }

/*
        req.setAttribute("result", result);
        RequestDispatcher view = req.getRequestDispatcher("result.jsp");
        view.forward(req, resp);
        */

    }
}
