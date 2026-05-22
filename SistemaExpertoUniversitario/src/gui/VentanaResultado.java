package gui;

import javax.swing.*;
import java.awt.*;

public class VentanaResultado extends JFrame {

    public VentanaResultado(String carrera) {

        setTitle("Resultado Vocacional");

        setSize(800,500);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        getContentPane().setBackground(
                new Color(18,18,40)
        );



        // ======================================
        // TITULO
        // ======================================

        JLabel titulo = new JLabel(
                "RESULTADO DEL TEST VOCACIONAL",
                SwingConstants.CENTER
        );

        titulo.setFont(
                new Font("Arial", Font.BOLD, 30)
        );

        titulo.setForeground(Color.WHITE);

        titulo.setBorder(
                BorderFactory.createEmptyBorder(
                        25,10,25,10
                )
        );



        add(titulo, BorderLayout.NORTH);



        // ======================================
        // PANEL CENTRAL
        // ======================================

        JPanel panelCentro = new JPanel();

        panelCentro.setBackground(
                new Color(18,18,40)
        );

        panelCentro.setLayout(
                new GridBagLayout()
        );



        JPanel tarjeta = new JPanel();

        tarjeta.setPreferredSize(
                new Dimension(650,250)
        );

        tarjeta.setBackground(
                new Color(35,35,70)
        );

        tarjeta.setLayout(
                new BorderLayout()
        );

        tarjeta.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(0,255,200),
                                3
                        ),
                        BorderFactory.createEmptyBorder(
                                30,30,30,30
                        )
                )
        );



        JLabel resultado = new JLabel(
                "La carrera recomendada para ti es:",
                SwingConstants.CENTER
        );

        resultado.setForeground(Color.WHITE);

        resultado.setFont(
                new Font("Arial", Font.PLAIN, 24)
        );



        JLabel carreraLabel = new JLabel(
                carrera.toUpperCase(),
                SwingConstants.CENTER
        );

        carreraLabel.setForeground(
                new Color(0,255,200)
        );

        carreraLabel.setFont(
                new Font("Arial", Font.BOLD, 36)
        );



        // ======================================
        // IMAGEN
        // ======================================

        JLabel imagen = new JLabel();

        imagen.setHorizontalAlignment(
                SwingConstants.CENTER
        );



        String ruta = "resources/default.png";

        switch (carrera.toLowerCase()) {

            case "ingenieria_sistemas":
                ruta = "resources/sistemas.png";
                break;

            case "derecho":
                ruta = "resources/derecho.png";
                break;

            case "diseno":
                ruta = "resources/diseno.png";
                break;

            case "turismo":
                ruta = "resources/turismo.png";
                break;

            case "administracion":
                ruta = "resources/administracion.png";
                break;

            case "contabilidad":
                ruta = "resources/contabilidad.png";
                break;

            case "pedagogia":
                ruta = "resources/pedagogia.png";
                break;
            case "medicina":
                ruta = "resources/medicina.png";
                break;

        }



        ImageIcon icono = new ImageIcon(ruta);

        Image img = icono.getImage().getScaledInstance(
                140,
                140,
                Image.SCALE_SMOOTH
        );

        imagen.setIcon(
                new ImageIcon(img)
        );



        JPanel contenido = new JPanel();

        contenido.setBackground(
                new Color(35,35,70)
        );

        contenido.setLayout(
                new GridLayout(3,1)
        );



        contenido.add(resultado);

        contenido.add(carreraLabel);

        contenido.add(imagen);



        tarjeta.add(contenido, BorderLayout.CENTER);



        panelCentro.add(tarjeta);



        add(panelCentro, BorderLayout.CENTER);



        // ======================================
        // PANEL BOTONES
        // ======================================

        JPanel panelBotones = new JPanel();

        panelBotones.setBackground(
                new Color(18,18,40)
        );

        panelBotones.setBorder(
                BorderFactory.createEmptyBorder(
                        20,20,30,20
                )
        );



        JButton btnICFES =
                new JButton("Continuar con Analisis ICFES");

        JButton btnVolver =
                new JButton("Volver al Inicio");



        estilizarBoton(
                btnICFES,
                new Color(0,180,255)
        );

        estilizarBoton(
                btnVolver,
                new Color(255,80,80)
        );



        panelBotones.add(btnICFES);

        panelBotones.add(Box.createHorizontalStrut(20));

        panelBotones.add(btnVolver);



        add(panelBotones, BorderLayout.SOUTH);



        // ======================================
        // EVENTOS
        // ======================================

        btnICFES.addActionListener(e -> {

            new VentanaICFES(carrera);

            dispose();

        });



        btnVolver.addActionListener(e -> {

            new VentanaInicio();

            dispose();

        });



        setVisible(true);
    }



    // ======================================
    // ESTILO BOTONES
    // ======================================

    private void estilizarBoton(
            JButton boton,
            Color color
    ) {

        boton.setPreferredSize(
                new Dimension(250,50)
        );

        boton.setBackground(color);

        boton.setForeground(Color.WHITE);

        boton.setFocusPainted(false);

        boton.setFont(
                new Font("Arial", Font.BOLD, 16)
        );

        boton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );
    }
}