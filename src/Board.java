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
        Balls[ball.getColumn()][ball.getRow()] = ball;
    }

    public Boolean FindFirstIterationForCheck(Color color, Ball[][] balls) {
        Boolean result;
        for (var i = 0; i < matrix.getColumns(); i++) {
            for (var j = 0; j < matrix.getRows(); j++) {
                if (balls[i][j].getColor() == color) {
                    result = CheckForWin(balls, i, j, 1, color);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Boolean CheckForWin(Ball[][] balls, int y, int x, int count, Color color) {

        if (count < 5 && x < 5 && balls[y][x + 1].getColor() == color) {
            count = 0;
            count = CheckForWin(balls, y, x + 1, count + 1, color, Dir.Right);
        }
        if (count < 5 && x > 0 && balls[y][x - 1].getColor() == color) {
            count = 0;
            count = CheckForWin(balls, y, x - 1, count + 1, color, Dir.Left);
        }
        if (count < 5 && y < 5 && balls[y + 1][x].getColor() == color) {
            count = 0;
            count = CheckForWin(balls, y + 1, x, count + 1, color, Dir.Down);
        }
        if (count < 5 && y > 0 && balls[y - 1][x].getColor() == color) {
            count = 0;
            count = CheckForWin(balls, y - 1, x, count + 1, color, Dir.Up);
        }
        if (count < 5 && y > 0 && x < 5 && balls[y - 1][x + 1].getColor() == color) {
            count = 0;
            count = CheckForWin(balls, y - 1, x + 1, count + 1, color, Dir.RightUpDiagonal);
        }
        if (count < 5 && y > 0 && x > 0 && balls[y - 1][x - 1].getColor() == color) {
            count = 0;
            count = CheckForWin(balls, y - 1, x - 1, count + 1, color, Dir.LeftUpDiagonal);
        }
        if (count < 5 && x > 0 && y < 5 && balls[y + 1][x - 1].getColor() == color) {
            count = 0;
            count = CheckForWin(balls, y + 1, x - 1, count + 1, color, Dir.LeftDownDiagonal);
        }
        if (count < 5 && x < 5 && y < 5 && balls[y + 1][x + 1].getColor() == color) {
            count = 0;
            count = CheckForWin(balls, y + 1, x + 1, count + 1, color, Dir.RightDownDiagonal);
        }
        return count >= 5;
    }

    public int CheckForWin(Ball[][] balls, int y, int x, int count, Color color, Dir dir) {

        if (x < 5 && balls[y][x + 1].getColor() == color && dir == Dir.Right) {
            count = CheckForWin(balls, y, x + 1, count + 1, color, Dir.Right);
        }
        if (x > 0 && balls[y][x - 1].getColor() == color && dir == Dir.Left) {
            count = CheckForWin(balls, y, x - 1, count + 1, color, Dir.Left);
        }
        if (y < 5 && balls[y + 1][x].getColor() == color && dir == Dir.Down) {
            count = CheckForWin(balls, y + 1, x, count + 1, color, Dir.Down);
        }
        if (y > 0 && balls[y - 1][x].getColor() == color && dir == Dir.Up) {
            count = CheckForWin(balls, y - 1, x, count + 1, color, Dir.Up);
        }
        if (count < 5 && y > 0 && x < 5 && balls[y - 1][x + 1].getColor() == color && dir == Dir.RightUpDiagonal) {
            count = CheckForWin(balls, y - 1, x + 1, count + 1, color, Dir.RightUpDiagonal);
        }
        if (count < 5 && y > 0 && x > 0 && balls[y - 1][x - 1].getColor() == color && dir == Dir.LeftUpDiagonal) {
            count = CheckForWin(balls, y - 1, x - 1, count + 1, color, Dir.LeftUpDiagonal);
        }
        if (count < 5 && x > 0 && y < 5 && balls[y + 1][x - 1].getColor() == color && dir == Dir.LeftDownDiagonal) {
            count = CheckForWin(balls, y + 1, x - 1, count + 1, color, Dir.LeftDownDiagonal);
        }
        if (count < 5 && x < 5 && y < 5 && balls[y + 1][x + 1].getColor() == color && dir == Dir.RightDownDiagonal) {
            count = CheckForWin(balls, y + 1, x + 1, count + 1, color, Dir.RightDownDiagonal);
        }
        return count;
    }
}
