package model;

import java.sql.*;

public class MetodoPagamentoDao {
    public MetodoPagamento retrievebyCliente(User user) throws SQLException {
        MetodoPagamento metodoPagamento = new MetodoPagamento();
        UserDao userDao = new UserDao();
        try(Connection con= ConnectionPool.getConnection())
        {
            PreparedStatement ps =
                    con.prepareStatement("select * from Metodo where ClienteMail=? and ClientePasw=?;", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,user.getMail());
            ps.setString(2,user.getPasw());
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                metodoPagamento.setCartaconto(rs.getString("CartaConto"));
                metodoPagamento.setCvv(rs.getString("CVV"));
                metodoPagamento.setTipo(rs.getString("Tipo"));
                metodoPagamento.setUser(userDao.checkLogin(rs.getString("ClienteMail"), rs.getString("ClientePasw")));
            }
        }
        return metodoPagamento;
    }
}
