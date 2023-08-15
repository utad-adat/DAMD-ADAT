package com.utad;

import java.sql.*;

public class DBConnection {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String pass = "postgres";

    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(url, user, pass);

            String createTableMarcas = "CREATE TABLE IF NOT EXISTS marcas (id SERIAL PRIMARY KEY, nombre VARCHAR(255));";
            Statement statement = conn.createStatement();
            statement.executeUpdate(createTableMarcas);
            System.out.println("Tabla 'marcas' creada correctamente.");

            return conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
