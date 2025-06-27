package RenMor;

import java.util.ArrayList;
import java.util.List;
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

    // Qui gestisco la ricerca per numero di giocatori
    public List<TableGames> ricercaNumGiocatori(int numPlayers){
        return gamesList.stream().filter(g -> g instanceof TableGames)
                .map(g ->(TableGames) g).filter(np -> np.getPlayers()== numPlayers).collect(Collectors.toList());
    }
}

