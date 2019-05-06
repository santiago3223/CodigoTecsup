package com.santiago.codigotecsup.Realm;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Contenedor extends RealmObject {

    @PrimaryKey
    int id;
    @Required
    String descripcion;
    @Required
    Date f_creacion;

    RealmList<Entrada> entradas;

    public Contenedor() {

    }

    public Contenedor(String descripcion) {
        this.id = MiApp.ContenedorId.incrementAndGet();
        this.descripcion = descripcion;
        this.f_creacion = new Date();
        this.entradas = new RealmList<>();
    }

    public RealmList<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(RealmList<Entrada> entradas) {
        this.entradas = entradas;
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
