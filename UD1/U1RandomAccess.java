import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class U1RandomAccess {
    public static void main(String[] args) {
        randomAccess();
    }

    private static void randomAccess() {
        Path path = Paths.get("proyecto.txt");
        
        try (RandomAccessFile raf = new RandomAccessFile(path.toFile(), "rw");
             FileChannel channel = raf.getChannel()) {

            // Colocarse en una posición específica del fichero
            long posicion = 10; // Ejemplo: acceder a la posición 10
            channel.position(posicion);

            // Leer datos en la posición seleccionada
            ByteBuffer buffer = ByteBuffer.allocate(100);
            int bytesRead = channel.read(buffer);

            // Procesar los datos leídos desde la posición 10
            if (bytesRead != -1) {
                buffer.flip(); // Preparamos el buffer para lectura
                byte[] data = new byte[bytesRead];
                buffer.get(data);

                // Procesar los datos leídos
                String datosLeidos = new String(data);
                System.out.println("Datos leídos desde la posición " + posicion + ": " + datosLeidos);
            } else {
                System.out.println("No se encontraron datos en la posición " + posicion);
            }

        } catch (IOException e) {
            System.out.println("Error al acceder al fichero de forma aleatoria.");
        }
    }
}
