package za.co.wethinkcode.toyrobot.maze;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.world.Obstacle;

import java.util.ArrayList;
import java.util.List;

public class EmptyMaze extends AbstractMaze{
    public EmptyMaze(){
        System.out.println("Loaded EmptyMaze");
    }
    @Override
    public List<Obstacle> getObstacles() {
        List<Obstacle> obstacles = new ArrayList<>();
        return obstacles;
    }

    @Override
    public boolean blocksPath(Position a, Position b) {
        return super.blocksPath(a,b);
    }
}
