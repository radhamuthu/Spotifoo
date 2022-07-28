package com.radha.spotifoo.Main;

import java.util.*;
import java.lang.*;

/**
 *Class have  two methods .
 * assignListHashset method is used for creating the list for Artist /Album/Genre without duplication
 * displayUserGivenHashList method to display the created list and allow to select one from user
 * displaySelectedSong method to display corresponding song from the user selected option and allow to select songs and play it
 *
 * */

public class ArtistOrAlbumOrGenreSelection {

    /**
     * This method is used to create new list without duplicates
     *
     * @param userSelectedList -the List have duplications
     */
    public static void assignListHashset(ArrayList<String> userSelectedList) {
        ArrayList<String> userGivenHashList = new ArrayList<>(new HashSet<>(userSelectedList));
        displayUserGivenHashList(userGivenHashList, userSelectedList);
    }


    /**
     * @param userGivenHashList-this list has either artist/album/genre names
     *                               without duplication to display in console  and allow the user to select the option
     * @param userSelectedList-      this allows to map the selected song number
     *                               with original number and store in temporary array
     */
    public static void displayUserGivenHashList(ArrayList<String> userGivenHashList, ArrayList<String> userSelectedList) {

        Helper.displayInConsoleNames(userGivenHashList);
        boolean validInput = true;
        // the do- while block is to run repeatedly when the user input is not in the expected way
        do {
            try {
                Scanner userInput = new Scanner(System.in);
                int userInputNumber = Helper.scanUserInput(userInput.nextLine());
                Helper.clearConsole();
                if (userInputNumber == 0) {
                    ConsoleMenu.MenuList();
                }
                // user input is checked based on their selection of displayed names in {Album or Artist or Genre}
                else if (userInputNumber <= userGivenHashList.size()) {
                    // temporary ArrayList created to store the position of the specific selected name in the given arrayList
                    // which matches with console displayed given Hash list
                    ArrayList<Integer> temporaryList = new ArrayList<>();
                    userInputNumber = userInputNumber - 1;
                    String nameSelection = userGivenHashList.get(userInputNumber);
                    for (int j = 0; j < userSelectedList.size(); j++) {
                        if (userSelectedList.get(j).equals(nameSelection)) {
                            temporaryList.add(j);
                        }
                    }
                    // to display the songs - specific to {Album or Artist or Genre}
                    displaySelectedSong(temporaryList);
                } else throw new IllegalArgumentException();
            } catch (IllegalArgumentException | InputMismatchException e) {
                // the catch block will show invalid input message and ask for valid input by do-while
                System.out.print("Invalid input. Please enter correct value :");
                validInput = false;

            }
        } while (!validInput);// loop until user input= true
    }


    /**
     * @param temporaryList- to display songs corresponding
     *                       to specifically selected  {Album or Artist or Genre} using temporary arrayList
     *                       and allow to select the song to play
     */

    public static void displaySelectedSong(ArrayList<Integer> temporaryList) {
        Helper.displayInConsoleSong(temporaryList);
        Helper.playTheSelectedSong(temporaryList);
    }
}