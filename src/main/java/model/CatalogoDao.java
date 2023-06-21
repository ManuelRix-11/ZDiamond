package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CatalogoDao {
    public Catalogo CreateCatalogo() throws SQLException {
        Catalogo c = new Catalogo();
        ArrayList<Gioiello> catalogo = new ArrayList<>();
        ArrayList<String> categorie = new ArrayList<>();
        ArrayList<Gioiello> newEntry = new ArrayList<>();
        ArrayList<Gioiello> bestseller = new ArrayList<>();
        ArrayList<Gioiello> ultimi = new ArrayList<>();
        ArrayList<String> listaMetalli = new ArrayList<>();
        ArrayList<String> listaPietre = new ArrayList<>();

        try (Connection con = ConnectionPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "select * from gioiello, pietre, montatura where gioiello.Matricola = pietre.Gioiello and gioiello.Matricola = montatura.Gioiello order by gioiello.Matricola desc;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Gioiello gioiello = new Gioiello();
                gioiello.setMatricola(rs.getString("gioiello.Matricola"));
                gioiello.setModello(rs.getString("gioiello.modello"));
                gioiello.setCategoria(rs.getString("gioiello.categoria"));
                gioiello.setPrezzo(rs.getInt("gioiello.prezzo"));
                gioiello.setPezzidisponibili(rs.getInt("gioiello.pezziDisponibile"));
                gioiello.setImmagine(rs.getString("gioiello.immagine"));
                gioiello.setVenduti(rs.getInt("gioiello.venduti"));

                Pietre pietre = new Pietre();
                pietre.setCodice(rs.getString("pietre.Codice"));
                pietre.setTipo(rs.getString("pietre.Tipo"));
                pietre.setCaratura(rs.getFloat("pietre.Caratura"));
                pietre.setDimensione(rs.getFloat("pietre.Dimensione"));
                pietre.setQuantita(rs.getInt("pietre.Quantita"));
                pietre.setPrezzo(rs.getFloat("pietre.Prezzo"));
                gioiello.setPietre(pietre);

                Montatura montatura = new Montatura();
                montatura.setCodice(rs.getString("montatura.Codice"));
                montatura.setPeso(rs.getFloat("montatura.Peso"));
                montatura.setMetallo(rs.getString("montatura.Metallo"));
                montatura.setPurezza(rs.getFloat("montatura.Purezza"));
                montatura.setPrezzo(rs.getFloat("montatura.Prezzo"));
                gioiello.setMontatura(montatura);

                catalogo.add(gioiello);
                if (!categorie.contains(gioiello.getCategoria()))
                    categorie.add(gioiello.getCategoria());
                if (newEntry.size() <= 5)
                    newEntry.add(gioiello);
                if (!listaMetalli.contains(montatura.getMetallo()))
                    listaMetalli.add(montatura.getMetallo());
                if (!listaPietre.contains(pietre.getTipo()))
                    listaPietre.add(pietre.getTipo());

                c.setCatalogo(catalogo);
                c.setCategorie(categorie);
                c.setListaMetalli(listaMetalli);
                c.setListaPietre(listaPietre);
                c.setNewEntry(newEntry);
            }
            ps = con.prepareStatement(
                    "select * from gioiello, pietre, montatura where gioiello.Matricola = pietre.Gioiello and gioiello.Matricola = montatura.Gioiello order by gioiello.venduti desc limit 4;");
            rs = ps.executeQuery();
            while (rs.next()) {
                Gioiello gioiello = new Gioiello();
                gioiello.setMatricola(rs.getString("gioiello.Matricola"));
                gioiello.setModello(rs.getString("gioiello.modello"));
                gioiello.setCategoria(rs.getString("gioiello.categoria"));
                gioiello.setPrezzo(rs.getInt("gioiello.prezzo"));
                gioiello.setPezzidisponibili(rs.getInt("gioiello.pezziDisponibile"));
                gioiello.setImmagine(rs.getString("gioiello.immagine"));
                gioiello.setVenduti(rs.getInt("gioiello.venduti"));

                Pietre pietre = new Pietre();
                pietre.setCodice(rs.getString("pietre.Codice"));
                pietre.setTipo(rs.getString("pietre.Tipo"));
                pietre.setCaratura(rs.getFloat("pietre.Caratura"));
                pietre.setDimensione(rs.getFloat("pietre.Dimensione"));
                pietre.setQuantita(rs.getInt("pietre.Quantita"));
                pietre.setPrezzo(rs.getFloat("pietre.Prezzo"));
                gioiello.setPietre(pietre);

                Montatura montatura = new Montatura();
                montatura.setCodice(rs.getString("montatura.Codice"));
                montatura.setPeso(rs.getFloat("montatura.Peso"));
                montatura.setMetallo(rs.getString("montatura.Metallo"));
                montatura.setPurezza(rs.getFloat("montatura.Purezza"));
                montatura.setPrezzo(rs.getFloat("montatura.Prezzo"));
                gioiello.setMontatura(montatura);

                bestseller.add(gioiello);
            }
            c.setBestseller(bestseller);

            ps = con.prepareStatement("select * from gioiello, pietre, montatura where gioiello.Matricola = pietre.Gioiello and gioiello.Matricola = montatura.Gioiello and gioiello.pezziDisponibile<10 order by gioiello.venduti;");
            rs = ps.executeQuery();
            while (rs.next())
            {
                Gioiello gioiello = new Gioiello();
                gioiello.setMatricola(rs.getString("gioiello.Matricola"));
                gioiello.setModello(rs.getString("gioiello.modello"));
                gioiello.setCategoria(rs.getString("gioiello.categoria"));
                gioiello.setPrezzo(rs.getInt("gioiello.prezzo"));
                gioiello.setPezzidisponibili(rs.getInt("gioiello.pezziDisponibile"));
                gioiello.setImmagine(rs.getString("gioiello.immagine"));
                gioiello.setVenduti(rs.getInt("gioiello.venduti"));

                Pietre pietre = new Pietre();
                pietre.setCodice(rs.getString("pietre.Codice"));
                pietre.setTipo(rs.getString("pietre.Tipo"));
                pietre.setCaratura(rs.getFloat("pietre.Caratura"));
                pietre.setDimensione(rs.getFloat("pietre.Dimensione"));
                pietre.setQuantita(rs.getInt("pietre.Quantita"));
                pietre.setPrezzo(rs.getFloat("pietre.Prezzo"));
                gioiello.setPietre(pietre);

                Montatura montatura = new Montatura();
                montatura.setCodice(rs.getString("montatura.Codice"));
                montatura.setPeso(rs.getFloat("montatura.Peso"));
                montatura.setMetallo(rs.getString("montatura.Metallo"));
                montatura.setPurezza(rs.getFloat("montatura.Purezza"));
                montatura.setPrezzo(rs.getFloat("montatura.Prezzo"));
                gioiello.setMontatura(montatura);

                ultimi.add(gioiello);
            }
            c.setUltimi(ultimi);
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return c;
    }
}
