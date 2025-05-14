package com.servelet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class FirstServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String em = req.getParameter("em");
        String ps = req.getParameter("ps");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        RequestDispatcher rd;

        if ("archu@gmail.com".equals(em) && "123".equals(ps)) {
            req.setAttribute("email", em);
            rd = req.getRequestDispatcher("/Servlet2");
            rd.forward(req, resp);
        } else {
            out.print("<h1>Invalid email or password</h1>");
            rd = req.getRequestDispatcher("/index.html");
            rd.include(req, resp);
        }
    }
}
