package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VentanaInicio extends JFrame {

    public VentanaInicio() {

        // =========================
        // CONFIGURACION VENTANA
        // =========================

        setTitle(
                "Sistema Experto Universitario"
        );

        setSize(900,600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                EXIT_ON_CLOSE
        );

        setLayout(new BorderLayout());



        // =========================
        // COLORES MODERNOS
        // =========================

        Color fondoPrincipal =
                new Color(15,23,42);

        Color fondoPanel =
                new Color(30,41,59);

        Color colorBoton =
                new Color(59,130,246);

        Color colorBotonHover =
                new Color(37,99,235);

        Color colorTexto =
                Color.WHITE;



        // =========================
        // PANEL PRINCIPAL
        // =========================

        JPanel panelPrincipal =
                new JPanel();

        panelPrincipal.setLayout(
                new BorderLayout()
        );

        panelPrincipal.setBackground(
                fondoPrincipal
        );

        panelPrincipal.setBorder(
                new EmptyBorder(30,30,30,30)
        );



        // =========================
        // PANEL SUPERIOR
        // =========================

        JPanel panelSuperior =
                new JPanel();

        panelSuperior.setLayout(
                new BoxLayout(panelSuperior, BoxLayout.Y_AXIS)
        );

        panelSuperior.setOpaque(false);



        JLabel titulo = new JLabel(
                "SISTEMA EXPERTO UNIVERSITARIO",
                SwingConstants.CENTER
        );

        titulo.setFont(
                new Font("Segoe UI", Font.BOLD, 32)
        );

        titulo.setForeground(
                colorTexto
        );

        titulo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );



        JLabel subtitulo = new JLabel(
                "Orientacion vocacional inteligente",
                SwingConstants.CENTER
        );

        subtitulo.setFont(
                new Font("Segoe UI", Font.PLAIN, 18)
        );

        subtitulo.setForeground(
                new Color(203,213,225)
        );

        subtitulo.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );



        JLabel descripcion = new JLabel(
                "<html><center>" +
                "Descubre la carrera universitaria ideal para ti<br>" +
                "mediante preguntas vocacionales y analisis ICFES." +
                "</center></html>",
                SwingConstants.CENTER
        );

        descripcion.setFont(
                new Font("Segoe UI", Font.PLAIN, 16)
        );

        descripcion.setForeground(
                new Color(148,163,184)
        );

        descripcion.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );



        panelSuperior.add(titulo);

        panelSuperior.add(Box.createVerticalStrut(10));

        panelSuperior.add(subtitulo);

        panelSuperior.add(Box.createVerticalStrut(20));

        panelSuperior.add(descripcion);



        // =========================
        // PANEL CENTRAL
        // =========================

        JPanel panelCentro =
                new JPanel();

        panelCentro.setLayout(
                new GridBagLayout()
        );

        panelCentro.setOpaque(false);



        JPanel tarjeta =
                new JPanel();

        tarjeta.setLayout(
                new GridLayout(4,1,20,20)
        );

        tarjeta.setBackground(
                fondoPanel
        );

        tarjeta.setBorder(
                new EmptyBorder(40,50,40,50)
        );



        // =========================
        // BOTONES
        // =========================

        JButton btnIniciar =
                crearBoton(
                        "Iniciar Test",
                        colorBoton,
                        colorTexto
                );

        JButton btnCarreras =
                crearBoton(
                        "Ver Carreras",
                        colorBoton,
                        colorTexto
                );

        JButton btnAyuda =
                crearBoton(
                        "Ayuda",
                        colorBoton,
                        colorTexto
                );

        JButton btnSalir =
                crearBoton(
                        "Salir",
                        new Color(239,68,68),
                        colorTexto
                );



        // =========================
        // EVENTOS
        // =========================

        btnIniciar.addActionListener(e -> {

            new VentanaPreguntas();

            dispose();

        });



        btnCarreras.addActionListener(e -> {

            new VentanaCarreras();

            dispose();

        });



        btnAyuda.addActionListener(e -> {

            new VentanaAyuda();

            dispose();

        });



        btnSalir.addActionListener(e -> {

            System.exit(0);

        });



        // =========================
        // AGREGAR BOTONES
        // =========================

        tarjeta.add(btnIniciar);

        tarjeta.add(btnCarreras);

        tarjeta.add(btnAyuda);

        tarjeta.add(btnSalir);



        panelCentro.add(tarjeta);



        // =========================
        // FOOTER
        // =========================

        JLabel footer = new JLabel(
                "Proyecto Sistema Experto Vocacional - Java + Prolog",
                SwingConstants.CENTER
        );

        footer.setForeground(
                new Color(148,163,184)
        );

        footer.setFont(
                new Font("Segoe UI", Font.PLAIN, 14)
        );



        // =========================
        // AGREGAR TODO
        // =========================

        panelPrincipal.add(
                panelSuperior,
                BorderLayout.NORTH
        );

        panelPrincipal.add(
                panelCentro,
                BorderLayout.CENTER
        );

        panelPrincipal.add(
                footer,
                BorderLayout.SOUTH
        );



        add(panelPrincipal);



        setVisible(true);
    }



    // ==================================================
    // METODO PARA CREAR BOTONES MODERNOS
    // ==================================================

    private JButton crearBoton(

            String texto,
            Color fondo,
            Color textoColor

    ) {

        JButton boton =
                new JButton(texto);

        boton.setFocusPainted(false);

        boton.setFont(
                new Font("Segoe UI", Font.BOLD, 18)
        );

        boton.setForeground(textoColor);

        boton.setBackground(fondo);

        boton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );

        boton.setPreferredSize(
                new Dimension(250,55)
        );

        boton.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        20,
                        10,
                        20
                )
        );



        return boton;
    }
}