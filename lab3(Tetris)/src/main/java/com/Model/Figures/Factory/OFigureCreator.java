package com.Model.Figures.Factory;

import com.Model.Block;
import com.Model.ColorEnum;
import com.Model.Figures.ConcreteFigure;
import com.Model.Figures.Figure;
import com.Model.Point;

public class OFigureCreator implements FigureCreator {
    @Override
    public Figure createFigure() {
        Point centre = new Point(0.5F, 0.5F);
        Block[] blocks = {
                new Block(0, 0),
                new Block(0, 1),
                new Block(1, 0),
                new Block(1, 1)
        };
        return new ConcreteFigure(centre, blocks, ColorEnum.Yellow);
    }
}
