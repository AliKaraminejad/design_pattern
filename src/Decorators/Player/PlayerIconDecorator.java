package Decorators.Player;

import Builders.PlayerCardBuilder;
import Director.Director;
import Models.PlayerCard;

public class PlayerIconDecorator extends PlayerCard {

    public static PlayerIconDecorator decorate(PlayerCardBuilder builder) {
        PlayerCardBuilder newBuilder = new PlayerCardBuilder();
        int[] features = builder.getFeatures();
        features[0] += 5;
        features[1] += 3;
        features[2] += 2;
        features[3] += 0;
        features[4] += 2;
        features[5] += 5;
        for(int i = 0; i < 6; i++) {
            if(features[i] > 99) {
                features[i] = 99;
            }
        }
        Director.makePlayerBuilder(newBuilder, builder.getName(), builder.getNationality(), features);
        return new PlayerIconDecorator(newBuilder);
    }

    private PlayerIconDecorator(PlayerCardBuilder builder) {
        super(builder);
    }

}
