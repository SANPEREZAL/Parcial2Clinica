package model;


import java.io.Serializable;
import java.time.LocalDate;

public class Consulta implements Serializable {
    private Paciente paciente;
    private Medico medico;
    private String sintomas;
    private String diagnostico;
    private String tratamiento;
    private LocalDate fecha;

    public Consulta(Paciente paciente, Medico medico, String sintomas, String diagnostico, String tratamiento) {
        this.paciente = paciente;
        this.medico = medico;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.fecha = LocalDate.now();
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public String getSintomas() {
        return sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Consulta [" + fecha + "]\nPaciente: " + paciente.getNombre() +
               "\nMédico: " + medico.getNombre() +
               "\nSíntomas: " + sintomas +
               "\nDiagnóstico: " + diagnostico +
               "\nTratamiento: " + tratamiento;
    }
}
