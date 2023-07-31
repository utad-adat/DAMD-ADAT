import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class U1CreateFile {

    static String FILE_PATH = "proyecto.txt";
    static String data = "En U-tad nos mueve la pasión por enseñar a nuestros estudiantes como nos hubiera gustado que nos formaran a nosotros.";

    public static void main(String[] args) {
        createFileWithText();
    }

    private static void createFileWithText() {
        Path rutaFichero = Paths.get(FILE_PATH);
        try {
            Files.write(rutaFichero, data.getBytes());
            System.out.println("Fichero de texto creado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al crear el fichero: " + e.getMessage());
        }
    }

}
