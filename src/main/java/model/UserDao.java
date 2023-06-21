package model;

import org.apache.taglibs.standard.extra.spath.Step;

import java.sql.*;

public class UserDao {
    public User checkLogin(String email, String password) throws SQLException {
        try(Connection con = ConnectionPool.getConnection())
        {
            PreparedStatement ps =
                    con.prepareStatement("select * from Cliente where mail=? and pasw=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            User user = null;
            if(rs.next())
            {
                user = new User();
                user.setNome(rs.getString("nome"));
                user.setCognome(rs.getString("cognome"));
                user.setCitta(rs.getString("citta"));
                user.setVia(rs.getString("via"));
                user.setNcivico(rs.getInt("ncivico"));
                user.setMail(rs.getString("mail"));
                user.setPasw(rs.getString("pasw"));
            }
            con.close();
            return user;
        }catch (SQLException e)
        {
            throw new SQLException(e);
        }
    }

    public void doSave(User user, MetodoPagamento metodo) throws SQLException {
        try(Connection con = ConnectionPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("insert into Cliente values (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getNome());
            ps.setString(2, user.getCognome());
            ps.setString(3, user.getCitta());
            ps.setString(4, user.getVia());
            ps.setInt(5, user.getNcivico());
            ps.setString(6, user.getMail());
            ps.setString(7, user.getPasw());
            if(ps.executeUpdate() != 1)
            {
                throw new RuntimeException("Failed registration");
            }

            ps = con.prepareStatement("insert into Metodo values (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, metodo.getCartaconto());
            ps.setString(2, metodo.getCvv());
            ps.setString(3, metodo.getTipo());
            ps.setString(4, metodo.getUser().getMail());
            ps.setString(5, metodo.getUser().getPasw());
            if(ps.executeUpdate() != 1)
            {
                throw new RuntimeException("Failed registration");
            }

            ps = con.prepareStatement("insert into Pagamento values (?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getMail());
            ps.setString(2, user.getPasw());
            ps.setString(3, metodo.getCartaconto());
            if(ps.executeUpdate() != 1)
            {
                throw new RuntimeException("Failed registration");
            }
        }
    }
}
