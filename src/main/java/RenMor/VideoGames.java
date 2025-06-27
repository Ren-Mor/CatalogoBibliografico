package RenMor;

import RenMor.entities.Categories;

public class VideoGames  extends Games{
    private String platform;
    private int gameDuration;
    private Categories category;

    // Il costruttore
    public VideoGames(String gameId, String title, int annoPubblicazione, double price, String platform, int gameDuration, Categories category){
        super(gameId, title, annoPubblicazione, price);
        this.platform = platform;
        this.gameDuration = gameDuration;
        this.category = category;
    }

    // Getter
    public String getPlatform() {
        return platform;
    }

    public int getGameDuration() {
        return gameDuration;
    }

    public Categories getCategory() {
        return category;
    }

    // Setter

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setGameDuration(int gameDuration) {
        this.gameDuration = gameDuration;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "VideoGames{" +
                "platform='" + platform + '\'' +
                ", gameDuration=" + gameDuration +
                ", category=" + category +
                '}';
    }
}
