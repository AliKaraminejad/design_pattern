package Models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Command {
    buildPlayer("^build\\s+player\\s+(?<name>\\S+)\\s+(?<nationality>\\S+)\\s+(?<shooting>\\d+)\\s+(?<pace>\\d+)\\s+(?<dribbling>\\d+)\\s+(?<physic>\\d+)\\s+(?<passing>\\d+)\\s+(?<defending>\\d+)$"),
    buildGoalKeeper("^build\\s+goalie\\s+(?<name>\\S+)\\s+(?<nationality>\\S+)\\s+(?<diving>\\d+)\\s+(?<handling>\\d+)\\s+(?<reflex>\\d+)\\s+(?<positioning>\\d+)\\s+(?<kicking>\\d+)\\s+(?<speed>\\d+)$"),
    buyPLayer("^buy\\s+(?<name>\\S+)"),
    sellPlayer("^sell\\s+(?<name>\\S+)"),
    selectPosition("^select\\s+(?<position>\\S+)\\s+(?<name>\\S+)$"),
    setDecoration("^set\\s+decoration\\s+(?<position>\\S+)\\s+(?<decoration>\\S+)$"),
    setPlayStyle("^set\\s+play\\s+style\\s+(?<position>\\S+)\\s+(?<style>\\S+)$"),
    showLineup("^show\\s+lineup$"),
    showMoney("^show\\s+money$"),
    calTeamPower("^calculate\\s+team\\s+power$"),
    soot("^soot$");

    private final Pattern pattern;

    Command(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    public Matcher matcher(String input) {
        Matcher matcher = pattern.matcher(input);
        if(matcher.matches()) {
            return matcher;
        }
        return null;
    }

    public static Command getCommand(String input) {
        for(Command command : Command.values()) {
            if(command.pattern.matcher(input).matches()) {
                return command;
            }
        }
        return null;
    }

}
