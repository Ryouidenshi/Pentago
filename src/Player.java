import java.awt.*;

public class Player {

    private int number;
    private Color color;

    public Player(Color color, int number) {
        setColor(color);
        setNumber(number);
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
}
