package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MetodoPagamento;
import model.User;
import model.UserDao;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Register")
public class UserRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String indirizzo = "/shop.jsp";

        UserDao userDao = new UserDao();
        String nome = req.getParameter("nome");
        String cognome = req.getParameter("cognome");
        String citta = req.getParameter("citta");
        String via = req.getParameter("via");
        int ncivico = Integer.parseInt(req.getParameter("ncivico"));
        String mail = req.getParameter("mail");
        String password = req.getParameter("password");

        User user = new User();
        user.setMail(mail);
        user.setPasw(password);
        user.setVia(via);
        user.setNcivico(ncivico);
        user.setCitta(citta);
        user.setNome(nome);
        user.setCognome(cognome);

        String cartaconto = req.getParameter("cartaconto");
        String cvv = req.getParameter("cvv");
        String tipo = req.getParameter("tipo");

        MetodoPagamento metodo = new MetodoPagamento();
        metodo.setCartaconto(cartaconto);
        metodo.setCvv(cvv);
        metodo.setTipo(tipo);
        try {
            metodo.setUser(userDao.checkLogin(user.getMail(),user.getPasw()));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            userDao.doSave(user, metodo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath()+indirizzo);
    }
}
