package com.empresa.seguimiento.runner;

import com.empresa.seguimiento.model.*;
import com.empresa.seguimiento.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeguimientoRunner implements CommandLineRunner {

    private final DesarrolladorRepository desarrolladorRepo;
    private final ProyectoRepository proyectoRepo;
    private final HistoriaUsuarioRepository historiaRepo;
    private final BugRepository bugRepo;
    private final TareaTecnicaRepository tareaRepo;

    public SeguimientoRunner(DesarrolladorRepository desarrolladorRepo,
                             ProyectoRepository proyectoRepo,
                             HistoriaUsuarioRepository historiaRepo,
                             BugRepository bugRepo,
                             TareaTecnicaRepository tareaRepo) {
        this.desarrolladorRepo = desarrolladorRepo;
        this.proyectoRepo = proyectoRepo;
        this.historiaRepo = historiaRepo;
        this.bugRepo = bugRepo;
        this.tareaRepo = tareaRepo;
    }

    @Override
    public void run(String... args) {
        Desarrollador ana = desarrolladorRepo.save(new Desarrollador("Ana", "Backend", "ana@empresa.com"));
        Desarrollador luis = desarrolladorRepo.save(new Desarrollador("Luis", "Frontend", "luis@empresa.com"));

        Proyecto proyecto = new Proyecto("Plataforma de Tareas", "PLT");
        proyecto.agregarDesarrollador(ana);
        proyecto.agregarDesarrollador(luis);
        proyectoRepo.save(proyecto);

        HistoriaUsuario historia = new HistoriaUsuario();
        historia.setTitulo("Login de usuarios");
        historia.setDescripcion("Como usuario quiero iniciar sesión");
        historia.setEstado(Estado.PROGRESO);
        historia.setPuntosEstimacion(5);
        historia.setValorNegocio(80);
        historia.setResponsable(ana);
        historia.agregarCriterio(new CriterioAceptacion("Valida mail y contraseña", false));
        historia.agregarCriterio(new CriterioAceptacion("Muestra error si falla", true));
        historiaRepo.save(historia);

        Bug bug = new Bug();
        bug.setTitulo("Error al guardar");
        bug.setDescripcion("Falla al guardar con campos vacíos");
        bug.setEstado(Estado.BACKLOG);
        bug.setPasosParaReproducir("1) Abrir formulario 2) Dejar vacío 3) Guardar");
        bug.setSeveridad(Severidad.ALTA);
        bug.setResponsable(luis);
        bugRepo.save(bug);

        TareaTecnica tarea = new TareaTecnica();
        tarea.setTitulo("Migrar a Java 25");
        tarea.setDescripcion("Actualizar build y dependencias");
        tarea.setEstado(Estado.REVISION);
        tarea.setComponenteAfectado("build");
        tarea.setResponsable(ana);
        tareaRepo.save(tarea);

        System.out.println(">>> Datos de prueba cargados");
    }
}