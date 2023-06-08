package com.solvd.laba.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.LinkedBlockingQueue;

public class Database {
    private static final int POOL_SIZE = 10;
    private static final LinkedBlockingQueue<Connection> connectionPool = new LinkedBlockingQueue<>();
    private static final Properties props = new Properties();

    static {
        try {
            InputStream input = new FileInputStream("src/main/resources/db.properties");
            props.load(input);
            input.close();
            try {
                initializeConnectionPool();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load db.properties file.");
        }
    }

    private Database() {}

    public static Connection getConnection() throws SQLException {
        try {
            return connectionPool.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new SQLException("Failed to obtain a database connection.", e);
        }
    }

    public static void releaseConnection(Connection connection) throws SQLException {
        try {
            connectionPool.put(connection);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new SQLException("Failed to release the database connection.", e);
        }
    }

    private static void initializeConnectionPool() throws SQLException {
        for (int i = 0; i < POOL_SIZE; i++) {
            Connection connection = createConnection();
            connectionPool.offer(connection);
        }
    }

    private static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.user"),
                props.getProperty("db.password")
        );
    }
}
