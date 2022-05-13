package za.co.wethinkcode.toyrobot.world;

import za.co.wethinkcode.toyrobot.Direction;
import za.co.wethinkcode.toyrobot.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorld implements IWorld {

//    Position TOP_LEFT;
//    Position BOTTOM_RIGHT;
    private final Position TOP_LEFT = new Position(-100,200);
    private final Position BOTTOM_RIGHT = new Position(100,-200);
    private Position position;
    private Direction currentDirection;
    private ArrayList<Obstacle> obstacles;

    public AbstractWorld() {
        this.position = CENTRE;
        this.currentDirection = Direction.UP;
        this.obstacles = new ArrayList<>();
//        TOP_LEFT = new Position(-100,200);
//        BOTTOM_RIGHT = new Position(-100,200);
    }

//    protected AbstractWorld(Object currentDirection) {
//        this.currentDirection = Direction.UP;
//    }

    @Override
    public UpdateResponse updatePosition(int nrSteps) {
        Position CENTRE = new Position(0,0);
        int newX = this.position.getX();
        int newY = this.position.getY();

        if (Direction.UP.equals(this.currentDirection)) {
            newY = newY + nrSteps;
        } else if(Direction.DOWN.equals(this.currentDirection)){
            newY = newY - nrSteps;
        } else if(Direction.RIGHT.equals(this.currentDirection)) {
            newX = newX + nrSteps;
        } else if(Direction.LEFT.equals(this.currentDirection)) {
            newX = newX - nrSteps;
        }

        Position newPosition = new Position(newX, newY);
        for (Obstacle i : getObstacles()){
            if(i.blocksPosition(newPosition)){
                return UpdateResponse.FAILED_OBSTRUCTED;
            } else if(i.blocksPath(this.position,newPosition)){
                return UpdateResponse.FAILED_OBSTRUCTED;
            }
        }
        if (newPosition.isIn(TOP_LEFT,BOTTOM_RIGHT)){
            this.position = newPosition;
            return UpdateResponse.SUCCESS;
        }
        return UpdateResponse.FAILED_OUTSIDE_WORLD;
    }

    @Override
    public void updateDirection(boolean turnRight) {
//        Direction getCurrentDirection();
        if(IWorld.Direction.UP.equals(currentDirection)){
            if (turnRight) {
                currentDirection = IWorld.Direction.RIGHT;
            }else if(!turnRight){;
                currentDirection = IWorld.Direction.LEFT;
            }
        } else if(IWorld.Direction.LEFT.equals(currentDirection)){
            if (turnRight) {
                currentDirection = IWorld.Direction.UP;
            }else if(!turnRight){;
                currentDirection = IWorld.Direction.DOWN;
            }
        } else if(IWorld.Direction.RIGHT.equals(currentDirection)){
            if (turnRight) {
                currentDirection = IWorld.Direction.DOWN;
            }else if(!turnRight){;
                currentDirection = IWorld.Direction.UP;
            }
        } else if(IWorld.Direction.DOWN.equals(currentDirection)) {
            if (turnRight) {
                currentDirection = IWorld.Direction.LEFT;
            } else if (!turnRight) {
                currentDirection = IWorld.Direction.RIGHT;
            }
        }
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public Direction getCurrentDirection() {
        return currentDirection;
    }

    @Override
    public boolean isNewPositionAllowed(Position position) {
        Position newPosition = new Position(position.getX(), position.getY());
        if (newPosition.isIn(TOP_LEFT, BOTTOM_RIGHT)) {
            this.position = newPosition;
            return true;
        }
        return false;
    }






//            return isNewPositionAllowed.SUCCESS;

//        return isNewPositionAllowed.FAILED_OUTSIDE_WORLD;
//}

    @Override
    public boolean isAtEdge() {
        return false;
    }

    @Override
    public void reset() {
        this.position = CENTRE;
        this.currentDirection = IWorld.Direction.UP;
        this.obstacles = new ArrayList<>();
    }

}
