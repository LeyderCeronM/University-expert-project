package prologconexion;

import java.util.ArrayList;
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

    // =====================================================
    // OBTENER PREGUNTAS DESDE PROLOG
    // =====================================================

    public static ArrayList<String[]> obtenerPreguntas() {

        ArrayList<String[]> lista = new ArrayList<>();

        Query query = new Query("pregunta(X,Y)");

        while(query.hasMoreSolutions()) {

            Map<String, Term> solucion = query.nextSolution();

            String clave = solucion.get("X").toString();

            String pregunta =
                    solucion.get("Y")
                            .toString()
                            .replace("'", "");

            lista.add(new String[]{
                    clave,
                    pregunta
            });
        }

        return lista;
    }

    public static void enviarRespuesta(String pregunta) {

        String consulta = "assert(respuesta(" + pregunta + ",si))";

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


    // =====================================================
// OBTENER CARRERAS DESDE PROLOG
// =====================================================

public static ArrayList<String[]> obtenerCarreras() {

    ArrayList<String[]> lista =
            new ArrayList<>();

    Query query = new Query(
            "carrera_info(Id,Nombre,Descripcion,Imagen)"
    );

    while(query.hasMoreSolutions()) {

        Map<String, Term> solucion =
                query.nextSolution();

        String nombre =
                solucion.get("Nombre")
                        .toString()
                        .replace("'", "");

        String descripcion =
                solucion.get("Descripcion")
                        .toString()
                        .replace("'", "");

        String imagen =
                solucion.get("Imagen")
                        .toString()
                        .replace("'", "");

        lista.add(new String[]{

                nombre,
                descripcion,
                imagen
        });
    }

    return lista;
}
}