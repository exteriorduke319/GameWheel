import java.util.ArrayList;

public class Game {
    public static void play(GameWheel g) {
        ArrayList<Slice> prizes = new ArrayList<Slice>();
        boolean doublePrize = false;
        int prizeMoney = 0;

        for (int i = 0; i < 3; i++) {
            prizes.add(g.spinWheel());
            prizeMoney += prizes.get(i).getPrizeAmount();
        }


        System.out.println("Total prize money: $" + prizeMoney);

        System.out.println("Spin 1 - " + prizes.get(0).toString());
        System.out.println("Spin 2 - " + prizes.get(1).toString());
        System.out.println("Spin 3 - " + prizes.get(2).toString());

        if (prizes.get(0).getColor() == prizes.get(1).getColor() && prizes.get(1).getColor() == prizes.get(2).getColor()) {
            doublePrize = true;
            System.out.println("Three " + prizes.get(0).getColor() + "s!  Double your money!  You win $" + prizeMoney*2);
        }
    }
}
