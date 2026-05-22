package gui;

import javax.swing.*;
import java.awt.*;

public class VentanaICFES extends JFrame {

    private String carrera;

    private JTextField txtPuntaje;

    private JPanel panelResultados;

    public VentanaICFES(String carrera) {

        this.carrera = carrera;

        setTitle("Analisis ICFES");

        setSize(1100,750);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        getContentPane().setBackground(
                new Color(18,18,40)
        );



        // =========================================
        // TITULO
        // =========================================

        JLabel titulo = new JLabel(
                "ANALISIS DE COMPATIBILIDAD ICFES",
                SwingConstants.CENTER
        );

        titulo.setFont(
                new Font("Arial", Font.BOLD, 30)
        );

        titulo.setForeground(Color.WHITE);

        titulo.setBorder(
                BorderFactory.createEmptyBorder(
                        20,10,20,10
                )
        );

        add(titulo, BorderLayout.NORTH);



        // =========================================
        // PANEL RESULTADOS
        // =========================================

        panelResultados = new JPanel();

        panelResultados.setBackground(
                new Color(18,18,40)
        );

        panelResultados.setLayout(
                new BoxLayout(
                        panelResultados,
                        BoxLayout.Y_AXIS
                )
        );



        JScrollPane scroll = new JScrollPane(
                panelResultados
        );

        scroll.getVerticalScrollBar().setUnitIncrement(16);

        scroll.setBorder(null);

        add(scroll, BorderLayout.CENTER);



        // =========================================
        // PANEL INFERIOR
        // =========================================

        JPanel panelInferior = new JPanel();

        panelInferior.setBackground(
                new Color(25,25,55)
        );

        panelInferior.setBorder(
                BorderFactory.createEmptyBorder(
                        15,15,15,15
                )
        );



        JLabel lblPuntaje = new JLabel(
                "Ingrese su puntaje ICFES:"
        );

        lblPuntaje.setForeground(Color.WHITE);

        lblPuntaje.setFont(
                new Font("Arial", Font.BOLD, 16)
        );



        txtPuntaje = new JTextField(10);

        txtPuntaje.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );



        JButton btnAnalizar =
                new JButton("Analizar");

        JButton btnVolver =
                new JButton("Volver");



        estilizarBoton(
                btnAnalizar,
                new Color(0,180,255)
        );

        estilizarBoton(
                btnVolver,
                new Color(255,80,80)
        );



        panelInferior.add(lblPuntaje);

        panelInferior.add(txtPuntaje);

        panelInferior.add(btnAnalizar);

        panelInferior.add(btnVolver);



        add(panelInferior, BorderLayout.SOUTH);



        // =========================================
        // EVENTOS
        // =========================================

        btnAnalizar.addActionListener(e -> {

            analizarICFES();

        });



        btnVolver.addActionListener(e -> {

            new VentanaInicio();

            dispose();

        });



