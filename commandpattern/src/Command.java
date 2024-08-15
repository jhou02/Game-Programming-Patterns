public interface Command {
    void execute(GameActor actor);
    void undo();
}
