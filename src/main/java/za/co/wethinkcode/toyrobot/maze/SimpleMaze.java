package za.co.wethinkcode.toyrobot.maze;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.world.Obstacle;
import za.co.wethinkcode.toyrobot.world.SquareObstacle;

import java.util.ArrayList;
import java.util.List;

public class SimpleMaze extends AbstractMaze {
    public SimpleMaze(){
        System.out.println("Loaded SimpleMaze");
    }
    @Override
    public List<Obstacle> getObstacles() {
        List<Obstacle> obstacles = new ArrayList<>();
        SquareObstacle obstacle = new SquareObstacle(1,1);
        obstacles.add(obstacle);
        return obstacles;
    }

    @Override
    public boolean blocksPath(Position a, Position b) {
        return super.blocksPath(a,b);
    }
}
