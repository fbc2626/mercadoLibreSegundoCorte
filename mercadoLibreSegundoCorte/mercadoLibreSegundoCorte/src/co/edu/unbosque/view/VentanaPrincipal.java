package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private JTabbedPane panelPestanas;
    private JPanel panelHogar, panelOcio, panelOficina, panelCarrito;
    private JButton btnAgregarHogar, btnAgregarOcio, btnAgregarOficina, btnVerCarrito;

    public VentanaPrincipal() {
        setTitle("Mercado Libre - Sistema de Compras");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

     
        panelPestanas = new JTabbedPane();

        panelHogar = new JPanel();
        panelHogar.add(new JLabel("Productos del Hogar"));
        btnAgregarHogar = new JButton("Añadir al Carrito");
        panelHogar.add(btnAgregarHogar);
        panelPestanas.addTab("Hogar", panelHogar);

        panelOcio = new JPanel();
        panelOcio.add(new JLabel("Productos de Ocio"));
        btnAgregarOcio = new JButton("Añadir al Carrito");
        panelOcio.add(btnAgregarOcio);
        panelPestanas.addTab("Ocio", panelOcio);

        panelOficina = new JPanel();
        panelOficina.add(new JLabel("Productos de Oficina"));
        btnAgregarOficina = new JButton("Añadir al Carrito");
        panelOficina.add(btnAgregarOficina);
        panelPestanas.addTab("Oficina", panelOficina);

        panelCarrito = new JPanel();
        panelCarrito.add(new JLabel("Carrito de Compras"));
        btnVerCarrito = new JButton("Ver Carrito");
        panelCarrito.add(btnVerCarrito);
        panelPestanas.addTab("Carrito", panelCarrito);

        add(panelPestanas, BorderLayout.CENTER);
    }

    
    public JButton getBtnAgregarHogar() { return btnAgregarHogar; }
    public JButton getBtnAgregarOcio() { return btnAgregarOcio; }
    public JButton getBtnAgregarOficina() { return btnAgregarOficina; }
    public JButton getBtnVerCarrito() { return btnVerCarrito; }
}
