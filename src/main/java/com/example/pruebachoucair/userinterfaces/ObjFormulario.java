package com.example.pruebachoucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ObjFormulario {
    public static final Target RECLUTAMIENTO = Target.the("Boton para ir a formulario de reclutamiento").locatedBy("//li[@class='oxd-main-menu-item-wrapper'][5]");
    public static final Target BOTONADD = Target.the("Boton para crear contratacion").locatedBy("//div[@class='orangehrm-paper-container']/div[@class='orangehrm-header-container']/button");
    public static final Target NOMBRE = Target.the("Caja nombre").locatedBy("//input[@name='firstName']");
    public static final Target NOMBRE2 = Target.the("Caja segundo nombre").locatedBy("//input[@name='middleName']");
    public static final Target APELLIDO = Target.the("Caja apellido").locatedBy("//input[@name='lastName']");
    public static final Target LISTAVACANTE = Target.the("Caja de vacantes").locatedBy("//form[@class='oxd-form']//div[@class='oxd-select-wrapper']/div");
    public static final Target OPCIONVACANTE = Target.the("Lista de vacantes").locatedBy("//div[@role='listbox']");
    public static final Target EMAIL = Target.the("Caja correo").locatedBy("//div[@data-v-2130bd2a][3]/div/div[1]//input");
    public static final Target MOVIL = Target.the("Caja de numero de telefono").locatedBy("//div[@data-v-2130bd2a][3]/div/div[2]//input");
    public static final Target RESUME = Target.the("Caja para subir archivo").locatedBy("//input[@type='file']");
    public static final Target PALABRASCLAVE = Target.the("Caja palabras clave").locatedBy("//div[@data-v-2130bd2a][5]/div/div[1]//input");
    public static final Target CALENDARIO = Target.the("fecha aplicacion").locatedBy("//div[@data-v-2130bd2a][5]/div/div[2]//input");
    public static final Target NOTAS = Target.the("Caja de notras").locatedBy("//div[@data-v-2130bd2a][6]/div//textarea");
    public static final Target CONSENTIMIENTO = Target.the("Caja de consentimiento").locatedBy("//div[@data-v-2130bd2a][7]/div//span/i");
    public static final Target BOTONENVIAR = Target.the("Botón de guardar").locatedBy("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");

}
