package br.com.fintech.project.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
    private static ConnectionManager connectionManager;

    private ConnectionManager() {}

    public static ConnectionManager instance() {
        if (connectionManager == null) {
            connectionManager = new ConnectionManager();
        }
        return connectionManager;
    }
    public static Connection getConnectionManager() {
        Connection  connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            connection =  DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
                    "RM559767",
                    "280204");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}