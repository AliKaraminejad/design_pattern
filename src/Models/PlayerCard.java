package Models;

import Builders.PlayerCardBuilder;
import Strategies.Balanced;
import Strategies.PlayStyle;

import java.util.ArrayList;

public class PlayerCard extends Card {

    private final static ArrayList<PlayerCard> allCards = new ArrayList<>();

    private final int shooting;
    private final int pace;
    private final int dribbling;
    private final int physic;
    private final int passing;
    private final int defending;

    private PlayStyle playStyle = new Balanced();

    public PlayerCard(PlayerCardBuilder builder) {
        this.name = builder.getName();
        this.nationality = builder.getNationality();
        this.features = builder.getFeatures();
        this.shooting = features[0];
        this.pace = features[1];
        this.dribbling = features[2];
        this.physic = features[3];
        this.passing = features[4];
        this.defending = features[5];
        allCards.add(this);
    }

    public static PlayerCard getPlayerCardByName(String name) {
        for(PlayerCard card : allCards) {
            if(card.getName().equals(name)) {
                return card;
            }
        }
        return null;
    }

    public void setPlayStyle(PlayStyle playStyle) {
        this.playStyle = playStyle;
    }

    @Override
    public int getOverall() {
        return playStyle.getOverall(features);
    }

    @Override
    public String toString() {
        String output = super.toString();
        output += " " + playStyle;
        return output;
    }
}
