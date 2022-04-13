package com.Model.Figures.Factory;

import com.Model.Figures.Figure;
import com.Model.Figures.FiguresLetter;

import java.util.Random;

public class FigureFactory {
    public Figure createFigure(FiguresLetter figuresLetter) {
        return switch (figuresLetter) {
            case IFigure -> new IFigureCreator().createFigure();
            case JFigure -> new JFigureCreator().createFigure();
            case LFigure -> new LFigureCreator().createFigure();
            case OFigure -> new OFigureCreator().createFigure();
            case SFigure -> new SFigureCreator().createFigure();
            case TFigure -> new TFigureCreator().createFigure();
            case ZFigure -> new ZFigureCreator().createFigure();
        };
    }

    private FiguresLetter getRandomFigureLetter() {
        Random random = new Random();
        FiguresLetter[] figuresLetters = FiguresLetter.values();
        return figuresLetters[random.nextInt(figuresLetters.length)];
    }

    public Figure createRandomFigure() {
        FiguresLetter figuresLetter = getRandomFigureLetter();
        Figure figure = createFigure(figuresLetter);
        figure.set(4, 19);
        return figure;
    }
}

