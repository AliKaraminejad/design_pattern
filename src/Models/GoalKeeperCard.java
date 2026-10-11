package Models;

import Builders.GoalKeeperCardBuilder;

import java.util.ArrayList;

public class GoalKeeperCard extends Card{

    private final static ArrayList<GoalKeeperCard> allCards = new ArrayList<>();

    private final int diving;
    private final int handling;
    private final int reflex;
    private final int positioning;
    private final int kicking;
    private final int speed;

    public GoalKeeperCard(GoalKeeperCardBuilder builder) {
        this.name = builder.getName();
        this.nationality = builder.getNationality();
        this.features = builder.getFeatures();
        this.diving = features[0];
        this.handling = features[1];
        this.reflex = features[2];
        this.positioning = features[3];
        this.kicking = features[4];
        this.speed = features[5];
        allCards.add(this);
    }

    public static GoalKeeperCard getGoalKeeperCardByName(String name) {
        for(GoalKeeperCard card : allCards) {
            if(card.getName().equals(name)) {
                return card;
            }
        }
        return null;
    }

    @Override
    public int getOverall() {
        int sum = 0;
        for(int feature : features) {
            sum += feature;
        }
        return sum / 6;
    }
}
