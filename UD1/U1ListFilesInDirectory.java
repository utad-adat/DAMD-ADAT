import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class U1ListFilesInDirectory {
    public static void main(String[] args) {
        listFiles();
    }

    private static void listFiles() {
        Path directorio = Paths.get("./src/ficheros");

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directorio)) {
            for (Path fichero : stream) {
                // Procesar cada fichero del directorio
                System.out.println("Nombre: " + fichero.getFileName());

                // Obtener los atributos básicos del fichero
                BasicFileAttributes atributos = Files.readAttributes(fichero, BasicFileAttributes.class);
                System.out.println("Tamaño: " + atributos.size() + " bytes");
                System.out.println("Fecha de última modificación: " + atributos.lastModifiedTime());
            }
        } catch (IOException e) {
            System.out.println("Error al listar los ficheros del directorio: " + e.getMessage());
        }
    }

}
