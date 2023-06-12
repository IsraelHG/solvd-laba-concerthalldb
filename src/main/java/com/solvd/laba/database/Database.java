package com.solvd.laba.database;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * The Database class provides a connection pooling mechanism for managing database connections.
 * It allows clients to obtain and release database connections efficiently.
 */
public class Database {
    public static final Logger LOGGER = LogManager.getLogger(Database.class.getName());
    private static final int POOL_SIZE = 10;
    private static final LinkedBlockingQueue<Connection> connectionPool = new LinkedBlockingQueue<>();
    private static final Properties props = new Properties();
    private static boolean isConnectionPoolInitialized = false;

    static {
        try {
            InputStream input = new FileInputStream("src/main/resources/db.properties");
            props.load(input);
            input.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load db.properties file.");
        }
    }

    /**
     * Private constructor to prevent instantiation of the Database class.
     * All methods and properties are static, and the class should be accessed statically.
     */
    private Database() {}

    /**
     * Retrieves a database connection from the connection pool.
     *
     * @return a Connection object representing a database connection
     * @throws SQLException if an error occurs while obtaining a connection
     */
    public static Connection getConnection() throws SQLException {
        initializeConnectionPool();
        try {
            Connection connection = connectionPool.take();
            LOGGER.info("Worker connected: " + Thread.currentThread().getName() + " Size: " + connectionPool.size());
            return connection;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new SQLException("Failed to obtain a database connection.", e);
        }
    }

    /**
     * Releases a database connection and returns it to the connection pool.
     *
     * @param connection the Connection object to release
     * @throws SQLException if an error occurs while releasing the connection
     */
    public static void releaseConnection(Connection connection) throws SQLException {
        initializeConnectionPool();
        try {
            connectionPool.put(connection);
            LOGGER.info("Worker exhausted: " + Thread.currentThread().getName() + " Size: " + connectionPool.size());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new SQLException("Failed to release the database connection.", e);
        }
    }

    /**
     * Initializes the connection pool if it has not been initialized yet.
     * Creates and adds connections to the pool up to the maximum pool size.
     */
    private static synchronized void initializeConnectionPool() {
        if (!isConnectionPoolInitialized) {
            try {
                for (int i = 0; i < POOL_SIZE; i++) {
                    Connection connection = createConnection();
                    connectionPool.offer(connection);
                    LOGGER.info("Added connection: " + connectionPool.size());
                }
                isConnectionPoolInitialized = true;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Creates a new database connection using the configured properties.
     *
     * @return a new Connection object representing a database connection
     * @throws SQLException if an error occurs while creating the connection
     */
    private static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.user"),
                props.getProperty("db.password")
        );
    }
}
