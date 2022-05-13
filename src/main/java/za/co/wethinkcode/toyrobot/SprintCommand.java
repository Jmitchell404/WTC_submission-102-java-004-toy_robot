package za.co.wethinkcode.toyrobot;

public class SprintCommand extends Command {

    @Override
    public boolean execute(Robot target) {
        int nrSteps = Integer.parseInt(getArgument());
        if (DistanceTesting(nrSteps,target)) {
            for (int i = nrSteps + 1; i > 1; i--) {
                ForwardCommand forward = new ForwardCommand(String.valueOf(nrSteps));
                forward.execute(target);
                if (i != 2) {
                    System.out.println(target);
                }
                nrSteps = nrSteps - 1;
            }
        } else if (!DistanceTesting(nrSteps,target)) {
            target.setStatus("Sorry, I cannot go outside my safe zone");
        }
        return true;
    }
    public boolean DistanceTesting(Integer steps,Robot target){
        Integer totalSteps = 0;
            for (int i = steps; i> 0; i--) {
                totalSteps += i;
            }
        if(target.ValidateDistanace(totalSteps)){
            return true;
        }
        return false;
    }
    public SprintCommand(String argument) {super("sprint", argument);}
}
