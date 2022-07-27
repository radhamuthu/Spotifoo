import java.io.IOException;

public class validation {
    public static void cls(){
        try {

            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c",
                        "cls").inheritIO().start().waitFor();
                System.out.println("Welcome to Spotifoo");
            }

            else{
                Runtime.getRuntime().exec("clear");
                System.out.println("Welcome to Spotifoo");
            }
        } catch (IOException | InterruptedException ex) {}
    }
}
