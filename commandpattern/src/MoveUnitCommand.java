public class MoveUnitCommand implements Command { 

    private Unit unit;
    private int x, y;
    private int xBefore;
    
    public MoveUnitCommand(Unit unit, int x, int y) {
        this.unit = unit;
        this.x = x;
        this.y = y;    
    }

    @Override
    void execute() {

        xBefore = x;
        yBefore = y;

        unit.moveTo(x, y);
    }

    @Override
    void undo() {
        unit.moveTo(xBefore, yBefore);
    }
}