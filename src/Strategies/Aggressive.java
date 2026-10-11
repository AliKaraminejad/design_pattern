package Strategies;

public class Aggressive implements PlayStyle {
    @Override
    public int getOverall(int[] features) {
        int sum = 0;
        for(int i = 0; i < 3; i++) {
            sum += features[i];
        }
        return sum / 3;
    }

    @Override
    public String toString() {
        return "aggressive";
    }
}
