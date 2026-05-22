package gui;

import prologconexion.ConexionProlog;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaPreguntas extends JFrame {

    private JLabel lblPregunta;

    private JButton btnSi;
    private JButton btnNo;

    // =========================================
    // BARRA DE PROGRESO
    // =========================================

    private JProgressBar barraProgreso;

    private JLabel lblProgreso;

    private ArrayList<String[]> preguntas;

    private int indice = 0;

    public VentanaPreguntas() {

        setTitle("Test Vocacional");

        setSize(900,500);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        getContentPane().setBackground(
                new Color(18,18,40)
        );



        // =====================================================
        // LISTA DE PREGUNTAS DESDE PROLOG
        // =====================================================

        preguntas = ConexionProlog.obtenerPreguntas();

        if(preguntas.isEmpty()) {

                JOptionPane.showMessageDialog(
                        null,
                        "No se pudieron cargar las preguntas desde Prolog"
                );

                System.exit(0);
        }


        // =====================================================
        // PANEL SUPERIOR
        // =====================================================

        JPanel panelSuperior = new JPanel();

        panelSuperior.setLayout(
                new BorderLayout()
        );

        panelSuperior.setBackground(
                new Color(18,18,40)
        );



        // =====================================================
        // TITULO
        // =====================================================

        JLabel titulo = new JLabel(
                "TEST VOCACIONAL",
                SwingConstants.CENTER
        );

        titulo.setFont(
                new Font("Arial", Font.BOLD, 30)
        );

        titulo.setForeground(Color.WHITE);

        titulo.setBorder(
                BorderFactory.createEmptyBorder(
                        20,10,10,10
                )
        );



        // =====================================================
        // BARRA DE PROGRESO
        // =====================================================

        barraProgreso = new JProgressBar(
                0,
                preguntas.size()
        );

        barraProgreso.setValue(0);

        barraProgreso.setStringPainted(true);

        barraProgreso.setForeground(
                new Color(0,255,200)
        );

        barraProgreso.setBackground(
                new Color(35,35,70)
        );

        barraProgreso.setPreferredSize(
                new Dimension(700,25)
        );



        lblProgreso = new JLabel(
                "Pregunta 1 de " + preguntas.size(),
                SwingConstants.CENTER
        );

        lblProgreso.setForeground(Color.WHITE);

        lblProgreso.setFont(
                new Font("Arial", Font.BOLD, 15)
        );



        JPanel panelBarra = new JPanel();

        panelBarra.setBackground(
                new Color(18,18,40)
        );

        panelBarra.setLayout(
                new BorderLayout()
        );

        panelBarra.setBorder(
                BorderFactory.createEmptyBorder(
                        10,60,20,60
                )
        );



        panelBarra.add(
                lblProgreso,
                BorderLayout.NORTH
        );

        panelBarra.add(
                barraProgreso,
                BorderLayout.CENTER
        );



        panelSuperior.add(
                titulo,
                BorderLayout.NORTH
        );

        panelSuperior.add(
                panelBarra,
                BorderLayout.SOUTH
        );



        // =====================================================
        // PANEL CENTRAL
        // =====================================================

        JPanel panelCentro = new JPanel();

        panelCentro.setBackground(
                new Color(18,18,40)
        );

        panelCentro.setLayout(
                new GridBagLayout()
        );



        JPanel tarjetaPregunta = new JPanel();

        tarjetaPregunta.setBackground(
                new Color(35,35,70)
        );

        tarjetaPregunta.setPreferredSize(
                new Dimension(700,180)
        );

        tarjetaPregunta.setLayout(
                new BorderLayout()
        );

        tarjetaPregunta.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(0,255,200),
                                2
                        ),
                        BorderFactory.createEmptyBorder(
                                20,20,20,20
                        )
                )
        );



        lblPregunta = new JLabel(
                "<html><div style='text-align:center;'>"
                + preguntas.get(indice)[1]
                + "</div></html>",
                SwingConstants.CENTER
        );

        lblPregunta.setFont(
                new Font("Arial", Font.BOLD, 26)
        );

        lblPregunta.setForeground(Color.WHITE);



        tarjetaPregunta.add(
                lblPregunta,
                BorderLayout.CENTER
        );



        panelCentro.add(tarjetaPregunta);



        // =====================================================
        // PANEL BOTONES
        // =====================================================

        JPanel panelBotones = new JPanel();

        panelBotones.setBackground(
                new Color(18,18,40)
        );

        panelBotones.setBorder(
                BorderFactory.createEmptyBorder(
                        20,20,30,20
                )
        );



        btnSi = new JButton("SI");

        btnNo = new JButton("NO");



        estilizarBoton(
                btnSi,
                new Color(0,200,120)
        );

        estilizarBoton(
                btnNo,
                new Color(220,60,60)
        );



        // =====================================================
        // EVENTOS
        // =====================================================

        btnSi.addActionListener(e -> responder("si"));

        btnNo.addActionListener(e -> responder("no"));



        panelBotones.add(btnSi);

        panelBotones.add(Box.createHorizontalStrut(30));

        panelBotones.add(btnNo);



        // =====================================================
        // AGREGAR COMPONENTES
        // =====================================================

        add(panelSuperior, BorderLayout.NORTH);

        add(panelCentro, BorderLayout.CENTER);

        add(panelBotones, BorderLayout.SOUTH);



        setVisible(true);
    }



    // =====================================================
    // ESTILO BOTONES
    // =====================================================

    private void estilizarBoton(
            JButton boton,
            Color color
    ) {

        boton.setPreferredSize(
                new Dimension(150,50)
        );

        boton.setBackground(color);

        boton.setForeground(Color.WHITE);

        boton.setFocusPainted(false);

        boton.setFont(
                new Font("Arial", Font.BOLD, 18)
        );

        boton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );
    }



    // =====================================================
    // RESPONDER
    // =====================================================

    private void responder(String respuesta) {

        String clavePregunta =
                preguntas.get(indice)[0];



        ConexionProlog.guardarRespuesta(
                clavePregunta,
                respuesta
        );



        indice++;



        // =========================================
        // ACTUALIZAR BARRA
        // =========================================

        barraProgreso.setValue(indice);



        if(indice < preguntas.size()) {

            lblPregunta.setText(
                "<html><div style='text-align:center;'>"
                + preguntas.get(indice)[1]
                + "</div></html>"
                );



            lblProgreso.setText(
                    "Pregunta "
                            + (indice + 1)
                            + " de "
                            + preguntas.size()
            );

        }

        // =========================================
        // FINALIZA TEST
        // =========================================

        else {

            lblProgreso.setText(
                    "Test completado"
            );

            terminarTest();
        }
    }



    // =====================================================
    // TERMINAR TEST
    // =====================================================

    private void terminarTest() {

        // =========================================
        // SONIDO FINAL
        // =========================================

        Toolkit.getDefaultToolkit().beep();



        String carrera =
                ConexionProlog.obtenerCarrera();



        new VentanaResultado(carrera);



        dispose();
    }
}