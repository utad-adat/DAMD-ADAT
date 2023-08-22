import entity.Marcas;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    private static Session session = null;

    public static void main(String[] args) {
        try {
            session = HibernateUtil.getSession();

            // Aquí van las funciones del CRUD

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }

}
