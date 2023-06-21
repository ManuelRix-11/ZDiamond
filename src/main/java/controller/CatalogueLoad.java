package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Catalogo;
import model.CatalogoDao;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/catalogo")
public class CatalogueLoad extends HttpServlet
{
    private final Catalogo catalogo = new Catalogo();

    public CatalogueLoad() throws SQLException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            CatalogoDao dao = new CatalogoDao();
            Catalogo catalogo = dao.CreateCatalogo();
            req.setAttribute("categorie", catalogo.getCategorie());
            req.setAttribute("bestseller", catalogo.getBestseller());
            req.setAttribute("newentry", catalogo.getNewEntry());
            req.setAttribute("catalogo", catalogo.getCatalogo());
            req.setAttribute("metalli", catalogo.getListaMetalli());
            req.setAttribute("pietre", catalogo.getListaPietre());
            req.setAttribute("ultimi", catalogo.getUltimi());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
