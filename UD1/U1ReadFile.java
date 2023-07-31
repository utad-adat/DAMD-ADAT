import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class U1ReadFile {
    static String FILE_PATH = "proyecto.txt";

    public static void main(String[] args) {
        readTextFileSequentially();
        readTextFileSequentiallyWithBufferedReader();
    }

    private static void readTextFileSequentially() {
        Path rutaFichero = Paths.get(FILE_PATH);
        try {
            List<String> lines = Files.readAllLines(rutaFichero);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }

    private static void readTextFileSequentiallyWithBufferedReader() {
        Path rutaFichero = Paths.get(FILE_PATH);
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaFichero.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}
