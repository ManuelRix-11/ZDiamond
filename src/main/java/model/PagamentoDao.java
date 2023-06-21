package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PagamentoDao {
    public void doSave(Pagamento pagamento) throws SQLException {
        try(Connection con = ConnectionPool.getConnection())
        {
            PreparedStatement ps =
                    con.prepareStatement("insert into pagamento values (?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pagamento.getIdPagamento());
            ps.setTimestamp(2, pagamento.getTimestamp());
            ps.setString(3, pagamento.getCliente().getMail());
            ps.setString(4, pagamento.getCliente().getPasw());
            ps.setString(5,pagamento.getMetodoPagamento().getCartaconto());
            if(ps.executeUpdate() != 1)
            {
                throw new RuntimeException("Failed registration");
            }
        }
    }
}
