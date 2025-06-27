package RenMor;

// Dichiaro le proprietà generiche di un gioco
public abstract class Games {
    protected String gameId;
    protected String title;
    protected int annoPubblicazione;
    protected double price;

    // Creo anche il costruttore
    public Games (String gameId, String title, int annoPubblicazione, double price){
        this.gameId = gameId;
        this.title = title;
        this.annoPubblicazione = annoPubblicazione;
        this.price = price;
    }

    // Getter

    public String getGameId() {
        return gameId;
    }

    public String getTitle() {
        return title;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public double getPrice() {
        return price;
    }

    // Setter

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    @Override
    public String toString() {
        return "Games{" +
                "gameId='" + gameId + '\'' +
                ", title='" + title + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", price=" + price +
                '}';
    }
}
