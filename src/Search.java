import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Search {
// method is used to clear the console and ask for user input to search song
    public static void readInput() {
        validation.cls();
        String searchInput;
        System.out.print("Enter search words :");
        try {
            Scanner ui = new Scanner(System.in);
            searchInput = ui.nextLine();
            if (searchInput.trim().isEmpty()) throw new InputMismatchException();
            searchInput =searchInput.trim().toLowerCase();
            ArrayList<Integer> tempsearchSong = new ArrayList<Integer>();
            // the input word is searched in songArrayList and stored in temporary Search arraylist
            for (int i = 0; i < ReadFile.songList.size(); i++) {
                String toCheck =ReadFile.songList.get(i).toLowerCase();
                if(toCheck.contains(searchInput)){
                tempsearchSong.add(i);
                }
            }
            //to check if there is any song matched with the search word or else it will say no song
            if(tempsearchSong.size()>0) {
                System.out.println("The Searched songs available are");
                displaySearchedSong(tempsearchSong);// to display the search matched song names by calling method
            } else
                System.out.println("There is no song based on your search.");
        }catch(InputMismatchException e){
            System.out.print("Invalid input. Please enter search words :");
            }

        }
    //to display the search matched song names
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
                // to check space or null or empty input from user and throw exception error
                if (numberString.trim().isEmpty()) throw new IllegalArgumentException();
                int number = Integer.parseInt(numberString) ;
                // to clear console
                validation.cls();
                // check userinput to play the  selected song and also open image file respective to the song
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
                    if (songfile.contains(".mp3"))// to check if file exist but doesnot have mp3 format to open in music player
                    {
                        //read the path name and store the perfect filepath
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
                        // error message when .mp3 format not there to play the song and go to main menu
                        System.out.println("Sorry for inconvenience ,Can't play the song");
                        Display.displaymain();
                    }


                } else if (number == 0) {
                    Display.displaymain();

                } else throw new IllegalArgumentException();

            } catch (IllegalArgumentException | InputMismatchException e) {
                //if user enterd symbols or number more than arrayList size or negavtive integer
                System.out.print("Invalid input,Please enter a correct number: ");
                input2 =false;
            } catch (IOException e) {
                System.out.println("Sorry for inconvenience. ");
                Display.displaymain();
            }

        } while (!input2);//loop until user enter expected input
    }

}