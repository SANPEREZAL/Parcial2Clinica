/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import viewmodel.ClinicaViewModel;
import model.Consulta;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanelHistorial extends JPanel {
    private ClinicaViewModel viewModel;

    public PanelHistorial(ClinicaViewModel viewModel) {
        this.viewModel = viewModel;

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JLabel titulo = new JLabel("Historial Médico");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setForeground(new Color(25, 118, 210));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(titulo, BorderLayout.NORTH);

        JPanel panelBuscar = new JPanel(new FlowLayout());
        panelBuscar.setBackground(Color.WHITE);
        panelBuscar.setBorder(BorderFactory.createTitledBorder("Buscar por ID"));

        JLabel lblID = new JLabel("ID del Paciente o Médico:");
        JTextField txtID = new JTextField(20);
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBackground(new Color(25, 118, 210));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscar.setBackground(new Color(21, 101, 192));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscar.setBackground(new Color(25, 118, 210));
            }
        });

        panelBuscar.add(lblID);
        panelBuscar.add(txtID);
        panelBuscar.add(btnBuscar);

        add(panelBuscar, BorderLayout.NORTH);

        JTextArea txtResultados = new JTextArea(15, 50);
        txtResultados.setEditable(false);
        txtResultados.setFont(new Font("Monospaced", Font.PLAIN, 13));
        txtResultados.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JScrollPane scroll = new JScrollPane(txtResultados);
        scroll.setBorder(BorderFactory.createTitledBorder("Resultados"));

        add(scroll, BorderLayout.CENTER);

        btnBuscar.addActionListener(e -> {
            String id = txtID.getText().trim();
            List<Consulta> consultasPaciente = viewModel.historialPaciente(id);
            List<Consulta> consultasMedico = viewModel.consultasMedico(id);

            txtResultados.setText(""); // Limpiar resultados

            if (!consultasPaciente.isEmpty()) {
                txtResultados.append("Consultas del Paciente (ID: " + id + "):\n\n");
                for (Consulta c : consultasPaciente) {
                    txtResultados.append(c.toString() + "\n----------------------\n");
                }
            } else if (!consultasMedico.isEmpty()) {
                txtResultados.append("Consultas del Médico (ID: " + id + "):\n\n");
                for (Consulta c : consultasMedico) {
                    txtResultados.append(c.toString() + "\n----------------------\n");
                }
            } else {
                txtResultados.append("No se encontraron consultas con ese ID.");
            }
        });
    }
}