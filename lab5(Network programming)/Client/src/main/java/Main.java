import Client.Client;

import View.*;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        GUI gui = new GUI(client);
        gui.setVisible(true);
        new Thread(client).start();
    }
}
