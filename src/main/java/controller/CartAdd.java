package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Gioiello;
import model.GioielloDao;

import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet("/cartAdd")
public class CartAdd extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<Gioiello, Integer> carrello = (HashMap<Gioiello, Integer>) req.getSession().getAttribute("carrello");
        double totale = (double) req.getSession().getAttribute("totale");

        String mode = req.getParameter("mode");
        GioielloDao gioielloDao = new GioielloDao();
        Gioiello gioiello = null;
        String indirizzo = null;

        if(mode.equals("addupdate"))
        {
            try {
                gioiello = gioielloDao.retrieveByModello(req.getParameter("gioiello"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Set<Map.Entry<Gioiello, Integer>> entrySet = carrello.entrySet();

            for (Map.Entry<Gioiello, Integer> entry: entrySet) {
                Gioiello key = entry.getKey();
                Integer value = entry.getValue();
                if (key.getModello().equals(gioiello.getModello()))
                {
                    value++;
                    totale+=gioiello.getPrezzo();
                    carrello.replace(key,value);
                }
            }

            indirizzo = "/results/cart.jsp";
        }else if(mode.equals("lessupdate"))
        {
            try {
                gioiello = gioielloDao.retrieveByModello(req.getParameter("gioiello"));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            Set<Map.Entry<Gioiello, Integer>> entrySet = carrello.entrySet();

            for (Map.Entry<Gioiello, Integer> entry: entrySet) {
                Gioiello key = entry.getKey();
                Integer value = entry.getValue();
                if (key.getModello().equals(gioiello.getModello()))
                {
                    if (value==1)
                        carrello.remove(key);
                    else
                    {
                        value--;
                        totale-=gioiello.getPrezzo();
                        carrello.replace(key,value);
                    }
                }
            }

            indirizzo = "/results/cart.jsp";
        }
        else if(mode.equals("emptyupdate"))
        {
            carrello.clear();
            indirizzo = "/results/cart.jsp";
            totale = 0;
        }

        req.getSession().setAttribute("totale", totale);
        resp.sendRedirect(req.getContextPath()+indirizzo);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<Gioiello, Integer> carrello = (HashMap<Gioiello, Integer>) req.getSession().getAttribute("carrello");
        String indirizzo = null;
        double totale;
        if(req.getSession().getAttribute("totale")==null)
             totale = 0;
        else
            totale = (double) req.getSession().getAttribute("totale");

        if (carrello == null) {
            carrello = new HashMap<>();
            req.getSession().setAttribute("carrello", carrello);
            totale=0;
            req.getSession().setAttribute("totale", totale);
        }

        GioielloDao gioielloDao = new GioielloDao();
        Gioiello gioiello = null;
        try {
            gioiello = gioielloDao.retrieveByModello(req.getParameter("gioiello"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Set<Map.Entry<Gioiello, Integer>> entrySet = carrello.entrySet();
        boolean aggiunto = false;

        for (Map.Entry<Gioiello, Integer> entry: entrySet) {
            Gioiello key = entry.getKey();
            Integer value = entry.getValue();
            if (key.getModello().equals(gioiello.getModello()))
            {
                value++;
                totale+=gioiello.getPrezzo();
                carrello.replace(key,value);
                aggiunto=true;
            }
        }
        if(!aggiunto)
        {
            carrello.put(gioiello, 1);
            totale+=gioiello.getPrezzo();
        }

        req.getSession().setAttribute("totale", totale);
        indirizzo = "/shop.jsp";
        resp.sendRedirect(req.getContextPath()+indirizzo);
    }
}
