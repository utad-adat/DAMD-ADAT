import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        readXML();
    }

    // Lectura del XML con DOM
    private static void readXML() {

        try {
            // Paso 1
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("./src/files/UD1_XML_72_Example.xml"));

            // Paso 2:
            // Obtenemos el elemento root que sería "marcas"
            Element root = document.getDocumentElement();

            // Obtenemos la lista de lo que contiene root, es decir, una lista de "marca"
            NodeList marcasList = root.getElementsByTagName("marca");

            // Recorrer la lista de marcas y obtener la información
            for (int i = 0; i < marcasList.getLength(); i++) {
                Element marca = (Element) marcasList.item(i);

                // Obtenemos el elemento "nombre" de la marca
                String nombreMarca = marca.getElementsByTagName("nombre").item(0).getTextContent();
                System.out.println("Marca: " + nombreMarca);

                // Obtenemos la lista de modelos de la marca
                NodeList listaModelos = marca.getElementsByTagName("modelo");

                // Recorremos la lista de los modelos
                for (int j = 0; j < listaModelos.getLength(); j++) {
                    Element modelo = (Element) listaModelos.item(j);
                    String nombreModelo = modelo.getTextContent();
                    System.out.println(" --> Modelo: " + nombreModelo);
                }

                System.out.println(); // Separador entre marcas
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
