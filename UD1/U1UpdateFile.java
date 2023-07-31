import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class U1UpdateFile {
    static String FILE_PATH = "proyecto.txt";
    static String newData = "\n¡Actualización exitosa!";

    public static void main(String[] args) {
        updateTextFile();
    }
    private static void updateTextFile() {
        Path rutaFichero = Paths.get(FILE_PATH);
        try {
            Files.write(rutaFichero, newData.getBytes(), StandardOpenOption.APPEND);
            System.out.println("Fichero de texto actualizado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al actualizar el fichero: " + e.getMessage());
        }
    }
}
