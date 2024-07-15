package com.example.pruebachoucair.tasks;

import com.example.pruebachoucair.utils.LeerArchivoExcel;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LeerExcel implements Task  {
    private static final String ruta = "Archivos/ExcelData.xlsx";
    private static final String nombreHojaUsuario = "ExcelData";
    private static final String nombreHojaCandidato = "Candidato";

    @Override
    public <T extends Actor> void performAs(T actor)  {
        LeerArchivoExcel leerArchivoExcel = new LeerArchivoExcel();
        Path excelRuta;
        try {
            excelRuta = Paths.get(getClass().getClassLoader().getResource(ruta).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException("Error al obtener la ruta del archivo Excel", e);
        }
        try {

            //Usuario
            String usuario =(String) leerArchivoExcel.getCellValue(excelRuta.toString(),nombreHojaUsuario,1, 0);
            String clave =(String) leerArchivoExcel.getCellValue(excelRuta.toString(),nombreHojaUsuario,1, 1);
            actor.remember("usuario", usuario);
            actor.remember("clave", clave);

            //Candidato
            String nombre = (String) leerArchivoExcel.getCellValue(excelRuta.toString(), nombreHojaCandidato, 1, 0);
            String nombre2 =(String) leerArchivoExcel.getCellValue(excelRuta.toString(), nombreHojaCandidato, 1, 1);
            String apellido =(String) leerArchivoExcel.getCellValue(excelRuta.toString(), nombreHojaCandidato, 1, 2);
            String vacante =(String) leerArchivoExcel.getCellValue(excelRuta.toString(), nombreHojaCandidato, 1, 3);
            String email = (String) leerArchivoExcel.getCellValue(excelRuta.toString(), nombreHojaCandidato, 1, 4);
            String movil = (String) leerArchivoExcel.getCellValue(excelRuta.toString(), nombreHojaCandidato, 1, 5);
            String palabrasC = (String) leerArchivoExcel.getCellValue(excelRuta.toString(), nombreHojaCandidato, 1, 6);
            String fechaA = (String) leerArchivoExcel.getCellValue(excelRuta.toString(), nombreHojaCandidato, 1, 7);
            String notas = (String) leerArchivoExcel.getCellValue(excelRuta.toString(), nombreHojaCandidato, 1, 8);
            String titulo = (String) leerArchivoExcel.getCellValue(excelRuta.toString(), nombreHojaCandidato, 1, 9);
            String entrevistador = (String) leerArchivoExcel.getCellValue(excelRuta.toString(), nombreHojaCandidato, 1, 10);
            String fecha = (String) leerArchivoExcel.getCellValue(excelRuta.toString(), nombreHojaCandidato, 1, 11);
            String hora = (String) leerArchivoExcel.getCellValue(excelRuta.toString(), nombreHojaCandidato, 1, 12);

            actor.remember("nombre", nombre);
            actor.remember("nombre2", nombre2);
            actor.remember("apellido", apellido);
            actor.remember("vacante", vacante);
            actor.remember("email", email);
            actor.remember("movil", movil);
            actor.remember("palabrasC", palabrasC);
            actor.remember("fechaA", fechaA);
            actor.remember("notas", notas);
            actor.remember("titulo", titulo);
            actor.remember("entrevistador", entrevistador);
            actor.remember("fecha", fecha);
            actor.remember("hora", hora);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LeerExcel en() {
        return Tasks.instrumented(LeerExcel.class);
    }

}
