package com.gsd.daw.prog.api;

import java.util.List;

import lombok.Data;

@Data
public class Alumno {
    private int          edad;
    private final String nombre;
    private String numeroMatricula;
    private List<Modulo> modulos;
}
