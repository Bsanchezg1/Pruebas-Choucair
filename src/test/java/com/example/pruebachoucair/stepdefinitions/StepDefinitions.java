package com.example.pruebachoucair.stepdefinitions;

import com.example.pruebachoucair.questions.ValidarDatos;
import com.example.pruebachoucair.tasks.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static com.example.pruebachoucair.userinterfaces.ObjValidacion.*;

import java.awt.*;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class StepDefinitions {
    public static Actor cliente;

    @Before
    public void configuracionInicial() {
        OnStage.setTheStage(new OnlineCast());
        cliente = theActorCalled("Cliente");
    }

    @Given("El usuario inicia sesion")
    public void elUsuarioIniciaSesion() throws AWTException {
        cliente.wasAbleTo(AbrirTarea.theHomePage());
        cliente.attemptsTo(
                LeerExcel.en(),
                Login.en()
        );
    }

    @When("El cliente realiza proceso de contratacion")
    public void elClienteRealizaProcesoDeContratacion() {
        cliente.attemptsTo(
                Formulario.en(),
                Aprobacion.en()
        );
    }

    @Then("El usuario valida que los datos de la persona correspondan a los diligenciados")
    public void elUsuarioValidaQueLosDatosDeLaPersonaCorrespondanALosDiligenciados(DataTable datos) {
        List<Map<String, String>> dato = datos.asMaps(String.class, String.class);
        String manager = MANAGER.resolveFor(cliente).getText();
        cliente.should(seeThat("Validar mensajes recibidos",
                        ValidarDatos.en(
                                dato.get(0).get("Vacante"),
                                dato.get(0).get("Candidato"),
                                manager,
                                dato.get(0).get("Fecha"),
                                dato.get(0).get("Estado"))
                )
        );
    }

    @And("El usuario valida estado de contratacion")
    public void elUsuarioValidaEstadoDeContratacion() {
    }
}
