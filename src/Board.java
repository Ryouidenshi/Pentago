public class Board {

    private final Matrix matrix = new Matrix(6, 6);
    private final Ball[][] Balls = matrix.matrixArray();

    public Ball[][] getBalls() {
        return Balls;
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void addBall(Ball ball) {
        if (Balls[ball.getColumn()][ball.getRow()].getColor() == Color.None) {
            Balls[ball.getColumn()][ball.getRow()] = ball;
        }
        else {
            System.out.println("Эта ячейка уже занята, выберите другую");
        }
    }

    public Boolean FindFirstIterationForCheck(Color color) {
        Boolean result = false;
        //for (var i = 0; i < matrix.getColumns(); i++) {
            //for (var j = 0; j < matrix.getRows()-1; j++) {
                //if (Balls[i][j] != null && Balls[i][j].getColor() == color)
                    //result = CheckForWin(i, j, 1, color);
            //}
        //}
        return false;
    }

    public Boolean CheckForWin(int y, int x, int count, Color color) {

        if (Balls[y][x + 1] != null && Balls[y][x + 1].getColor() == color) {
            CheckForWin(y, x + 1, count + 1, color);
        }
        if (Balls[y][x - 1] != null && Balls[y][x + 1].getColor() == color) {
            CheckForWin(y, x - 1, count + 1, color);
        }
        if (Balls[y + 1][x] != null && Balls[y][x + 1].getColor() == color) {
            CheckForWin(y + 1, x, count + 1, color);
        }
        if (Balls[y - 1][x] != null && Balls[y][x + 1].getColor() == color) {
            CheckForWin(y - 1, x, count + 1, color);
        }
        return count >= 6;
    }

}
