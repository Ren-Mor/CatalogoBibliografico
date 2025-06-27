package RenMor;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Collezione collezione = new Collezione();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(" <-- MENU --> ");
            System.out.println("1 = Aggiungi gioco");
            System.out.println("2 = Cerca ID gioco");
            System.out.println("3 = Cerca gioco per prezzo");
            System.out.println("4 = Cerca gioco per numero giocatori");
            System.out.println("5 = Rimuovi gioco tramite ID");
            System.out.println("6 = Aggiorna gioco tramite ID");
            System.out.println("0 = Uscita = ");
            System.out.println("Scelta: ");

            String selezione = scanner.nextLine();

            switch (selezione) {
                case "1":
                    System.out.println("Aggiungi gioco: "); break;
                case "2":
                    System.out.println("Ricerca per ID: ");
                String id = scanner.nextLine();
                Games gioco = collezione.ricercaId(id);
                if (gioco != null) {
                    System.out.println("Eccolo: " + gioco);
                } else {
                    System.out.println("Nessun ID trovato");
                } break;

                case "3":
                    System.out.println("Inserisci un prezzo massimo");
                    try {
                        double prezzo = Double.parseDouble(scanner.nextLine());
                        List<Games> filteredGames = collezione.ricercaPrezzo(prezzo);
                    } catch (NumberFormatException e){
                        System.out.println("Prezzo non valido");
                    } break;
                case "4":
                    System.out.println("Inserisci il numero di giocatori: ");
                    try {
                        int numPlayers = Integer.parseInt(scanner.nextLine());
                        List<TableGames> giochiGiocatori = collezione.ricercaNumGiocatori(numPlayers);
                        if (giochiGiocatori.isEmpty()){
                            System.out.println("Nessun gioco da tavolo con " + numPlayers + " giocatori.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Numero di giocatori non valido");
                    } break;
                case "5":
                    System.out.println("Inserisci l'ID da rimuovere: ");
                    String removeId = scanner.nextLine();
                    if (collezione.rimuoviGioco(removeId)){
                        System.out.println("Gioco rimosso");
                    } break;
                case "6":
                    System.out.println("Inserisci ID da aggiornare: ");
                    String updateId = scanner.nextLine();
                    collezione.updateGame(updateId, scanner); break;
                case "0":
                    System.out.println("Chiusura programma");
                    break;
                default:
                    System.out.println("Errore: selezione non valida");
            }
        }
    }
}

