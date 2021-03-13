public class Board {

    private final Matrix matrix = new Matrix(6, 6);
    private Ball[][] Balls = matrix.matrixArray();

    public Board(Ball[][] balls) {
        setBalls(balls);
    }

    public Ball[][] getBalls() {
        return Balls;
    }

    public void setBalls(Ball[][] balls) {
        Balls = balls;
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void addBall(Ball ball) {
        if (Balls[ball.getColumn()][ball.getRow()] == null) {
            Balls[ball.getColumn()][ball.getRow()] = ball;
        }
    }

    public Boolean FindFirstIterationForCheck(Ball.Color color) {
        Boolean result = false;
        for (var i = 0; i < matrix.getColumns(); i++) {
            for (var j = 0; j < matrix.getRows(); j++) {
                if (Balls[i][j] != null && Balls[i][j].getColor() == color)
                    result = CheckForWin(i, j, 1, color);
            }
        }
        return result;
    }

    public Boolean CheckForWin(int y, int x, int count, Ball.Color color) {

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
