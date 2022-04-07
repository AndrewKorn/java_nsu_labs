package com;

public class State extends ConcretePublisher{
    private StateEnum state;

    public State(StateEnum state) {
        this.state = state;
    }

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public void switchState() {
        if (state == StateEnum.Run) {
            state = StateEnum.Pause;
        }
        else if (state == StateEnum.Pause) {
            state = StateEnum.Run;
        }
        notifySubscriber();
    }
}


