package com.utad;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String pass = "postgres";

            Connection conn = DriverManager.getConnection(url, user, pass);

            String createTableMarcas = "CREATE TABLE marcas (id SERIAL PRIMARY KEY, nombre VARCHAR(255));";
            Statement statement = conn.createStatement();
            statement.executeUpdate(createTableMarcas);
            System.out.println("Tabla 'marcas' creada correctamente.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
