package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout")
public class UserLogOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String indirizzo = "/index.jsp";
        HttpSession session = req.getSession();
        session.setAttribute("carrello", null);
        session.setAttribute("user", null);
        session.setAttribute("admin", null);
        session.setAttribute("totale", null);
        resp.sendRedirect(req.getContextPath()+indirizzo);
    }
}
