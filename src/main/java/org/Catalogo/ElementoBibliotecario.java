package org.Catalogo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ElementoBibliotecario {
    public String codiceISBN;
    public String titolo;
    public LocalDate annoDiPubblicazione;
    public int numeroPagine;
    public ElementoBibliotecario(String ISBN, String tit, LocalDate anno, int pag) {
        this.codiceISBN = ISBN;
        this.titolo = tit;
        this.annoDiPubblicazione = anno;
        this.numeroPagine = pag;
    }
    public static LocalDate dateInput(String data) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy");
        LocalDate date = LocalDate.parse(data, dateFormat);
        return date ;
    }
}
