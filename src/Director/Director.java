package Director;

import Builders.GoalKeeperCardBuilder;
import Builders.PlayerCardBuilder;
import Models.GoalKeeperCard;

public class Director {

    public static void makePlayerBuilder(PlayerCardBuilder builder, String name, String nationality, int[] features) {
        builder.reset();
        builder.setName(name);
        builder.setNationality(nationality);
        builder.setFeatures(features);
    }

    public static void makeGoalKeeperBuilder(GoalKeeperCardBuilder builder, String name, String nationality, int[] features) {
        builder.reset();
        builder.setName(name);
        builder.setNationality(nationality);
        builder.setFeatures(features);
    }
}
