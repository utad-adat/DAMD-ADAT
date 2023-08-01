package com.utad;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.util.List;

public class Main {

    private static String path = "./src/main/java/com/utad/Example.xml";

    public static void main(String[] args) {
        try {
            XmlMapper xmlMapper = new XmlMapper();

            // La mágia: leemos el archivo XML y lo convertirmos en una lista de objetos Marca
            List<Marca> marcas = xmlMapper.readValue(new File(path),
                    xmlMapper.getTypeFactory().constructCollectionType(List.class, Marca.class));

            // Pintamos la información de las marcas y sus modelos
            for (Marca marca : marcas) {
                System.out.println("Marca: " + marca.getNombre());
                System.out.println("Modelos: " + marca.getModelos());
                System.out.println(); // Separador entre marcas
            }

        } catch (Exception e) {
            System.out.println("Error al leer el archivo XML: " + e.getMessage());
        }
    }

}
