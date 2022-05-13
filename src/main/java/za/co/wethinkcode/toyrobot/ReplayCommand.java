package za.co.wethinkcode.toyrobot;

import java.util.ArrayList;
import java.util.Collections;

public class ReplayCommand extends Command {
    public ReplayCommand(String argument) {super("replay",argument);}
    @Override
    public boolean execute(Robot target) {
        ArrayList movementList = History.historyList;
        Integer numberOfCommands = movementList.size();
        String[] type = getArgument().toLowerCase().trim().split(" ");
        if(type.length > 1) {
            FilterReplay(getArgument(),target);
        } else if(getArgument().equals("replay")){
            Replay_cycle(movementList,target,numberOfCommands);
        }
        return true;
    }
    public void FilterReplay(String instruction,Robot target){
        ArrayList movementList = History.historyList;
        String[] type = instruction.toLowerCase().trim().split(" ");
        if (type[1].equals("reversed")){
            Boolean reversed = false;
            ArrayList Movement = movementList;
            Integer numberOfCommands = Movement.size();
            if (type.length == 3){
                if(type[2].contains("-")) {
                    String temp = type[2];
                    type[2] = type[1];
                    type[1] = temp;
                    String[] amount = type[1].toLowerCase().trim().split("-");
                    Integer start = Integer.parseInt(amount[0]);
                    Integer end = Integer.parseInt(amount[1]);
                    Replay_Between(start,end,target,reversed);
                } else if(type[2].matches("[0-9]+")){
                    String temp = type[2];
                    type[2] = type[1];
                    type[1] = temp;
                    Integer amount = Integer.parseInt(type[1]);
                    Replay_N(amount,target,reversed);
                }
            }else {
                Collections.reverse(Movement);
                Replay_cycle(Movement, target, numberOfCommands);
            }
        } else if(type[1].contains("-")){
            Boolean reversed = true;
            String[] amount = type[1].toLowerCase().trim().split("-");
            Integer start = Integer.parseInt(amount[0]);
            Integer end = Integer.parseInt(amount[1]);
            if(type.length == 3) {
                if (type[2].contains("reversed")) {
                    reversed = false;
                }
            }
            Replay_Between(start,end,target,reversed);

        } else if(type[1].matches("[0-9]+")){
            Boolean reversed = true;
            Integer amount = Integer.parseInt(type[1]);
            if (type.length == 3) {
                if(type[2].equals("reversed")){
                    reversed = false;
                }
            }
            Replay_N(amount,target,reversed);
        }
    }
    public void Replay_N(Integer amount,Robot target,Boolean reversed){
        ArrayList movementList = History.historyList;
        ArrayList movementAmount = new ArrayList();
        for (int z = -amount; z<0; z++){
            movementAmount.add(movementList.get(movementList.size()+z));
        }
        if (reversed.equals(false)) {
            Collections.reverse(movementAmount);
        }
        Integer numberOfCommands = movementAmount.size();
        Replay_cycle(movementAmount,target,numberOfCommands);
    }

    public static void Replay_Between(Integer start,Integer end, Robot target,Boolean reversed){
        ArrayList movementList = History.historyList;
        ArrayList movementAmount = new ArrayList();
        Integer numberOfCommands = start-end;
        for(int k = -start ; k <-end ; k++){
            movementAmount.add(movementList.get(movementList.size()+k));
        }
        if (reversed.equals(false)) {
            Collections.reverse(movementAmount);
        }
        Replay_cycle(movementAmount,target,numberOfCommands);
    }

    public static void Replay_cycle(ArrayList Movement,Robot target,Integer numberOfCommands){
        for(Object i: Movement){
            String[] command = i.toString().split(" ");
            Integer num = command.length;
            switch(command[0]){
                case "forward":
                    ForwardCommand forward = new ForwardCommand(command[num-1]);
                    forward.execute(target);
                    System.out.println(target);
                    break;
                case "back":
                    BackwardCommand back = new BackwardCommand(command[num-1]);
                    back.execute(target);
                    System.out.println(target);
                    break;
                case "left":
                    LeftCommand left = new LeftCommand();
                    left.execute(target);
                    System.out.println(target);
                    break;
                case "right":
                    RightCommand right = new RightCommand();
                    right.execute(target);
                    System.out.println(target);
                    break;
                case "sprint":
                    SprintCommand sprint = new SprintCommand(command[num-1]);
                    sprint.execute(target);
                    System.out.println(target);
                    break;
            }
        }
        target.setStatus("replayed " + numberOfCommands + " commands");
    }
}

