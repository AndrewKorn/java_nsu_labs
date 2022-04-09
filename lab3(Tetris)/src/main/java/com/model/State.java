package com.model;

import com.general.ConcretePublisher;

public class State extends ConcretePublisher {
    private StateEnum state;

    public State(StateEnum state) {
        this.state = state;
    }

    public StateEnum getData() {
        return state;
    }

    public void setData(StateEnum state) {
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


