package view;

import viewmodel.ClinicaViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaPrincipal extends JFrame {
    private ClinicaViewModel viewModel;
    private JPanel panelActual;

    public VentanaPrincipal(ClinicaViewModel viewModel) {
        this.viewModel = viewModel;

        setTitle("Sistema de Gestión - Clínica Pérez");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Estilo general
        Color colorPrincipal = new Color(25, 118, 210);
        Font fuenteTitulo = new Font("Arial", Font.BOLD, 18);
        Font fuenteBoton = new Font("Arial", Font.PLAIN, 14);

        // Título superior
        JLabel titulo = new JLabel("CLÍNICA PÉREZ");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(fuenteTitulo);
        titulo.setForeground(colorPrincipal);
        titulo.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        add(titulo, BorderLayout.NORTH);

        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        menu.setBackground(Color.WHITE);
        menu.setBorder(BorderFactory.createEmptyBorder(40, 200, 40, 200));

        JButton btnRegistro = crearBoton("Registrar Persona", colorPrincipal, fuenteBoton);
        JButton btnConsulta = crearBoton("Registrar Consulta", colorPrincipal, fuenteBoton);
        JButton btnHistorial = crearBoton("Consultar Historial", colorPrincipal, fuenteBoton);

        btnRegistro.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnConsulta.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnHistorial.setAlignmentX(Component.CENTER_ALIGNMENT);

        menu.add(btnRegistro);
        menu.add(Box.createVerticalStrut(15));
        menu.add(btnConsulta);
        menu.add(Box.createVerticalStrut(15));
        menu.add(btnHistorial);

        add(menu, BorderLayout.CENTER);

        panelActual = new JPanel();
        panelActual.setBackground(Color.WHITE);
        add(panelActual, BorderLayout.SOUTH);

        btnRegistro.addActionListener(e -> mostrarPanel(new PanelRegistro(viewModel)));
        btnConsulta.addActionListener(e -> mostrarPanel(new PanelConsulta(viewModel)));
        btnHistorial.addActionListener(e -> mostrarPanel(new PanelHistorial(viewModel)));

        getContentPane().setBackground(Color.WHITE);
    }

    private JButton crearBoton(String texto, Color colorFondo, Font fuente) {
        JButton btn = new JButton(texto);
        btn.setBackground(colorFondo);
        btn.setForeground(Color.WHITE);
        btn.setFont(fuente);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(colorFondo.darker(), 1));

        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(colorFondo.darker());
            }

            public void mouseExited(MouseEvent e) {
                btn.setBackground(colorFondo);
            }
        });

        return btn;
    }

    private void mostrarPanel(JPanel nuevoPanel) {
        remove(panelActual);
        panelActual = nuevoPanel;
        add(panelActual, BorderLayout.SOUTH);
        revalidate();
        repaint();
    }
    public static void setNimbusLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
    }
}