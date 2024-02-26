import java.util.ArrayList;

public class GameWheel {
    private ArrayList<Slice> slices;
    private int currentPos;
    private ArrayList<Slice> red = new ArrayList<Slice>();
    private ArrayList<Slice> blue = new ArrayList<Slice>();
    private ArrayList<Slice> black = new ArrayList<Slice>();

    public GameWheel() {
        slices = new ArrayList<Slice>();
        for (int i = 0; i < 20; i++) {
            if (i % 5 == 0) {
                slices.add(new Slice("black", (1000*i)));
            } else if (i % 2 != 0) {
                slices.add(new Slice("red", (200*i)));
            } else {
                slices.add(new Slice("blue", (100*i)));
            }
        }
    }

    public String toString() {
        String sliceString = "";

        for (int i = 0; i < slices.size(); i++) {
            sliceString += i + " - " + slices.get(i).toString() + "\n";
        }

        return sliceString;
    }

    public void split() {
        for (int i = 0; i < slices.size(); i++) {
            if (slices.get(i).getColor().equals("black")) {
                black.add(slices.get(i));
            } else if (slices.get(i).getColor().equals("red")) {
                red.add(slices.get(i));
            } else {
                blue.add(slices.get(i));
            }
        }
    }

    public void scramble() {
        split();
        for (int i = 0; i < slices.size(); i++) {
            if (i % 5 == 0) {
                slices.set(i, black.remove((int)(Math.random() * black.size())));
            } else if (i % 2 == 0) {
                slices.set(i, blue.remove((int)(Math.random() * blue.size())));
            } else {
                slices.set(i, red.remove((int)(Math.random() * red.size())));
            }
        }
    }

    public void sort() {
        split();
        for (int i = 0; i < slices.size(); i++) {
            int lowest;
            if (i % 5 == 0) {
                lowest = 0;
                for (int j = 0; j < black.size(); j++) {
                    if(black.get(j).getPrizeAmount() < black.get(lowest).getPrizeAmount()){
                        lowest = j;
                    }
                }
                slices.set(i, black.get(lowest));
                black.remove(lowest);
            } else if (i % 2 == 0) {
                lowest = 0;
                for (int j = 0; j < blue.size(); j++) {
                    if(blue.get(j).getPrizeAmount() < blue.get(lowest).getPrizeAmount()){
                        lowest = j;
                    }
                }
                slices.set(i, blue.get(lowest));
                blue.remove(lowest);
            } else {
                lowest = 0;
                for (int j = 0; j < red.size(); j++) {
                    if(red.get(j).getPrizeAmount() < red.get(lowest).getPrizeAmount()){
                        lowest = j;
                    }
                }
                slices.set(i, red.get(lowest));
                red.remove(lowest);
            }

        }

    }

    public Slice spinWheel() {
        currentPos = (int)(Math.random() * 19) + 1;
        return slices.get(currentPos);
    }


    public Slice getSlice(int i) {
        if (i > 19 || i < 0) {
            return slices.get(0);
        } else {
            return slices.get(i);
        }
    }
}