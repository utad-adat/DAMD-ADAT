package com.utad;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "marcas")
public class Marcas {
    private List<Marca> marcas;

    public List<Marca> getMarcas() {
        return marcas;
    }

    @XmlElement(name = "marca")
    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }
}
