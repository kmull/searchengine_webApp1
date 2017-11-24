package com.infoshareacademy.searchengine.servlets;


import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.dao.UsersRepositoryDaoBean;
import com.infoshareacademy.searchengine.domain.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/find-user-by-id")
public class FindUserByIdServlet extends HelloServlet {

    @EJB
    UsersRepositoryDao usersRepositoryDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        String stringId = req.getParameter("id");
        int numberId;
        try {
            numberId = Integer.parseInt(stringId);
        } catch (NumberFormatException e) {
            numberId = 0;
        }

        User user = usersRepositoryDao.getUserById(numberId);
        resp.setContentType("text/html;charset=UTF-8");
        if (stringId != null) {
            writer.println("<!DOCTYPE html><html><body><br/>" +
                    user.getName() + " " +
                    user.getSurname() + " " +
                    user.getAge() +
                    "</body></html>");
        } else {
            writer.println(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
