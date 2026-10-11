package Models;

public abstract class Card {
    protected String name;
    protected String nationality;
    protected int[] features;

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public int[] getFeatures() {
        return features;
    }

    public int getPrice() {
        int[] features = getFeatures();
        int sum = 0;
        for (int feature : features) {
            sum += feature;
        }
        sum /= 6;
        return sum * 10000000;
    }

    public abstract int getOverall();

    @Override
    public String toString() {
        int[] features = getFeatures();
        StringBuilder output = new StringBuilder();
        output.append(name).append(" ");
        output.append(nationality).append(" ");
        for (int feature : features) {
            output.append(feature).append(" ");
        }
        output.deleteCharAt(output.length() - 1);
        return output.toString();
    }

}
