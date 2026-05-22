% HECHOS DINAMICOS

:- dynamic respuesta/2.

% REGLAS DE CARRERAS

carrera(ingenieria_sistemas):- respuesta(programacion,si), respuesta(matematicas,si), respuesta(tecnologia,si).

carrera(derecho):- respuesta(debate,si), respuesta(historia,si).

carrera(diseno):- respuesta(creatividad,si), respuesta(dibujo,si).

% LIMPIAR RESPUESTAS

limpiar:- retractall(respuesta(_,_)).