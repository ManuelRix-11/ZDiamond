package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Carrello;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/cart")
public class CartInitialize extends HttpServlet {
    private Carrello carrello = new Carrello();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("carrello", carrello.getCarrello());
    }
}
