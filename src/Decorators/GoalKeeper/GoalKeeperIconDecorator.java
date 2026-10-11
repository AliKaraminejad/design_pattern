package Decorators.GoalKeeper;

import Builders.GoalKeeperCardBuilder;
import Director.Director;
import Models.GoalKeeperCard;

public class GoalKeeperIconDecorator extends GoalKeeperCard {

    public static GoalKeeperIconDecorator decorate(GoalKeeperCardBuilder builder) {
        GoalKeeperCardBuilder newBuilder = new GoalKeeperCardBuilder();
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
        Director.makeGoalKeeperBuilder(newBuilder, builder.getName(), builder.getNationality(), features);
        return new GoalKeeperIconDecorator(newBuilder);
    }

    private GoalKeeperIconDecorator(GoalKeeperCardBuilder builder) {
        super(builder);
    }

}
