public class ChildBoard {

    private final Matrix matrix = new Matrix(3, 3);

    private Ball[][] Balls = matrix.matrixArray();

    public Ball[][] getBalls() {
        return Balls;
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void addBall(Ball ball) throws Exception {
        if (Balls[ball.getColumn()][ball.getRow()].getColor() == Color.None) {
            Balls[ball.getColumn()][ball.getRow()] = ball;
        }
        else {
           throw new Exception("Поле уже занято!");
        }
    }

    public void flip(Dir dir) {
        Ball[][] balls = new Matrix(matrix.getRows(), matrix.getColumns()).matrixArray();
        for (int i = 0; i < matrix.getColumns(); i++) {
            for (int j = 0; j < matrix.getRows(); j++) {
                if (Balls[i][j].getColor() != Color.None) {

                    if (i == 0 && j == 0 && dir == Dir.Right) {
                        balls[i][j + 2] = Balls[i][j];
                    }

                    if (i == 0 && j == 1 && dir == Dir.Right) {
                        balls[i + 1][j + 1] = Balls[i][j];
                    }

                    if (i == 0 && j == 2 && dir == Dir.Right) {
                        balls[i+1][j] = Balls[i][j];
                    }

                    if (i == 1 &&  j==0 && dir == Dir.Right) {
                        balls[i-1][j+1] = Balls[i][j];
                    }

                    if (i == 1 &&  j==1 && dir == Dir.Right) {
                        balls[i][j] = Balls[i][j];
                    }

                    if (i == 1 &&  j==2 && dir == Dir.Right) {
                        balls[i+1][j-1] = Balls[i][j];
                    }

                    if (i == 2 && j == 0 && dir == Dir.Right) {
                        balls[i - 2][j] = Balls[i][j];
                    }

                    if (i == 2 && j == 1 && dir == Dir.Right) {
                        balls[i - 1][j - 1] = Balls[i][j];
                    }

                    if (i == 2 && j == 2 && dir == Dir.Right) {
                        balls[i][j-2] = Balls[i][j];
                    }

                    if (i == 0 && j == 0 && dir == Dir.Left) {
                        balls[i+2][j] = Balls[i][j];
                    }

                    if (i == 0 && j == 1 && dir == Dir.Left) {
                        balls[i+1][j-1] = Balls[i][j];
                    }

                    if (i == 0 && j == 2 && dir == Dir.Left) {
                        balls[i][j - 2] = Balls[i][j];
                    }

                    if (i == 1 && j == 0 && dir == Dir.Left) {
                        balls[i + 1][j + 1] = Balls[i][j];
                    }

                    if (i == 1 && j == 1 && dir == Dir.Left) {
                        balls[i][j] = Balls[i][j];
                    }

                    if (i == 1 && j == 2 && dir == Dir.Left) {
                        balls[i - 1][j - 1] = Balls[i][j];
                    }
                    if (i == 2 && j == 0 && dir == Dir.Left) {
                        balls[i][j+2] = Balls[i][j];
                    }

                    if (i == 2 && j == 1 && dir == Dir.Left) {
                        balls[i - 1][j + 1] = Balls[i][j];
                    }

                    if (i == 2 && j == 2 && dir == Dir.Left) {
                        balls[i-2][j] = Balls[i][j];
                    }
                }
            }
        }
        Balls = balls;
    }
}
