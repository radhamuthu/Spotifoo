public class Main {
    public static void main(String[] args) {
        validation.cls();
        ReadFile readFile = new ReadFile ();
        Display displayFile = new Display();
        readFile.readNames();
        displayFile.displaymain();
        System.out.println("thanks for choosing Spotifoo");
    }
}