import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.List;



public  class Display {
    static ArrayList<String> songList = new ArrayList<>();
    static ArrayList<String> artistList = new ArrayList<>();
    static ArrayList<String> albumList = new ArrayList<>();
    static ArrayList<String> genreList = new ArrayList<>();


    public static void displaymain() {

        boolean input = true;
        //to display the mainlist
        System.out.println("1.Songs");
        System.out.println("2.Artists");
        System.out.println("3.Albums");
        System.out.println("4.Genre");
        System.out.println("5.Search");
        System.out.println("Please choose the option :");
        do {
            try {
                Scanner ui = new Scanner(System.in);
                int user = ui.nextInt();
                //System.out.print("\033[H\033[2J");
                System.out.print("\033[H\033[2J");
                System.out.flush();

                if (user > 0 && user < 6 && user!=0) {
                    switch (user) {
                        case 1:
                            // create object for class
                           Song songClass = new Song();
                            songClass.songName();
                            break;
                        case 2:
                            // create object for class
                            Artist artistClass = new Artist();
                            artistClass.assignArtistListHashset();
                            break;
                        case 3:
                            // create object for class
                            Album albumClass = new Album();
                            albumClass.assignAlbumListHashset();
                            break;
                        case 4:
                            // create object for class
                            Genre genreClass = new Genre();
                            genreClass.assignGenreListHashset();
                            break;
                        case 5:
                            System.out.println("enter search string");
                            break;

                    }

                } else {
                    System.out.println("Please enter number from 1 to 5:");
                    input = false;
                }
            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println("Invalid input.Please enter number from 1 to 5:");
                input = false;

            }
        } while (!input);

    }




}

