package com.santiago.codigotecsup.SQLite;

public class Auto {
    public int id;
    public String marca;
    public String color;
    public String placa;

    public Auto(int id, String marca, String color, String placa) {
        this.id = id;
        this.marca = marca;
        this.color = color;
        this.placa = placa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