        setVisible(true);
    }



    // =========================================
    // ANALIZAR ICFES
    // =========================================

    private void analizarICFES() {

        try {

            int puntaje =
                    Integer.parseInt(
                            txtPuntaje.getText()
                    );



            panelResultados.removeAll();



            // =========================================
            // INGENIERIA
            // =========================================

            if(puntaje >= 320) {

                agregarCarrera(
                        "Ingenieria de Sistemas",
                        "resources/sistemas.png",

                        "PROBABILIDAD DE INGRESO: ALTA\n\n" +

                        "Descripcion:\n" +
                        "Carrera enfocada en programacion,\n" +
                        "software, inteligencia artificial,\n" +
                        "redes y tecnologia.\n\n" +

                        "PONDERADOS ICFES:\n" +
                        "• Matematicas: 40%\n" +
                        "• Lectura Critica: 20%\n" +
                        "• Ingles: 20%\n" +
                        "• Sociales: 20%\n\n" +

                        "Carreras Relacionadas:\n" +
                        "• Ingenieria de Software\n" +
                        "• Ciencia de Datos\n" +
                        "• Ciberseguridad"
                );
            }



            // =========================================
            // DERECHO
            // =========================================

            if(puntaje >= 300) {

                agregarCarrera(
                        "Derecho",
                        "resources/derecho.png",

                        "PROBABILIDAD DE INGRESO: MEDIA - ALTA\n\n" +

                        "Descripcion:\n" +
                        "Carrera enfocada en leyes,\n" +
                        "argumentacion juridica y debates.\n\n" +

                        "PONDERADOS ICFES:\n" +
                        "• Lectura Critica: 40%\n" +
                        "• Sociales: 30%\n" +
                        "• Ingles: 20%\n" +
                        "• Matematicas: 10%\n\n" +

                        "Carreras Relacionadas:\n" +
                        "• Derecho Penal\n" +
                        "• Derecho Internacional\n" +
                        "• Ciencias Politicas"
                );
            }



            // =========================================
            // ADMINISTRACION
            // =========================================

            if(puntaje >= 270) {

                agregarCarrera(
                        "Administracion",
                        "resources/administracion.png",

                        "PROBABILIDAD DE INGRESO: MEDIA\n\n" +

                        "Descripcion:\n" +
                        "Carrera enfocada en liderazgo,\n" +
                        "gestion y negocios empresariales.\n\n" +

                        "PONDERADOS ICFES:\n" +
                        "• Matematicas: 20%\n" +
                        "• Lectura Critica: 30%\n" +
                        "• Sociales: 30%\n" +
                        "• Ingles: 20%\n\n" +

                        "Carreras Relacionadas:\n" +
                        "• Mercadeo\n" +
                        "• Finanzas\n" +
                        "• Negocios Internacionales"
                );
            }



            // =========================================
            // CONTABILIDAD
            // =========================================

            if(puntaje >= 260) {

                agregarCarrera(
                        "Contabilidad",
                        "resources/contabilidad.png",

                        "PROBABILIDAD DE INGRESO: MEDIA\n\n" +

                        "Descripcion:\n" +
                        "Carrera enfocada en finanzas,\n" +
                        "bancos y auditorias.\n\n" +

                        "PONDERADOS ICFES:\n" +
                        "• Matematicas: 40%\n" +
                        "• Lectura Critica: 20%\n" +
                        "• Sociales: 20%\n" +
                        "• Ingles: 20%\n\n" +

                        "Carreras Relacionadas:\n" +
                        "• Economia\n" +
                        "• Finanzas\n" +
                        "• Auditoria"
                );
            }
        if (puntaje >= 350) {

                agregarCarrera(
                        "Medicina",
                        "resources/medicina.png",

                        "Probabilidad: MUY ALTA\n\n" +

                        "Descripción:\n" +
                        "Carrera enfocada en la salud, diagnóstico, tratamiento y prevención de enfermedades.\n\n" +

                        "Ponderados ICFES:\n" +
                        "- Biología: 40%\n" +
                        "- Química: 30%\n" +
                        "- Lectura Crítica: 20%\n" +
                        "- Inglés: 10%\n\n" +

                        "Carreras relacionadas:\n" +
                        "- Cirugía\n" +
                        "- Pediatría\n" +
                        "- Medicina Interna"
                );
        }


            // =========================================
            // DISEÑO
            // =========================================

            if(puntaje >= 250) {

                agregarCarrera(
                        "Diseño Grafico",
                        "resources/diseno.png",

                        "PROBABILIDAD DE INGRESO: MEDIA\n\n" +

                        "Descripcion:\n" +
                        "Carrera orientada a creatividad,\n" +
                        "diseño visual y multimedia.\n\n" +

                        "PONDERADOS ICFES:\n" +
                        "• Lectura Critica: 30%\n" +
                        "• Sociales: 30%\n" +
                        "• Ingles: 20%\n" +
                        "• Matematicas: 20%\n\n" +

                        "Carreras Relacionadas:\n" +
                        "• Diseño Multimedia\n" +
                        "• Publicidad\n" +
                        "• Animacion Digital"
                );
            }



            // =========================================
            // TURISMO
            // =========================================

            if(puntaje >= 240) {

                agregarCarrera(
                        "Turismo",
                        "resources/turismo.png",

                        "PROBABILIDAD DE INGRESO: MEDIA\n\n" +

                        "Descripcion:\n" +
                        "Carrera enfocada en idiomas,\n" +
                        "viajes y cultura internacional.\n\n" +

                        "PONDERADOS ICFES:\n" +
                        "• Ingles: 40%\n" +
                        "• Sociales: 30%\n" +
                        "• Lectura Critica: 20%\n" +
                        "• Matematicas: 10%\n\n" +

                        "Carreras Relacionadas:\n" +
                        "• Hoteleria\n" +
                        "• Guia Turistico\n" +
                        "• Relaciones Internacionales"
                );
            }



            // =========================================
            // PEDAGOGIA
            // =========================================

            if(puntaje >= 230) {

                agregarCarrera(
                        "Pedagogia",
                        "resources/pedagogia.png",

                        "PROBABILIDAD DE INGRESO: MEDIA\n\n" +

                        "Descripcion:\n" +
                        "Carrera enfocada en educacion,\n" +
                        "aprendizaje y enseñanza.\n\n" +

                        "PONDERADOS ICFES:\n" +
                        "• Lectura Critica: 40%\n" +
                        "• Sociales: 30%\n" +
                        "• Ingles: 20%\n" +
                        "• Matematicas: 10%\n\n" +

                        "Carreras Relacionadas:\n" +
                        "• Psicopedagogia\n" +
                        "• Educacion Especial\n" +
                        "• Licenciatura Infantil"
                );
            }



            // =========================================
            // SIN RESULTADOS
            // =========================================

            if(panelResultados.getComponentCount() == 0) {

                JLabel mensaje =
                        new JLabel(
                                "No se encontraron carreras compatibles."
                        );

                mensaje.setForeground(Color.WHITE);

                mensaje.setFont(
                        new Font("Arial", Font.BOLD, 22)
                );

                panelResultados.add(mensaje);
            }



            panelResultados.revalidate();

            panelResultados.repaint();

        }

        catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Ingrese un puntaje valido"
            );
        }
    }



    // =========================================
    // AGREGAR CARRERA
    // =========================================

    private void agregarCarrera(

            String nombre,
            String rutaImagen,
            String descripcion

    ) {

        JPanel tarjeta = new JPanel();

        tarjeta.setMaximumSize(
                new Dimension(950,450)
        );

        tarjeta.setBackground(
                new Color(35,35,70)
        );

        tarjeta.setLayout(
                new BorderLayout(15,15)
        );

        tarjeta.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(0,255,200),
                                2
                        ),
                        BorderFactory.createEmptyBorder(
                                15,15,15,15
                        )
                )
        );



        // =========================================
        // IMAGEN
        // =========================================

        ImageIcon icono =
                new ImageIcon(rutaImagen);

        Image imagen =
                icono.getImage().getScaledInstance(
                        150,
                        150,
                        Image.SCALE_SMOOTH
                );

        JLabel lblImagen =
                new JLabel(
                        new ImageIcon(imagen)
                );



        // =========================================
        // PANEL TEXTO
        // =========================================

       JPanel panelTexto = new JPanel();

        panelTexto.setBackground(
                new Color(35,35,70)
        );

        panelTexto.setLayout(
                new BoxLayout(panelTexto, BoxLayout.Y_AXIS)
        );



        JLabel lblNombre =
                new JLabel(nombre);

        lblNombre.setForeground(
                new Color(0,255,200)
        );

        lblNombre.setFont(
                new Font("Arial", Font.BOLD, 24)
        );



       JTextArea area =
        new JTextArea(descripcion);

                area.setEditable(false);

                area.setLineWrap(true);

                area.setWrapStyleWord(true);

                area.setOpaque(false);

                area.setBackground(
                        new Color(35,35,70)
                );

                area.setForeground(Color.WHITE);

                area.setFont(
                        new Font("Arial", Font.PLAIN, 16)
                );



        panelTexto.add(
                lblNombre,
                BorderLayout.NORTH
        );

        panelTexto.add(
                area,
                BorderLayout.CENTER
        );



        tarjeta.add(
                lblImagen,
                BorderLayout.WEST
        );

        tarjeta.add(
                panelTexto,
                BorderLayout.CENTER
        );



        panelResultados.add(tarjeta);

        panelResultados.add(
                Box.createVerticalStrut(20)
        );
    }



    // =========================================
    // ESTILO BOTONES
    // =========================================

    private void estilizarBoton(
            JButton boton,
            Color color
    ) {

        boton.setBackground(color);

        boton.setForeground(Color.WHITE);

        boton.setFocusPainted(false);

        boton.setFont(
                new Font("Arial", Font.BOLD, 15)
        );

        boton.setCursor(
                new Cursor(Cursor.HAND_CURSOR)
        );
    }
}