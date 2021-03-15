public class End {

    private EndingSituation endingSituation;

    private final Cleaner cleaner = new Cleaner();

    public End(EndingSituation endingSituation) {
        setEndingSituation(endingSituation);
    }

    public void setEndingSituation(EndingSituation endingSituation) {
        this.endingSituation = endingSituation;
    }

    public void DrawEndWithWin(Player firstPlayer, Player secondPlayer) {
        switch (endingSituation) {
            case FirstPlayer -> {
                cleaner.Clear(10);
                System.out.println(firstPlayer.getName() + " ПОБЕДИЛ!!!");
                System.out.println("-----------------------------");
            }
            case SecondPlayer -> {
                cleaner.Clear(10);
                System.out.println(secondPlayer.getName() + " ПОБЕДИЛ!!!");
                System.out.println("-----------------------------");
            }
            case Drawn -> {
                cleaner.Clear(10);
                System.out.println("НИЧЬЯ!");
                System.out.println("-----------------------------");
            }
        }
    }


}
