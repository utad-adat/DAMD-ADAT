import entity.Asistentes;
import entity.Eventos;
import jdk.jfr.Event;
import org.hibernate.Session;

import java.sql.Date;
import java.util.List;

public class Main {
    private static Session session = null;

    public static void main(String[] args) {
        try {
            session = HibernateUtil.getSession();
            //crearEventoConAsistente();
            //mostrarEventosYAsistentes();
            //buscarAsistente("Lucas");
            actualizarEvento(3, "Navidad");
            eliminarAsistente(3);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }

    private static void eliminarAsistente(int idAsistente) {
        // Cargar la entidad que deseas eliminar
        Asistentes user = session.get(Asistentes.class, idAsistente);

        if (user != null) {
            // Iniciar la transacción y eliminar la entidad
            session.beginTransaction();
            session.remove(user);
            session.getTransaction().commit();

            System.out.println("Asistente eliminado correctamente.");
        } else {
            System.out.println("No se encontró el asistente con el ID: " + idAsistente);
        }
    }

    private static void actualizarEvento(int idEvento, String nombre) {
        // Cargar la entidad que deseas actualuzar
        Eventos event = session.get(Eventos.class, idEvento);

        if (event != null) {
            // Actualizamos la propiedad que querramos
            event.setNombre(nombre);

            // Iniciar la transacción y eliminar la entidad
            session.beginTransaction();
            session.merge(event);
            session.getTransaction().commit();

            System.out.println("Evento actualizado correctamente.");
        } else {
            System.out.println("No se encontró el evento con el ID: " + idEvento);
        }
    }

    private static void buscarAsistente(String nombre) {
        // Definir la consulta
        String hql = "FROM Asistentes WHERE nombre = :nombre";

        // Ejecutar la consulta
        Asistentes asistente = session.createQuery(hql, Asistentes.class)
                .setParameter("nombre", nombre)
                .uniqueResult();

        if (asistente != null) {
            System.out.println("ID: " + asistente.getId() + ", Nombre: " + asistente.getNombre());
        } else {
            System.out.println("No se encontró el asistente con el nombre: " + nombre);
        }
    }

    private static void mostrarEventosYAsistentes() {
        List<Eventos> dataList = session.createQuery("FROM Eventos ", Eventos.class).list();

        for (Eventos ev : dataList) {
            System.out.println("ID: " + ev.getId() + ", Nombre: " + ev.getNombre());
        }

        List<Asistentes> usersList = session.createQuery("FROM Asistentes ", Asistentes.class).list();

        for (Asistentes u : usersList) {
            System.out.println("ID: " + u.getId() + ", Nombre: " + u.getNombre());
        }
    }

    private static void crearEventoConAsistente() {
        session.beginTransaction();

        Eventos event = new Eventos();
        event.setNombre("Fiesta de cumple");
        Date now = new Date(System.currentTimeMillis());
        event.setFecha(now);
        session.persist(event);

        Asistentes user = new Asistentes();
        user.setEventoId(event.getId());
        user.setNombre("Lucas");

        session.persist(user);

        session.getTransaction().commit();
    }
}
