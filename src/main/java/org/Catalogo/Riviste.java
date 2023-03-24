package org.Catalogo;

import java.time.LocalDate;

public class Riviste extends ElementoBibliotecario {
    public static Periodicità periodicità;

    public Riviste (String ISBN, String tit, LocalDate anno, int pag, Periodicità per) {
        super(ISBN, tit, anno, pag);
        this.periodicità = per;
    }
}

