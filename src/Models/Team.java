package Models;

import Decorators.GoalKeeper.GoalKeeperDecorator;
import Decorators.Player.PlayerDecorator;
import Strategies.Aggressive;
import Strategies.Balanced;
import Strategies.Defensive;
import Strategies.PlayStyle;

import java.util.ArrayList;

public class Team {

    private static Team instance;

    private Team() {}

    public static Team getInstance() {
        if (instance == null) {
            instance = new Team();
        }
        return instance;
    }

    private int money = 1000000000;
    private final ArrayList<Card> bench = new ArrayList<>();
    private PlayerCard striker = null;
    private PlayerCard back = null;
    private GoalKeeperCard goalKeeper = null;

    public void increaseMoney(int amount) {
        this.money += amount;
    }

    public void decreaseMoney(int amount) {
        this.money -= amount;
    }

    public int getMoney() {
        return this.money;
    }

    public void addToBench(Card card) {
        this.bench.add(card);
    }

    public void removeFromBench(Card card) {
        this.bench.remove(card);
    }

    public Card getPlayerByName(String name) {
        for(Card card : bench) {
            if(card.getName().equals(name)) {
                return card;
            }
        }
        return null;
    }

    public void setLineupCard(String position, Card card) {
        switch (position) {
            case "st": {
                this.striker = (PlayerCard) card;
                break;
            }
            case "cb" : {
                this.back = (PlayerCard) card;
                break;
            }
            case "gk" : {
                this.goalKeeper = (GoalKeeperCard) card;
                break;
            }
        }
    }

    public Card getLineupCard(String position) {
        return switch (position) {
            case "st" -> striker;
            case "cb" -> back;
            case "gk" -> goalKeeper;
            default -> null;
        };
    }

    public void setDecoration(String position, String decorateType) {
        PlayerDecorator playerDecorator = new PlayerDecorator();
        GoalKeeperDecorator goalKeeperDecorator = new GoalKeeperDecorator();
        switch (position) {
            case "st": {
                striker = playerDecorator.decorate(striker, decorateType);
                break;
            }
            case "cb" : {
                back = playerDecorator.decorate(back, decorateType);
                break;
            }
            case "gk" : {
                goalKeeper = goalKeeperDecorator.decorate(goalKeeper, decorateType);
                break;
            }
        }
    }

    public void setPlayStyle(String position, String playStyle) {
        PlayStyle strategy;
        switch (playStyle) {
            case "aggressive": {
                strategy = new Aggressive();
                break;
            }
            case "defensive": {
                strategy = new Defensive();
                break;
            }
            case "balanced": {
                strategy = new Balanced();
                break;
            }
            default: {
                strategy = null;
                break;
            }
        }
        switch (position) {
            case "st": {
                striker.setPlayStyle(strategy);
                break;
            }
            case "cb": {
                back.setPlayStyle(strategy);
                break;
            }
        }
    }

    public int getOverallPower() {
        int sum = 0;
        if(striker != null) {
            sum += striker.getOverall();
        }
        if(back != null) {
            sum += back.getOverall();
        }
        if(goalKeeper != null) {
            sum += goalKeeper.getOverall();
        }
        return sum / 3;
    }
}
