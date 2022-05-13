package za.co.wethinkcode.toyrobot.world;

import za.co.wethinkcode.toyrobot.maze.Maze;

import java.util.List;

public class TextWorld extends AbstractWorld {
    private Maze mazeType;

    public TextWorld(Maze maze) {
        System.out.println("Loaded Text World");
        this.mazeType = maze;
    }
    @Override
    public boolean isAtEdge(){
        return super.isAtEdge();
    }

    @Override
    public void showObstacles(){
        System.out.println("There are some Obstacles:");
        for (Obstacle i: mazeType.getObstacles()) {
            System.out.println(" - At position " + i.getBottomLeftX() + "," + i.getBottomLeftY() +
                    " (to " + (i.getBottomLeftX() + 4)+ "," + (i.getBottomLeftY() + 4)+ ")");
        }
    }
    @Override
    public void reset(){
        super.reset();
    }
    public List<Obstacle> getObstacles(){
        return mazeType.getObstacles();
    }
}
