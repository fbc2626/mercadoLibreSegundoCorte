package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class LoginVentana extends JFrame {

    private JTextField campoUsuario;
    private JPasswordField campoContrasena;
    private JButton btnIngresar, btnRegistrarse;
    private JLabel mensajeError;

    public LoginVentana() {
        setTitle("Acceso a Mercado Libre");
        setSize(800, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setBackground(new Color(255, 223, 0)); 
        panelIzquierdo.setPreferredSize(new Dimension(350, 450));
        panelIzquierdo.setLayout(new BorderLayout());

        JLabel lblBienvenida = new JLabel("<html><center><h2>¡Bienvenido!</h2><br>Accede a tu cuenta y compra con confianza.</center></html>", SwingConstants.CENTER);
        lblBienvenida.setFont(new Font("Arial", Font.BOLD, 18));
        lblBienvenida.setForeground(Color.BLACK);
        panelIzquierdo.add(lblBienvenida, BorderLayout.CENTER);

        JPanel panelDerecho = new JPanel();
        panelDerecho.setLayout(new GridBagLayout());
        panelDerecho.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;

        campoUsuario = new JTextField(20);
        campoUsuario.setBorder(BorderFactory.createTitledBorder("Usuario"));
        gbc.gridy = 0;
        panelDerecho.add(campoUsuario, gbc);

        campoContrasena = new JPasswordField(20);
        campoContrasena.setBorder(BorderFactory.createTitledBorder("Contraseña"));
        gbc.gridy = 1;
        panelDerecho.add(campoContrasena, gbc);

        mensajeError = new JLabel(" ", SwingConstants.CENTER);
        mensajeError.setForeground(Color.RED);
        gbc.gridy = 2;
        panelDerecho.add(mensajeError, gbc);

        btnIngresar = new JButton("🚀 Ingresar");
        btnIngresar.setFont(new Font("Arial", Font.BOLD, 16));
        btnIngresar.setBackground(Color.BLACK);
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setFocusPainted(false);
        gbc.gridy = 3;
        panelDerecho.add(btnIngresar, gbc);

        btnRegistrarse = new JButton("📝 Registrarse");
        btnRegistrarse.setFont(new Font("Arial", Font.BOLD, 16));
        btnRegistrarse.setBackground(new Color(80, 80, 80));
        btnRegistrarse.setForeground(Color.WHITE);
        btnRegistrarse.setFocusPainted(false);
        gbc.gridy = 4;
        panelDerecho.add(btnRegistrarse, gbc);

        add(panelIzquierdo, BorderLayout.WEST);
        add(panelDerecho, BorderLayout.CENTER);
    }

    public JTextField getCampoUsuario() { return campoUsuario; }
    public JPasswordField getCampoContrasena() { return campoContrasena; }
    public JButton getBtnIngresar() { return btnIngresar; }
    public JButton getBtnRegistrarse() { return btnRegistrarse; }
    public JLabel getMensajeError() { return mensajeError; }
}


