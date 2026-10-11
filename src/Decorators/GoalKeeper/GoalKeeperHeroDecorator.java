package Decorators.GoalKeeper;

import Builders.GoalKeeperCardBuilder;
import Director.Director;
import Models.GoalKeeperCard;

public class GoalKeeperHeroDecorator extends GoalKeeperCard {

    public static GoalKeeperHeroDecorator decorate(GoalKeeperCardBuilder builder) {
        GoalKeeperCardBuilder newBuilder = new GoalKeeperCardBuilder();
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
        Director.makeGoalKeeperBuilder(newBuilder, builder.getName(), builder.getNationality(), features);
        return new GoalKeeperHeroDecorator(newBuilder);
    }

    private GoalKeeperHeroDecorator(GoalKeeperCardBuilder builder) {
        super(builder);
    }

}
