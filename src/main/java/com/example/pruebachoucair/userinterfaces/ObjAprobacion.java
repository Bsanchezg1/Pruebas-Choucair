package com.example.pruebachoucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ObjAprobacion {
    public static final Target BOTONSHORT = Target.the("Botón de shortlist").locatedBy("//button[@class='oxd-button oxd-button--medium oxd-button--success']");
    public static final Target BOTONSAVE = Target.the("Botón de guardar 2").locatedBy("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    public static final Target BOTONSHEDULE = Target.the("Botón de shedule interview").locatedBy("//button[@class='oxd-button oxd-button--medium oxd-button--success']");
    public static final Target TITULO = Target.the("Caja de texto de titulo").locatedBy("//div[@class='oxd-form-row'][2]//div[@data-v-957b4417]/input[@class='oxd-input oxd-input--active']");
    public static final Target ENTREVISTADOR = Target.the("Caja de texto de entrevistador").locatedBy("//input[@include-employees='onlyCurrent']");
    public static final Target LISTA = Target.the("Lista de entrevistadores").locatedBy("//div[@class='oxd-autocomplete-dropdown']");
    public static final Target FECHA = Target.the("Caja para fehca").locatedBy("//div[@class='oxd-form-row'][2]//div[@class='oxd-date-input']/input[@class='oxd-input oxd-input--active']");
    public static final Target HORA = Target.the("Caja para hora").locatedBy("//div[@class='oxd-form-row'][2]//div[@class='oxd-time-input']/input[@class='oxd-input oxd-input--active']");
    public static final Target BOTONOFFER = Target.the("Botón de Offer Job").locatedBy("//button[@class='oxd-button oxd-button--medium oxd-button--success'][2]");
    public static final Target BOTONHIRE = Target.the("Botón de Hire").locatedBy("//button[@class='oxd-button oxd-button--medium oxd-button--success']");
    public static final Target NUEVOESTADO = Target.the("Estado de contratacion").locatedBy("//p[@class='oxd-text oxd-text--p oxd-text--subtitle-2']");

}
