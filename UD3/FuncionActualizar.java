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
