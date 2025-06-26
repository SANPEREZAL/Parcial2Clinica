package model;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Persona implements Agendable {
    private String especialidad;
    private List<Consulta> agenda;

    public Medico(String id, String nombre, int edad, String especialidad) {
        super(id, nombre, edad);
        this.especialidad = especialidad;
        this.agenda = new ArrayList<>();
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public void agendarConsulta(Consulta consulta) {
        agenda.add(consulta);
    }

    public List<Consulta> getAgenda() {
        return agenda;
    }

    @Override
    public String getRol() {
        return "Médico";
    }

    @Override
    public String toString() {
        return "Dr. " + nombre + " (ID: " + id + ", Especialidad: " + especialidad + ")";
    }
}
