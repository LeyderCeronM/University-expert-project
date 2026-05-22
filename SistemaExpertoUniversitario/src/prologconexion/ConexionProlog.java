package prologconexion;

import java.util.Map;

import org.jpl7.Query;
import org.jpl7.Term;

public class ConexionProlog {

    public static void conectar() {

        Query consulta = new Query("consult('prolog/main.pl')");

        if(consulta.hasSolution()) {

            System.out.println("Prolog conectado correctamente");

        } else {

            System.out.println("Error al conectar");

        }
    }

    public static void enviarRespuesta(String pregunta) {

        String consulta =
                "assert(respuesta(" + pregunta + ",si))";

        Query q = new Query(consulta);

        q.hasSolution();
    }

    public static String obtenerCarrera() {

        Query q = new Query("carrera(X)");

        if(q.hasSolution()) {

            Map<String, Term> solucion =
                    q.oneSolution();

            return solucion.get("X").toString();

        }

        return "No encontrada";
    }

    public static void limpiarRespuestas() {

        Query q = new Query("limpiar");

        q.hasSolution();
    }

    public static void guardarRespuesta(
            String pregunta,
            String respuesta
    ) {

        String consulta =
                "assert(respuesta("
                + pregunta +
                "," +
                respuesta +
                "))";

        Query q = new Query(consulta);

        q.hasSolution();
    }
}