package server.database;

public class Player
{
    private String name;
    private long date;
    private int score;
    private long timeGame;

    public Player(String name, long date, int score, long timeGame)
    {
        this.name = name;
        this.date = date;
        this.score = score;
        this.timeGame = timeGame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getTimeGame() {
        return timeGame;
    }

    public void setTimeGame(long timeGame) {
        this.timeGame = timeGame;
    }
}
