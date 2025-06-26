package view;

import viewmodel.ClinicaViewModel;
import viewmodel.ClinicaViewModel;
import excepciones.*;

import javax.swing.*;
import java.awt.*;

public class PanelConsulta extends JPanel {
    private ClinicaViewModel viewModel;

    public PanelConsulta(ClinicaViewModel viewModel) {
        this.viewModel = viewModel;

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JLabel titulo = new JLabel("Asignar Consulta Médica");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setForeground(new Color(25, 118, 210));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        add(titulo, BorderLayout.NORTH);

        JPanel formulario = new JPanel(new GridLayout(6, 2, 10, 10));
        formulario.setBorder(BorderFactory.createTitledBorder("Datos de la Consulta"));
        formulario.setBackground(Color.WHITE);

        JLabel lblPaciente = new JLabel("ID Paciente:");
        JTextField txtPaciente = new JTextField();
        JLabel lblMedico = new JLabel("ID Médico:");
        JTextField txtMedico = new JTextField();
        JLabel lblSintomas = new JLabel("Síntomas:");
        JTextField txtSintomas = new JTextField();
        JLabel lblDiagnostico = new JLabel("Diagnóstico:");
        JTextField txtDiagnostico = new JTextField();
        JLabel lblTratamiento = new JLabel("Tratamiento:");
        JTextField txtTratamiento = new JTextField();

        JButton btnAsignar = new JButton("Asignar Consulta");
        btnAsignar.setBackground(new Color(25, 118, 210));
        btnAsignar.setForeground(Color.WHITE);
        btnAsignar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnAsignar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAsignar.setBackground(new Color(21, 101, 192));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAsignar.setBackground(new Color(25, 118, 210));
            }
        });

        formulario.add(lblPaciente); formulario.add(txtPaciente);
        formulario.add(lblMedico); formulario.add(txtMedico);
        formulario.add(lblSintomas); formulario.add(txtSintomas);
        formulario.add(lblDiagnostico); formulario.add(txtDiagnostico);
        formulario.add(lblTratamiento); formulario.add(txtTratamiento);
        formulario.add(new JLabel()); formulario.add(btnAsignar);

        add(formulario, BorderLayout.CENTER);

        btnAsignar.addActionListener(e -> {
            try {
                String idPaciente = txtPaciente.getText().trim();
                String idMedico = txtMedico.getText().trim();
                String sintomas = txtSintomas.getText().trim();
                String diagnostico = txtDiagnostico.getText().trim();
                String tratamiento = txtTratamiento.getText().trim();

                viewModel.agendarConsulta(idPaciente, idMedico, sintomas, diagnostico, tratamiento);
                JOptionPane.showMessageDialog(this, "Consulta asignada correctamente.");

                // Limpiar campos
                txtPaciente.setText("");
                txtMedico.setText("");
                txtSintomas.setText("");
                txtDiagnostico.setText("");
                txtTratamiento.setText("");

            } catch (CampoVacioException | UsuarioNoEncontradoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}