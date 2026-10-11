package Builders;

import Models.PlayerCard;

public class PlayerCardBuilder implements CardBuilder {

    private String name;
    private String nationality;
    private int shooting;
    private int pace;
    private int dribbling;
    private int physic;
    private int passing;
    private int defending;

    public String getName() {
        return name;
    }
    public String getNationality() {
        return nationality;
    }

    public int[] getFeatures() {
        int[] features = new int[6];
        features[0] = shooting;
        features[1] = pace;
        features[2] = dribbling;
        features[3] = physic;
        features[4] = passing;
        features[5] = defending;
        return features;
    }


    @Override
    public void reset() {
        name = null;
        nationality = null;
        shooting = 0;
        pace = 0;
        dribbling = 0;
        physic = 0;
        passing = 0;
        defending = 0;
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
        this.shooting = features[0];
        this.pace = features[1];
        this.dribbling = features[2];
        this.physic = features[3];
        this.passing = features[4];
        this.defending = features[5];
    }

    public void getResult() {
        new PlayerCard(this);
    }
}
