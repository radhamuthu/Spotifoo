import java.io.IOException;

public class Helper {
    public static void clearConsole(){
        try {

            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c","cls").inheritIO().start().waitFor();
                System.out.println("Welcome to Spotifoo - Music Player");
            }

            else{
                Runtime.getRuntime().exec("clear");
                System.out.println("Welcome to Spotifoo - Music Player");
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("Interrupted exception");
        }
    }
}
