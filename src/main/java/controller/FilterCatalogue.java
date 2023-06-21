package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Catalogo;
import model.CatalogoDao;
import model.Gioiello;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/filter")
public class FilterCatalogue extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filtro = req.getParameter("filtro");
        String indirizzo = "/shop.jsp";
        CatalogoDao dao = new CatalogoDao();
        try {
            Catalogo catalogo = dao.CreateCatalogo();
            ArrayList<Gioiello> listaCatalogo = new ArrayList<>();
            if(filtro.equals("catalogo"))
                listaCatalogo=catalogo.getCatalogo();
            if(filtro.equals("bestseller"))
                listaCatalogo=catalogo.getBestseller();
            if(filtro.equals("newentry"))
                listaCatalogo=catalogo.getNewEntry();
//            if(filtro.equals("regali"))
//                listaCatalogo=catalogo.getRegali();
//            if(filtro.equals("ultimi"))
//                listaCatalogo=catalogo.getUltimi();

            req.getSession().setAttribute("catalogo", listaCatalogo);
            resp.sendRedirect(req.getContextPath()+indirizzo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filtro = req.getParameter("filtro");
        String indirizzo = "/shop.jsp";
        CatalogoDao dao = new CatalogoDao();
        try {
            Catalogo catalogo = dao.CreateCatalogo();
            ArrayList<Gioiello> listaCatalogo = new ArrayList<>();
            if(filtro.equals("catalogo"))
                listaCatalogo=catalogo.getCatalogo();
            else if(filtro.equals("bestseller"))
                listaCatalogo=catalogo.getBestseller();
            else if(filtro.equals("newentry"))
                listaCatalogo=catalogo.getNewEntry();

            req.getSession().setAttribute("catalogo", listaCatalogo);
            resp.sendRedirect(req.getContextPath()+indirizzo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
