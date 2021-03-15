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

    public Boolean FindFirstIterationForCheck(Color color, Ball[][] balls) {
        Boolean result = false;
        int countDirs = 0;
        for (var i = 0; i < matrix.getColumns(); i++) {
            for (var j = 0; j < matrix.getRows(); j++) {
                if (balls[i][j].getColor() == color) {
                    countDirs++;
                    result = CheckForWin(balls, i, j, 1, color);
                }
            }
        }
        if(countDirs==36 && result==false) {
            End end = new End(null);
            end.DrawDrawn();
        }
        return result;
    }

    public Boolean CheckForWin(Ball[][] balls, int y, int x, int count, Color color) {

        if (x<5 && balls[y][x + 1].getColor() == color) {
            CheckForWin(balls, y, x + 1, count + 1, color, Dir.Right);
        }
        else if (x>0 && balls[y][x - 1].getColor() == color) {
            CheckForWin(balls, y, x - 1, count + 1, color, Dir.Left);
        }
        else if (y<5 && balls[y+1][x].getColor() == color) {
            CheckForWin(balls, y + 1, x, count + 1, color, Dir.Up);
        }
        else if (y>0 && balls[y-1][x].getColor() == color) {
            CheckForWin(balls, y - 1, x, count + 1, color, Dir.Down);
        }
        return count >= 5;
    }

    public Boolean CheckForWin(Ball[][] balls, int y, int x, int count, Color color, Dir dir) {

        if (x<5 && balls[y][x + 1].getColor() == color && dir==Dir.Right) {
            CheckForWin(balls, y, x + 1, count + 1, color);
        }
        if (x>0 && balls[y][x - 1].getColor() == color&& dir==Dir.Left) {
            CheckForWin(balls, y, x - 1, count + 1, color);
        }
        if (y<5 && balls[y+1][x].getColor() == color&& dir==Dir.Up) {
            CheckForWin(balls, y + 1, x, count + 1, color);
        }
        if (y>0 && balls[y-1][x].getColor() == color&& dir==Dir.Down) {
            CheckForWin(balls, y - 1, x, count + 1, color);
        }
        return count >= 5;
    }

}
