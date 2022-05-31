
public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        ServerLogger serverLogger = new ServerLogger();
        new Thread(new Server(configuration, serverLogger)).start();
    }
}
