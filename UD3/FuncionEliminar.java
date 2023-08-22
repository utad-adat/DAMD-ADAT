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
