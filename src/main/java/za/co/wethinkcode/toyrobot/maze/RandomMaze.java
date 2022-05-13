package za.co.wethinkcode.toyrobot.maze;

import za.co.wethinkcode.toyrobot.Position;
import za.co.wethinkcode.toyrobot.world.Obstacle;
import za.co.wethinkcode.toyrobot.world.SquareObstacle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMaze extends AbstractMaze{
    List<Obstacle> obstacles;
    public RandomMaze(){
        this.obstacles = new ArrayList<>();
        createObstacles();
        System.out.println("Loaded RandomMaze");
    }
    @Override
    public List<Obstacle> getObstacles() {
        return obstacles;
    }


    public void createObstacles(){
        Random random = new Random();
        int num = random.nextInt(9)+1;
        for(int i = 0; i< num; i++){
            int rand_X = random.nextInt(100+100)-100;
            int rand_Y = random.nextInt(200+200)-200;
            SquareObstacle new_obstacle = new SquareObstacle(rand_X,rand_Y);
            this.obstacles.add(new_obstacle);
        }
    }
    @Override
    public boolean blocksPath(Position a, Position b) {
        return super.blocksPath(a,b);
    }
}
