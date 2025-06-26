package model;

public class Paciente extends Persona {

    public Paciente(String id, String nombre, int edad) {
        super(id, nombre, edad);
    }

    @Override
    public String getRol() {
        return "Paciente";
    }

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ", Edad: " + edad + ")";
    }
}
