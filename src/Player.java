public class Player {

    private int number;
    private Color color;
    private String name;

    public Player(Color color, int number, String name) {
        setColor(color);
        setNumber(number);
        setName(name);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
