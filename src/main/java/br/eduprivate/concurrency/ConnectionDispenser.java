package br.eduprivate.concurrency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectionDispenser
 * <p/>
 * Using ThreadLocal to ensure thread confinement
 *
 */
public class ConnectionDispenser {
    static String DB_URL = "jdbc:mysql://localhost/mydatabase";

    private final ThreadLocal<Connection> connectionHolder
            = new ThreadLocal<Connection>() {
                public Connection initialValue() {
                    try {
                        return DriverManager.getConnection(DB_URL);
                    } catch (SQLException e) {
                        throw new RuntimeException("Unable to acquire Connection, e");
                    }
                }
    };

    public Connection getConnection() {
        return connectionHolder.get();
    }
}
