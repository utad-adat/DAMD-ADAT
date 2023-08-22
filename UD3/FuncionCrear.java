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
