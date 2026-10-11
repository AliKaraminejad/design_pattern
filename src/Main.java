import Builders.GoalKeeperCardBuilder;
import Builders.PlayerCardBuilder;
import Director.Director;
import Models.*;

import java.util.Scanner;
import java.util.regex.Matcher;

public class Main {

    private final static Team barca = Team.getInstance();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine().trim();
            Command command = Command.getCommand(input);

            if(command == null){
                continue;
            }
            switch (command) {
                case buildPlayer: {
                    buildPlayer(command.matcher(input));
                    break;
                }
                case buildGoalKeeper: {
                    buildGoalKeeper(command.matcher(input));
                    break;
                }
                case buyPLayer: {
                    buyPLayer(command.matcher(input));
                    break;
                }
                case sellPlayer: {
                    sellPlayer(command.matcher(input));
                    break;
                }
                case selectPosition: {
                    selectPosition(command.matcher(input));
                    break;
                }
                case setDecoration: {
                    setDecoration(command.matcher(input));
                    break;
                }
                case setPlayStyle: {
                    setPlayStyle(command.matcher(input));
                    break;
                }
                case showLineup: {
                    showLineup(command.matcher(input));
                    break;
                }
                case showMoney: {
                    showMoney(command.matcher(input));
                    break;
                }
                case calTeamPower: {
                    calTeamPower(command.matcher(input));
                    break;
                }
                case soot: {
                    soot(command.matcher(input));
                    System.exit(0);
                }
            }
        }
    }

    private static void buildPlayer(Matcher matcher) {
        String name = matcher.group("name").trim();
        String nationality = matcher.group("nationality").trim();
        String shootingStr = matcher.group("shooting").trim();
        String paceStr = matcher.group("pace").trim();
        String dribblingStr = matcher.group("dribbling").trim();
        String physicStr = matcher.group("physic").trim();
        String passingStr = matcher.group("passing").trim();
        String defendingStr = matcher.group("defending").trim();
        int[] features = new int[6];
        features[0] = Integer.parseInt(shootingStr);
        features[1] = Integer.parseInt(paceStr);
        features[2] = Integer.parseInt(dribblingStr);
        features[3] = Integer.parseInt(physicStr);
        features[4] = Integer.parseInt(passingStr);
        features[5] = Integer.parseInt(defendingStr);

        PlayerCardBuilder builder = new PlayerCardBuilder();
        Director.makePlayerBuilder(builder, name, nationality, features);
        builder.getResult();
    }

    private static void buildGoalKeeper(Matcher matcher) {
        String name = matcher.group("name").trim();
        String nationality = matcher.group("nationality").trim();
        String divingStr = matcher.group("diving").trim();
        String handlingStr = matcher.group("handling").trim();
        String reflexStr = matcher.group("reflex").trim();
        String positioningStr = matcher.group("positioning").trim();
        String kickingStr = matcher.group("kicking").trim();
        String speedStr = matcher.group("speed").trim();
        int[] features = new int[6];
        features[0] = Integer.parseInt(divingStr);
        features[1] = Integer.parseInt(handlingStr);
        features[2] = Integer.parseInt(reflexStr);
        features[3] = Integer.parseInt(positioningStr);
        features[4] = Integer.parseInt(kickingStr);
        features[5] = Integer.parseInt(speedStr);

        GoalKeeperCardBuilder builder = new GoalKeeperCardBuilder();
        Director.makeGoalKeeperBuilder(builder, name, nationality, features);
        builder.getResult();
    }

    private static void buyPLayer(Matcher matcher) {
        String name = matcher.group("name").trim();
        Card card = PlayerCard.getPlayerCardByName(name);
        if (card == null) {
            card = GoalKeeperCard.getGoalKeeperCardByName(name);
        }
        int price = card.getPrice();
        if (price > barca.getMoney()) {
            System.out.println("8 - 2");
        }

        barca.addToBench(card);
        barca.decreaseMoney(price);
    }

    private static void sellPlayer(Matcher matcher) {
        String name = matcher.group("name").trim();
        Card card = barca.getPlayerByName(name);
        int price = card.getPrice() / 2;

        barca.removeFromBench(card);
        barca.increaseMoney(price);
    }

    private static void selectPosition(Matcher matcher) {
        String position = matcher.group("position").trim();
        String name = matcher.group("name").trim();
        Card card = barca.getPlayerByName(name);

        barca.setLineupCard(position, card);
        barca.removeFromBench(card);
    }

    private static void setDecoration(Matcher matcher) {
        String position = matcher.group("position").trim();
        String decoration = matcher.group("decoration").trim();
        int price;
        switch (decoration) {
            case "bronze": {
                price = 50;
                break;
            }
            case "silver": {
                price = 70;
                break;
            }
            case "gold": {
                price = 100;
                break;
            }
            case "hero": {
                price = 150;
                break;
            }
            case "icon": {
                price = 200;
                break;
            }
            default: {
                price = 0;
                break;
            }
        }
        price *= 1000000;
        barca.setDecoration(position, decoration);
        barca.decreaseMoney(price);
    }

    private static void setPlayStyle(Matcher matcher) {
        String position = matcher.group("position").trim();
        String style = matcher.group("style").trim();
        int price;
        switch (style) {
            case "aggressive": {
                price = 5;
                break;
            }
            case "defensive": {
                price = 4;
                break;
            }
            case "balanced": {
                price = 3;
                break;
            }
            default: {
                price = 0;
                break;
            }
        }
        price *= 1000000;
        barca.setPlayStyle(position, style);
        barca.decreaseMoney(price);
    }

    private static void showLineup(Matcher matcher) {
        String strikerOutput = "striker:";
        PlayerCard striker = (PlayerCard) barca.getLineupCard("st");
        if (striker != null) {
            strikerOutput += " " + striker.toString();
        }
        System.out.println(strikerOutput);

        String backOutput = "center back:";
        PlayerCard back = (PlayerCard) barca.getLineupCard("cb");
        if (back != null) {
            backOutput += " " + back.toString();
        }
        System.out.println(backOutput);

        String goalKeeperOutput = "goal keeper:";
        GoalKeeperCard goalKeeper = (GoalKeeperCard) barca.getLineupCard("gk");
        if (goalKeeper != null) {
            goalKeeperOutput += " " + goalKeeper.toString();
        }
        System.out.println(goalKeeperOutput);


    }

    private static void showMoney(Matcher matcher) {
        int money = barca.getMoney();
        System.out.println(money);
    }

    private static void calTeamPower(Matcher matcher) {
        int totalPower = barca.getOverallPower();
        System.out.println(totalPower);
    }

    private static void soot(Matcher matcher) {
        int totalPower = barca.getOverallPower();
        if (totalPower > 90) {
            System.out.println("Visca Barca");
        } else if (totalPower == 90) {
            System.out.println("draw");
        } else {
            System.out.println("Hala Madrid");
        }
    }
}