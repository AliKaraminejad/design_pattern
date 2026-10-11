package Decorators.Player;

import Builders.PlayerCardBuilder;
import Director.Director;
import Models.PlayerCard;

public class PlayerSilverDecorator extends PlayerCard {

    public static PlayerSilverDecorator decorate(PlayerCardBuilder builder) {
        PlayerCardBuilder newBuilder = new PlayerCardBuilder();
        int[] features = builder.getFeatures();
        features[0] += 2;
        features[1] += 2;
        features[2] += 4;
        features[3] += 2;
        features[4] += 3;
        features[5] += 1;
        for(int i = 0; i < 6; i++) {
            if(features[i] > 99) {
                features[i] = 99;
            }
        }
        Director.makePlayerBuilder(newBuilder, builder.getName(), builder.getNationality(), features);
        return new PlayerSilverDecorator(newBuilder);
    }

    private PlayerSilverDecorator(PlayerCardBuilder builder) {
        super(builder);
    }

}
