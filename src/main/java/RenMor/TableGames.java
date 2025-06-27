package RenMor;

public class TableGames  extends Games{

    // Rappresento un gioco di società
    private int players;
    private int averageDuration;

    // Ne creo il costruttore
    public TableGames(String gameId, String title, int annoPubblicazione, double price, int players, int averageDuration) {
        super(gameId, title, annoPubblicazione, price);
        this.players = players;
        this.averageDuration = averageDuration;
    }

    // Getter

    public int getPlayers() {
        return players;
    }

    public int getAverageDuration() {
        return averageDuration;
    }

    // Setter
    public void setAverageDuration(int averageDuration) {
        this.averageDuration = averageDuration;
    }

    // Controllo per il numero di giocatori
    public void setPlayers(int players) {
        if (players < 2 || players > 10) {
            throw new IllegalArgumentException("I giocatori devono essere compresi tra 2 e 10");
        }
        this.players = players;
    }

    @Override
    public String toString() {
        return "TableGames{" +
                "players=" + players +
                ", averageDuration=" + averageDuration +
                '}';
    }
}
