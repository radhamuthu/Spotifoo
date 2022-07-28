import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WordSearch {
// method is used to clear the console and ask for user input to search song
    public static void getSearchWordInput() {
        String searchWordInput;
        System.out.print("Enter search words :");
        try {
            Scanner scanInput = new Scanner(System.in);
            searchWordInput = scanInput.nextLine();
            if (searchWordInput.trim().isEmpty()) throw new InputMismatchException();
            searchWordInput =searchWordInput.trim().toLowerCase();
            ArrayList<Integer> temporarySearchList = new ArrayList<>();
            // the input word is searched in songArrayList and stored in temporary Search arraylist
            for (int i = 0; i < AssetsFolderReader.songList.size(); i++) {
                String toCheck =AssetsFolderReader.songList.get(i).toLowerCase();
                if(toCheck.contains(searchWordInput)){
                    temporarySearchList.add(i);
                }
            }
            //to check if there is any song matched with the search word or else it will say no song
            if(temporarySearchList.size()>0) {
                System.out.println("The Searched songs available are");
                displaySearchedSongAndPlay(temporarySearchList);// to display the search matched song names by calling method

            } else {
                System.out.println("There is no song based on your search.");
                ConsoleMenu.MenuList();
            }
        }catch(InputMismatchException e){
            System.out.print("Invalid input. Please enter search words :");
            }

        }
    //to display the search matched song names
    public static void displaySearchedSongAndPlay(ArrayList<Integer> temporaryList) {

        int beginNumber= 1;// to  start the display with 1
        for (Integer integer : temporaryList) {
            int j = integer;
            System.out.println("[" + beginNumber + "]. " + AssetsFolderReader.songList.get(j));
            beginNumber++;
        }
        System.out.println("[0]. To go back to main menu");
        System.out.print("Please choose the option :");
        boolean validInput;
        do {
            validInput = true;
            try {

                Scanner scanNumber = new Scanner(System.in);
                String songNumberString = String.valueOf(scanNumber.nextInt());
                // to check space or null or empty input from user and throw exception error
                if (songNumberString.trim().isEmpty()) throw new IllegalArgumentException();
                int userSelectedNumber = Integer.parseInt(songNumberString) ;
                 // check user input to play the  selected song and also open image file respective to the song
                if (userSelectedNumber > 0 && userSelectedNumber <= temporaryList.size()) {
                    userSelectedNumber = userSelectedNumber - 1;// to access array by reducing the number by 1
                    userSelectedNumber = temporaryList.get(userSelectedNumber);
                    String songName = AssetsFolderReader.songFileList.get(userSelectedNumber);
                    String imageName= AssetsFolderReader.imageList.get(userSelectedNumber);
                    Desktop d = Desktop.getDesktop();
                    if (songName.contains(".mp3"))// to check if song name exist but does not have mp3 format to open in music player
                    {
                        //read the path name and store the perfect filepath
                        File songPathFile = new File("assets/songs/" + songName);
                        File imagePathFile = new File("assets/albums/" + imageName);
                        File defaultImagePathFile = new File("assets/no-picture.png");
                        if (songPathFile.exists()) {
                            d.open(songPathFile);
                            System.out.println("Enjoy listening to the Song");
                            if (imagePathFile.exists()) {
                                d.open(imagePathFile);
                            } else if (defaultImagePathFile.exists())
                                d.open(defaultImagePathFile);

                        }
                     }  else {
                        // error message when .mp3 format not there to play the song and go to main menu
                        System.out.println("Sorry for inconvenience ,Can't play the song");
                        ConsoleMenu.MenuList();
                    }


                } else if (userSelectedNumber == 0) {
                    ConsoleMenu.MenuList();
                } else throw new IllegalArgumentException();

            } catch (IllegalArgumentException | InputMismatchException e) {
                //if user entered symbols or number more than arrayList size or negative integer
                System.out.print("Invalid input,Please enter a correct number: ");
                validInput =false;
            } catch (IOException e) {
                System.out.println("Sorry for inconvenience. ");
                ConsoleMenu.MenuList();
            }

        } while (!validInput);//loop until user enter expected/valid input
    }

}