package model;

import java.sql.*;

public class GioielloDao {
    public void doSave(Gioiello gioiello, Pietre pietre, Montatura montatura) throws SQLException
    {
        try(Connection con = ConnectionPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("insert into Gioiello values (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, gioiello.getMatricola());
            ps.setString(2, gioiello.getModello());
            ps.setString(3, gioiello.getCategoria());
            ps.setDouble(4, gioiello.getPrezzo());
            ps.setInt(5, gioiello.getPezzidisponibili());
            ps.setString(6, gioiello.getImmagine());
            ps.setInt(7, gioiello.getVenduti());
            if(ps.executeUpdate() != 1)
            {
                throw new RuntimeException("Failed registration");
            }

            ps = con.prepareStatement("insert into Pietre values (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pietre.getCodice());
            ps.setString(2, pietre.getTipo());
            ps.setFloat(3, pietre.getCaratura());
            ps.setFloat(4, pietre.getDimensione());
            ps.setInt(5, pietre.getQuantita());
            ps.setFloat(6, pietre.getPrezzo());
            ps.setString(7, gioiello.getMatricola());
            if(ps.executeUpdate() != 1)
            {
                throw new RuntimeException("Failed registration");
            }

            ps = con.prepareStatement("insert into Montatura values (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, montatura.getCodice());
            ps.setFloat(2, montatura.getPeso());
            ps.setString(3, montatura.getMetallo());
            ps.setFloat(4, montatura.getPurezza());
            ps.setString(5, gioiello.getMatricola());
            ps.setFloat(6, montatura.getPrezzo());
            if(ps.executeUpdate() != 1)
            {
                throw new RuntimeException("Failed registration");
            }
        }
    }

    public Gioiello retrieveByModello(String modello) throws  SQLException
    {
        try(Connection con = ConnectionPool.getConnection() ) {
            PreparedStatement ps =
                    con.prepareStatement("select * from gioiello, pietre, montatura where gioiello.Matricola = pietre.Gioiello and gioiello.Matricola = montatura.Gioiello and modello=?;");
            ps.setString(1, modello);
            ResultSet rs = ps.executeQuery();
            Gioiello gioiello = null;
            if(rs.next())
            {
                gioiello =new Gioiello();
                gioiello.setMatricola(rs.getString("Matricola"));
                gioiello.setModello(rs.getString("modello"));
                gioiello.setPrezzo(rs.getInt("prezzo"));
                gioiello.setPezzidisponibili(rs.getInt("pezziDisponibile"));
                gioiello.setImmagine(rs.getString("immagine"));
                gioiello.setCategoria(rs.getString("categoria"));
                gioiello.setVenduti(rs.getInt("venduti"));

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

            }
            con.close();
            return gioiello;
            }catch (SQLException e)
            {
                throw new SQLException(e);
            }
    }

    public Gioiello retrieveByMatricola(String matricola) throws SQLException {
        try(Connection con = ConnectionPool.getConnection() ) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * from Gioiello where Matricola=?");
            ps.setString(1, matricola);
            ResultSet rs = ps.executeQuery();
            Gioiello gioiello = null;
            if(rs.next())
            {
                gioiello =new Gioiello();
                gioiello.setMatricola(rs.getString("Matricola"));
                gioiello.setModello(rs.getString("modello"));
                gioiello.setPrezzo(rs.getInt("prezzo"));
                gioiello.setPezzidisponibili(rs.getInt("pezziDisponibile"));
                gioiello.setImmagine(rs.getString("immagine"));
                gioiello.setCategoria(rs.getString("categoria"));
                gioiello.setVenduti(rs.getInt("venduti"));

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
            }
            con.close();
            return gioiello;
        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
    }
}
