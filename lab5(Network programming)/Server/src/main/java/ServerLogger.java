import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class ServerLogger {
    private final Logger logger;

    public ServerLogger() {
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
