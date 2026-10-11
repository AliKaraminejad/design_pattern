package Decorators.Player;

import Builders.PlayerCardBuilder;
import Director.Director;
import Models.PlayerCard;

public class PlayerHeroDecorator extends PlayerCard {

    public static PlayerHeroDecorator decorate(PlayerCardBuilder builder) {
        PlayerCardBuilder newBuilder = new PlayerCardBuilder();
        int[] features = builder.getFeatures();
        features[0] += 4;
        features[1] += 2;
        features[2] += 2;
        features[3] += 1;
        features[4] += 1;
        features[5] += 2;
        for(int i = 0; i < 6; i++) {
            if(features[i] > 99) {
                features[i] = 99;
            }
        }
        Director.makePlayerBuilder(newBuilder, builder.getName(), builder.getNationality(), features);
        return new PlayerHeroDecorator(newBuilder);
    }

    private PlayerHeroDecorator(PlayerCardBuilder builder) {
        super(builder);
    }

}
