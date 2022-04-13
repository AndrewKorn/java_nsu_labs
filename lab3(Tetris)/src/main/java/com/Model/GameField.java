package com.Model;

import com.General.ConcretePublisher;
import com.Model.Figures.Factory.FigureFactory;
import com.Model.Figures.Figure;

public class GameField extends ConcretePublisher {
    private final BlocksField blocksField;
    private Figure currentFigure;

    public GameField() {
        blocksField = new BlocksField(10, 20);
        currentFigure = new FigureFactory().createRandomFigure();
    }

    public boolean isSuitable() {
        Block[] blocks = currentFigure.getBlocks();
        for (Block block : blocks) {
            if (blocksField.isInside(currentFigure)) {
                if (blocksField.getField()[blocksField.height - 1 - block.getY()][block.getX()] != ColorEnum.Empty) {
                    return false;
                }
            }
            if (block.getY() < 0 || block.getX() < 0 || block.getX() > 9) {
                return false;
            }

        }
        return true;
    }

    public boolean isFalling() {
        currentFigure.shift(0, -1);
        boolean falling = isSuitable();
        currentFigure.shift(0, 1);
        return falling;
    }

    public void shiftFigure(int x, int y) {
        currentFigure.shift(x, y);
        if (!isSuitable()) {
            currentFigure.shift(-x, -y);
        }
        notifySubscriber();
    }

    public void rotateFigure() {
        currentFigure.rotateClockwise();
        if (!isSuitable()) {
            currentFigure.rotateCounterclockwise();
        }
        notifySubscriber();
    }

    public void spawnNewFigure() {
        blocksField.addFigure(currentFigure);
        currentFigure = new FigureFactory().createRandomFigure();
        notifySubscriber();
    }

    public boolean isPossibleToSpawn() {
        Figure prevFigure = currentFigure;
        currentFigure = new FigureFactory().createRandomFigure();
        if (!isFalling()) {
            return false;
        }
        currentFigure = prevFigure;
        return true;
    }

    public void fallFigure() {
        if (isFalling()) {
            currentFigure.shift(0, -1);
        }
        else {
            spawnNewFigure();
        }
        notifySubscriber();
    }

    public void dropFigure() {
        while(isSuitable() && isFalling()) {
            currentFigure.shift(0, -1);
        }
        notifySubscriber();
    }

    public BlocksField getBlocksField() {
        return blocksField;
    }

    public Figure getCurrentFigure() {
        return currentFigure;
    }

    public int clearFilledRows() {
        int removed = 0;
        int minIdx = blocksField.height;
        for (int i = 0; i < blocksField.height; ++i) {
            if (getBlocksField().isRowFull(i)) {
                removed += 1;
                if (i < minIdx) {
                    minIdx = i;
                }
            }
        }
        if (removed > 0) {
            for (int j = minIdx; j < blocksField.height - removed; ++j) {
                for (int k = 0; k < blocksField.width; ++k) {
                    blocksField.getField()[blocksField.height - 1 - j][k] = blocksField.getField()[blocksField.height - 1 - j - removed][k];
                }
            }
        }

        notifySubscriber();
        return removed;
    }

    public void clear() {
        spawnNewFigure();
        blocksField.clear();
        notifySubscriber();
    }

    public BlocksField getFieldWithFigure() {
        BlocksField copy = new BlocksField(10, 20);
        for (int i = 0; i < blocksField.height; ++i) {
            for (int j = 0; j < blocksField.width; ++j) {
                copy.getField()[i][j] = blocksField.getField()[i][j];
            }
        }
        copy.addFigure(currentFigure);
        return copy;
    }
}
