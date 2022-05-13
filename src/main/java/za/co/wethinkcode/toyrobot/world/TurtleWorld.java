package za.co.wethinkcode.toyrobot.world;

import org.turtle.StdDraw;
import org.turtle.Turtle;
import za.co.wethinkcode.toyrobot.maze.Maze;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TurtleWorld extends AbstractWorld{
    private ArrayList<Obstacle> obstacle;
    Turtle player;
    private Maze mazeType;

    public TurtleWorld(Maze maze){
        System.out.println("Loaded TurtleWorld");
        this.mazeType = maze;
        this.obstacle = new ArrayList<>();
        StdDraw.setXscale(-250,250);
        StdDraw.setYscale(-250,250);
        player = new Turtle(0,0,90);
        player.setSize(0.01);
        player.forward(0);
    }

    @Override
    public List<Obstacle> getObstacles(){
        return this.obstacle;
    }

    @Override
    public void reset(){
        super.reset();
    }

    @Override
    public boolean isAtEdge(){
        return isAtEdge();
    }

    @Override
    public void showObstacles(){
        for(Obstacle i : mazeType.getObstacles()){
            player.setColor(Color.blue);
            StdDraw.filledSquare(i.getBottomLeftX()+5,i.getBottomLeftY()+5,i.getSize());
        }
    }
    @Override
    public UpdateResponse updatePosition(int nrSteps){
        player.setColor(Color.BLACK);
        UpdateResponse update = super.updatePosition(nrSteps);
        if(update == UpdateResponse.SUCCESS){
            player.forward(nrSteps);
        }
        return update;
    }

    @Override
    public void updateDirection(boolean turnRight){
        super.updateDirection(turnRight);
        player.setColor(Color.BLACK);
        if(turnRight){
            player.right(90);
        } else if(!turnRight){
            player.left(90);
        }
    }
}
