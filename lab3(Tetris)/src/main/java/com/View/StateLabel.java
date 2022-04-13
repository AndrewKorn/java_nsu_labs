package com.View;

import com.General.Subscriber;
import com.Model.State;

import javax.swing.*;
import java.awt.*;

public class StateLabel extends JLabel implements Subscriber {
    private final State state;

    public StateLabel(State state) {
        super("Game is running");
        this.state = state;
        this.state.addSubscriber(this);
        this.setForeground(Color.RED);
    }

    @Override
    public void reactOnNotify() {
        switch (state.getData()) {
            case Run -> this.setText("Game is running");
            case Pause -> this.setText("Game is pausing");
            case End -> this.setText("Game over");
        }
    }
}
