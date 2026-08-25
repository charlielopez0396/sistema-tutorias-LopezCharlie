\# Parte 1 - Análisis del dominio



\## Elementos del dominio



| Elemento / clase candidata | Responsabilidad | Información relevante | Reglas / colaboraciones |

|---|---|---|---|

| Estudiante | Solicitar y gestionar sus tutorías | id, nombre, correo, carrera | Puede solicitar o cancelar una tutoría. No puede registrarse en dos tutorías en el mismo horario. Colabora con Reserva. |

| Docente | Publicar y administrar horarios disponibles | id, nombre, correo, departamento | No puede tener dos tutorías confirmadas en el mismo horario. Colabora con HorarioTutoria. |

| HorarioTutoria | Representar la disponibilidad de un docente | id, fecha, horaInicio, horaFin, disponible | Solo puede reservarse cuando está disponible. Colabora con Docente y Reserva. |

| Reserva | Gestionar el ciclo de vida de una tutoría solicitada | id, estudiante, horario, estado, fechaReserva | Puede estar PENDIENTE, CONFIRMADA, CANCELADA o REALIZADA. |

| Asignatura | Representar la materia asociada a una tutoría | id, nombre, descripción | Una tutoría debe estar asociada a una asignatura. |

| ServicioReservas | Coordinar el proceso de reservar, cancelar o reprogramar | No almacena información propia del estudiante o docente | Coordina Reserva, HorarioTutoria y Notificador. |

| Notificador | Gestionar las comunicaciones de eventos importantes | destinatario, mensaje | Es utilizado por ServicioReservas. |



\## Reglas principales



1\. Un estudiante no puede registrarse en dos tutorías en el mismo horario.

2\. Un docente no puede tener dos tutorías confirmadas en el mismo horario.

3\. Solo se puede reservar un horario que esté disponible.

4\. Una reserva cancelada no puede confirmarse directamente.

5\. Toda reserva debe estar asociada a un estudiante, horario y asignatura.

6\. Al confirmar, cancelar o reprogramar una reserva se debe generar una notificación.

