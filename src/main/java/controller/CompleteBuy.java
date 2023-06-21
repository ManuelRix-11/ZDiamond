package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@WebServlet("/completeBuy")
public class CompleteBuy extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<Gioiello, Integer> carrello = (HashMap<Gioiello, Integer>) req.getSession().getAttribute("carrello");
        User cliente = (User) req.getSession().getAttribute("user");
        String indirizzo = "/results/cart.jsp";
        Random generatore = new Random();
        int Nordine = generatore.nextInt(10000);
        if (carrello == null) {
            carrello = new HashMap<>();
        }
        MetodoPagamento metodoPagamento = new MetodoPagamento();
        MetodoPagamentoDao metodoPagamentoDao = new MetodoPagamentoDao();
        try {
            metodoPagamento = metodoPagamentoDao.retrievebyCliente(cliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        OrdineDao ordineDao = new OrdineDao();
        Pagamento pagamento = new Pagamento();
        pagamento.setCliente(cliente);
        pagamento.setIdPagamento(Nordine);
        pagamento.setMetodoPagamento(metodoPagamento);
        PagamentoDao pagamentoDao = new PagamentoDao();
        try {
            pagamentoDao.doSave(pagamento);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Map.Entry<Gioiello, Integer> entry: carrello.entrySet())
        {
            Ordine ordine = new Ordine();
            ordine.setCliente(cliente);
            ordine.setGioiello(entry.getKey());
            ordine.setnOrdine(Nordine);
            ordine.setQuantita(entry.getValue());
            try {
                ordineDao.doSave(ordine);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        carrello.clear();
        req.getSession().setAttribute("carrello",carrello);
        req.getSession().setAttribute("totale",0);
        resp.sendRedirect(req.getContextPath()+indirizzo);
    }
}
