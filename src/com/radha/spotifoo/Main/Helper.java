package com.radha.spotifoo.Main;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Helper {
    /**
     * to clear the console
     */
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
    public static Integer scanUserInput(String userInput ){

        int userInputNumber;
        if (userInput.trim().isEmpty()) {
            throw new InputMismatchException();
        }else{
            userInputNumber = Integer.parseInt(userInput) ;
            return userInputNumber;
        }
    }

    /**
     *
     * @param temporaryList-To display the songs by taking position
     *    of selected Album/artist/genre name from temporary ArrayList
     */
    public static void displayInConsoleSong(ArrayList<Integer> temporaryList){
        int beginNumber = 1;// to  start the display with 1
        System.out.println("The Songs available are ");

        for (Integer integer : temporaryList) {
            int j = integer;
            System.out.println("[" + beginNumber + "]. " + AssetsFolderReader.songList.get(j));
            beginNumber++;
        }
        System.out.println("[0]. To go back to main menu");
        System.out.print("Please choose the option : ");
    }

    /**
     *
     * @param userList- to display the album/artist/genre names to console
     */
    public static void displayInConsoleNames(ArrayList<String> userList){
        int beginNumber = 1;// to  start the display with 1 in console
        for (String i : userList) {
            System.out.println("["+beginNumber +"]. " + i);
            beginNumber++;
        }
        System.out.println("[0]. To go back to main menu");
        System.out.print("Please choose the option :");
    }

    /**
     *  the method check user input to play the  selected song and also open image file respective to the song
     * @param temporaryList - holds the position of the selected songs
     *  which will help to recover the song when user selects the specific song to play
     */
    public static void playTheSelectedSong(ArrayList<Integer> temporaryList){
        boolean validInput;
        do {
            validInput = true;
            try {
                Scanner scanInput = new Scanner(System.in);
                int userSelectedNumber =Helper.scanUserInput(scanInput.nextLine());

                if (userSelectedNumber > 0 && userSelectedNumber <= temporaryList.size()) {
                    userSelectedNumber = userSelectedNumber - 1;// to access array by reducing the number by 1
                    userSelectedNumber = temporaryList.get(userSelectedNumber);
                    String songName = AssetsFolderReader.songFileList.get(userSelectedNumber);
                    String imageName= AssetsFolderReader.imageList.get(userSelectedNumber);
                    Desktop d = Desktop.getDesktop();
                    if (songName.contains(".mp3"))
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

