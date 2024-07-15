package com.example.pruebachoucair.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.example.pruebachoucair.userinterfaces.ObjPaginaPrincipal.*;

public class Login implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        String usuario = actor.recall("usuario");
        String clave = actor.recall("clave");
            actor.attemptsTo(
                    Enter.theValue(usuario).into(USUARIO),
                    Enter.theValue(clave).into(CLAVE),
                    Click.on(BOTONINICIO)
            );
        }

    public static Login en(){
        return Tasks.instrumented(Login.class);
    }
}
