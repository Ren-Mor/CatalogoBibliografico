package RenMor;

import RenMor.entities.Categories;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Collezione collezione = new Collezione();
        Scanner scanner = new Scanner(System.in);

        // VideoGames di esempio
        collezione.addGame(new VideoGames("VG001", "Fantasix", 2023, 59.99, "PC", 40, Categories.Fantasy));
        collezione.addGame(new VideoGames("VG002", "Action Hero", 2021, 49.99, "PS5", 30, Categories.Action));
        collezione.addGame(new VideoGames("VG003", "Epic Quest", 2022, 39.99, "Xbox", 50, Categories.MMORPG));

       // TableGames di esempio
        collezione.addGame(new TableGames("TG001", "Risiko", 2018, 29.99, 4, 120));
        collezione.addGame(new TableGames("TG002", "Monopoly", 2019, 25.50, 6, 90));
        collezione.addGame(new TableGames("TG003", "Cluedo", 2017, 20.00, 5, 60));


        while (true) {
            System.out.println(" <-- MENU --> ");
            System.out.println("1 = Aggiungi gioco");
            System.out.println("2 = Cerca ID gioco");
            System.out.println("3 = Cerca gioco per prezzo");
            System.out.println("4 = Cerca gioco per numero giocatori");
            System.out.println("5 = Rimuovi gioco tramite ID");
            System.out.println("6 = Aggiorna gioco tramite ID");
            System.out.println("0 = Uscita");
            System.out.println("Scelta: ");

            String selezione = scanner.nextLine();

            switch (selezione) {
                case "1":
                    System.out.println("Che tipo di gioco vuoi aggiungere? (1 = VideoGame, 2 = TableGame)");
                    String tipo = scanner.nextLine();

                    try {
                        System.out.println("ID gioco: ");
                        String gameId = scanner.nextLine();

                        System.out.println("Titolo: ");
                        String titolo = scanner.nextLine();

                        System.out.println("Anno di pubblicazione: ");
                        int anno = Integer.parseInt(scanner.nextLine());

                        System.out.println("Prezzo: ");
                        double prezzo = Double.parseDouble(scanner.nextLine());

                        if (tipo.equals("1")) {
                            // VideoGame
                            System.out.println("Piattaforma: ");
                            String piattaforma = scanner.nextLine();

                            System.out.println("Durata del gioco in ore: ");
                            int durata = Integer.parseInt(scanner.nextLine());

                            System.out.println("Categoria (Action, MMORPG, Fantasy, Roguelite): ");
                            String categoriaStr = scanner.nextLine();
                            Categories categoria = Categories.valueOf(categoriaStr);

                            VideoGames nuovoVG = new VideoGames(gameId, titolo, anno, prezzo, piattaforma, durata, categoria);
                            collezione.addGame(nuovoVG);

                        } else if (tipo.equals("2")) {
                            // TableGame
                            System.out.println("Numero giocatori (2-10): ");
                            int giocatori = Integer.parseInt(scanner.nextLine());

                            System.out.println("Durata media della partita in minuti: ");
                            int durataMedia = Integer.parseInt(scanner.nextLine());

                            TableGames nuovoTG = new TableGames(gameId, titolo, anno, prezzo, giocatori, durataMedia);
                            collezione.addGame(nuovoTG);

                        } else {
                            System.out.println("Tipo di gioco non valido");
                            break;
                        }

                        System.out.println("Gioco aggiunto con successo.");

                    } catch (NumberFormatException e) {
                        System.out.println("Errore: formato numero non valido");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Errore: " + e.getMessage());
                    }
                    break;

                    case "2":
                    System.out.println("Ricerca per ID: ");
                    String id = scanner.nextLine();
                    Games gioco = collezione.ricercaId(id);
                    if (gioco != null) {
                        System.out.println("Eccolo: " + gioco);
                    } else {
                        System.out.println("Nessun ID trovato");
                    }
                    break;

                case "3":
                    System.out.println("Inserisci un prezzo massimo");
                    try {
                        double prezzo = Double.parseDouble(scanner.nextLine());
                        List<Games> filteredGames = collezione.ricercaPrezzo(prezzo);
                        if (filteredGames.isEmpty()) {
                            System.out.println("Nessun gioco trovato con prezzo inferiore a " + prezzo);
                        } else {
                            for (Games g : filteredGames) {
                                System.out.println(g);
                            }
                        }
                    } catch (NumberFormatException e){
                        System.out.println("Prezzo non valido");
                    }
                    break;

                case "4":
                    System.out.println("Inserisci il numero di giocatori: ");
                    try {
                        int numPlayers = Integer.parseInt(scanner.nextLine());
                        List<TableGames> giochiGiocatori = collezione.ricercaNumGiocatori(numPlayers);
                        if (giochiGiocatori.isEmpty()){
                            System.out.println("Nessun gioco da tavolo con " + numPlayers + " giocatori.");
                        } else {
                            for (TableGames tg : giochiGiocatori) {
                                System.out.println(tg);
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Numero di giocatori non valido");
                    }
                    break;

                case "5":
                    System.out.println("Inserisci l'ID da rimuovere: ");
                    String removeId = scanner.nextLine();
                    if (collezione.rimuoviGioco(removeId)){
                        System.out.println("Gioco rimosso");
                    } else {
                        System.out.println("ID non trovato, niente da rimuovere");
                    }
                    break;

                case "6":
                    System.out.println("Inserisci ID da aggiornare: ");
                    String updateId = scanner.nextLine();
                    collezione.updateGame(updateId, scanner);
                    break;

                case "0":
                    System.out.println("Chiusura programma");
                    scanner.close();
                    return;

                default:
                    System.out.println("Errore: selezione non valida");
            }
        }
    }
}
