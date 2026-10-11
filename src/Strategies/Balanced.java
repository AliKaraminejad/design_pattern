package Strategies;

public class Balanced implements PlayStyle {

    @Override
    public int getOverall(int[] features) {
        int sum = 0;
        for(int i = 0; i < 6; i++) {
            sum += features[i];
        }
        return sum / 6;
    }

    @Override
    public String toString() {
        return "balanced";
    }
}
