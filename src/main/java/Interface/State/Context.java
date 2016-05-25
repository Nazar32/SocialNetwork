package Interface.State;

public class Context {

    private State currentState;

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public Context() {

        currentState = null;
    }

    public State getCurrentState() {
        return currentState;
    }
}
