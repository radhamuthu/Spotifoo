package com.radha.spotifoo.Main;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SongSelection {

    // this method is used to select the song from the display in console and then user may have option to play or go to main menu
    private static void userInputForSongSelection() {
        // the do- while block is to run repeatedly when the user input is not in the expected way
        boolean validInput;
        do {

            validInput = true;
            try {
                Scanner scanUserInput = new Scanner(System.in);
                int userGivenNumber = Helper.scanUserInput(scanUserInput.nextLine());
                // check user input to play the  selected song and also open image file respective to the song
                if (userGivenNumber <= AssetsFolderReader.songList.size() && userGivenNumber > 0) {
                    userGivenNumber = userGivenNumber - 1;// to access array
                    String songName = AssetsFolderReader.songFileList.get(userGivenNumber);
                    String imageName = AssetsFolderReader.imageList.get(userGivenNumber);
                    Desktop d = Desktop.getDesktop();
                    if (songName.contains(".mp3"))// to check if file exist but does not have mp3 format to open in music player
                    {
                        //read the path name and store the perfect file path
                        File songPathFile = new File("assets/songs/" + songName);

                        File imagePathFile = new File("assets/albums/" + imageName);
                        File defaultImageFile = new File("assets/no-picture.png");
                        if (songPathFile.exists()) {
                            d.open(songPathFile);
                            System.out.println("Enjoy listening to the Song");
                            if (imagePathFile.exists()) {
                                d.open(imagePathFile);
                            } else if (defaultImageFile.exists()) {
                                d.open(defaultImageFile);
                            }
                        }
                    } else {
                        // error message when .mp3 format not there to play the song and go to main menu
                        System.out.println("Sorry for inconvenience ,Can't play the song");
                        System.out.print("Select other song number :");
                        validInput = false;
                    }
                } else if (userGivenNumber == 0) {
                    ConsoleMenu.MenuList();

                } else if (userGivenNumber > AssetsFolderReader.songList.size()) {
                    System.out.print("Invalid input,Please enter a correct number :");
                    validInput = false;
                }

            } catch (IOException e) {
                System.out.println("Sorry for inconvenience ,Can't play the song");
                System.out.print("Select other song number  :");
                validInput = false;

            } catch (IllegalArgumentException | InputMismatchException e) {
                //if user entered symbols or number more than arrayList size or negative integer
                System.out.print("Invalid input,Please enter a correct number :");
                validInput = false;
            }
        } while (!validInput);// loop until user gives valid input= true
    }

    public static void displaySongNameInConsole() {
        Helper.displayInConsoleNames(AssetsFolderReader.songList);
        userInputForSongSelection();

    }
}
