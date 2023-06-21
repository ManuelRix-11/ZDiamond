package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/product-add")
public class CatalogueAdd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Gioiello> catalogo = (ArrayList<Gioiello>) req.getSession().getAttribute("catalogo");
        String indirizzo = "/results/admin-prodotti.jsp";
        if(catalogo==null)
        {
            try {
                CatalogoDao dao = new CatalogoDao();
                Catalogo c = dao.CreateCatalogo();
                catalogo= c.getCatalogo();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        String matricola = req.getParameter("matricola");
        String modello = req.getParameter("modello");
        String categoria = req.getParameter("categoria");
        String immagine = req.getParameter("immagine");
        double prezzo = Double.parseDouble(req.getParameter("prezzo"));
        int pezziDisponibile = Integer.parseInt(req.getParameter("pezziDisponibile"));
        int venduti = Integer.parseInt(req.getParameter("pezziVenduti"));

        String codicePietre = req.getParameter("codicePietre");
        String tipoPietre = req.getParameter("tipoPietre");
        float caraturaPietre = Float.parseFloat(req.getParameter("caraturaPietre"));
        float dimensionePietre = Float.parseFloat(req.getParameter("dimensionePietre"));
        float prezzoPietre = Float.parseFloat(req.getParameter("prezzoPietre"));
        int quantitaPietre = Integer.parseInt(req.getParameter("quantitaPietre"));
        Pietre pietre = new Pietre();
        pietre.setPrezzo(prezzoPietre);
        pietre.setQuantita(quantitaPietre);
        pietre.setCaratura(caraturaPietre);
        pietre.setDimensione(dimensionePietre);
        pietre.setTipo(tipoPietre);
        pietre.setCodice(codicePietre);

        String codiceMontatura = req.getParameter("codiceMontatura");
        String metalloMontatura = req.getParameter("metalloMontatura");
        float pesoMontatura = Float.parseFloat(req.getParameter("pesoMontatura"));
        float purezzaMontatura = Float.parseFloat(req.getParameter("purezzaMontatura"));
        float prezzoMontatura = Float.parseFloat(req.getParameter("prezzoMontatura"));
        Montatura montatura = new Montatura();
        montatura.setCodice(codiceMontatura);
        montatura.setMetallo(metalloMontatura);
        montatura.setPeso(pesoMontatura);
        montatura.setPurezza(purezzaMontatura);
        montatura.setPrezzo(prezzoMontatura);

        Gioiello gioiello = new Gioiello();
        gioiello.setPietre(pietre);
        gioiello.setMontatura(montatura);
        gioiello.setMatricola(matricola);
        gioiello.setCategoria(categoria);
        gioiello.setModello(modello);
        gioiello.setImmagine(immagine);
        gioiello.setPrezzo(prezzo);
        gioiello.setPezzidisponibili(pezziDisponibile);
        gioiello.setPezzidisponibili(venduti);

        GioielloDao gioielloDao = new GioielloDao();
        try {
            gioielloDao.doSave(gioiello,pietre,montatura);
            catalogo.add(gioiello);
            req.getSession().setAttribute("catalogo",catalogo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + indirizzo);
    }
}
