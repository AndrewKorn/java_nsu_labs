package com.Model.Figures.Factory;

import com.Model.Block;
import com.Model.Figures.ConcreteFigure;
import com.Model.Figures.Figure;
import com.Model.Point;

import javax.xml.crypto.KeySelector;
import java.awt.*;

public class TFigureCreator implements FigureCreator {
    @Override
    public Figure createFigure() {
        Point centre = new Point(1, 0);
        Block[] blocks = {
                new Block(0, 0),
                new Block(1, 0),
                new Block(1, 1),
                new Block(2, 0)
        };
        return new ConcreteFigure(centre, blocks, Color.MAGENTA);
    }
}
