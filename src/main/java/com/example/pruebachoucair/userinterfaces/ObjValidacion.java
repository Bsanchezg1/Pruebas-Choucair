package com.example.pruebachoucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ObjValidacion {
    public static final Target BOTONRESET = Target.the("Botón para actualizar lista").locatedBy("//button[@class='oxd-button oxd-button--medium oxd-button--ghost']");
        public static final Target OPCIONLISTA = Target.the("Botón de guardar 2").locatedBy("//div[@class='oxd-table-row oxd-table-row--with-border']/div[3]/div[contains(text(), '{0}')]//parent::div//parent::div[@class='oxd-table-row oxd-table-row--with-border']");
    public static final Target DATOSLISTA = Target.the("Datos de la lista ").locatedBy("(//div[contains(text(), '{0}')]//parent::div//parent::div//parent::div[@class='oxd-table-card' and @data-v-f2168256])[1]//div[@class='oxd-table-cell oxd-padding-cell'][{1}]/div[not(@class)]");
    public static final Target MANAGER = Target.the("Nombre del manager").locatedBy("//p[@class='oxd-userdropdown-name']");

}
