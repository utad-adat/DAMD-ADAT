package com.utad;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try {
            Connection conn = DBConnection.getConnection();
            BrandDAO brand = new BrandDAO(conn);

            // IMPORTANTE, No ejecutes todas las consultas de golpe. Descomenta la función que quieres utilizar.

            // Crear una marca
            brand.createBrand("Utad");

            // Leer todas las marcas
            brand.readAllBrands();

            // ID del producto que queremos modificar, asegurate de que en la tabla exista este ID
            int idProduct = 1;

            // Actualizar la marca con id 1 (descomentar para usar)
            // brand.updateBrand(idProduct, "ProductoActualizado");

            // Leer la marca con id 1
            // brand.readBrand(idProduct);

            // Eliminar la marca con id 1
            // brand.deleteBrand(idProduct);

            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
