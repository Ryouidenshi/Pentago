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
                if(balls[i][j].getColor()== Color.None) {
                    System.out.print('☐' + " ");
                }

                if(balls[i][j].getColor()== Color.Black) {
                    System.out.print('●' + " ");
                }

                if(balls[i][j].getColor()== Color.White) {
                    System.out.print('○' + " ");
                }

                if (j + 1 == board.getMatrix().getRows()) {
                    System.out.println();
                }
            }
        }
    }
}
