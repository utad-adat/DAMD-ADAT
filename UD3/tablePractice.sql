-- Creación de la tabla Eventos
CREATE TABLE eventos
(
    id     SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    fecha  DATE         NOT NULL
);

-- Creación de la tabla Asistentes
CREATE TABLE asistentes
(
    id        SERIAL PRIMARY KEY,
    nombre    VARCHAR(255) NOT NULL,
    evento_id INT REFERENCES eventos (id) ON DELETE CASCADE
);
