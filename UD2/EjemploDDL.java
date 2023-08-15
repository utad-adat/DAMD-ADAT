package com.utad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DDL {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String pass = "postgres";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(url, user, pass)) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS employees (" +
                    "id SERIAL PRIMARY KEY," +
                    "first_name VARCHAR(50)," +
                    "last_name VARCHAR(50)," +
                    "email VARCHAR(100)" +
                    ");";

            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createTableQuery);
                System.out.println("Tabla 'employees' creada correctamente o ya existe.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
