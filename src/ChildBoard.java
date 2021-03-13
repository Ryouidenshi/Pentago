public class ChildBoard {

    enum Dir {
        Right,
        Left
    }

    private final Matrix matrix = new Matrix(3, 3);
    private Ball[][] Balls = matrix.matrixArray();
    private int number; //1-4

    public ChildBoard(Ball[][] balls, int number) {
        setBalls(balls);
        setNumber(number);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Ball[][] getBalls() {
        return Balls;
    }

    public void setBalls(Ball[][] balls) {
        Balls = balls;
    }

    public void addBall(Ball ball) {
        if (Balls[ball.getColumn()][ball.getRow()] == null) {
            Balls[ball.getColumn()][ball.getRow()] = ball;
        }
    }

    public void flip(Dir dir) {
        Ball[][] balls = new Matrix(matrix.getRows(), matrix.getColumns()).matrixArray();
        for (int i = 0; i < matrix.getColumns(); i++) {
            for (int j = 0; i < matrix.getRows(); j++) {
                if (Balls[i][j] != null) {

                    if (i == 0 && j == 0 && dir == Dir.Right) {
                        balls[i][j + 2] = Balls[i][j];
                    }

                    if (i == 0 && j == 1 && dir == Dir.Right) {
                        balls[i + 1][j + 1] = Balls[i][j];
                    }

                    if (i == 0 && j == 2 && dir == Dir.Right) {
                        balls[i][j - 2] = Balls[i][j];
                    }

                    if (i == 1 && dir == Dir.Right) {
                        balls[j][i] = Balls[i][j];
                    }

                    if (i == 2 && j == 0 && dir == Dir.Right) {
                        balls[i - 2][j] = Balls[i][j];
                    }

                    if (i == 2 && j == 1 && dir == Dir.Right) {
                        balls[i - 1][j - 1] = Balls[i][j];
                    }

                    if (i == 2 && j == 2 && dir == Dir.Right) {
                        balls[i][j - 2] = Balls[i][j];
                    }

                    if (i == 0 && j == 0 && dir == Dir.Left) {
                        balls[i + 2][j] = Balls[i][j];
                    }

                    if (i == 0 && j == 1 && dir == Dir.Left) {
                        balls[j][i] = Balls[i][j];
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
                        balls[i - 2][j] = Balls[i][j];
                    }

                    if (i == 2 && j == 1 && dir == Dir.Left) {
                        balls[i - 1][j - 1] = Balls[i][j];
                    }

                    if (i == 2 && j == 2 && dir == Dir.Left) {
                        balls[i][j - 2] = Balls[i][j];
                    }
                }
            }
        }
        Balls = balls;
    }
}
