package com.santiago.codigotecsup.Realm;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Entrada extends RealmObject {
    @PrimaryKey
    int id;
    @Required
    String descripcion;
    @Required
    Date f_creacion;

    public Entrada() {
    }

    public Entrada(String descripcion) {
        this.id = MiApp.EntradaId.incrementAndGet();
        this.descripcion = descripcion;
        this.f_creacion = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getF_creacion() {
        return f_creacion;
    }

    public void setF_creacion(Date f_creacion) {
        this.f_creacion = f_creacion;
    }
}
