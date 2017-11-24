package com.infoshareacademy.searchengine.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/welcome-user")
public class WelcomeUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        String setParameterName = req.getParameter("name");
        resp.setContentType("text/html;charset=UTF-8");

        if (setParameterName != null) {
            writer.println("<!DOCTYPE html><html><body><br/>imie: " + setParameterName + "</body></html>");
        } else {
            writer.println(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
