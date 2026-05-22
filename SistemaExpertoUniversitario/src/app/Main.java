package app;

import gui.VentanaInicio;
import prologconexion.ConexionProlog;

public class Main {

    public static void main(String[] args) {

        ConexionProlog.conectar();
        new VentanaInicio();

    }
}