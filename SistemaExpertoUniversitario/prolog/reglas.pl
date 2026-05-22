:- dynamic respuesta/2.


carrera(ingenieria_sistemas):- respuesta(programacion,si), respuesta(matematicas,si), respuesta(tecnologia,si).
carrera(derecho):- respuesta(debate,si), respuesta(historia,si).
carrera(medicina):- respuesta(salud, si), respuesta(biologia, si).
carrera(diseno):- respuesta(creatividad,si), respuesta(dibujo,si).
carrera(turismo):- respuesta(idiomas,si), respuesta(viajes,si).

carrera(no_encontrada).

limpiar:-

retractall(respuesta(_,_)).