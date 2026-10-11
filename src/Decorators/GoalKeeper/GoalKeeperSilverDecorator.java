package Decorators.GoalKeeper;

import Builders.GoalKeeperCardBuilder;
import Director.Director;
import Models.GoalKeeperCard;

public class GoalKeeperSilverDecorator extends GoalKeeperCard {

    public static GoalKeeperSilverDecorator decorate(GoalKeeperCardBuilder builder) {
        GoalKeeperCardBuilder newBuilder = new GoalKeeperCardBuilder();
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
        Director.makeGoalKeeperBuilder(newBuilder, builder.getName(), builder.getNationality(), features);
        return new GoalKeeperSilverDecorator(newBuilder);
    }

    private GoalKeeperSilverDecorator(GoalKeeperCardBuilder builder) {
        super(builder);
    }

}
