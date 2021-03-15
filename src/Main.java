import java.util.Scanner;

public class Main {

    private static Ball[][] balls;

    public static void main(String[] args) throws Exception {
        System.out.print("Введите Имя первого игрока, он будет играть за белых : ");
        Scanner in = new Scanner(System.in);
        String firstName = in.nextLine();
        System.out.print("\nВведите Имя второго игрока, он будет играть за чёрных : ");
        String secondName = in.nextLine();

        Board board = new Board();
        Matrix matrix = new Matrix(board.getMatrix().getRows(), board.getMatrix().getColumns());
        balls = matrix.matrixArray();
        ChildBoard firstChildBoard = new ChildBoard();
        ChildBoard secondChildBoard = new ChildBoard();
        ChildBoard thirdChildBoard = new ChildBoard();
        ChildBoard fourthChildBoard = new ChildBoard();

        Player firstPlayer = new Player(Color.White, firstName, true);
        Player secondPlayer = new Player(Color.Black, secondName, false);

        Painter painter = new Painter();
        painter.Draw(board);

        while (!board.FindFirstIterationForCheck(firstPlayer.getColor(), balls)
                && !board.FindFirstIterationForCheck(secondPlayer.getColor(), balls)) {
            if (firstPlayer.getTurn()) {
                DeterminePlayer(firstPlayer, secondPlayer,
                        firstChildBoard, secondChildBoard, thirdChildBoard, fourthChildBoard);
            } else if (secondPlayer.getTurn()) {
                DeterminePlayer(secondPlayer, firstPlayer,
                        firstChildBoard, secondChildBoard, thirdChildBoard, fourthChildBoard);
            }
        }
        End end;
        if (board.FindFirstIterationForCheck(firstPlayer.getColor(), balls)) {
            end = new End(EndingSituation.FirstPlayer);
        } else if (board.FindFirstIterationForCheck(secondPlayer.getColor(), balls)) {
            end = new End(EndingSituation.SecondPlayer);
        } else {
            end = new End(EndingSituation.Drawn);
        }
        end.DrawEndWithWin(firstPlayer, secondPlayer);
    }

    public static void DeterminePlayer(Player currentPlayer, Player otherPlayer,
                                       ChildBoard firstChildBoard,
                                       ChildBoard secondChildBoard,
                                       ChildBoard thirdChildBoard,
                                       ChildBoard fourthChildBoard) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println(currentPlayer.getName() + ", выберите одно из четырёх полей");
        int currentChildBoard = in.nextInt();

        while (currentChildBoard > 4 || currentChildBoard < 1) {
            System.out.println(currentPlayer.getName() + "Такого поля не существует, выберите другое!");
            System.out.println(currentPlayer.getName() + ", выберите одно из четырёх полей");
            currentChildBoard = in.nextInt();
        }

        switch (currentChildBoard) {
            case 1 -> MakeMove(firstChildBoard, currentPlayer, otherPlayer,
                    firstChildBoard, secondChildBoard, thirdChildBoard, fourthChildBoard);
            case 2 -> MakeMove(secondChildBoard, currentPlayer, otherPlayer,
                    firstChildBoard, secondChildBoard, thirdChildBoard, fourthChildBoard);
            case 3 -> MakeMove(thirdChildBoard, currentPlayer, otherPlayer,
                    firstChildBoard, secondChildBoard, thirdChildBoard, fourthChildBoard);
            case 4 -> MakeMove(fourthChildBoard, currentPlayer, otherPlayer,
                    firstChildBoard, secondChildBoard, thirdChildBoard, fourthChildBoard);
            default -> throw new Exception("Not Exist!");
        }
    }

    public static void MakeMove(ChildBoard childBoard,
                                Player currentPlayer, Player otherPlayer,
                                ChildBoard firstChildBoard,
                                ChildBoard secondChildBoard,
                                ChildBoard thirdChildBoard,
                                ChildBoard fourthChildBoard) {
        Scanner in = new Scanner(System.in);
        Painter painter = new Painter();
        painter.Draw(childBoard);

        System.out.println("В какой столбик поставить шарик?");
        int column = in.nextInt();
        System.out.println("В какую строку поставить шарик?");
        int row = in.nextInt();

        while (column > 3 || row > 3
                || childBoard.getBalls()[column - 1][row - 1].getColor() != Color.None) {
            System.out.println(currentPlayer.getName() + " сюда нельзя поставить, выберете другое место!");
            System.out.println("В какой столбик поставить шарик?");
            column = in.nextInt();
            System.out.println("В какую строку поставить шарик?");
            row = in.nextInt();
        }

        childBoard.addBall(new Ball(currentPlayer.getColor(), column - 1, row - 1));
        painter.Draw(childBoard);

        Board board = addBallsInBoard(firstChildBoard, secondChildBoard,
                thirdChildBoard, fourthChildBoard);
        if (!board.FindFirstIterationForCheck(currentPlayer.getColor(), balls)) {
            System.out.println("В какую сторону повернуть поле? (1-влево, 2-вправо)");
            int dirNumber = in.nextInt();

            while (dirNumber > 2 || dirNumber < 1) {
                System.out.println("Такого направления нет, выберите другой!");
                System.out.println(currentPlayer.getName() + "В какую сторону повернуть поле? (1-влево, 2-вправо)");
                dirNumber = in.nextInt();
            }

            if (dirNumber == 1) {
                childBoard.flip(Dir.Left);
            } else {
                childBoard.flip(Dir.Right);
            }
            currentPlayer.setTurn(false);
            otherPlayer.setTurn(true);
            board = addBallsInBoard(firstChildBoard, secondChildBoard,
                    thirdChildBoard, fourthChildBoard);
            painter.Draw(board);
        }
    }


    public static Board addBallsInBoard(ChildBoard board1, ChildBoard board2,
                                        ChildBoard board3, ChildBoard board4) {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                AddBallsFromChildBoard(board, board1, board2, board3, board4, i, j);
            }
        }
        balls = board.getBalls();
        return board;
    }

    public static void AddBallsFromChildBoard(Board board, ChildBoard board1, ChildBoard board2,
                                              ChildBoard board3, ChildBoard board4, int i, int j) {
        board.addBall(new Ball(board1.getBalls()[i][j].getColor(), i, j));
        board.addBall(new Ball(board2.getBalls()[i][j].getColor(), i, j + 3));
        board.addBall(new Ball(board3.getBalls()[i][j].getColor(), i + 3, j));
        board.addBall(new Ball(board4.getBalls()[i][j].getColor(), i + 3, j + 3));
    }
}