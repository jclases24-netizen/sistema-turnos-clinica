-- =================================================================
-- SCRIPT DE CONSULTAS DE PRUEBA Y AUDITORÍA - SISTEMA DE TURNOS
-- =================================================================
USE clinica_db;

-- 1. Ver todos los Pacientes registrados en el sistema
SELECT * FROM Pacientes;

-- 2. Ver todos los Médicos con sus respectivas especialidades
SELECT matricula, nombre, apellido, especialidad FROM Medicos;

-- 3. Ver la agenda de turnos completa (Uniendo las 3 tablas con JOIN)
-- Esta consulta traduce los DNI y Matrículas en nombres reales para que sea legible.
SELECT 
    t.id_turno AS 'ID Turno',
    t.fecha AS 'Fecha',
    t.hora AS 'Hora',
    t.estado AS 'Estado',
    CONCAT(p.apellido, ', ', p.nombre) AS 'Paciente',
    CONCAT(m.apellido, ', ', m.nombre) AS 'Médico',
    m.especialidad AS 'Especialidad'
FROM Turnos t
INNER JOIN Pacientes p ON t.paciente_dni = p.dni
INNER JOIN Medicos m ON t.medico_matricula = m.matricula
ORDER BY t.fecha ASC, t.hora ASC;

-- 4. Buscar turnos de un Paciente usando su DNI
SELECT * FROM Turnos 
WHERE paciente_dni = '46330163';

-- 5. Contar cuántos turnos tiene cada Médico
SELECT 
    m.matricula, 
    CONCAT(m.apellido, ', ', m.nombre) AS 'Médico', 
    COUNT(t.id_turno) AS 'Total Turnos Agendados'
FROM Medicos m
LEFT JOIN Turnos t ON m.matricula = t.medico_matricula
GROUP BY m.matricula;

-- 6. Ver solamente los turnos que están en estado 'Pendiente'
SELECT * FROM Turnos 
WHERE estado = 'Pendiente';