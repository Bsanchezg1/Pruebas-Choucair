package com.example.pruebachoucair.tasks;

import com.example.pruebachoucair.utils.LeerArchivoExcel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.example.pruebachoucair.userinterfaces.ObjAprobacion.*;
import static com.example.pruebachoucair.userinterfaces.ObjAprobacion.BOTONSAVE;
import static com.example.pruebachoucair.userinterfaces.ObjFormulario.RECLUTAMIENTO;
import static com.example.pruebachoucair.userinterfaces.ObjValidacion.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import net.serenitybdd.screenplay.questions.Attribute;

public class Aprobacion implements Task {
    private static final String ruta = "Archivos/ExcelData.xlsx";
    private static final String nombreHojaUsuario = "ExcelData";
    private static final String nombreHojaCandidato = "Candidato";
    public <T extends Actor> void performAs(T actor) {
        LeerArchivoExcel leerArchivoExcel = new LeerArchivoExcel();
        Path excelRuta;
        try {
            excelRuta = Paths.get(getClass().getClassLoader().getResource(ruta).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException("Error al obtener la ruta del archivo Excel", e);
        }
        String titulo=actor.recall("titulo");
        String entrevistador = actor.recall("entrevistador");
        String  fecha="";
        String hora=actor.recall("hora");
        actor.attemptsTo(
                Click.on(BOTONSHORT).afterWaitingUntilEnabled(),
                Click.on(BOTONSAVE).afterWaitingUntilEnabled(),
                Click.on(BOTONSHEDULE).afterWaitingUntilEnabled()
        );

        actor.attemptsTo(
                Enter.theValue(titulo).into(TITULO),
                Enter.theValue(entrevistador).into(ENTREVISTADOR)
        );
        try {
            Thread.sleep(5000);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            String place=Attribute.of(FECHA).named("placeholder").answeredBy(actor);

            if(place.equals("yyyy-dd-mm"))
                fecha = (String) leerArchivoExcel.getCellValue(excelRuta.toString(), nombreHojaCandidato, 1, 7);
            if(place.equals("dd-mm-yyyy"))
                fecha = (String) leerArchivoExcel.getCellValue(excelRuta.toString(), nombreHojaCandidato, 2, 7);
            if(place.equals("mm-dd-yyyy"))
                fecha = (String) leerArchivoExcel.getCellValue(excelRuta.toString(), nombreHojaCandidato, 3, 7);
            if(place.equals("yyyy-mm-dd"))
                fecha = (String) leerArchivoExcel.getCellValue(excelRuta.toString(), nombreHojaCandidato, 4, 7);
        } catch (AWTException e) {
            e.printStackTrace();
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        actor.attemptsTo(
                Enter.theValue(fecha).into(FECHA),
                Enter.theValue(hora).into(HORA),
                Click.on(BOTONSAVE).afterWaitingUntilEnabled()
        );
        try {Thread.sleep(2000);}
        catch (InterruptedException e) {}
        actor.attemptsTo(Click.on(BOTONSHEDULE).afterWaitingUntilEnabled());
        try {Thread.sleep(2000);}
        catch (InterruptedException e) {}
        actor.attemptsTo(Click.on(BOTONSAVE).afterWaitingUntilEnabled());
        try {Thread.sleep(2000);}
        catch (InterruptedException e) {}
        actor.attemptsTo(Click.on(BOTONOFFER).afterWaitingUntilEnabled());
        try {Thread.sleep(2000);}
        catch (InterruptedException e) {}
        actor.attemptsTo(Click.on(BOTONSAVE).afterWaitingUntilEnabled());
        try {Thread.sleep(2000);}
        catch (InterruptedException e) {}
        actor.attemptsTo(Click.on(BOTONHIRE).afterWaitingUntilEnabled());
        try {Thread.sleep(2000);}
        catch (InterruptedException e) {}
        actor.attemptsTo(
                Click.on(BOTONSAVE).afterWaitingUntilEnabled(),
                WaitUntil.the(NUEVOESTADO, isVisible()).forNoMoreThan(10).seconds()
        );
        String estadoCompleto = NUEVOESTADO.resolveFor(actor).getText();
        String estado = estadoCompleto.split(": ")[1].trim();
        actor.remember("estado", estado);
        String nombre = actor.recall("nombre")+" "+actor.recall("nombre2")+" "+actor.recall("apellido");
        actor.attemptsTo(
                Click.on(RECLUTAMIENTO).afterWaitingUntilEnabled(),
                Click.on(BOTONRESET),
                Scroll.to(OPCIONLISTA.of(nombre))
        );
        int cantidad= OPCIONLISTA.of(nombre).resolveAllFor(actor).size();
        String validacion="";
        for (int i = 0; i<cantidad;i++){
            if (DATOSLISTA.of(nombre, "6").resolveAllFor(actor).get(i).isPresent()){
                validacion = DATOSLISTA.of(nombre, "6").resolveAllFor(actor).get(i).getText();
            }

            if (validacion.equals("Hired")){
                actor.remember("vacante",DATOSLISTA.of(nombre, "2").resolveAllFor(actor).get(i).getText());
                actor.remember("candidato",DATOSLISTA.of(nombre, "3").resolveAllFor(actor).get(i).getText());
                actor.remember("manager",MANAGER.of(nombre, "4").resolveAllFor(actor).get(i).getText());
                actor.remember("fechaAplicacion",DATOSLISTA.of(nombre, "5").resolveAllFor(actor).get(i).getText());
                actor.remember("estado",DATOSLISTA.of(nombre, "6").resolveAllFor(actor).get(i).getText());
                break;
            }
        }
    }
    public static Aprobacion en(){
        return Tasks.instrumented(Aprobacion.class);
    }
}
