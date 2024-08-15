public class JumpCommand implements Command {

    @Override
    public void execute(GameActor actor) {
        actor.jump();
    }

    @Override
    public void undo() {
        
    }
}