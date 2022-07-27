import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Search {

    public static void readInput() {
        validation.cls();
        String searchInput;
        System.out.print("Enter search string :");
        try {
            Scanner ui = new Scanner(System.in);
            searchInput = ui.nextLine();
            if (searchInput.trim().isEmpty()) throw new InputMismatchException();
            searchInput =searchInput.trim().toLowerCase();
            ArrayList<Integer> tempsearchSong = new ArrayList<Integer>();

            for (int i = 0; i < ReadFile.songList.size(); i++) {
                String toCheck =ReadFile.songList.get(i).toLowerCase();
                if(toCheck.contains(searchInput)){
                tempsearchSong.add(i);
                }
            }
            if(tempsearchSong.size()>0) {
                System.out.println("The Searched songs available are");
                displaySearchedSong(tempsearchSong);
            } else
                System.out.println("There is no song based on your search.");
        }catch(InputMismatchException e){
            System.out.print("Invalid input. Please enter search words :");
            }

        }
    //public static void displaySong(ArrayList<Integer> temp);
    public static void displaySearchedSong(ArrayList<Integer> temp) {

        int a = 1;// to  start the display with 1
        for (int i = 0; i < temp.size(); i++) {
            int j = (int) temp.get(i);
            System.out.println("["+a + "]. " + ReadFile.songList.get(j));
            a++;
        }
        System.out.println("[0]. To go back to main menu");
        System.out.print("Please choose the option :");
        boolean input2 = true;
        do {
            input2 = true;
            try {

                Scanner ui = new Scanner(System.in);
                String numberString = String.valueOf(ui.nextInt());
                if (numberString.trim().isEmpty()) throw new IllegalArgumentException();
                int number = Integer.parseInt(numberString) ;
                if (number > 0 && number <= temp.size()) {
                    number = number - 1;
                    number = (int) temp.get(number);
                    String songfile = ReadFile.songfileList.get(number);
                    String pngfile = ReadFile.pngList.get(number);
                    songfile = songfile.toLowerCase();
                    pngfile = pngfile.toLowerCase();
                    pngfile = pngfile.replace(' ', '-');
                    songfile = songfile.replace(' ', '-');
                    Desktop d = Desktop.getDesktop();
                    if (songfile.contains(".mp3"))
                    {
                        //public void browseFileDirectory(File )
                        File readsongfile = new File("assets/songs/" + songfile);
                        File readpngfile = new File("assets/albums/" + pngfile);
                        File defaultpngfile = new File("assets/no-picture.png");
                        if (readsongfile.exists()) {
                            d.open(readsongfile);
                            if (readpngfile.exists()) {
                                d.open(readpngfile);
                            } else if (defaultpngfile.exists())
                                d.open(defaultpngfile);

                        }
                     }  else {
                        System.out.println("Sorry for inconvenience ,Can't play the song");
                        Display.displaymain();
                    }


                } else if (number == 0) {
                    Display.displaymain();

                } else throw new IllegalArgumentException();

            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.print("Invalid input,Please enter a correct number: ");
                input2 =false;
            } catch (IOException e) {
                System.out.println("Sorry for inconvenience. ");
                Display.displaymain();
            }

        } while (!input2);
    }

}