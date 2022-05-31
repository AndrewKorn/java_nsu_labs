import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private final boolean log;
    private final int chatHistoryCount;
    private final int timeout;

    public Configuration() {
        Properties properties = new Properties();

        try {
            InputStream inputStream = Configuration.class.getClassLoader().getResourceAsStream("configuration.properties");
            properties.load(inputStream);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        log = Boolean.parseBoolean(properties.getProperty("Log"));
        chatHistoryCount = Integer.parseInt(properties.getProperty("ChatHistoryCount"));
        timeout = Integer.parseInt(properties.getProperty("Timeout"));
    }

    public boolean isLog() {
        return log;
    }

    public int getChatHistoryCount() {
        return chatHistoryCount;
    }

    public int getTimeout() {
        return timeout;
    }
}
