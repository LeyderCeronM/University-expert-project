package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import prologconexion.ConexionProlog;

import java.awt.*;

public class VentanaCarreras extends JFrame {

    public VentanaCarreras() {

        // =========================
        // CONFIGURACION VENTANA
        // =========================

        setTitle("Carreras Disponibles");

        setSize(1200,750);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());



        // =========================
        // COLORES
        // =========================

        Color fondo =
                new Color(15,23,42);

        Color tarjeta =
                new Color(30,41,59);

        Color texto =
                Color.WHITE;

        Color subtitulo =
                new Color(148,163,184);

        Color botonColor =
                new Color(59,130,246);



        // =========================
        // PANEL PRINCIPAL
        // =========================

        JPanel panelPrincipal =
                new JPanel(new BorderLayout());

        panelPrincipal.setBackground(fondo);

        panelPrincipal.setBorder(
                new EmptyBorder(20,20,20,20)
        );



        // =========================
        // TITULO
        // =========================

        JLabel titulo =
                new JLabel(
                        "CARRERAS UNIVERSITARIAS",
                        SwingConstants.CENTER
                );

        titulo.setFont(
                new Font("Segoe UI", Font.BOLD, 32)
        );

        titulo.setForeground(texto);



        JLabel descripcion =
                new JLabel(
                        "Explora las carreras disponibles en el sistema",
                        SwingConstants.CENTER
                );

        descripcion.setFont(
                new Font("Segoe UI", Font.PLAIN, 18)
        );

        descripcion.setForeground(subtitulo);



        JPanel panelTitulo = new JPanel();

        panelTitulo.setLayout(
                new BoxLayout(
                        panelTitulo,
                        BoxLayout.Y_AXIS
                )
        );

        panelTitulo.setOpaque(false);

        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        descripcion.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelTitulo.add(titulo);

        panelTitulo.add(Box.createVerticalStrut(10));

        panelTitulo.add(descripcion);



        // =========================
        // PANEL CARRERAS
        // =========================

        JPanel panelCarreras = new JPanel();

        panelCarreras.setLayout(
                new GridLayout(0,2,20,20)
        );

        panelCarreras.setBackground(fondo);

        panelCarreras.setBorder(
                new EmptyBorder(20,20,20,20)
        );



        // =========================
        // AGREGAR CARRERAS DESDE PROLOG
        // =========================

        for(String[] carrera :
                ConexionProlog.obtenerCarreras()) {

            panelCarreras.add(

                    crearPanelCarrera(

                            carrera[0],
                            carrera[1],
                            carrera[2],

                            tarjeta,
                            texto,
                            subtitulo
                    )
            );
        }



        // =========================
        // SCROLL
        // =========================

        JScrollPane scroll =
                new JScrollPane(panelCarreras);

        scroll.setBorder(null);

        scroll.getViewport().setBackground(fondo);



        // =========================
        // BOTON VOLVER
        // =========================

        JButton volver =
                new JButton("Volver");

        volver.setFont(
                new Font("Segoe UI", Font.BOLD, 18)
        );

        volver.setBackground(botonColor);

        volver.setForeground(Color.WHITE);

        volver.setFocusPainted(false);

        volver.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        volver.setPreferredSize(
                new Dimension(200,50)
        );



        volver.addActionListener(e -> {

            new VentanaInicio();

            dispose();

        });



        JPanel panelBoton = new JPanel();

        panelBoton.setBackground(fondo);

        panelBoton.add(volver);



        // =========================
        // AGREGAR TODO
        // =========================

        panelPrincipal.add(
                panelTitulo,
                BorderLayout.NORTH
        );

        panelPrincipal.add(
                scroll,
                BorderLayout.CENTER
        );

        panelPrincipal.add(
                panelBoton,
                BorderLayout.SOUTH
        );



        add(panelPrincipal);

        setVisible(true);
    }



    // ====================================================
    // PANEL MODERNO DE CARRERA
    // ====================================================

    private JPanel crearPanelCarrera(

            String nombre,
            String descripcion,
            String rutaImagen,
            Color fondo,
            Color texto,
            Color descripcionColor

    ){

        JPanel panel = new JPanel();

        panel.setLayout(
                new BorderLayout(10,10)
        );

        panel.setBackground(fondo);

        panel.setBorder(
                new EmptyBorder(15,15,15,15)
        );



        // =========================
        // IMAGEN
        // =========================

        ImageIcon icono =
                new ImageIcon(rutaImagen);

        Image imagen =
                icono.getImage().getScaledInstance(
                        350,
                        180,
                        Image.SCALE_SMOOTH
                );

        JLabel lblImagen =
                new JLabel(
                        new ImageIcon(imagen)
                );

        lblImagen.setHorizontalAlignment(
                SwingConstants.CENTER
        );



        // =========================
        // NOMBRE
        // =========================

        JLabel lblNombre =
                new JLabel(
                        nombre,
                        SwingConstants.CENTER
                );

        lblNombre.setFont(
                new Font("Segoe UI", Font.BOLD, 22)
        );

        lblNombre.setForeground(texto);



        // =========================
        // DESCRIPCION
        // =========================

        JTextArea txtDescripcion =
                new JTextArea(descripcion);

        txtDescripcion.setLineWrap(true);

        txtDescripcion.setWrapStyleWord(true);

        txtDescripcion.setEditable(false);

        txtDescripcion.setOpaque(false);

        txtDescripcion.setForeground(descripcionColor);

        txtDescripcion.setFont(
                new Font("Segoe UI", Font.PLAIN, 16)
        );



        // =========================
        // AGREGAR COMPONENTES
        // =========================

        panel.add(
                lblNombre,
                BorderLayout.NORTH
        );

        panel.add(
                lblImagen,
                BorderLayout.CENTER
        );

        panel.add(
                txtDescripcion,
                BorderLayout.SOUTH
        );

        return panel;
    }
}