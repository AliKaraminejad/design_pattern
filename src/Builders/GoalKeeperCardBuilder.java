package Builders;

import Models.GoalKeeperCard;

public class GoalKeeperCardBuilder implements CardBuilder{

    private String name;
    private String nationality;
    private int diving;
    private int handling;
    private int reflex;
    private int positioning;
    private int kicking;
    private int speed;

    public String getName() {
        return name;
    }
    public String getNationality() {
        return nationality;
    }

    public int[] getFeatures() {
        int[] features = new int[6];
        features[0] = diving;
        features[1] = handling;
        features[2] = reflex;
        features[3] = positioning;
        features[4] = kicking;
        features[5] = speed;
        return features;
    }


    @Override
    public void reset() {
        this.name = null;
        this.nationality = null;
        this.diving = 0;
        this.handling = 0;
        this.reflex = 0;
        this.positioning = 0;
        this.kicking = 0;
        this.speed = 0;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public void setFeatures(int[] features) {
        this.diving = features[0];
        this.handling = features[1];
        this.reflex = features[2];
        this.positioning = features[3];
        this.kicking = features[4];
        this.speed = features[5];
    }

    public void getResult() {
        new GoalKeeperCard(this);
    }
}
