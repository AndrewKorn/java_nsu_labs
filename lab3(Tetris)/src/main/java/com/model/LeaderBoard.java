package com.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LeaderBoard {
    private final Properties properties = new Properties();

    public LeaderBoard() throws IOException {
        InputStream is = LeaderBoard.class.getClassLoader().getResourceAsStream("leaderboard.properties");
        properties.load(is);
    }

    public Properties getProperties() {
        return properties;
    }
}
