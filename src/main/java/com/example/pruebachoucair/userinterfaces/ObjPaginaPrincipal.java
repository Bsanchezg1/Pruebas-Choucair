package com.example.pruebachoucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ObjPaginaPrincipal {
    public static final Target USUARIO = Target.the("Usuario").locatedBy("//input[@name='username']");
    public static final Target CLAVE = Target.the("Clave").locatedBy("//input[@name='password']");
    public static final Target BOTONINICIO = Target.the("Boton de inicio").locatedBy("//button[@type='submit']");

}
