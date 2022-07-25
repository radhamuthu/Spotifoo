public class Main {
    public static void main(String[] args) {

        System.out.println("\u266b  Welcome to Spotifoo \u266b");
        ReadFile readFile = new ReadFile ();
        Display displayFile = new Display();



        //to read the  inputfiles
        readFile.readNames();
        //to display in console
        displayFile.displaymain();
       // System.out.println("0. To go back to main menu");
        System.out.println("thanks for choosing spotifoo,Enjoy the song \u266b");
    }
}