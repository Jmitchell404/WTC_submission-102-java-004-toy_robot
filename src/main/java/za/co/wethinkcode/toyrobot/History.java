package za.co.wethinkcode.toyrobot;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

public class History {
    public static ArrayList historyList = new ArrayList();
    public static final List<String> VALID_COMMANDS = Arrays.asList("forward","back","left","right","sprint");
    public static boolean ValidHistoryToAdd(String movement){
        boolean Answer = false;
        String[] move = movement.toLowerCase().trim().split(" ");
        if(VALID_COMMANDS.contains(move[0])){
            Answer = true;
        }else if(VALID_COMMANDS.contains(movement) == false){
            Answer = Answer;
        }
        return Answer;
    }
        public static void TrackMovements (String movement) {historyList.add(movement);
    }
}
