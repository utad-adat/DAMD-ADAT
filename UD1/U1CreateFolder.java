import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class U1CreateFolder {
    public static void main(String[] args) {
        createFolder("./src/trimestres");
        createFolderWithPath("./src/imgs/");
    }

    private static void createFolderWithPath(String routeFolder) {
        Path nuevoDirectorio = Paths.get(routeFolder);

        try {
            if(Files.exists(nuevoDirectorio)) {
                System.out.println("El directorio " + routeFolder + " ya existe.");
            } else {
                Files.createDirectory(nuevoDirectorio);
                System.out.println("Directorio creado correctamente.");
            }
        } catch (IOException e) {
            System.out.println("Error al crear el directorio: " + e.getMessage());
        }
    }

    private static void createFolder(String pathFolder) {
        File folder = new File(pathFolder);

        if(folder.exists()) {
            System.out.println("La carpeta " + pathFolder + " ya existe.");
            return;
        }

        if(folder.mkdirs()) {
            System.out.println("Carpeta creada");
        } else {
            System.err.println("Error al crear la carpeta");
        }
    }

}
