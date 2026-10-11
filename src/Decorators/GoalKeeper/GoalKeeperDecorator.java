package Decorators.GoalKeeper;

import Builders.GoalKeeperCardBuilder;
import Director.Director;
import Models.GoalKeeperCard;

public class GoalKeeperDecorator {

    public GoalKeeperCard decorate(GoalKeeperCard card, String decorateType) {
        GoalKeeperCardBuilder builder = new GoalKeeperCardBuilder();
        Director.makeGoalKeeperBuilder(builder, card.getName(), card.getNationality(), card.getFeatures());
        return switch (decorateType) {
            case "bronze" -> GoalKeeperBronzeDecorator.decorate(builder);
            case "silver" -> GoalKeeperSilverDecorator.decorate(builder);
            case "gold" -> GoalKeeperGoldDecorator.decorate(builder);
            case "hero" -> GoalKeeperHeroDecorator.decorate(builder);
            case "icon" -> GoalKeeperIconDecorator.decorate(builder);
            default -> null;
        };

    }
}
