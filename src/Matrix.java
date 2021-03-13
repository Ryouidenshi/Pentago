import java.lang.reflect.Array;

public class Matrix {

    private int rows;
    private int columns;

    public Matrix(int rows, int columns) {
        setColumns(columns);
        setRows(rows);
    }


    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Ball[][] matrixArray() {
        Ball[][] arr = (Ball[][]) Array.newInstance(Ball.class, rows, columns);
        for (var i = 0; i < columns; i++) {
            for (var j = 0; j < rows; j++) {
                arr[i][j] = null;
            }
        }
        return arr;
    }
}
