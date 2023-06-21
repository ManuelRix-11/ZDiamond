package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import model.UserDao;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class UserLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mail = req.getParameter("username");
        String password = req.getParameter("password");

        UserDao userDao = new UserDao();

        try {
            User user = userDao.checkLogin(mail, password);
            String indirizzo = null;
            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                if(mail.equalsIgnoreCase("admin"))
                    session.setAttribute("admin", true);
            } else {
                String message = "Failed login";
                req.setAttribute("message", message);
            }
//            RequestDispatcher dispatcher = req.getRequestDispatcher(indirizzo);
//            dispatcher.forward(req, resp);
        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
