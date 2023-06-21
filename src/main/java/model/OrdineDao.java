package model;

import com.oracle.wls.shaded.org.apache.xpath.operations.Or;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class OrdineDao {
    public void doSave(Ordine ordine) throws SQLException
    {
        try(Connection con = ConnectionPool.getConnection())
        {
            PreparedStatement ps
                    = con.prepareStatement("insert into Ordini values (?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ordine.getnOrdine());
            ps.setString(2, ordine.getCliente().getMail());
            ps.setString(3, ordine.getCliente().getPasw());
            ps.setString(4, ordine.getGioiello().getMatricola());
            ps.setInt(5, ordine.getQuantita());
            if(ps.executeUpdate() != 1)
            {
                throw new RuntimeException("Failed registration");
            }
        }
    }
}
