package Decorators.Player;

import Builders.PlayerCardBuilder;
import Director.Director;
import Models.PlayerCard;

public class PlayerBronzeDecorator extends PlayerCard {

    public static PlayerBronzeDecorator decorate(PlayerCardBuilder builder) {
        PlayerCardBuilder newBuilder = new PlayerCardBuilder();
        int[] features = builder.getFeatures();
        features[0] += 0;
        features[1] += 1;
        features[2] += 3;
        features[3] += 0;
        features[4] += 0;
        features[5] += 2;
        for(int i = 0; i < 6; i++) {
            if(features[i] > 99) {
                features[i] = 99;
            }
        }
        Director.makePlayerBuilder(newBuilder, builder.getName(), builder.getNationality(), features);
        return new PlayerBronzeDecorator(newBuilder);
    }

    private PlayerBronzeDecorator(PlayerCardBuilder builder) {
        super(builder);
    }

}
