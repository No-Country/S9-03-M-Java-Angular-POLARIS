package com.polaris.appWebPolaris.persistance.entity;

public enum SkillsEntity {

    TALLER_DE_ARTE("TALLER DE ARTE"),
    LENGUAJE_DE_SENAS("LENGUAJE DE SEÑAS"),
    DEPORTES("DEPORTES"),
    TALLER_DE_LECTURA("TALLER DE LECTURA"),
    YOGA_Y_MEDITACION("YOGA Y MEDITACION"),
    IDIOMAS("IDIOMAS"),
    OTROS("OTROS"),
    VOLUNTARIO("VOLUNTARIO");

    private String name;

    SkillsEntity(String name) {
        this.name = name;
    }
}
