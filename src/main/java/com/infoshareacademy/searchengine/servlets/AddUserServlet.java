package com.infoshareacademy.searchengine.servlets;


import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.domain.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HelloServlet {

    @EJB
    UsersRepositoryDao usersRepositoryDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        resp.setContentType("text/html;charset=UTF-8");

        String stringId = req.getParameter("id");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String login = req.getParameter("login");
        String stringAge = req.getParameter("age");

        int id;
        int age;

        try {
            id = Integer.parseInt(stringId);
        } catch (NumberFormatException e) {
            id = 0;
        }
        try {
            age = Integer.parseInt(stringAge);
        } catch (NumberFormatException e) {
            age = 0;
        }

        List<User> myUser = usersRepositoryDao.getUsersList();
        if (!(name.equals("")) && !(surname.equals("")) && !(login.equals("")) && (age != 0) && (id != 0)) {
            for (User userTmp : myUser) {
                if (userTmp.getId() == id) {
                    writer.println("blad nr: " + HttpServletResponse.SC_CONFLICT +
                            " - W systemie istnieje juz uzytkownik o tym numerze id");
                    return;
                }
            }
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setSurname(surname);
            user.setLogin(login);
            user.setAge(age);
            usersRepositoryDao.addUser(user);
        } else {
            writer.println("blad nr: " + HttpServletResponse.SC_BAD_REQUEST +
                    " - Wprowadzane dane sa niekompletne lub bledne, blad nr: ");
            return;
        }

        writer.println("<!DOCTYPE html><html><body>Lista osob w naszym repozytorium: " +
                "<br/><br/>");
        for (User user1 : myUser) {
            writer.println("imie: " + user1.getName() + "<br/>" +
                    "nazwisko: " + user1.getSurname() + "<br/>" +
                    "login: " + user1.getLogin() + "<br/>" +
                    "wiek: " + user1.getAge() +
                    " id: " + user1.getId() +
                    "<br/><br/>" +
                    "</body></html>");
        }
//         stringId = null;
//         name = null;
//         surname = null;
//         login = null;
//         stringAge = null;
    }
}
