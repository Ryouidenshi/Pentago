public class End {
    private Player winner;

    public End(Player winner) {
        setWinnde(winner);
    }

    public void setWinnde(Player winner) {
        this.winner = winner;
    }

    public void DrawEndWithWin() {
        Cleaner cleaner = new Cleaner();
        cleaner.Clear(10);
        System.out.println(winner.getName() + "ПОБЕДИЛ!!!");
    }

    public void DrawDrawn() {
        Cleaner cleaner = new Cleaner();
        cleaner.Clear(10);
        System.out.println("Никто не выиграл :(");
    }
}
