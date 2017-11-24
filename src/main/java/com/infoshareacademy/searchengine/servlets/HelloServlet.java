package com.infoshareacademy.searchengine.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        writer.println("Hello Krzysztof!\n");
//        String s1 = "";
//        String s1 = req.getParameter("name");
//
//        resp.setContentType("text/html;charset=UTF-8");
//        writer.println("<!DOCTYPE html><html><body><br/>");
//
//        try {
//            writer.println("imie: " + s1);
//        } catch (NullPointerException e) {
//            writer.println(HttpServletResponse.SC_BAD_REQUEST);
//        }
//        writer.println("</body></html>");

    }
}