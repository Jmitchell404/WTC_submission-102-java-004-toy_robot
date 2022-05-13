package za.co.wethinkcode.toyrobot;

//import za,];
import za.co.wethinkcode.toyrobot.maze.*;
import za.co.wethinkcode.toyrobot.world.AbstractWorld;
import za.co.wethinkcode.toyrobot.world.IWorld;
import za.co.wethinkcode.toyrobot.world.TextWorld;
import za.co.wethinkcode.toyrobot.world.TurtleWorld;

public class Robot {


    public static final Position CENTRE = new Position(0,0);

    private String status;
    private final String name;
    private Position position;
    private Direction currentDirection;
    private Maze maze;

    private AbstractWorld world;

    public Robot(String name) {
        this.name = name;
//        this.Iworld = Iworld;
        this.status = "Ready.";
//        this.position = CENTRE;
        this.currentDirection = Direction.UP;
        Chooseworld(Play.getWorld());
    }

    public void Chooseworld(String[] commands){
//        if(commands.length == 0){             //testing
//            this.maze = new EmptyMaze();      //testing
//            world = new TextWorld(this.maze);    //testing
//
//        }

        if(commands == null){
            this.maze = new EmptyMaze();
            world = new TextWorld(this.maze);

        } else if(commands.length == 0){
            this.maze = new EmptyMaze();
            world = new TextWorld(this.maze);

        } else if(commands.length == 1){
            if(commands[0].equals("turtle")){
                this.maze = new EmptyMaze();
                world = new TurtleWorld(this.maze);

            } else if(commands[0].equals("text")){
                this.maze = new EmptyMaze();
                world = new TextWorld(this.maze);

            } else if(commands[0].equals("SimpleMaze")){
                this.maze = new SimpleMaze();
                world = new TextWorld(this.maze);

            } else if(commands[0].equals("RandomMaze")){
                this.maze = new RandomMaze();
                world = new TextWorld(this.maze);

            } else if(commands[0].equals("EmptyMaze")){
                this.maze = new EmptyMaze();
                world = new TextWorld(this.maze);

            }
        } else if(commands.length == 2){
            if(commands[0].equals("turtle")){
                if (commands[1].equals("EmptyMaze")){
                    this.maze = new EmptyMaze();
                    world = new TurtleWorld(this.maze);
                } else if (commands[1].equals("SimpleMaze")){
                    this.maze = new EmptyMaze();
                    world = new TurtleWorld(this.maze);
                } else if (commands[1].equals("RandomMaze")){
                    this.maze = new RandomMaze();
                    world = new TurtleWorld(this.maze);
                } else if (commands[1].equals("DesignedMaze")){
                    this.maze = new DesignMaze();
                    world = new TurtleWorld(this.maze);
                }

            } else if(commands[0].equals("text")){
                if(commands[1].equals("EmptyMaze")){
                    this.maze = new EmptyMaze();
                    world = new TextWorld(this.maze);
                } else if(commands[1].equals("SimpleMaze")){
                    this.maze = new SimpleMaze();
                    world = new TextWorld(this.maze);
                } else if(commands[1].equals("RandomMaze")) {
                    this.maze = new RandomMaze();
                    world = new TextWorld(this.maze);
                }
            }
        }

    }

    public boolean ValidateDistanace(int totalDistance){
        if(this.world.ValidateDistanace(totalDistance)){
            return true;
        }
        return false;
    }

    public String getStatus() {
        return this.status;
    }

    public Direction getCurrentDirection() {
        return this.currentDirection;
    }

    public boolean handleCommand(Command command) {
        return command.execute(this);
    }

    public void updateDirection(boolean check){
        this.world.updateDirection(check);
    }

    public IWorld.UpdateResponse updatePosition(int nrSteps){
        return world.updatePosition(nrSteps);
    }

    @Override
    public String toString() {
       return "[" + this.world.getPosition().getX() + "," + this.world.getPosition().getY() + "] "
               + this.name + "> " + this.status+".";
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }
}