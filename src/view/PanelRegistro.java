package view;


import viewmodel.ClinicaViewModel;
import excepciones.CampoVacioException;

import javax.swing.*;
import java.awt.*;

public class PanelRegistro extends JPanel {
    private ClinicaViewModel viewModel;

    public PanelRegistro(ClinicaViewModel viewModel) {
        this.viewModel = viewModel;

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JLabel titulo = new JLabel("Registro de Persona");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setForeground(new Color(25, 118, 210));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        add(titulo, BorderLayout.NORTH);

        JPanel formulario = new JPanel(new GridLayout(6, 2, 10, 10));
        formulario.setBorder(BorderFactory.createTitledBorder("Datos de la Persona"));
        formulario.setBackground(Color.WHITE);

        JLabel lblTipo = new JLabel("Tipo:");
        JComboBox<String> cmbTipo = new JComboBox<>(new String[]{"Paciente", "Médico"});
        JLabel lblId = new JLabel("ID:");
        JTextField txtId = new JTextField();
        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();
        JLabel lblEdad = new JLabel("Edad:");
        JTextField txtEdad = new JTextField();
        JLabel lblEspecialidad = new JLabel("Especialidad (si es médico):");
        JTextField txtEspecialidad = new JTextField();

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBackground(new Color(25, 118, 210));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrar.setBackground(new Color(21, 101, 192));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrar.setBackground(new Color(25, 118, 210));
            }
        });

        formulario.add(lblTipo); formulario.add(cmbTipo);
        formulario.add(lblId); formulario.add(txtId);
        formulario.add(lblNombre); formulario.add(txtNombre);
        formulario.add(lblEdad); formulario.add(txtEdad);
        formulario.add(lblEspecialidad); formulario.add(txtEspecialidad);
        formulario.add(new JLabel()); formulario.add(btnRegistrar);

        add(formulario, BorderLayout.CENTER);

        btnRegistrar.addActionListener(e -> {
            try {
                String id = txtId.getText().trim();
                String nombre = txtNombre.getText().trim();
                int edad = Integer.parseInt(txtEdad.getText().trim());
                String tipo = (String) cmbTipo.getSelectedItem();

                if ("Paciente".equals(tipo)) {
                    viewModel.registrarPaciente(id, nombre, edad);
                } else {
                    String esp = txtEspecialidad.getText().trim();
                    viewModel.registrarMedico(id, nombre, edad, esp);
                }

                JOptionPane.showMessageDialog(this, "Registro exitoso.");
                txtId.setText(""); txtNombre.setText(""); txtEdad.setText(""); txtEspecialidad.setText("");

            } catch (CampoVacioException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Edad debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}