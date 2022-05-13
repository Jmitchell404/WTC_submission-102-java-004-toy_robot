package za.co.wethinkcode.toyrobot;

import za.co.wethinkcode.toyrobot.world.IWorld;

public class BackwardCommand extends Command {
    @Override
    public boolean execute(Robot target) {
        int nrSteps = Integer.parseInt(getArgument());
        if (target.updatePosition(-nrSteps) == IWorld.UpdateResponse.SUCCESS){
            target.setStatus("Moved back by "+nrSteps+" steps");
        } else {
            target.setStatus("Sorry, I cannot go outside my safe zone");
        }
        return true;
    }

    public BackwardCommand(String argument) {
        super("Backward", argument);
    }
}