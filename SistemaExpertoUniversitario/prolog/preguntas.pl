% =========================
% PREGUNTAS
% =========================

pregunta(programacion,'¿Te gusta programar?').
pregunta(matematicas,'¿Te gustan las matematicas?').
pregunta(tecnologia,'¿Te interesa la tecnologia?').
pregunta(biologia,'¿Te gusta la biologia y el funcionamiento del cuerpo humano?').
pregunta(debate,'¿Te gusta debatir?').
pregunta(historia,'¿Te gusta la historia?').
pregunta(diagnostico,'¿Te interesa diagnosticar enfermedades?').
pregunta(creatividad,'¿Eres creativo?').
pregunta(pacientes,'¿Te interesa la salud y ayudar a los pacientes?').
pregunta(dibujo,'¿Te gusta dibujar?').

% =========================
% RESPUESTAS DINAMICAS
% =========================

:- dynamic respuesta/2.

guardar_respuesta(Pregunta,Respuesta) :-
    assertz(respuesta(Pregunta,Respuesta)).