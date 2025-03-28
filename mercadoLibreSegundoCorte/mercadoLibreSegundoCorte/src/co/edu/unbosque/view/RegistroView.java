package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class RegistroView extends JFrame {

    private JTextField campoUsuario;
    private JPasswordField campoContrasena, campoConfirmarContrasena;
    private JButton btnRegistrar, btnCancelar;
    private JLabel mensajeError;

    public RegistroView() {
        setTitle("📝 Registro de Usuario");
        setSize(450, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        
        getContentPane().setBackground(new Color(240, 240, 240));

       
        JPanel panelTarjeta = new JPanel();
        panelTarjeta.setLayout(new GridBagLayout());
        panelTarjeta.setBackground(Color.WHITE);
        panelTarjeta.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
        panelTarjeta.setPreferredSize(new Dimension(400, 400));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;

        
        JLabel lblTitulo = new JLabel("Crear Cuenta", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridy = 0;
        panelTarjeta.add(lblTitulo, gbc);

        
        campoUsuario = new JTextField(20);
        campoUsuario.setBorder(BorderFactory.createTitledBorder(" Usuario"));
        gbc.gridy = 1;
        panelTarjeta.add(campoUsuario, gbc);

       
        campoContrasena = new JPasswordField(20);
        campoContrasena.setBorder(BorderFactory.createTitledBorder(" Contraseña"));
        gbc.gridy = 2;
        panelTarjeta.add(campoContrasena, gbc);

        
        campoConfirmarContrasena = new JPasswordField(20);
        campoConfirmarContrasena.setBorder(BorderFactory.createTitledBorder(" Confirmar Contraseña"));
        gbc.gridy = 3;
        panelTarjeta.add(campoConfirmarContrasena, gbc);

        mensajeError = new JLabel(" ", SwingConstants.CENTER);
        mensajeError.setForeground(Color.RED);
        gbc.gridy = 4;
        panelTarjeta.add(mensajeError, gbc);

        btnRegistrar = new JButton(" Registrar");
        btnRegistrar.setFont(new Font("Arial", Font.BOLD, 16));
        btnRegistrar.setBackground(new Color(76, 175, 80));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFocusPainted(false);
        gbc.gridy = 5;
        panelTarjeta.add(btnRegistrar, gbc);

        btnCancelar = new JButton(" Cancelar");
        btnCancelar.setFont(new Font("Arial", Font.BOLD, 16));
        btnCancelar.setBackground(new Color(220, 53, 69));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);
        gbc.gridy = 6;
        panelTarjeta.add(btnCancelar, gbc);

        add(panelTarjeta, BorderLayout.CENTER);
    }

    
    public JTextField getCampoUsuario() { return campoUsuario; }
    public JPasswordField getCampoContrasena() { return campoContrasena; }
    public JPasswordField getCampoConfirmarContrasena() { return campoConfirmarContrasena; }
    public JButton getBtnRegistrar() { return btnRegistrar; }
    public JButton getBtnCancelar() { return btnCancelar; }
    public JLabel getMensajeError() { return mensajeError; }
}

