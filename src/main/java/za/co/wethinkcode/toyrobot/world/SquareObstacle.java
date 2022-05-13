package za.co.wethinkcode.toyrobot.world;

import za.co.wethinkcode.toyrobot.Position;

public class SquareObstacle implements Obstacle{
    private int x,y;

    public SquareObstacle(int i,int i1){
        this.x = i;
        this.y = i1;
    }

    @Override
    public int getBottomLeftX() {
        return this.x;
    }

    @Override
    public int getBottomLeftY() {
        return this.y;
    }

    @Override
    public int getSize() {
        return 5;
    }

    @Override
    public boolean blocksPosition(Position position) {
        boolean blocked = false;
        if(position.getX()>= getBottomLeftX() && getBottomLeftX()+getSize() >= position.getX()){
            if(position.getY()>= getBottomLeftY() && getBottomLeftY()+getSize() >=position.getY()){
                blocked = true;
            }
        }
        return blocked;
    }

    @Override
    public boolean blocksPath(Position a, Position b) {
        if(a.getX() > b.getX()){
            if(a.getX() >= getBottomLeftX() && b.getX() <= getBottomLeftX()+(getSize()-1) &&
            b.getY() >= getBottomLeftY() && b.getY() <= getBottomLeftY()+(getSize()-1)){
                return true;
            }
        } else if(b.getX() > a.getX()){
            if(a.getX() <= getBottomLeftX() && b.getX() >= getBottomLeftX()+(getSize()-1) &&
                    b.getY() >= getBottomLeftY() && b.getY() <= getBottomLeftY()+(getSize()-1)){
                return true;
            }
        } else if(a.getY() > b.getY()){
            if(a.getY() >= getBottomLeftX() && b.getY() <= getBottomLeftX()+(getSize()-1) &&
                    b.getX() >= getBottomLeftX() && b.getX() <= getBottomLeftX()+(getSize()-1)){
                return true;
            }
        } else if(b.getY() >a.getY()){
            if(a.getY() <= getBottomLeftX() && b.getY() >= getBottomLeftX()+(getSize()-1) &&
                    b.getX() >= getBottomLeftX() && b.getX() <= getBottomLeftX()+(getSize()-1)){
                return true;
            }
        }
        return false;
    }
}
