package com.xyz.banco;

public class Persona {
    protected String id;
    protected String nombre;

    public Persona(String id, String nombre) { this.id = id; this.nombre = nombre; }
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override public String toString() { return id+" - "+nombre; }
}
