package Lab01;

public class Hero {

    MoveStrategy moveStrategy;

    public Hero() {
        this.moveStrategy = new MoveByFoot();
    }

    public void move() {
        System.out.print("Hero ");
        moveStrategy.move();
    }

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }
}
