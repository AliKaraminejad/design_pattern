package Decorators.GoalKeeper;

import Builders.GoalKeeperCardBuilder;
import Director.Director;
import Models.GoalKeeperCard;

public class GoalKeeperBronzeDecorator extends GoalKeeperCard {

    public static GoalKeeperBronzeDecorator decorate(GoalKeeperCardBuilder builder) {
        GoalKeeperCardBuilder newBuilder = new GoalKeeperCardBuilder();
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
        Director.makeGoalKeeperBuilder(newBuilder, builder.getName(), builder.getNationality(), features);
        return new GoalKeeperBronzeDecorator(newBuilder);
    }

    private GoalKeeperBronzeDecorator(GoalKeeperCardBuilder builder) {
        super(builder);
    }

}
