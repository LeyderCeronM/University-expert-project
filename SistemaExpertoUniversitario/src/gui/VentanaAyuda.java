package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VentanaAyuda extends JFrame {

    public VentanaAyuda() {

        setTitle("Ayuda");

        setSize(850,600);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());



        // =========================
        // COLORES
        // =========================

        Color fondo = new Color(15,23,42);

        Color tarjeta = new Color(30,41,59);

        Color texto = Color.WHITE;

        Color descripcion = new Color(203,213,225);

        JPanel panelPrincipal = new JPanel(new BorderLayout());

        panelPrincipal.setBackground(fondo);

        panelPrincipal.setBorder( new EmptyBorder(25,25,25,25));

        // =========================
        // TITULO
        // =========================

        JLabel titulo =
                new JLabel(
                        "GUIA DEL SISTEMA",
                        SwingConstants.CENTER
                );

        titulo.setFont(new Font("Segoe UI", Font.BOLD, 32)
        );

        titulo.setForeground(texto);



        // =========================
        // AREA TEXTO
        // =========================

        JTextArea area =
                new JTextArea();

        area.setEditable(false);

        area.setLineWrap(true);

        area.setWrapStyleWord(true);

        area.setBackground(tarjeta);

        area.setForeground(descripcion);

        area.setCaretColor(descripcion);

        area.setFont(
                new Font("Segoe UI", Font.PLAIN, 18)
        );

        area.setBorder(
                new EmptyBorder(30,30,30,30)
        );



        area.setText(
                "En la pantalla de inicio encontrarás diferentes opciones:\n" +
                "\"Iniciar Test\", que da comienzo a la prueba para descubrir tu\n" +
                "carrera ideal; \"Ver Carreras\", que te permite explorar todas las\n" +
                "opciones disponibles en modalidad de solo lectura; y \"Ayuda\",\n" +
                "el cual te dirigirá a una guía práctica para navegar en el sistema.\n\n" +

                "1. Presiona el boton 'Iniciar Test'.\n\n" +

                "2. Responde todas las preguntas vocacionales.\n\n" +

                "3. El sistema analizara tus respuestas usando Prolog.\n\n" +

                "4. Se mostrara la carrera recomendada para ti.\n\n" +

                "5. Tambien podras analizar tu puntaje ICFES.\n\n" +

                "6. El sistema mostrara carreras compatibles,\n" +
                "   ponderados y probabilidades de ingreso.\n\n" +

                "7. Puedes explorar todas las carreras disponibles\n" +
                "   desde el menu principal.\n\n" +

                "8. Se puede mirar las carreras que posiblemente le pueden \n" +
                "gustar a las personas .\n\n" 
        );

        JScrollPane scroll = new JScrollPane(area);

        scroll.setBorder(null);



        // =========================
        // BOTON VOLVER
        // =========================

        JButton volver = new JButton("Volver");

        volver.setFont(new Font("Segoe UI", Font.BOLD, 18));

        volver.setBackground(new Color(59,130,246));

        volver.setForeground(Color.WHITE);

        volver.setFocusPainted(false);

        volver.setPreferredSize(new Dimension(200,50));



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

        panelPrincipal.add(titulo, BorderLayout.NORTH);

        panelPrincipal.add(scroll, BorderLayout.CENTER);

        panelPrincipal.add(panelBoton, BorderLayout.SOUTH);

        add(panelPrincipal);

        setVisible(true);
    }
}