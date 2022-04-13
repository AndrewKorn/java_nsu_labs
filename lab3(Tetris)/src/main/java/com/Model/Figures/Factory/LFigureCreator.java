package com.Model.Figures.Factory;

import com.Model.Block;
import com.Model.ColorEnum;
import com.Model.Figures.ConcreteFigure;
import com.Model.Figures.Figure;
import com.Model.Point;

public class LFigureCreator implements FigureCreator {
    @Override
    public Figure createFigure() {
        Point centre = new Point(1, 0);
        Block[] blocks = {
                new Block(0, 0),
                new Block(1, 0),
                new Block(2, 0),
                new Block(2, 1)
        };
        return new ConcreteFigure(centre, blocks, ColorEnum.Orange);
    }
}
