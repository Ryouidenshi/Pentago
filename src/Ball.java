public class Ball {

    private Color color;
    private int column;
    private int row;

    public Ball(Color color, int column, int row) {
        setColor(color);
        setColumn(column);
        setRow(row);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}

