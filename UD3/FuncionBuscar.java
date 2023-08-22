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
