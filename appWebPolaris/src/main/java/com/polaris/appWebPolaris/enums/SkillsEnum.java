package com.polaris.appWebPolaris.enums;

public enum SkillsEnum {

    TALLER_DE_ARTE("Taller de Arte"),
    LENGUAJE_DE_SENAS("Lenguaje de Señas"),
    DEPORTES("Deportes"),
    TALLER_DE_LECTURA("Taller de Lectura"),
    YOGA_Y_MEDITACION("Yoga y meditacion"),
    IDIOMAS("Idiomas"),
    OTROS("Otros"),
    VOLUNTARIO("VOLUNTARIO");

    private String name;

    SkillsEnum(String name) {
        this.name = name;
    }
}
