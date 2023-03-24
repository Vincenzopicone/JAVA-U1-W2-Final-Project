package org.Catalogo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static List<ElementoBibliotecario> archivio = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Libri L1 = new Libri("L21", "Imparare Java", LocalDate.of(2000,1,1),912, "Mario Rossi", "Commedia");
        Libri L2 = new Libri("L18", "Imparare Java in giapponese",LocalDate.of(2015,1,1) ,213, "Unamoto Guidamoto", "Horror");
        Libri L3 = new Libri("L45", "Il signore degli Stream", LocalDate.of(2015,1,1),123, "Mark Zuckemberg", "Fantasy");
        Libri L4 = new Libri("L92", "Titolo 4",LocalDate.of(2002,1,1) ,144,"Sconosciuto di nome", "Commedia");
        Libri L5 = new Libri("L56", "Calcio",LocalDate.of(1952,1,1) ,365, "Alessandro Del Piero", "Sport");
        Riviste R1 = new Riviste("R50", "Gazzetta dello Sport", LocalDate.of(1982,1,1),56,Periodicità.SETTIMANALE);
        Riviste R2 = new Riviste("R21", "TuttoSport", LocalDate.of(1952,1,1),26,Periodicità.SETTIMANALE);
        Riviste R3 = new Riviste("R65", "RivistaSpace", LocalDate.of(1962,1,1),656,Periodicità.MENSILE);
        Riviste R4 = new Riviste("R32", "Pesca", LocalDate.of(1952,1,1),220,Periodicità.SEMESTRALE);
        Riviste R5 = new Riviste("R45", "Caccia", LocalDate.of(1988,1,1),751,Periodicità.SEMESTRALE);
        aggiungiAdArchivio(L1);
        aggiungiAdArchivio(L2);
        aggiungiAdArchivio(L3);
        aggiungiAdArchivio(L4);
        aggiungiAdArchivio(L5);
        aggiungiAdArchivio(R1);
        aggiungiAdArchivio(R2);
        aggiungiAdArchivio(R3);
        aggiungiAdArchivio(R4);
        aggiungiAdArchivio(R5);
        while(true) {
            System.out.println("------------------------------------");
            System.out.println("1 per mostrare cosa hai aggiunto");
            System.out.println("2 per rimuovere un elemento");
            System.out.println("3 per ricercare per anno");
            System.out.println("4 per ricercare per ISBN");
            System.out.println("5 per ricercare per autore");
            System.out.println("6 per aggiungere un libro");
            System.out.println("7 per aggiungere una rivista");
            System.out.println("8 per salvare i dati su file");
            System.out.println("9 per caricare un file");
            System.out.println("Seleziona 0 per uscire!");
            System.out.println("------------------------------------");
            System.out.println("Scegli cosa fare");
            int scelta = scanner.nextInt();
            switch (scelta) {
                case 1:
                    caricaArchivio();
                    break;
                case 2:
                    System.out.println("ISBN da eliminare");
                    String ISBNDelete = scanner.next();
                    rimuoviElemento(ISBNDelete);
                    break;
                case 3:
                    System.out.println("Ricerca per anno");
                    Long anno = scanner.nextLong();
                    ricercaPerAnno(anno);
                    break;
                case 4:
                    System.out.println("Ricerca per ISBN");
                    String ISBN = scanner.next();
                    ricercaISBN(ISBN);
                    break;
                case 5:
                    System.out.println("Ricerca per autore");
                    String autore = scanner.next();
                    ricercaPerAutore(autore);
                    break;
                case 6:
                    System.out.println("Inserisci l'ISBN");
                    String ISBNLibro = scanner.next();
                    System.out.println("Inserisci il titolo");
                    String titoloLibro = scanner.next();
                    System.out.println("Inserisci l'anno di pubblicazione");
                    int annoLibro = scanner.nextInt();
                    System.out.println("Inserisci il mese di pubblicazione");
                    int mese = scanner.nextInt();
                    System.out.println("Inserisci il giorno di pubblicazione");
                    int giorno = scanner.nextInt();
                    System.out.println("Inserisci le pagine");
                    int pagineLibro = scanner.nextInt();
                    System.out.println("Inserisci l'autore");
                    String autoreLibro = scanner.next();
                    System.out.println("Inserisci il genere");
                    String genere = scanner.next();
                    Libri L = new Libri(ISBNLibro, titoloLibro, LocalDate.of(annoLibro, mese, giorno), pagineLibro, autoreLibro, genere);
                    aggiungiAdArchivio(L);
                    break;
                case 7:
                    System.out.println("Inserisci l'ISBN");
                    String ISBNRivista = scanner.next();
                    System.out.println("Inserisci il titolo");
                    String titoloRivista = scanner.next();
                    System.out.println("Inserisci l'anno di pubblicazione");
                    int annoRivista = scanner.nextInt();
                    System.out.println("Inserisci il mese di pubblicazione");
                    int meseRivista = scanner.nextInt();
                    System.out.println("Inserisci il giorno di pubblicazione");
                    int giornoRivista = scanner.nextInt();
                    System.out.println("Inserisci le pagine");
                    int pagineRivista = scanner.nextInt();
                    System.out.println("Inserisci che tipo di periodico è: 1-Settimanale, 2-Mensile, 3-Semestrale");
                    Periodicità periodicità = null;
                    int scannerPeriodo = 0;
                    do {
                        scannerPeriodo = scanner.nextInt();
                        switch (scannerPeriodo) {
                            case 1:
                                periodicità = Periodicità.SETTIMANALE;
                            case 2:
                                periodicità = Periodicità.MENSILE;
                            case 3:
                                periodicità = Periodicità.SEMESTRALE;
                            case 0:
                                break;
                            default:
                                System.out.println("Scelta non valida");
                        };
                    } while (scannerPeriodo < 0 || scannerPeriodo > 3);
                    Riviste R = new Riviste(ISBNRivista, titoloRivista, LocalDate.of(annoRivista, meseRivista, giornoRivista), pagineRivista, periodicità);
                    aggiungiAdArchivio(R);
                    break;
                case 8:
                    System.out.println("Con quale nome vuoi salvare il file?");
                    String nomeFile = scanner.next();
                    scriviFile(nomeFile);
                    break;
                case 9:
                    System.out.println("Quale file vuoi caricare?");
                    String nomeFileDaLeggere = scanner.next();
                    leggiFile(nomeFileDaLeggere);
                    break;
                default: System.exit(0);
            }

        }
    }

    public static void aggiungiAdArchivio (ElementoBibliotecario elem) {
        archivio.add(elem);
    }

    public static void caricaArchivio () {
        System.out.println("------------------------------------");
        System.out.println("Questi sono tutti gli elementi dentro l'archivio:");
        System.out.println("------------------------------------");
        for (int i = 0; i < archivio.size(); i++) {
            System.out.println("ISBN: " + archivio.get(i).codiceISBN + " " + "Titolo: " + archivio.get(i).titolo + " " + "Pubblicato il : " + archivio.get(i).annoDiPubblicazione.getYear());
        }
    }
    public static void rimuoviElemento (String s) {
        List <ElementoBibliotecario> archivioStream = archivio.stream()
                .filter(x -> !x.codiceISBN.toLowerCase().equals(s.toLowerCase()))
                .collect(Collectors.toList());
        archivio = archivioStream;
        System.out.println("Elemento cancellato");
    }
    public static void ricercaISBN (String s) {
        archivio.stream()
                .filter(x -> x.codiceISBN.toLowerCase().equals(s.toLowerCase()))
                .forEach(x-> System.out.println("Elemento ricercato per ISBN: Il titolo è... " + x.titolo.toString()));
        System.out.println("------------------------------------");
    }
    public static void ricercaPerAnno (Long date) {
        archivio.stream()
                .filter(x -> x.annoDiPubblicazione.getYear() == date)
                .forEach(x-> System.out.println("Elemento ricercato per ANNO: Il titolo è...  " + x.titolo.toString()));
        System.out.println("------------------------------------");
    }
    public static void ricercaPerAutore (String aut) {
        archivio.stream()
                .filter(x -> x instanceof Libri)
                .filter(libri -> ((Libri) libri).autore.toLowerCase().contains(aut.toLowerCase()))
                .forEach(x-> System.out.println("Elemento ricercato per AUTORE: Il titolo è... " + x.titolo.toString()));
        System.out.println("------------------------------------");
    }
    public static void scriviFile(String nomeFile) throws Exception, IOException {
        File file = new File(nomeFile);
        List<String> contenuti = new ArrayList<String>();
        try {
            for (int i = 0; i < archivio.size(); i++) {
               if (archivio.get(i) instanceof Libri) {
                   contenuti.add("ISBN: "+archivio.get(i).codiceISBN+ " Titolo: "+ archivio.get(i).titolo + " Anno di Pubblicazione: " + archivio.get(i).annoDiPubblicazione.getYear()+" Numero Pagine: " +archivio.get(i).numeroPagine + " Autore: " + ((Libri) archivio.get(i)).autore + " Genere: " + ((Libri) archivio.get(i)).genere);
               } else if (archivio.get(i) instanceof Riviste) {
                   contenuti.add("ISBN: "+archivio.get(i).codiceISBN+ " Titolo: "+ archivio.get(i).titolo + " Anno di Pubblicazione: " + archivio.get(i).annoDiPubblicazione.getYear()+" Numero Pagine: " +archivio.get(i).numeroPagine + " Periodicità: " + String.valueOf(((Riviste) archivio.get(i)).periodicità));
               }
            }
            FileUtils.writeLines(file, contenuti);
        } catch (Exception e) {
            e.getStackTrace();
        };
    }
    public static void leggiFile(String nomeFile) throws Exception {
        try{
        File file = new File(nomeFile);
        String fileInput = FileUtils.readFileToString(file, "UTF-8");
        System.out.println(fileInput.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}