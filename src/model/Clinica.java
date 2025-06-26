package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Clinica implements Serializable {
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<Consulta> consultas;

    public Clinica() {
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.consultas = new ArrayList<>();
    }

    public void registrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void registrarMedico(Medico medico) {
        medicos.add(medico);
    }

    public void agendarConsulta(String idPaciente, String idMedico, String sintomas, String diagnostico, String tratamiento) {
        Paciente paciente = buscarPaciente(idPaciente);
        Medico medico = buscarMedico(idMedico);
        if (paciente != null && medico != null) {
            Consulta consulta = new Consulta(paciente, medico, sintomas, diagnostico, tratamiento);
            consultas.add(consulta);
            medico.agendarConsulta(consulta);
        }
    }

    public Paciente buscarPaciente(String id) {
        for (Paciente p : pacientes) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    public Medico buscarMedico(String id) {
        for (Medico m : medicos) {
            if (m.getId().equals(id)) return m;
        }
        return null;
    }

    public List<Consulta> historialPaciente(String idPaciente) {
        List<Consulta> resultado = new ArrayList<>();
        for (Consulta c : consultas) {
            if (c.getPaciente().getId().equals(idPaciente)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public List<Consulta> consultasMedico(String idMedico) {
        List<Consulta> resultado = new ArrayList<>();
        for (Consulta c : consultas) {
            if (c.getMedico().getId().equals(idMedico)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }
}
