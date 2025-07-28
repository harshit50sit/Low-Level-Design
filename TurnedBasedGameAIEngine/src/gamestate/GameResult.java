package gamestate;

public class GameResult {
    private boolean isOver = true;
    private String winner;

    public GameResult(boolean isOver, String winner) {
        this.isOver = isOver;
        this.winner = winner;
    }

    public boolean isOver() {
        return isOver;
    }

    public String getWinner(){
        return winner;
    }
    @Override
    public String toString(){
        return "GameResult{" +
                "isOver=" + isOver +
                ", winner='" + winner + '\'' +
                '}';
    }
}
