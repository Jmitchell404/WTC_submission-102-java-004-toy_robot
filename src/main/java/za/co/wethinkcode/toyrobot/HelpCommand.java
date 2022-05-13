package za.co.wethinkcode.toyrobot;

public class HelpCommand extends Command {

    public HelpCommand() {
        super("help");
    }

    @Override
    public boolean execute(Robot target) {
        target.setStatus("I can understand these commands:\n" +
                "OFF  - Shut down robot\n" +
                "HELP - provide information about commands\n" +
                "FORWARD - move forward by specified number of steps, e.g. 'FORWARD 10'\n"+
                "FORWARD - move forward by specified number of steps, e.g. 'FORWARD 10'\n"+
                "LEFT - turns left\n"+
                "RIGHT - turns right\n"+
                "SPRINT - moves forward multiple steps at a time, e.g. 'SPRINT 2'\n+" +
                "REPLAY - replays previous commands");
        return true;
    }
}
