package Strategies;

public class Defensive implements PlayStyle {
    @Override
    public int getOverall(int[] features) {
        int sum = 0;
        for(int i = 3; i < 6; i++) {
            sum += features[i];
        }
        return sum / 3;
    }

    @Override
    public String toString() {
        return "defensive";
    }
}
