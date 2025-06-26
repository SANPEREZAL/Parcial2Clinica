package model;

import java.io.IOException;

public interface IPersistencia {
    void guardarClinica(Clinica clinica) throws IOException;
    Clinica cargarClinica() throws IOException, ClassNotFoundException;
}
