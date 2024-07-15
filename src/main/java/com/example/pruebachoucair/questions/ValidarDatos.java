package com.example.pruebachoucair.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarDatos implements Question<Boolean> {

    private String vacante;
    private String candidato;
    private String manager;
    private String fechaAplicacion;
    private String estado;


    public ValidarDatos(String vacante, String candidato, String manager, String fechaAplicacion, String estado) {
        this.vacante = vacante;
        this.candidato = candidato;
        this.manager = manager;
        this.fechaAplicacion = fechaAplicacion;
        this.estado = estado;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String managerIncompleto = actor.recall("manager");
        String managerCorrecto = managerIncompleto.split(" ")[0].trim();
        manager = manager.split(" ")[0].trim();

        String resultadoVacante = actor.recall("vacante");
        String resultadoCandidato = actor.recall("candidato");
        String resultadofecha = actor.recall("fechaAplicacion");
        String resultadoestado = actor.recall("estado");

        return actor.recall("vacante").equals(vacante) &&
                actor.recall("candidato").equals(candidato) &&
                managerCorrecto.equals(manager) &&
                actor.recall("fechaAplicacion").equals(fechaAplicacion) &&
                actor.recall("estado").equals(estado);
    }

    public static ValidarDatos en(String vacante, String candidato, String manager, String fechaAplicacion, String estado) {
        return new ValidarDatos(vacante, candidato, manager, fechaAplicacion, estado);
    }
}
