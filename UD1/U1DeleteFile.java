import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class U1DeleteFile {
    static String FILE_PATH = "proyecto.txt";

    public static void main(String[] args) {
        deleteTextFile();
    }

    private static void deleteTextFile() {
        Path rutaFichero = Paths.get(FILE_PATH);
        try {
            Files.delete(rutaFichero);
            System.out.println("Fichero de texto eliminado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al eliminar el fichero: " + e.getMessage());
        }
    }
}
