package model;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static DataSource dataSource;

    public static Connection getConnection() throws SQLException
    {
        if(dataSource == null)
        {
            PoolProperties p = new PoolProperties();
            p.setUrl("jdbc:mysql://localhost:3306/gioielleriatsw");
            p.setDriverClassName("com.mysql.cj.jdbc.Driver");
            p.setUsername("root");
            p.setPassword("lollypop");
            dataSource = new DataSource();
            dataSource.setPoolProperties(p);
        }
        return dataSource.getConnection();
    }
}
