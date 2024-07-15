package com.example.pruebachoucair.tasks;

import com.example.pruebachoucair.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

import java.awt.*;

public class AbrirTarea implements Task {
    private HomePage homePage;
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(homePage));
    }
    public static AbrirTarea theHomePage() throws AWTException {
        return Tasks.instrumented(AbrirTarea.class);
    }
}
