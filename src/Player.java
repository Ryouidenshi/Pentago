public class Player {

    private Color color;
    private String name;
    private Boolean turn;

    public Player(Color color, String name, Boolean turn) {
        setColor(color);
        setName(name);
        setTurn(turn);
    }

    public Boolean getTurn() {
        return turn;
    }

    public void setTurn(Boolean turn) {
        this.turn = turn;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
