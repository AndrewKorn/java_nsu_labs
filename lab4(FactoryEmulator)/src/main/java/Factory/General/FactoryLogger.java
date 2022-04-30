package Factory.General;

import com.sun.tools.javac.Main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class FactoryLogger {
    private final Logger logger;

    public FactoryLogger() {
        try {
            LogManager.getLogManager().readConfiguration(Main.class.getClassLoader().getResourceAsStream("logging.properties"));
        }
        catch (SecurityException | IOException e) {
            e.printStackTrace();
        }

        this.logger = Logger.getLogger(Logger.class.getName());
    }

    public void getExceptionMessage(Level lvl, Throwable e) {
        logger.log(lvl, "Exception: ", e);
    }

    public void getInfoMessage(String message) {
        logger.log(Level.INFO, "Operation performed: " + message);
    }
}
