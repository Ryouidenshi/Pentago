import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.print("Введите Имя первого игрока, он будет играть за белых : ");
        Scanner in = new Scanner(System.in);
        String firstName = in.nextLine();
        System.out.print("\nВведите Имя второго игрока, он будет играть за чёрных : ");
        String secondName = in.nextLine();

        Board board = new Board();
        ChildBoard firstChildBoard = new ChildBoard(1);
        ChildBoard secondChildBoard = new ChildBoard(2);
        ChildBoard thirdChildBoard = new ChildBoard(3);
        ChildBoard fourthChildBoard = new ChildBoard(4);

        Painter painter = new Painter(board);
        PainterChild painterChild = new PainterChild();
        painter.Draw();

        Player firstPlayer = new Player(Color.White, 1, firstName);
        Player secondPlayer = new Player(Color.Black, 2, secondName);

        int indexPlayer = 1;

        while(!board.FindFirstIterationForCheck(firstPlayer.getColor())
                || !board.FindFirstIterationForCheck(secondPlayer.getColor())) {
            if(indexPlayer==1) {
                System.out.println("Первый игрок, выберите одно из четырёх полей");
                int currentChildBoard = in.nextInt();
                if(currentChildBoard==1){
                    painterChild.Draw(firstChildBoard);
                    System.out.println("В какой столбик поставить шарик?");
                    Integer column = in.nextInt();
                    System.out.println("В какую строку поставить шарик?");
                    Integer row = in.nextInt();
                    firstChildBoard.addBall(new Ball(Color.White, column-1, row-1));
                    painterChild.Draw(firstChildBoard);
                    System.out.println("В какую сторону повернуть поле? (1-влево, 2-вправо)");
                    int dirNumber = in.nextInt();
                    if (dirNumber==1) {
                        firstChildBoard.flip(Dir.Left);
                    }
                    else if (dirNumber==2) {
                        firstChildBoard.flip(Dir.Right);
                    }
                    painterChild.Draw(firstChildBoard);
                    board=addBallsInBoard(board, firstChildBoard);
                    indexPlayer=2;
                    painter.Draw();
                }
                else if(indexPlayer==2) {
                    indexPlayer=1;
                }
            }
        }
    }

    public static Board addBallsInBoard(Board board, ChildBoard childBoard) {
        if(childBoard.getNumber()==1) {
            for(int i=0 ; i < 3;i++) {
                for (int j=0; j<3; j++){
                    if(childBoard.getBalls()[i][j].getColor() != Color.None && i==0 && j==0) {
                        board.addBall(new Ball(childBoard.getBalls()[i][j].getColor(),i,j));
                    }
                    if(childBoard.getBalls()[i][j].getColor() != Color.None && i==0 && j==1) {
                        board.addBall(new Ball(childBoard.getBalls()[i][j].getColor(),i,j));
                    }
                    if(childBoard.getBalls()[i][j].getColor() != Color.None && i==0 && j==2) {
                        board.addBall(new Ball(childBoard.getBalls()[i][j].getColor(),i,j));
                    }
                    if(childBoard.getBalls()[i][j].getColor() != Color.None && i==1 && j==0) {
                        board.addBall(new Ball(childBoard.getBalls()[i][j].getColor(),i,j));
                    }
                    if(childBoard.getBalls()[i][j].getColor() != Color.None && i==1 && j==1) {
                        board.addBall(new Ball(childBoard.getBalls()[i][j].getColor(),i,j));
                    }
                    if(childBoard.getBalls()[i][j].getColor() != Color.None && i==1 && j==2) {
                        board.addBall(new Ball(childBoard.getBalls()[i][j].getColor(),i,j));
                    }
                    if(childBoard.getBalls()[i][j].getColor() != Color.None && i==2 && j==0) {
                        board.addBall(new Ball(childBoard.getBalls()[i][j].getColor(),i,j));
                    }
                    if(childBoard.getBalls()[i][j].getColor() != Color.None && i==2 && j==1) {
                        board.addBall(new Ball(childBoard.getBalls()[i][j].getColor(),i,j));
                    }
                    if(childBoard.getBalls()[i][j].getColor() != Color.None && i==2 && j==2) {
                        board.addBall(new Ball(childBoard.getBalls()[i][j].getColor(),i,j));
                    }
                }
            }
        }
        return board;
    }
}
