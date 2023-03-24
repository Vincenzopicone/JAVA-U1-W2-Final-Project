package org.Catalogo;

import java.time.LocalDate;

public class Libri extends ElementoBibliotecario{
    public String autore;
    public String genere;

    public Libri (String ISBN, String tit, LocalDate anno, int pag, String aut, String gen) {
        super(ISBN, tit, anno, pag);
        this.autore = aut;
        this.genere = gen;
    }
}
