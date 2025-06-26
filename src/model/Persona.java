package model;

import java.io.Serializable;

public abstract class Persona implements Serializable {
    protected String id;
    protected String nombre;
    protected int edad;

    public Persona(String id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(int edad) { this.edad = edad; }

    public abstract String getRol();
}
