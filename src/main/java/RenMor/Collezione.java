package RenMor;

import RenMor.entities.Categories;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Collezione {
    List<Games> gamesList;

    // Costruttore
    public Collezione(){
        this.gamesList = new ArrayList<>();
    }

    // Qui aggiungo un elemento se non esiste già un id uguale
    public void addGame(Games games) throws IllegalArgumentException {
        boolean verifica = gamesList.stream().anyMatch(g -> g.getGameId().equals(games.getGameId()));
        if (verifica) {
            throw new IllegalArgumentException("ID già presente: " + games.getGameId());
        }
        gamesList.add(games);
    }

    // Qui gestisco la ricerca per ID
    public Games ricercaId(String id) {
        for (Games games : gamesList) {
            if (games.getGameId().equals(id)){
                return games;
            }
        }
        return null;
    }

    // Gestisco la ricerca tramite prezzo
    public List<Games> ricercaPrezzo(double prezzoMax) {
        return gamesList.stream()
                .filter(g -> g.getPrice() < prezzoMax)
                .collect(Collectors.toList());
    }

    // Qui gestisco la ricerca per numero di giocatori
    public List<TableGames> ricercaNumGiocatori(int numPlayers){
        return gamesList.stream().filter(g -> g instanceof TableGames)
                .map(g ->(TableGames) g).filter(np -> np.getPlayers()== numPlayers).collect(Collectors.toList());
    }

    public boolean rimuoviGioco(String id) {
        for (Games g : gamesList) {
            if (g.getGameId().equals(id)) {
                gamesList.remove(g);
                return true;
            }
        }
        return false;
    }

    // Aggiorno un elemento esistente
    public void updateGame (String id, Scanner scanner){

        // Ricerca ed eventuale gestione errore
        Games games = ricercaId(id);
        if (games == null) {
            System.out.println("Nessun gioco trovato");
            return;
        }

        System.out.println("Gioco in aggiornamento: " + games.getTitle());

        // Richiedo i campi comuni da aggiornare
        try{
        System.out.println("Titolo aggiornato: ");
        String titolo = scanner.nextLine();
        System.out.println("Anno di pubblicazione: ");
        int anno = Integer.parseInt(scanner.nextLine());
        System.out.println("Prezzo: ");
        double prezzo = Double.parseDouble(scanner.nextLine());

        games.setTitle(titolo);
        games.setAnnoPubblicazione(anno);
        games.setPrice(prezzo);

        // Se appartiene a VideoGames allora procedo ad aggiornare i campi specifici
        if (games instanceof VideoGames) {
            VideoGames vg = (VideoGames) games;
            System.out.println("Piattaforma: ");
            String piattaforma = scanner.nextLine();;
            System.out.println("Durata del gioco in ore: ");
            int durata = Integer.parseInt(scanner.nextLine());
            System.out.println("Categoria: ");
            String category = scanner.nextLine();
            Categories categoria = Categories.valueOf(category);

            vg.setPlatform(piattaforma);
            vg.setGameDuration(durata);
            vg.setCategory(categoria);

        } else if (games instanceof TableGames) {

            TableGames tg = (TableGames) games;
            System.out.println("Numero giocatori: ");
            int giocatori = Integer.parseInt(scanner.nextLine());
            System.out.println("Durata media della partita in minuti: ");
            int durata = Integer.parseInt(scanner.nextLine());

            tg.setPlayers(giocatori);
            tg.setAverageDuration(durata);
        }

         // Messaggio di conferma e gestione dell'errore
        System.out.println("Gioco aggiornato.");
    } catch (NumberFormatException e) {
            System.out.println("Numero non valido");
        } catch (IllegalArgumentException e){
            System.out.println("Errore: " + e.getMessage());
        }
    }
}

