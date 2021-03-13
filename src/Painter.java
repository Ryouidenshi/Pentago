public class Painter {

    private Board board;

    public Painter(Board board) {
        setBoard(board);
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void Draw() {
        Ball[][] balls = board.getBalls();
        for (int i = 0; i < board.getMatrix().getColumns(); i++) {
            for (int j = 0; j < board.getMatrix().getRows(); j++) {
                System.out.print(balls[i][j] + " ");
                if (j + 1 == board.getMatrix().getRows()) {
                    System.out.println();
                }
            }
        }
    }
}
