public class PainterChild {

    public void Draw(ChildBoard childBoard) {
        Ball[][] balls = childBoard.getBalls();
        for (int i = 0; i < childBoard.getMatrix().getColumns(); i++) {
            for (int j = 0; j < childBoard.getMatrix().getRows(); j++) {
                if(balls[i][j].getColor()== Color.None) {
                    System.out.print('☐' + " ");
                }

                if(balls[i][j].getColor()== Color.Black) {
                    System.out.print('●' + " ");
                }

                if(balls[i][j].getColor()== Color.White) {
                    System.out.print('○' + " ");
                }

                if (j + 1 == childBoard.getMatrix().getRows()) {
                    System.out.println();
                }
            }
        }
    }
}
