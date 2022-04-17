package com.Model.Figures.Factory;
import com.Model.Figures.Figure;
import com.Model.Figures.FiguresLetter;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class FigureFactory {
    public Figure createFigure(FiguresLetter figuresLetter)  {
        FigureCreator figureCreator = null;
        try {
            String creatorName = getClass().getPackageName()  + "." + figuresLetter + "Creator";
            figureCreator = (FigureCreator) Class.forName(creatorName).getDeclaredConstructor().newInstance();
        }
        catch (
                ClassNotFoundException |
                InvocationTargetException |
                NoSuchMethodException |
                InstantiationException |
                IllegalAccessException e
        ) {e.printStackTrace();}

        assert figureCreator != null;
        return figureCreator.createFigure();
    }

    private FiguresLetter getRandomFigureLetter() {
        Random random = new Random();
        FiguresLetter[] figuresLetters = FiguresLetter.values();
        return figuresLetters[random.nextInt(figuresLetters.length)];
    }

    public Figure createRandomFigure()  {
        FiguresLetter figuresLetter = getRandomFigureLetter();
        Figure figure = createFigure(figuresLetter);
        figure.set(4, 19);
        return figure;
    }
}

