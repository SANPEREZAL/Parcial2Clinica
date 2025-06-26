/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.io.IOException;

public interface IPersistencia {
    void guardarClinica(Clinica clinica) throws IOException;
    Clinica cargarClinica() throws IOException, ClassNotFoundException;
}
