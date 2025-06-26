import model.Clinica;
import persistencia.PersistenciaArchivo;
import model.IPersistencia;
import viewmodel.ClinicaViewModel;
import view.VentanaPrincipal;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                
                IPersistencia persistencia = new PersistenciaArchivo();
                Clinica clinica = persistencia.cargarClinica();

                ClinicaViewModel viewModel = new ClinicaViewModel(clinica);
                VentanaPrincipal ventana = new VentanaPrincipal(viewModel);
                ventana.setVisible(true);

                ventana.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        try {
                            persistencia.guardarClinica(viewModel.getClinica());
                            System.out.println("Datos bien guardados.");
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(ventana, "Error al guardar: " + ex.getMessage(),
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

            } catch (IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Error al iniciar la interfaz: " + e.getMessage(),
                        "Error crítico", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
