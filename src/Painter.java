public class Painter {

    public void Draw(Board board) {
        Cleaner cleaner = new Cleaner();
        Ball[][] balls = board.getBalls();
        cleaner.Clear(0);
        for (int i = 0; i < board.getMatrix().getColumns(); i++) {
            for (int j = 0; j < board.getMatrix().getRows(); j++) {
                HelpDraw(balls, i, j, null, board);
            }
        }
        cleaner.Clear(0);
    }

    public void Draw(ChildBoard childBoard) {
        Cleaner cleaner = new Cleaner();
        Ball[][] balls = childBoard.getBalls();
        cleaner.Clear(0);
        for (int i = 0; i < childBoard.getMatrix().getColumns(); i++) {
            for (int j = 0; j < childBoard.getMatrix().getRows(); j++) {
                HelpDraw(balls, i, j, childBoard, null);
            }
        }
        cleaner.Clear(0);
    }

    public void HelpDraw(Ball[][] balls, int i, int j, ChildBoard childBoard, Board board) {
        if (balls[i][j].getColor() == Color.None) {
            System.out.print('·' + " ");
        }

        if (balls[i][j].getColor() == Color.Black) {
            System.out.print('●' + " ");
        }

        if (balls[i][j].getColor() == Color.White) {
            System.out.print('○' + " ");
        }

        if (childBoard!=null && j + 1 == childBoard.getMatrix().getRows()) {
            System.out.println();
        }
        if (board!=null && j + 1 == board.getMatrix().getRows()) {
            System.out.println();
        }
    }
}
