package Decorators.Player;

import Builders.PlayerCardBuilder;
import Director.Director;
import Models.PlayerCard;

public class PlayerDecorator{

    public PlayerCard decorate(PlayerCard card, String decorateType) {
        PlayerCardBuilder builder = new PlayerCardBuilder();
        Director.makePlayerBuilder(builder, card.getName(), card.getNationality(), card.getFeatures());
        return switch (decorateType) {
            case "bronze" -> PlayerBronzeDecorator.decorate(builder);
            case "silver" -> PlayerSilverDecorator.decorate(builder);
            case "gold" -> PlayerGoldDecorator.decorate(builder);
            case "hero" -> PlayerHeroDecorator.decorate(builder);
            case "icon" -> PlayerIconDecorator.decorate(builder);
            default -> null;
        };

    }
}
