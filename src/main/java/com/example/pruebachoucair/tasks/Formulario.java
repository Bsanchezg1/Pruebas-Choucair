package com.example.pruebachoucair.tasks;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import static com.example.pruebachoucair.userinterfaces.ObjFormulario.*;
public class Formulario implements Task {
    private static final String rutaPDF = "Archivos/HojadevidaBrayanSanchez.pdf";
    @Override
    public <T extends Actor> void performAs(T actor) {
        Path pdfRuta;
        try {
            pdfRuta = Paths.get(getClass().getClassLoader().getResource(rutaPDF).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException("Error al obtener la ruta del archivo PDF", e);
        }

        String nombre = actor.recall("nombre");
        String nombre2=actor.recall("nombre2");
        String apellido=actor.recall("apellido");
        String vacante=actor.recall("vacante");
        String email=actor.recall("email");
        String movil=actor.recall("movil");
        String palabrasC=actor.recall("palabrasC");
        String fechaA=actor.recall("fechaA");
        String notas=actor.recall("notas");
        actor.attemptsTo(
                Click.on(RECLUTAMIENTO).afterWaitingUntilEnabled(),
                Click.on(BOTONADD).afterWaitingUntilEnabled()
                );
        actor.attemptsTo(
                Enter.theValue(nombre).into(NOMBRE),
                Enter.theValue(nombre2).into(NOMBRE2),
                Enter.theValue(apellido).into(APELLIDO),
                Click.on(LISTAVACANTE).afterWaitingUntilEnabled()
        );
        try {
            Thread.sleep(3000);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(
                Enter.theValue(email).into(EMAIL),
                Enter.theValue(movil).into(MOVIL),
                Upload.theFile(Paths.get(pdfRuta.toString())).to(RESUME),
                Enter.theValue(palabrasC).into(PALABRASCLAVE),
                Enter.theValue(notas).into(NOTAS),
                Click.on(CONSENTIMIENTO).afterWaitingUntilEnabled(),
                Click.on(BOTONENVIAR).afterWaitingUntilEnabled()
                );
    }
    public static Formulario en(){
        return Tasks.instrumented(Formulario.class);
    }
}
