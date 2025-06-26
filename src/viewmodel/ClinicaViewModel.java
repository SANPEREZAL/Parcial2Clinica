package viewmodel;

import model.*;
import excepciones.*;

import java.util.List;

public class ClinicaViewModel {
    private Clinica clinica;

    public ClinicaViewModel(Clinica clinica) {
        this.clinica = clinica;
    }

    // Registro de pacientes
    public void registrarPaciente(String id, String nombre, int edad) throws CampoVacioException {
        if (id.isEmpty() || nombre.isEmpty()) {
            throw new CampoVacioException("Los campos ID y Nombre no pueden estar vacíos.");
        }

        clinica.registrarPaciente(new Paciente(id, nombre, edad));
    }

    // Registro de médicos
    public void registrarMedico(String id, String nombre, int edad, String especialidad) throws CampoVacioException {
        if (id.isEmpty() || nombre.isEmpty() || especialidad.isEmpty()) {
            throw new CampoVacioException("Los campos no pueden estar vacíos.");
        }

        clinica.registrarMedico(new Medico(id, nombre, edad, especialidad));
    }

    // Asignar una consulta
    public void agendarConsulta(String idPaciente, String idMedico, String sintomas, String diagnostico, String tratamiento)
            throws CampoVacioException, UsuarioNoEncontradoException {

        if (idPaciente.isEmpty() || idMedico.isEmpty() ||
            sintomas.isEmpty() || diagnostico.isEmpty() || tratamiento.isEmpty()) {
            throw new CampoVacioException("Todos los campos son obligatorios.");
        }

        Paciente paciente = clinica.buscarPaciente(idPaciente);
        Medico medico = clinica.buscarMedico(idMedico);

        if (paciente == null) {
            throw new UsuarioNoEncontradoException("Paciente con ID " + idPaciente + " no encontrado.");
        }

        if (medico == null) {
            throw new UsuarioNoEncontradoException("Médico con ID " + idMedico + " no encontrado.");
        }

        clinica.agendarConsulta(idPaciente, idMedico, sintomas, diagnostico, tratamiento);
    }

    // Obtener historial de un paciente
    public List<Consulta> historialPaciente(String idPaciente) {
        return clinica.historialPaciente(idPaciente);
    }

    // Obtener consultas de un médico
    public List<Consulta> consultasMedico(String idMedico) {
        return clinica.consultasMedico(idMedico);
    }

    // Acceder al modelo completo
    public Clinica getClinica() {
        return clinica;
    }
}