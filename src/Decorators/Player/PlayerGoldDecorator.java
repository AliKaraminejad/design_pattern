package Decorators.Player;

import Builders.PlayerCardBuilder;
import Director.Director;
import Models.PlayerCard;

public class PlayerGoldDecorator extends PlayerCard {

    public static PlayerGoldDecorator decorate(PlayerCardBuilder builder) {
        PlayerCardBuilder newBuilder = new PlayerCardBuilder();
        int[] features = builder.getFeatures();
        features[0] += 3;
        features[1] += 0;
        features[2] += 3;
        features[3] += 4;
        features[4] += 3;
        features[5] += 1;
        for(int i = 0; i < 6; i++) {
            if(features[i] > 99) {
                features[i] = 99;
            }
        }
        Director.makePlayerBuilder(newBuilder, builder.getName(), builder.getNationality(), features);
        return new PlayerGoldDecorator(newBuilder);
    }

    private PlayerGoldDecorator(PlayerCardBuilder builder) {
        super(builder);
    }

}
