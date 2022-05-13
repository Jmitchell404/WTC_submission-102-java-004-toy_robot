package za.co.wethinkcode.toyrobot;

import org.junit.jupiter.api.Test;
import za.co.wethinkcode.toyrobot.maze.EmptyMaze;
import za.co.wethinkcode.toyrobot.maze.RandomMaze;
import za.co.wethinkcode.toyrobot.maze.SimpleMaze;
import za.co.wethinkcode.toyrobot.world.IWorld;
import za.co.wethinkcode.toyrobot.world.TextWorld;
import za.co.wethinkcode.toyrobot.world.TurtleWorld;

import static org.junit.jupiter.api.Assertions.*;
public class ObstacleTest {
    @Test
    public void EmptyMaze(){
        IWorld world = new TextWorld( new EmptyMaze());
        assertEquals(world.getObstacles().size(),0);
    }
    @Test
    public void SimpleMaze(){
        IWorld world = new TextWorld( new SimpleMaze());
        assertEquals(world.getObstacles().size(),1);
    }
    @Test
    public void RandomMaze(){
    IWorld world = new TextWorld(new RandomMaze());
    assertTrue(world.getObstacles().size()<11);
    assertTrue(world.getObstacles().size()>0);
    }
}
