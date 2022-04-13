package com.View;


import com.Controller.Executor;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;

public class KeyboardListener implements KeyListener {
    private final Executor executor;

    public KeyboardListener(Executor executor) {
        super();
        this.executor = executor;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        try {
            executor.execute(String.valueOf(e.getKeyChar()));
        } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
