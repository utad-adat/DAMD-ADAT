package com.utad;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class Marca {
    private String nombre;
    private List<String> modelos;


    public String getNombre() {
        return nombre;
    }

    @XmlElement
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getModelos() {
        return modelos;
    }

    @XmlElementWrapper(name = "modelos")
    @XmlElement(name = "modelo")
    public void setModelos(List<String> modelos) {
        this.modelos = modelos;
    }
}
