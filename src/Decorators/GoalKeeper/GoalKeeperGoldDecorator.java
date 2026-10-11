package Decorators.GoalKeeper;

import Builders.GoalKeeperCardBuilder;
import Director.Director;
import Models.GoalKeeperCard;

public class GoalKeeperGoldDecorator extends GoalKeeperCard {

    public static GoalKeeperGoldDecorator decorate(GoalKeeperCardBuilder builder) {
        GoalKeeperCardBuilder newBuilder = new GoalKeeperCardBuilder();
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
        Director.makeGoalKeeperBuilder(newBuilder, builder.getName(), builder.getNationality(), features);
        return new GoalKeeperGoldDecorator(newBuilder);
    }

    private GoalKeeperGoldDecorator(GoalKeeperCardBuilder builder) {
        super(builder);
    }

}
