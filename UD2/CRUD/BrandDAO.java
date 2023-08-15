package com.utad;

import java.sql.*;

public class BrandDAO {

    private Connection connection;

    public BrandDAO(Connection connection) {
        this.connection = connection;
    }

    public int createBrand(String name) throws SQLException {
        String insertQuery = "INSERT INTO marcas (nombre) VALUES (?) RETURNING id;";
        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        }
        return -1;
    }

    public void readAllBrands() throws SQLException {
        String selectQuery = "SELECT id, nombre FROM marcas;";
        try (PreparedStatement statement = connection.prepareStatement(selectQuery);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("nombre");
                System.out.println("Producto: ID=" + id + ", Nombre=" + name);
            }
        }
    }

    public void updateBrand(int productId, String newName) throws SQLException {
        String updateQuery = "UPDATE marcas SET nombre = ? WHERE id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setString(1, newName);
            statement.setInt(2, productId);
            int rowsAffected = statement.executeUpdate();
            System.out.println("Filas afectadas por la actualización: " + rowsAffected);
        }
    }

    public void deleteBrand(int productId) throws SQLException {
        String deleteQuery = "DELETE FROM marcas WHERE id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setInt(1, productId);
            int rowsAffected = statement.executeUpdate();
            System.out.println("Filas afectadas por la eliminación: " + rowsAffected);
        }
    }

    public void readBrand(int productId) throws SQLException {
        String selectQuery = "SELECT id, nombre FROM marcas WHERE id = ?;";
        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setInt(1, productId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("nombre");
                System.out.println("Producto encontrado: ID=" + id + ", Nombre=" + name);
            } else {
                System.out.println("Producto no encontrado.");
            }
        }
    }
}
