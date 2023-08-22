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
