package com.utad;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static String path = "./src/main/java/com/utad/Example.xml";

    public static void main(String[] args) {
        readXML();
    }

    private static void readXML() {
        try {
            JAXBContext ctx = JAXBContext.newInstance(Marcas.class);
            Unmarshaller um =  ctx.createUnmarshaller();

            File fileToRead = new File(path);
            Marcas marcas = (Marcas) um.unmarshal(fileToRead);

            for (Marca marca: marcas.getMarcas()) {
                System.out.println("Marca: " + marca.getNombre());
                System.out.println("Modelos: " + marca.getModelos());
            }

            // Crea un coche nuevo en el xml
            addNewCar(marcas, path);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void addNewCar(Marcas marcas, String filePath) {
        Marca ford = new Marca();
        ford.setNombre("Ford");

        List<String> modelosFord = Arrays.asList("Kuga", "Focus", "Fiesta");
        ford.setModelos(modelosFord);
        marcas.getMarcas().add(ford);

        // Guardar los cambios en el archivo XML
        try {
            JAXBContext context = JAXBContext.newInstance(Marcas.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(marcas, new File(filePath));

            System.out.println("Nuevo fabricante \"Ford\" con modelos añadidos y cambios guardados en el archivo XML.");

        } catch (Exception e) {
            System.out.println("Error al guardar los cambios en el archivo XML: " + e.getMessage());
        }
    }

}
